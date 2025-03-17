package net.silas.kieganonium.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.kieganonium.Kieganonium;
import net.silas.kieganonium.entity.custom.ThrownJavelin;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Kieganonium.MOD_ID);

    public static final RegistryObject<EntityType<ThrownJavelin>> THROWN_JAVELIN =
            ENTITIES.register("thrown_javelin",
                    () -> EntityType.Builder.<ThrownJavelin>of(ThrownJavelin::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F) // Size of the entity
                            .clientTrackingRange(8) // How far away it is tracked
                            .updateInterval(10) // How often it updates
                            .build("thrown_javelin"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
