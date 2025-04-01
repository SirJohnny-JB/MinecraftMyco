package net.sirjohnny.myco.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.sirjohnny.myco.Myco;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> FLY_AGARIC_MUSHROOM_PLACED_KEY = registerKey("fly_agaric_mushroom_placed");
    public static final RegistryKey<PlacedFeature> INK_CAP_MUSHROOM_PLACED_KEY = registerKey("ink_cap_mushroom_placed");
    public static final RegistryKey<PlacedFeature> DESTROYING_ANGEL_MUSHROOM_PLACED_KEY = registerKey("destroying_angel_mushroom_placed");
    public static final RegistryKey<PlacedFeature> PUFFBALL_MUSHROOM_PLACED_KEY = registerKey("puffball_mushroom_placed");
    public static final RegistryKey<PlacedFeature> GLOWCAP_MUSHROOM_PLACED_KEY = registerKey("glowcap_mushroom_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, FLY_AGARIC_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLY_AGARIC_MUSHROOM_KEY),
                RarityFilterPlacementModifier.of(120), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, INK_CAP_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.INK_CAP_MUSHROOM_KEY),
                RarityFilterPlacementModifier.of(64), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, DESTROYING_ANGEL_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DESTROYING_ANGEL_MUSHROOM_KEY),
                RarityFilterPlacementModifier.of(120), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, PUFFBALL_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PUFFBALL_MUSHROOM_KEY),
                RarityFilterPlacementModifier.of(120), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, GLOWCAP_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GLOWCAP_MUSHROOM_KEY),
                RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Myco.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}