package net.silas.kieganonium.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.silas.kieganonium.Kieganonium;
import net.silas.kieganonium.client.model.ModelJavelin;
import net.silas.kieganonium.entity.ModEntities;
import net.silas.kieganonium.client.render.JavelinRenderer;

@Mod.EventBusSubscriber(modid = Kieganonium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelJavelin.LAYER_LOCATION, ModelJavelin::createBodyLayer);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(
                ModEntities.THROWN_JAVELIN.get(),
                JavelinRenderer::new
        );
    }
}
