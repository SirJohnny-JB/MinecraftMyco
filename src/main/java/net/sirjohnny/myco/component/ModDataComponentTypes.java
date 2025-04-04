package net.sirjohnny.myco.component;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sirjohnny.myco.Myco;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<String> FUNGISOURCE = register("fungisource", builder -> builder.codec(Codec.STRING));
    public static final ComponentType<String> CHEMICAL = register("chemical", builder -> builder.codec(Codec.STRING));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Myco.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes(){
        Myco.LOGGER.info("Registering Mod Data Components for " + Myco.MOD_ID);
    }
}
