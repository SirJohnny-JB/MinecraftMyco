package net.sirjohnny.myco.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;
import net.sirjohnny.myco.block.ModBlocks;
import net.sirjohnny.myco.item.custom.CottonSwabItem;
import net.sirjohnny.myco.item.custom.FungalExtractItem;

public class ModItems {
    public static final Item SWABBED_SPORES = registerItem("swabbed_spores", new Item(new Item.Settings()));
    public static final Item BOTTLE_OF_INK = registerItem("bottle_of_ink", new Item(new Item.Settings()));
    public static final Item BOTTLE_OF_MUSCIMOL = registerItem("bottle_of_muscimol", new Item(new Item.Settings()));
    public static final Item FLY_AGARIC_MUSHROOM_ITEM = registerModBlockItem("fly_agaric_mushroom", ModBlocks.FLY_AGARIC_MUSHROOM);
    public static final Item INKCAP_MUSHROOM_ITEM = registerModBlockItem("inkcap_mushroom", ModBlocks.INKCAP_MUSHROOM);
    public static final Item DESTROYING_ANGEL_MUSHROOM_ITEM = registerModBlockItem("destroying_angel_mushroom", ModBlocks.DESTROYING_ANGEL_MUSHROOM);
    public static final Item GLOWCAP_MUSHROOM_ITEM = registerModBlockItem("glowcap_mushroom", ModBlocks.GLOWCAP_MUSHROOM);


    public static final Item COTTON_SWAB = registerItem("cotton_swab", new CottonSwabItem(new Item.Settings()));
    public static final Item FUNGAL_EXTRACT = registerItem("fungal_extract", new FungalExtractItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Myco.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Myco.LOGGER.info("Registering Mod Items for " + Myco.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SWABBED_SPORES);
            entries.add(COTTON_SWAB);
            entries.add(BOTTLE_OF_INK);
            entries.add(FUNGAL_EXTRACT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(FLY_AGARIC_MUSHROOM_ITEM);
            entries.add(INKCAP_MUSHROOM_ITEM);
            entries.add(DESTROYING_ANGEL_MUSHROOM_ITEM);
            entries.add(GLOWCAP_MUSHROOM_ITEM);
        });


    }

    public static Item registerModBlockItem(String name, Block block){
        Myco.LOGGER.info("Registering Mod Block Items for " + Myco.MOD_ID);
        return Registry.register(
                Registries.ITEM,
                Identifier.of(Myco.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
}
