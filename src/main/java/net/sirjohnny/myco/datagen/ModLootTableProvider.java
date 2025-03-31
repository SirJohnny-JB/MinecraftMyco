package net.sirjohnny.myco.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.sirjohnny.myco.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PUFFBALL_MUSHROOM);
        addDrop(ModBlocks.DESTROYING_ANGEL_MUSHROOM);
        addDrop(ModBlocks.GLOWCAP_MUSHROOM);
        addDrop(ModBlocks.INKCAP_MUSHROOM);
        addDrop(ModBlocks.FLY_AGARIC_MUSHROOM);
        addDrop(ModBlocks.FUNGAL_PLANTER);
    }
}
