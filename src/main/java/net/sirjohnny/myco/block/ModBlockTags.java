package net.sirjohnny.myco.block;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;

public class ModBlockTags {
    public static final TagKey<Block> MUSHROOMS =
            TagKey.of(RegistryKeys.BLOCK, Identifier.of(Myco.MOD_ID, "mushrooms"));
}
