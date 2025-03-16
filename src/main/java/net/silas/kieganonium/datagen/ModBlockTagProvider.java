package net.silas.kieganonium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.silas.kieganonium.Kieganonium;
import net.silas.kieganonium.block.ModBlocks;
import net.silas.kieganonium.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Kieganonium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.KIEGANONIUM_BLOCK.get())
                .add(ModBlocks.RAW_KIEGANONIUM_BLOCK.get())
                .add(ModBlocks.KIEGANONIUM_ORE.get())
                .add(ModBlocks.KIEGANONIUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.KIEGANONIUM_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_KIEGANONIUM_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.KIEGANONIUM_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.KIEGANONIUM_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.KIEGANONIUM_WALL.get());

        tag(ModTags.Blocks.NEEDS_KIEGANONIUM_TOOL)
                .add(ModBlocks.RAW_KIEGANONIUM_BLOCK.get())
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_KIEGANONIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_KIEGANONIUM_TOOL);
    }
}
