package net.sirjohnny.myco.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> FUNGI = createTag("fungi");
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Myco.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> FUNGI = createTag("fungi");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Myco.MOD_ID, name));
        }
    }
}
