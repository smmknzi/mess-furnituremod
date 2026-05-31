package net.mess.furnituremod.entity;

import net.mess.furnituremod.FurnitureMod;
import net.mess.furnituremod.entity.custom.SitEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;


public class ModEntities {
    public static final ResourceKey<EntityType<?>> SIT_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(FurnitureMod.MOD_ID, "sit"));

    public static final EntityType<SitEntity> SIT = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(FurnitureMod.MOD_ID, "sit"),
            EntityType.Builder.of(SitEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .noLootTable()
                    .build(SIT_KEY)
    );



    public static void registerModEntities() {
        FurnitureMod.LOGGER.info("Registering Mod Entities for " + FurnitureMod.MOD_ID);
    }
}
