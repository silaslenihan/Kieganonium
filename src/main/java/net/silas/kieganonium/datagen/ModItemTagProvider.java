package net.silas.kieganonium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silas.kieganonium.Kieganonium;
import net.silas.kieganonium.item.ModItems;
import net.silas.kieganonium.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Kieganonium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.KIEGANONIUM.get())
                .add(ModItems.RAW_KIEGANONIUM.get())
                .add(Items.STICK)
                .add(Items.COAL)
                .add(Items.COMPASS);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.KIEGANONIUM_HELMET.get())
                .add(ModItems.KIEGANONIUM_CHESTPLATE.get())
                .add(ModItems.KIEGANONIUM_LEGGINGS.get())
                .add(ModItems.KIEGANONIUM_BOOTS.get());
    }


}
