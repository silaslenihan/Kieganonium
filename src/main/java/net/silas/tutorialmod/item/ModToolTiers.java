package net.silas.tutorialmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.silas.tutorialmod.util.ModTags;

public class ModToolTiers {
    public static final Tier ALEXANDRITE = new ForgeTier(1400, 4, 3f, 20,
            ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL, () -> Ingredient.of(ModItems.ALEXANDRITE.get()),
            ModTags.Blocks.INCORRECT_FOR_ALEXANDRITE_TOOL);
    
}
