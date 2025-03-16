package net.silas.kieganonium.mixin;

import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow
    public abstract EntityDimensions getDimensions(Pose pPose);

//    @Inject(method = "tick", at = @At("HEAD"))
//    private void onTickStart(CallbackInfo ci) {
//        getDimensions(Pose.STANDING);
//    }

    /**
     * @author Silas
     * @reason Huge
     */
//    @Overwrite
//    public float getScale() {
//        LivingEntity entity = (LivingEntity) (Object) this;
//
//        if (entity instanceof Player player) {
//            return 3.0F;
//        } else {
//            return 1.0F;
//        }
//    }

    // Injecting at the start of the 'getDimensions' method (this is where we modify the size)
//    @Inject(method = "getDimensions", at = @At("HEAD"), cancellable = true)
//    private void modifyPlayerSize(Pose pose, CallbackInfoReturnable<EntityDimensions> cir) {
//        System.out.println("test");
//        LivingEntity entity = (LivingEntity) (Object) this;
//
//        // Check if the entity is an instance of Player
//        if (entity instanceof Player player) {
//            player.setPose(Pose.CROUCHING);
//
//            // Check if the player has the "Huge" effect or any other condition you want
//            float scale = 5.0F;  // Scale factor, change this depending on your condition
//
//            // Calculate the new width and height based on the scale
//            float newWidth = 0.6F * scale;
//            float newHeight = 1.8F * scale;
//
//            // Set the new dimensions
//            cir.setReturnValue(EntityDimensions.scalable(newWidth, newHeight)
//                    .withEyeHeight(1.62F * scale));  // Adjust the eye height if needed
//        }
//    }
}
