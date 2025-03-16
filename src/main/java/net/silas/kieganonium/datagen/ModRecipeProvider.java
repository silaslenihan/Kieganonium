package net.silas.kieganonium.datagen;

import net.silas.kieganonium.Kieganonium;
import net.silas.kieganonium.block.ModBlocks;
import net.silas.kieganonium.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> KIEGANONIUM_SMELTABLES = List.of(ModItems.RAW_KIEGANONIUM.get(),
                ModBlocks.KIEGANONIUM_ORE.get(), ModBlocks.KIEGANONIUM_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.KIEGANONIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.KIEGANONIUM.get())
                .unlockedBy(getHasName(ModItems.KIEGANONIUM.get()), has(ModItems.KIEGANONIUM.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.KIEGANONIUM.get(), 9)
                .requires(ModBlocks.KIEGANONIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.KIEGANONIUM_BLOCK.get()), has(ModBlocks.KIEGANONIUM_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.KIEGANONIUM.get(), 32)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.KIEGANONIUM_BLOCK.get()), has(ModBlocks.KIEGANONIUM_BLOCK.get()))
                .save(pRecipeOutput, Kieganonium.MOD_ID + ":kieganonium_from_magic_block");

        oreSmelting(pRecipeOutput, KIEGANONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.KIEGANONIUM.get(), 0.25f, 200, "kieganonium");
        oreBlasting(pRecipeOutput, KIEGANONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.KIEGANONIUM.get(), 0.25f, 100, "kieganonium");

        stairBuilder(ModBlocks.KIEGANONIUM_STAIRS.get(), Ingredient.of(ModItems.KIEGANONIUM.get())).group("kieganonium")
                .unlockedBy(getHasName(ModItems.KIEGANONIUM.get()), has(ModItems.KIEGANONIUM.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.KIEGANONIUM_SLAB.get(), ModItems.KIEGANONIUM.get());

        buttonBuilder(ModBlocks.KIEGANONIUM_BUTTON.get(), Ingredient.of(ModItems.KIEGANONIUM.get())).group("kieganonium")
                .unlockedBy(getHasName(ModItems.KIEGANONIUM.get()), has(ModItems.KIEGANONIUM.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.KIEGANONIUM_PRESSURE_PLATE.get(), ModItems.KIEGANONIUM.get());

        fenceBuilder(ModBlocks.KIEGANONIUM_FENCE.get(), Ingredient.of(ModItems.KIEGANONIUM.get())).group("kieganonium")
                .unlockedBy(getHasName(ModItems.KIEGANONIUM.get()), has(ModItems.KIEGANONIUM.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.KIEGANONIUM_FENCE_GATE.get(), Ingredient.of(ModItems.KIEGANONIUM.get())).group("kieganonium")
                .unlockedBy(getHasName(ModItems.KIEGANONIUM.get()), has(ModItems.KIEGANONIUM.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.KIEGANONIUM_WALL.get(), ModItems.KIEGANONIUM.get());

        doorBuilder(ModBlocks.KIEGANONIUM_DOOR.get(), Ingredient.of(ModItems.KIEGANONIUM.get())).group("kieganonium")
                .unlockedBy(getHasName(ModItems.KIEGANONIUM.get()), has(ModItems.KIEGANONIUM.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.KIEGANONIUM_TRAPDOOR.get(), Ingredient.of(ModItems.KIEGANONIUM.get())).group("kieganonium")
                .unlockedBy(getHasName(ModItems.KIEGANONIUM.get()), has(ModItems.KIEGANONIUM.get())).save(pRecipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Kieganonium.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}