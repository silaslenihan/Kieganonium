package net.silas.kieganonium.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.silas.kieganonium.util.ModTags;

public class ModToolTiers {
    public static final Tier KIEGANONIUM = new ForgeTier(1400, 50, 3f, 20,
            ModTags.Blocks.NEEDS_KIEGANONIUM_TOOL, () -> Ingredient.of(ModItems.KIEGANONIUM.get()),
            ModTags.Blocks.INCORRECT_FOR_KIEGANONIUM_TOOL);

}
