package net.sirjohnny.myco.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.sirjohnny.myco.block.ModBlocks;
import net.sirjohnny.myco.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {


    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK)
                .add(Blocks.GRASS_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.FUNGI)
                .add(ModBlocks.DESTROYING_ANGEL_MUSHROOM)
                .add(ModBlocks.FLY_AGARIC_MUSHROOM)
                .add(ModBlocks.GLOWCAP_MUSHROOM)
                .add(ModBlocks.INKCAP_MUSHROOM)
                .add(ModBlocks.PUFFBALL_MUSHROOM);
    }
}
