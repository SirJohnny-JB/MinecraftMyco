package net.sirjohnny.myco.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.sirjohnny.myco.block.ModBlockTags;
import net.sirjohnny.myco.item.ModItems;

import java.util.Map;

public class CottonSwabItem extends Item {

    public CottonSwabItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        ItemStack clickedItem = context.getStack();

        if(!world.isClient()) {
            if (world.getBlockState(context.getBlockPos()).isIn(ModBlockTags.MUSHROOMS)) {
                ItemUsage.exchangeStack(clickedItem, context.getPlayer(), new ItemStack(ModItems.SWABBED_SPORES), true);
                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_BRUSH_BRUSHING_SAND, SoundCategory.BLOCKS);
            }
        }
        return ActionResult.SUCCESS;
    }
}
