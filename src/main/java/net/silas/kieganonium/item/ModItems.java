package net.silas.kieganonium.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.kieganonium.Kieganonium;
import net.silas.kieganonium.item.custom.*;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Kieganonium.MOD_ID);

    public static final RegistryObject<Item> KIEGANONIUM = ITEMS.register("kieganonium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_KIEGANONIUM = ITEMS.register("raw_kieganonium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.kieganonium.kohlrabi"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",
            () -> new FuelItem(new Item.Properties(), 1200));


    public static final RegistryObject<Item> KIEGANONIUM_SWORD = ITEMS.register("kieganonium_sword",
            () -> new SwordItem(ModToolTiers.KIEGANONIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.KIEGANONIUM, 3, -2.4f))));
    public static final RegistryObject<Item> KIEGANONIUM_PICKAXE = ITEMS.register("kieganonium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.KIEGANONIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.KIEGANONIUM, 1, -2.8f))));
    public static final RegistryObject<Item> KIEGANONIUM_SHOVEL = ITEMS.register("kieganonium_shovel",
            () -> new ShovelItem(ModToolTiers.KIEGANONIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.KIEGANONIUM, 1.5f, -3.0f))));
    public static final RegistryObject<Item> KIEGANONIUM_AXE = ITEMS.register("kieganonium_axe",
            () -> new AxeItem(ModToolTiers.KIEGANONIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.KIEGANONIUM, 6, -3.2f))));
    public static final RegistryObject<Item> KIEGANONIUM_HOE = ITEMS.register("kieganonium_hoe",
            () -> new HoeItem(ModToolTiers.KIEGANONIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.KIEGANONIUM, 0, -3))));
    public static final RegistryObject<Item> KIEGANONIUM_HAMMER = ITEMS.register("kieganonium_hammer",
            () -> new HammerItem(ModToolTiers.KIEGANONIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.KIEGANONIUM, 7, -3.5f))));

    public static final RegistryObject<Item> KIEGANONIUM_HELMET = ITEMS.register("kieganonium_helmet",
            () -> new ModArmorItem(ModArmorMaterials.KIEGANONIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));
    public static final RegistryObject<Item> KIEGANONIUM_CHESTPLATE = ITEMS.register("kieganonium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.KIEGANONIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> KIEGANONIUM_LEGGINGS = ITEMS.register("kieganonium_leggings",
            () -> new ArmorItem(ModArmorMaterials.KIEGANONIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));
    public static final RegistryObject<Item> KIEGANONIUM_BOOTS = ITEMS.register("kieganonium_boots",
            () -> new ArmorItem(ModArmorMaterials.KIEGANONIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));
    public static final RegistryObject<Item> KIEGANONIUM_BODY = ITEMS.register("kieganonium_body",
            () -> new ArmorItem(ModArmorMaterials.KIEGANONIUM_ARMOR_MATERIAL, ArmorItem.Type.BODY,
                    new Item.Properties().durability(ArmorItem.Type.BODY.getDurability(18))));

    public static final RegistryObject<Item> JAVELIN = ITEMS.register("javelin",
            () -> new JavelinItem(new Item.Properties().durability(250)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
