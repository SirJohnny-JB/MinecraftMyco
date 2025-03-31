package net.sirjohnny.myco.world;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;


public class ModWorldGeneration {

//    public static void generateModWorldGen() {
//        BiomeModifications.addFeature(
//                BiomeSelectors.tag(BiomeTags.IS_FOREST)
//                        .or(BiomeSelectors.includeByKey(BiomeKeys.PLAINS))
//                        .and(BiomeSelectors.excludeByKey(BiomeKeys.SNOWY_PLAINS))
//                        .and(BiomeSelectors.excludeByKey(BiomeKeys.SNOWY_SLOPES))
//                        .and(BiomeSelectors.excludeByKey(BiomeKeys.TAIGA))
//                        .and(BiomeSelectors.excludeByKey(BiomeKeys.SNOWY_TAIGA))
//                        .and(BiomeSelectors.excludeByKey(BiomeKeys.DESERT))
//                        .and(BiomeSelectors.excludeByKey(BiomeKeys.BADLANDS))
//                        .and(BiomeSelectors.excludeByKey(BiomeKeys.ERODED_BADLANDS))
//                        .and(BiomeSelectors.excludeByKey(BiomeKeys.WOODED_BADLANDS)),
//                GenerationStep.Feature.VEGETAL_DECORATION,
//                ModPlacedFeatures.INKCAP_MUSHROOM_PLACED_KEY
//        );
//    }
}
