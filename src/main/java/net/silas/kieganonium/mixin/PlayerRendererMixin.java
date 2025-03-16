package net.silas.kieganonium.mixin;

import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(PlayerRenderer.class)
public class PlayerRendererMixin {
    /**
     * @param pLivingEntity
     * @param pPoseStack
     * @param pPartialTickTime
     * @author silaslenihan
     * @reason For getting huge
     */
//    @Overwrite
//    protected void scale(AbstractClientPlayer pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
//        float f = 3.0F;
//        pPoseStack.scale(f, f, f);
//    }
}
