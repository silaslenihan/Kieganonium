package net.silas.kieganonium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.silas.kieganonium.Kieganonium;
import net.silas.kieganonium.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Kieganonium.MOD_ID);

    public static final RegistryObject<CreativeModeTab> KIEGANONIUM_ITEMS =
            CREATIVE_MODE_TABS.register("kieganonium_items_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KIEGANONIUM.get()))
                            .title(Component.translatable("creativetab.kieganonium.kieganonium_items"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.KIEGANONIUM.get());
//                                output.accept(ModItems.RAW_KIEGANONIUM.get());
//                                output.accept(ModItems.CHISEL.get());
//                                output.accept(ModItems.KOHLRABI.get());
//                                output.accept(ModItems.AURORA_ASHES.get());
                                output.accept(ModItems.KIEGANONIUM_SWORD.get());
                                output.accept(ModItems.KIEGANONIUM_PICKAXE.get());
                                output.accept(ModItems.KIEGANONIUM_SHOVEL.get());
                                output.accept(ModItems.KIEGANONIUM_AXE.get());
                                output.accept(ModItems.KIEGANONIUM_HOE.get());
                                output.accept(ModItems.KIEGANONIUM_HAMMER.get());
                                output.accept(ModItems.KIEGANONIUM_HELMET.get());
                                output.accept(ModItems.KIEGANONIUM_CHESTPLATE.get());
                                output.accept(ModItems.KIEGANONIUM_LEGGINGS.get());
                                output.accept(ModItems.KIEGANONIUM_BOOTS.get());
                                output.accept(ModItems.JAVELIN.get());
                            })
                            .build());

//    public static final RegistryObject<CreativeModeTab> KIEGANONIUM_BLOCKS =
//            CREATIVE_MODE_TABS.register("kieganonium_blocks_tab",
//                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.KIEGANONIUM_BLOCK.get()))
//                            .withTabsBefore(KIEGANONIUM_ITEMS.getId())
//                            .title(Component.translatable("creativetab.kieganonium.kieganonium_blocks"))
//                            .displayItems((itemDisplayParameters, output) -> {
//                                output.accept(ModBlocks.KIEGANONIUM_BLOCK.get());
//                                output.accept(ModBlocks.RAW_KIEGANONIUM_BLOCK.get());
//                                output.accept(ModBlocks.MAGIC_BLOCK.get());
//                                output.accept(ModBlocks.KIEGANONIUM_DEEPSLATE_ORE.get());
//                                output.accept(ModBlocks.KIEGANONIUM_ORE.get());
//                                output.accept(ModBlocks.KIEGANONIUM_STAIRS.get());
//                                output.accept(ModBlocks.KIEGANONIUM_SLAB.get());
//
//                                output.accept(ModBlocks.KIEGANONIUM_PRESSURE_PLATE.get());
//                                output.accept(ModBlocks.KIEGANONIUM_BUTTON.get());
//
//                                output.accept(ModBlocks.KIEGANONIUM_FENCE.get());
//                                output.accept(ModBlocks.KIEGANONIUM_FENCE_GATE.get());
//                                output.accept(ModBlocks.KIEGANONIUM_WALL.get());
//
//                                output.accept(ModBlocks.KIEGANONIUM_DOOR.get());
//                                output.accept(ModBlocks.KIEGANONIUM_TRAPDOOR.get());
//                                output.accept(ModBlocks.KIEGANONIUM_LAMP.get());
//                            })
//                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
