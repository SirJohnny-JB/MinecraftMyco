package net.sirjohnny.myco.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;
import net.sirjohnny.myco.block.ModBlocks;

public class ModItemGroups {


    public static final ItemGroup MYCO_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Myco.MOD_ID, "myco_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.RED_MUSHROOM))
                    .displayName(Text.translatable("itemgroup.myco.myco_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.COTTEN_SWAB);
                        entries.add(ModItems.SWABBED_SPORES);
                    }).build());

    public static final ItemGroup MYCO_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Myco.MOD_ID, "myco_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.FUNGAL_PLANTER))
                    .displayName(Text.translatable("itemgroup.myco.myco_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FUNGAL_PLANTER);
                    }).build());



    public static void registerItemGroups() {
        Myco.LOGGER.info("Registering Mod Item Groups for " + Myco.MOD_ID);
    }
}
