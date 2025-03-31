package net.sirjohnny.myco.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;
import net.sirjohnny.myco.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOTTLE_OF_INK)
                .input(Ingredient.ofItems(Items.INK_SAC, ModItems.INKCAP_MUSHROOM_ITEM))
                .input(Items.GLASS_BOTTLE)
                .criterion(hasItem(ModItems.INKCAP_MUSHROOM_ITEM), conditionsFromItem(ModItems.INKCAP_MUSHROOM_ITEM))
                .offerTo(recipeExporter);
        // Ingredient.ofItems(new ItemConvertible[]{Items})

    }
}
