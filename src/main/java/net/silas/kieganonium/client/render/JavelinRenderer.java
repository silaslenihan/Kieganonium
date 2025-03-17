package net.silas.kieganonium.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.silas.kieganonium.Kieganonium;
import net.silas.kieganonium.client.model.ModelJavelin;
import net.silas.kieganonium.entity.custom.ThrownJavelin;
import org.jetbrains.annotations.NotNull;

public class JavelinRenderer extends EntityRenderer<ThrownJavelin> {
    // For the in-flight texture
    // Use parse(...) to avoid private 2-arg constructor if needed:
    private static final ResourceLocation TEXTURE =
            ResourceLocation.tryParse(Kieganonium.MOD_ID + ":textures/entity/javelin_model.png");

    private final ModelJavelin model;

    public JavelinRenderer(EntityRendererProvider.Context context) {
        super(context);

        // Bake the layer from ModelJavelin
        // This gets the ModelPart root from the layer
        var bakedLayer = context.bakeLayer(ModelJavelin.LAYER_LOCATION);
        this.model = new ModelJavelin(bakedLayer);

        // Adjust shadow size as you prefer
        this.shadowRadius = 0.3F;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(ThrownJavelin entity) {
        return TEXTURE;
    }

    @Override
    public void render(ThrownJavelin entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        // Basic rotation to face the flying direction
        float yaw = Mth.lerp(partialTicks, entity.yRotO, entity.getYRot());
        float pitch = Mth.lerp(partialTicks, entity.xRotO, entity.getXRot());

        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(yaw));
        poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(pitch));

        // If you want a smaller or bigger javelin, scale here:
        // poseStack.scale(0.5F, 0.5F, 0.5F);

        // Our 5-arg renderToBuffer includes pColor, so let's pass 0xFFFFFF for white
        // (alpha is presumably omitted in your version)
        model.renderToBuffer(
                poseStack,
                buffer.getBuffer(model.renderType(TEXTURE)),
                packedLight,
                OverlayTexture.NO_OVERLAY,
                0xFFFFFF // Full white color
        );

        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
