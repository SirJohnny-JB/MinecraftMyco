package net.sirjohnny.myco.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> LETHAL_POISON = registerStatusEffect("lethal_poison",
            new LethalPoisonEffect(StatusEffectCategory.HARMFUL, 0xA1251C));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Myco.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        Myco.LOGGER.info("Registering Mod Effects from " + Myco.MOD_ID);
    }
}
