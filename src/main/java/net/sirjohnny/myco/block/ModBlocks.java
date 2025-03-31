package net.sirjohnny.myco.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;

public class ModBlocks {

    public static final Block FUNGAL_PLANTER = registerBlock("fungal_planter",
            new Block(AbstractBlock.Settings.create()
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block INKCAP_MUSHROOM = registerBlock(
            "inkcap_mushroom",
            new ModMushroomBlock(
                    null,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.BLACK)
                            .noCollision()
                            .ticksRandomly()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.GRASS)
                            .luminance(state -> 1)
                            .postProcess(Blocks::always)
                            .nonOpaque()
                            .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block FLY_AGARIC_MUSHROOM = registerBlock(
            "fly_agaric_mushroom",
            new ModMushroomBlock(
                    null,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.RED)
                            .noCollision()
                            .ticksRandomly()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.GRASS)
                            .luminance(state -> 1)
                            .postProcess(Blocks::always)
                            .nonOpaque()
                            .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block DESTROYING_ANGEL_MUSHROOM = registerBlock(
            "destroying_angel_mushroom",
            new ModMushroomBlock(
                    null,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.WHITE)
                            .noCollision()
                            .ticksRandomly()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.GRASS)
                            .luminance(state -> 1)
                            .postProcess(Blocks::always)
                            .nonOpaque()
                            .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block GLOWCAP_MUSHROOM = registerBlock(
            "glowcap_mushroom",
            new MushroomPlantBlock(
                    null,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PALE_YELLOW)
                            .noCollision()
                            .ticksRandomly()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.GRASS)
                            .luminance(state -> 10)
                            .postProcess(Blocks::always)
                            .nonOpaque()
                            .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block PUFFBALL_MUSHROOM = registerBlock(
            "puffball_mushroom",
            new PuffBallMushroomBlock(
                    null,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.GRAY)
                            .noCollision()
                            .ticksRandomly()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.GRASS)
                            .luminance(state -> 1)
                            .postProcess(Blocks::always)
                            .nonOpaque()
                            .pistonBehavior(PistonBehavior.DESTROY)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Myco.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Myco.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
}
