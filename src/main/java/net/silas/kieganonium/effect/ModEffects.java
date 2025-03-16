package net.silas.kieganonium.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.kieganonium.Kieganonium;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Kieganonium.MOD_ID);

    public static final RegistryObject<MobEffect> HUGE = EFFECTS.register("huge", () -> new HugeEffect(MobEffectCategory.BENEFICIAL, 0xFFA500));

    public static Holder<MobEffect> HUGE_HOLDER() {
        return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(HUGE.get());
    }

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}