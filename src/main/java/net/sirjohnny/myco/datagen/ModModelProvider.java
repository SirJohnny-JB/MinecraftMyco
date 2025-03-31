package net.sirjohnny.myco.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.sirjohnny.myco.block.ModBlocks;
import net.sirjohnny.myco.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleState(ModBlocks.DESTROYING_ANGEL_MUSHROOM);
        blockStateModelGenerator.registerSimpleState(ModBlocks.GLOWCAP_MUSHROOM);
        blockStateModelGenerator.registerSimpleState(ModBlocks.INKCAP_MUSHROOM);
        blockStateModelGenerator.registerSimpleState(ModBlocks.FLY_AGARIC_MUSHROOM);
        blockStateModelGenerator.registerItemModel(ModBlocks.PUFFBALL_MUSHROOM);
        blockStateModelGenerator.registerItemModel(ModBlocks.GLOWCAP_MUSHROOM);
        blockStateModelGenerator.registerItemModel(ModBlocks.INKCAP_MUSHROOM);
        blockStateModelGenerator.registerItemModel(ModBlocks.FLY_AGARIC_MUSHROOM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FUNGAL_PLANTER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FUNGAL_EXTRACT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOTTLE_OF_MUSCIMOL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWABBED_SPORES, Models.GENERATED);
        itemModelGenerator.register(ModItems.COTTON_SWAB, Models.GENERATED);
    }
}
