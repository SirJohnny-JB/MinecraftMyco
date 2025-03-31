package net.sirjohnny.myco.recipe;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import net.sirjohnny.myco.component.ModDataComponentTypes;
import net.sirjohnny.myco.item.ModItems;
import net.sirjohnny.myco.util.ModTags;

import java.util.ArrayList;
import java.util.List;

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

                if (item == Items.GLASS_BOTTLE) hasBottle = true;
                else if (item.getDefaultStack().isIn(ModTags.Items.FUNGI)) hasMushroom = true;
                else return false; // Prevent extra items
            }
        }

        return hasBottle && hasMushroom; // ingredient requirements fulfilled
    }

    @Override
    public ItemStack craft(CraftingRecipeInput inventory, RegistryWrapper.WrapperLookup manager) {
        String mushroomId = "unknown"; // placeholder
        String chemical = "none"; // placeholder

        // for each crafting grid slot, determine item stack and tag
        for (int i = 0; i < inventory.getSize(); i++){
            ItemStack stack = inventory.getStackInSlot(i);
            System.out.println("SIRJOHNNY: SELECTED SLOT: " + stack.getItem().getDefaultStack().getName().getString());

            // If itemstack is a mushroom, call setDetails()
            // to set extract components based on mushroom provided
            if (stack.isIn(ModTags.Items.FUNGI)){
                // First slot = source, second slot = chemical - see setDetails()
                ArrayList<String> details = setDetails(stack);
                mushroomId = details.getFirst();
                chemical = details.getLast();
            }

        }

        // Create resultant itemstack and set components determined in setDetails()
        ItemStack result = new ItemStack(ModItems.FUNGAL_EXTRACT);
        result.set(ModDataComponentTypes.FUNGISOURCE, mushroomId); // Assigns mushroomId as the source of the chemical
        result.set(ModDataComponentTypes.CHEMICAL, chemical);

        // Return Chemical Extract with components set
        return result;
    }

    // Returns an array of extract details determined by mushroom provided
    private ArrayList<String> setDetails(ItemStack stack){
        String mushroomId = "unknown";
        String chemical = "none";

        // Logic
        if (!stack.isEmpty()) {
            // Set source mushroom
            mushroomId = stack.getItem().getName().getString();
            // Iterate possible mushrooms and set chemicals accordingly
            switch (stack.getItem().getName().getString()) {
                case "Fly Agaric Mushroom":
                    System.out.println("Case 1");
                    chemical = "Muscimol";
                    break;
                case "Destroying Angel Mushroom":
                    System.out.println("Case 2");
                    chemical = "Amatoxin";
                    break;
                case "Inkcap Mushroom":
                    System.out.println("Case 3");
                    chemical = "Coprine";
                    break;
                case "Glowcap Mushroom":
                    System.out.println("Case 4");
                    chemical = "Gloidine";
                    break;
                case "Puffball Mushroom":
                    chemical = "Antioxidants";
                    break;
                default:
                    System.out.println("Ingredient not determined: " + stack.getItem().getName().getString());
            }
        }

        // Return resultant components via arrayList
        return new ArrayList<>(List.of(mushroomId, chemical));
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
