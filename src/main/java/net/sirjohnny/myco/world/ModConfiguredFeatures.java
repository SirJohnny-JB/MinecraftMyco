package net.sirjohnny.myco.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.sirjohnny.myco.Myco;
import net.sirjohnny.myco.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> FLY_AGARIC_MUSHROOM_KEY = registerKey("fly_agaric_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> INK_CAP_MUSHROOM_KEY = registerKey("ink_cap_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DESTROYING_ANGEL_MUSHROOM_KEY = registerKey("destroying_angel_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PUFFBALL_MUSHROOM_KEY = registerKey("puffball_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GLOWCAP_MUSHROOM_KEY = registerKey("glowcap_mushroom");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, FLY_AGARIC_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLY_AGARIC_MUSHROOM))));

        register(context, INK_CAP_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.INKCAP_MUSHROOM))));

        register(context, DESTROYING_ANGEL_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.DESTROYING_ANGEL_MUSHROOM))));

        register(context, PUFFBALL_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PUFFBALL_MUSHROOM))));

        register(context, GLOWCAP_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GLOWCAP_MUSHROOM))));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Myco.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
