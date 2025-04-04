package net.sirjohnny.myco;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.sirjohnny.myco.component.ModDataComponentTypes;
import net.sirjohnny.myco.effect.ModEffects;
import net.sirjohnny.myco.item.ModItems;
import net.sirjohnny.myco.potion.ModPotions;
import net.sirjohnny.myco.recipe.ModRecipes;

import net.sirjohnny.myco.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Myco implements ModInitializer {
	public static final String MOD_ID = "myco";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		ModItems.registerModItems();
		ModPotions.registerPotions();
		ModEffects.registerEffects();
		ModRecipes.registerRecipeSerializers();
		ModDataComponentTypes.registerDataComponentTypes();
		ModWorldGeneration.generateModWorldGen();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.BOTTLE_OF_MUSCIMOL, ModPotions.MUSCIMOL_POISON);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(ModPotions.MUSCIMOL_POISON, Items.FERMENTED_SPIDER_EYE, ModPotions.MUSCIMOL_POISON_II);
		});

	}
}