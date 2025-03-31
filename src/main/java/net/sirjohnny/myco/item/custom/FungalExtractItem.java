package net.sirjohnny.myco.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.sirjohnny.myco.block.ModBlockTags;
import net.sirjohnny.myco.component.ModDataComponentTypes;
import net.sirjohnny.myco.item.ModItems;

import java.util.List;

public class FungalExtractItem extends Item {

    public FungalExtractItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.get(ModDataComponentTypes.FUNGISOURCE) != null){
            // If a fungal source was identified, sets the source and chemical tooltip (determined in ChemicalExtractRecipe.java) coloured purple
            tooltip.add(Text.literal("Source: " + stack.get(ModDataComponentTypes.FUNGISOURCE)).withColor(0x7029ff));
            tooltip.add(Text.literal("Chemical: " + stack.get(ModDataComponentTypes.CHEMICAL)).withColor(0x7029ff));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
