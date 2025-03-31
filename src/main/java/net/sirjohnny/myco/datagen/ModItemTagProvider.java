package net.sirjohnny.myco.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.sirjohnny.myco.item.ModItems;
import net.sirjohnny.myco.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.FUNGI)
                .add(ModItems.GLOWCAP_MUSHROOM_ITEM)
                .add(ModItems.DESTROYING_ANGEL_MUSHROOM_ITEM)
                .add(ModItems.FLY_AGARIC_MUSHROOM_ITEM)
                .add(ModItems.INKCAP_MUSHROOM_ITEM)
                .add(ModItems.PUFFBALL_MUSHROOM_ITEM);
    }
}
