package net.sirjohnny.myco.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomPlantBlock;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ModMushroomBlock extends MushroomPlantBlock {
    public ModMushroomBlock(RegistryKey<ConfiguredFeature<?, ?>> featureKey, Settings settings) {
        super(featureKey, settings);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.getPlayers().getFirst().sendMessage(Text.literal("Trying to find a spot for a mushroom..."));
        super.randomTick(state, world, pos, random);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockBelow = world.getBlockState(pos.down());
        return blockBelow.isOf(Blocks.GRASS_BLOCK) || blockBelow.isIn(BlockTags.MUSHROOM_GROW_BLOCK);
    }
}
