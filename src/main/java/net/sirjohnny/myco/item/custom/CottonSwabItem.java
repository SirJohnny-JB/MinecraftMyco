package net.sirjohnny.myco.item.custom;

import net.minecraft.item.*;

public class CottonSwabItem extends Item {

    public CottonSwabItem(Settings settings) {
        super(settings);
    }

//    @Override
//    public ActionResult useOnBlock(ItemUsageContext context) {
//        World world = context.getWorld();
//        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
//        ItemStack clickedItem = context.getStack();
//
//        if(!world.isClient()) {
//            if (world.getBlockState(context.getBlockPos()).isIn(ModBlockTags.MUSHROOMS)) {
//                ItemUsage.exchangeStack(clickedItem, context.getPlayer(), new ItemStack(ModItems.SWABBED_SPORES), true);
//                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_BRUSH_BRUSHING_SAND, SoundCategory.BLOCKS);
//            }
//        }
//        return ActionResult.SUCCESS;
//    }
}
