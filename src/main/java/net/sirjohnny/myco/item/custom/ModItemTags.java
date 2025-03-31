package net.sirjohnny.myco.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;

public class ModItemTags {
    public static final TagKey<Item> MUSHROOMS =
            TagKey.of(RegistryKeys.ITEM, Identifier.of(Myco.MOD_ID, "mushrooms"));
}
