package net.sirjohnny.myco.recipe;


import net.minecraft.component.Component;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.sirjohnny.myco.Myco;
import net.sirjohnny.myco.block.ModBlocks;
import net.sirjohnny.myco.component.ModDataComponentTypes;
import net.sirjohnny.myco.item.ModItems;
import net.sirjohnny.myco.item.custom.ModItemTags;
import net.sirjohnny.myco.util.ModTags;

import java.util.List;
import java.util.Objects;

public class ChemicalExtractRecipe extends SpecialCraftingRecipe{


    public ChemicalExtractRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        boolean hasBottle = false;
        boolean hasMushroom = false;

        for (int i = 0; i < input.getSize(); i++){
            ItemStack stack = input.getStackInSlot(i);
            if (!stack.isEmpty()) {
                Item item = stack.getItem();
                if (stack.isIn(ModTags.Items.FUNGI)){
                    System.out.println("SIRJOHNNY: " + item.getName().getString() + ": is a mushroom");
                } else {
                    System.out.println("SIRJOHNNY: " + item.getName().getString() + ": is not a mushroom");
                }

                if (item == Items.GLASS_BOTTLE) hasBottle = true;
                else if (item.getDefaultStack().isIn(ModTags.Items.FUNGI)) hasMushroom = true;
                else return false; // Prevent extra items
            }
        }

        return hasBottle && hasMushroom;
    }

    @Override
    public ItemStack craft(CraftingRecipeInput inventory, RegistryWrapper.WrapperLookup manager) {
        String mushroomId = "unknown";
        System.out.println("SIRJOHNNY: CRAFTING...");

        for (int i = 0; i < inventory.getSize(); i++){
            ItemStack stack = inventory.getStackInSlot(i);
            System.out.println("SIRJOHNNY: SELECTED SLOT: " + stack.getItem().getDefaultStack().getName().getString());
            if (!stack.isEmpty() && Objects.equals(stack.getItem().getDefaultStack().getName().getString(), "Fly Agaric Mushroom")){
                System.out.println("SIRJOHNNY: THIS IS A MUSHROOM");
                mushroomId = stack.getItem().getDefaultStack().getName().getString();
                System.out.println(mushroomId);
                break;
            }
//            if (!stack.isEmpty() && stack.getItem().getDefaultStack().isIn(ModItemTags.MUSHROOMS)){
//                mushroomId = stack.getItem().toString();
//                break;
//            }
        }

        ItemStack result = new ItemStack(ModItems.FUNGAL_EXTRACT);
        result.set(ModDataComponentTypes.FUNGISOURCE, mushroomId);
        if (Objects.equals(result.get(ModDataComponentTypes.FUNGISOURCE), "Fly Agaric Mushroom")){
            result.set(ModDataComponentTypes.CHEMICAL, "Muscimol");
        }
        System.out.println(result.get(ModDataComponentTypes.FUNGISOURCE));

//        result.set(DataComponentTypes.LORE, new LoreComponent(List.of(
//                Text.literal("Extracted from: " + mushroomId)
//        )));
        return result;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CHEMICAL_EXTRACT_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }
}
