package net.sirjohnny.myco.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;
import net.sirjohnny.myco.effect.ModEffects;

public class ModPotions {

    public static final RegistryEntry<Potion> MUSCIMOL_POISON = registerPotion("muscimol_poison",
            new Potion(new StatusEffectInstance(ModEffects.LETHAL_POISON, 1200, 0)));

    public static final RegistryEntry<Potion> MUSCIMOL_POISON_II = registerPotion("muscimol_poison_ii",
            new Potion(new StatusEffectInstance(ModEffects.LETHAL_POISON, 1200, 1)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion){
        return Registry.registerReference(Registries.POTION, Identifier.of(Myco.MOD_ID, name), potion);
    }

    public static void registerPotions(){
        Myco.LOGGER.info("Registering Mod Potions for " + Myco.MOD_ID);
    }

}
