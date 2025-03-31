package net.sirjohnny.myco.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;

public class ModRecipes {

    public static final RecipeSerializer<ChemicalExtractRecipe> CHEMICAL_EXTRACT_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER,
                    Identifier.of(Myco.MOD_ID, "chemical_extract"),
                    new SpecialRecipeSerializer<>(ChemicalExtractRecipe::new));

    public static void registerRecipeSerializers(){
        Myco.LOGGER.info("Registering custom Mod Recipe Serializers for " + Myco.MOD_ID);
    }
}
