package net.mess.furnituremod;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {


    public static Item registerItem (String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(FurnitureMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(FurnitureMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        FurnitureMod.LOGGER.info("Registering Mod Items for " + FurnitureMod.MOD_ID);

    }


}
