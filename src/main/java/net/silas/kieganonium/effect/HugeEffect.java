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
        if (scaleAttribute != null) {
            scaleAttribute.setBaseValue(5.0F);
        }
        return true;
    }

    @Override
    public void removeAttributeModifiers(@NotNull AttributeMap pAttributeMap) {
        super.removeAttributeModifiers(pAttributeMap);

        // Get the SCALE attribute and reset it
        AttributeInstance scaleAttribute = pAttributeMap.getInstance(Attributes.SCALE);
        if (scaleAttribute != null) {
            scaleAttribute.setBaseValue(1.0F); // Reset size to normal
        }
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}
