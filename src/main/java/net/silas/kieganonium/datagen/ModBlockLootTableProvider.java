package net.silas.kieganonium.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.silas.kieganonium.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.silas.kieganonium.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.KIEGANONIUM_BLOCK.get());
        dropSelf(ModBlocks.RAW_KIEGANONIUM_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());

        this.add(ModBlocks.KIEGANONIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.KIEGANONIUM_BLOCK.get(), ModItems.RAW_KIEGANONIUM.get()));
        this.add(ModBlocks.KIEGANONIUM_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.KIEGANONIUM_DEEPSLATE_ORE.get(), ModItems.RAW_KIEGANONIUM.get(), 2, 6));

        dropSelf(ModBlocks.KIEGANONIUM_STAIRS.get());
        this.add(ModBlocks.KIEGANONIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.KIEGANONIUM_SLAB.get()));
        dropSelf(ModBlocks.KIEGANONIUM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.KIEGANONIUM_BUTTON.get());
        dropSelf(ModBlocks.KIEGANONIUM_FENCE.get());
        dropSelf(ModBlocks.KIEGANONIUM_FENCE_GATE.get());
        dropSelf(ModBlocks.KIEGANONIUM_WALL.get());
        dropSelf(ModBlocks.KIEGANONIUM_TRAPDOOR.get());

        this.add(ModBlocks.KIEGANONIUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.KIEGANONIUM_DOOR.get()));

        dropSelf(ModBlocks.KIEGANONIUM_LAMP.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                (LootPoolEntryContainer.Builder<?>) this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
