package net.mess.furnituremod;

import net.fabricmc.api.ClientModInitializer;
import net.mess.furnituremod.entity.ModEntities;
import net.mess.furnituremod.entity.client.SitRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class FurnitureModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        EntityRenderers.register(ModEntities.SIT, SitRenderer::new);

    }
}
