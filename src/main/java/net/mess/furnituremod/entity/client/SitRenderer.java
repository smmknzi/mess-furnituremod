package net.mess.furnituremod.entity.client;

import net.mess.furnituremod.entity.custom.SitEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class SitRenderer extends EntityRenderer<SitEntity, EntityRenderState> {
    public SitRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    public boolean shouldRender(SitEntity entity, Frustum culler, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }
}
