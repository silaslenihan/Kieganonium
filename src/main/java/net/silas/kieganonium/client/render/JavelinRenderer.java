package net.silas.kieganonium.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
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

        float yaw = Mth.lerp(partialTicks, entity.yRotO, entity.getYRot());
        float pitch = Mth.lerp(partialTicks, entity.xRotO, entity.getXRot());

        poseStack.mulPose(Axis.YP.rotationDegrees(yaw));
        poseStack.mulPose(Axis.ZP.rotationDegrees(pitch));

        if (entity.isHuge()) {
            poseStack.scale(3.0F, 3.0F, 3.0F);
        }

        // Render the normal javelin model
        this.model.renderToBuffer(
                poseStack,
                buffer.getBuffer(this.model.renderType(getTextureLocation(entity))),
                packedLight,
                OverlayTexture.NO_OVERLAY,
                0xFFFFFF
        );

        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
