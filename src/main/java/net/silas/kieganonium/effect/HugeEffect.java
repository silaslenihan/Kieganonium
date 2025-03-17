package net.silas.kieganonium.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

public class HugeEffect extends MobEffect {
    protected HugeEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        AttributeInstance scaleAttribute = pLivingEntity.getAttribute(Attributes.SCALE);
        AttributeInstance blockRangeAttribute = pLivingEntity.getAttribute(Attributes.BLOCK_INTERACTION_RANGE);
        AttributeInstance entityRangeAttribute = pLivingEntity.getAttribute(Attributes.ENTITY_INTERACTION_RANGE);
        AttributeInstance movementSpeedAttribute = pLivingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        AttributeInstance stepHeightAttribute = pLivingEntity.getAttribute(Attributes.STEP_HEIGHT);
        AttributeInstance jumpStrengthAttribute = pLivingEntity.getAttribute(Attributes.JUMP_STRENGTH);
        AttributeInstance gravityAttribute = pLivingEntity.getAttribute(Attributes.GRAVITY);
        AttributeInstance safeFallDistanceAttribute = pLivingEntity.getAttribute(Attributes.SAFE_FALL_DISTANCE);

        float multiplier = 5.0F;

        if (scaleAttribute != null) {
            scaleAttribute.setBaseValue(multiplier);
        }
        if (blockRangeAttribute != null) {
            blockRangeAttribute.setBaseValue(4.5F * multiplier);
        }
        if (entityRangeAttribute != null) {
            entityRangeAttribute.setBaseValue(3.0F * multiplier);
        }
        if (movementSpeedAttribute != null) {
            movementSpeedAttribute.setBaseValue(0.1F * multiplier);
        }
        if (stepHeightAttribute != null) {
            stepHeightAttribute.setBaseValue(1.0F);
        }
        if (jumpStrengthAttribute != null) {
            jumpStrengthAttribute.setBaseValue(0.42F * (multiplier / 1.5));
        }
        if (gravityAttribute != null) {
            gravityAttribute.setBaseValue(0.08 * multiplier / 2.5);
        }
        if (safeFallDistanceAttribute != null) {
            safeFallDistanceAttribute.setBaseValue(3.0F * multiplier);
        }
        return true;
    }

    @Override
    public void removeAttributeModifiers(@NotNull AttributeMap pAttributeMap) {
        super.removeAttributeModifiers(pAttributeMap);

        // Get the SCALE attribute and reset it
        AttributeInstance scaleAttribute = pAttributeMap.getInstance(Attributes.SCALE);
        AttributeInstance blockRangeAttribute = pAttributeMap.getInstance(Attributes.BLOCK_INTERACTION_RANGE);
        AttributeInstance entityRangeAttribute = pAttributeMap.getInstance(Attributes.ENTITY_INTERACTION_RANGE);
        AttributeInstance movementSpeedAttribute = pAttributeMap.getInstance(Attributes.MOVEMENT_SPEED);
        AttributeInstance stepHeightAttribute = pAttributeMap.getInstance(Attributes.STEP_HEIGHT);
        AttributeInstance jumpStrengthAttribute = pAttributeMap.getInstance(Attributes.JUMP_STRENGTH);
        AttributeInstance gravityAttribute = pAttributeMap.getInstance(Attributes.GRAVITY);
        AttributeInstance safeFallDistanceAttribute = pAttributeMap.getInstance(Attributes.SAFE_FALL_DISTANCE);

        if (scaleAttribute != null) {
            scaleAttribute.setBaseValue(1.0F); // Reset size to normal
        }
        if (blockRangeAttribute != null) {
            blockRangeAttribute.setBaseValue(4.5F);
        }
        if (entityRangeAttribute != null) {
            entityRangeAttribute.setBaseValue(3.0F);
        }
        if (movementSpeedAttribute != null) {
            movementSpeedAttribute.setBaseValue(0.1F);
        }
        if (stepHeightAttribute != null) {
            stepHeightAttribute.setBaseValue(0.6F);
        }
        if (jumpStrengthAttribute != null) {
            jumpStrengthAttribute.setBaseValue(0.42F);
        }
        if (gravityAttribute != null) {
            gravityAttribute.setBaseValue(0.08F);
        }
        if (safeFallDistanceAttribute != null) {
            safeFallDistanceAttribute.setBaseValue(3.0F);
        }
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}
