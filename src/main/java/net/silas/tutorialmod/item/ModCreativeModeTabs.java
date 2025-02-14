package net.silas.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.silas.tutorialmod.TutorialMod;
import net.silas.tutorialmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS =
            CREATIVE_MODE_TABS.register("alexandrite_items_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXDRITE.get()))
                            .title(Component.translatable("creativetab.tutorialmod.alexandite_items"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.ALEXDRITE.get());
                                output.accept(ModItems.RAW_ALEXANDRITE.get());
                            })
                            .build());

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_BLOCKS =
            CREATIVE_MODE_TABS.register("alexandrite_blocks_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                            .withTabsBefore(ALEXANDRITE_ITEMS.getId())
                            .title(Component.translatable("creativetab.tutorialmod.alexandite_blocks"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                                output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                            })
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus) ;
    }
}
