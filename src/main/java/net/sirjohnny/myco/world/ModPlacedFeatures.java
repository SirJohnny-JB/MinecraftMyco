package net.sirjohnny.myco.world;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.sirjohnny.myco.block.ModBlocks;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import java.util.List;

public class ModPlacedFeatures {

//    public static final RegistryKey<PlacedFeature> INKCAP_MUSHROOM_PLACED_KEY = RegistryKey.of(
//            RegistryKeys.PLACED_FEATURE,
//            Identifier.of("myco:inkcap_mushroom_placed"));
//
//    public static void bootstrap(Registerable<PlacedFeature> context) {
//        context.register(INKCAP_MUSHROOM_PLACED_KEY,
//                new PlacedFeature(context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE)
//                        .getOrThrow(ModConfiguredFeatures.INKCAP_MUSHROOM_KEY),
//                        List.of(
//                                RarityFilterPlacementModifier.of(2),
//                                SquarePlacementModifier.of(),
//                                BiomePlacementModifier.of()
//                        )));
//    }
//
//    static {
//        Registry.registerFor(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
//    }


}
