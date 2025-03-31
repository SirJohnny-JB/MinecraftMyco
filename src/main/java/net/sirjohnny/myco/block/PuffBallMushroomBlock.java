package net.sirjohnny.myco.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EntityShapeContext;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;


public class PuffBallMushroomBlock extends ModMushroomBlock{
    public PuffBallMushroomBlock(RegistryKey<ConfiguredFeature<?, ?>> featureKey, Settings settings) {
        super(featureKey, settings);
        this.setDefaultState(this.getDefaultState().with(PUFFED, false));
    }

    public static final BooleanProperty PUFFED = BooleanProperty.of("puffed");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(PUFFED);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!state.get(PUFFED)) {
            Vec3d blockCenter = Vec3d.ofCenter(pos);
            Vec3d playerPos = player.getPos();

            double distance = playerPos.distanceTo(blockCenter);
            if (distance <= 2) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 1));
            }
            world.playSound(null, pos, SoundEvents.ENTITY_SNOW_GOLEM_DEATH, SoundCategory.BLOCKS, 0.5F, 1.0F);
            if (!world.isClient && world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(
                        ParticleTypes.CLOUD,
                        pos.getX() + 0.5,
                        pos.getY() + 0.5,
                        pos.getZ() + 0.5,
                        15,
                        0.4, 0.2, 0.4,
                        0.001
                );
            }
        }
        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient
                && entity instanceof PlayerEntity player
                && world instanceof ServerWorld serverWorld
                && !state.get(PUFFED)) {
            serverWorld.spawnParticles(
                    ParticleTypes.CLOUD,
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    10,
                    0.3, 0.2, 0.3,
                    0.01
            );
            world.playSound(null, pos, SoundEvents.ENTITY_SNOW_GOLEM_DEATH, SoundCategory.BLOCKS, 0.7F, 1.3F);

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 50, 0));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 50, 0));

            world.setBlockState(pos, state.with(PUFFED, true), Block.NOTIFY_ALL);
            int delay = world.getRandom().nextBetween(1200,6000);
            world.scheduleBlockTick(pos, this, delay);
        }
        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    protected void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient
                && world instanceof ServerWorld serverWorld
                && !state.get(PUFFED)) {

            BlockPos pos = hit.getBlockPos();
            serverWorld.spawnParticles(
                    ParticleTypes.CLOUD,
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    10,
                    0.3, 0.2, 0.3,
                    0.01
            );
            world.playSound(null, pos, SoundEvents.ENTITY_SNOW_GOLEM_DEATH, SoundCategory.BLOCKS, 0.7F, 1.3F);

            world.setBlockState(pos, state.with(PUFFED, true), Block.NOTIFY_ALL);
//            int delay = world.getRandom().nextBetween(1200,6000);
            int delay = world.getRandom().nextBetween(500,700);
            world.scheduleBlockTick(pos, this, delay);
        }
        super.onProjectileHit(world, state, hit, projectile);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (context instanceof EntityShapeContext entityContext) {
            Entity entity = entityContext.getEntity();
            if ((entity instanceof LivingEntity)){
                // Let players and mobs pass through
                return VoxelShapes.empty();
            }
        }
        // Projectiles and other entities collide
        return Block.createCuboidShape(4,0,4,12,6,12);
    }

    @Override
    public Settings getSettings() {
        return super.getSettings();
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(4,0,4,12,6,12);
    }

    @Override
    protected boolean isShapeFullCube(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(PUFFED)) {
            System.out.println("Block is no longer puffed");
            world.playSound(null, pos, SoundEvents.BLOCK_SAND_STEP, SoundCategory.BLOCKS, 0.9F, 1.3F);
            world.setBlockState(pos, state.with(PUFFED, false), Block.NOTIFY_ALL);

        }
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(PUFFED, false);
    }

//    @Override
//    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
//        BlockPos targetPos = pos.add(
//                random.nextInt(3) - 1,
//                random.nextInt(2) - random.nextInt(2),
//                random.nextInt(3) - 1
//        );
//
//        if (world.isAir(targetPos) && state.canPlaceAt(world, targetPos)) {
//            world.setBlockState(targetPos, this.getDefaultState().with(PUFFED, false), Block.NOTIFY_ALL);
//        }
//
//        super.randomTick(state, world, pos, random);
//    }
}
