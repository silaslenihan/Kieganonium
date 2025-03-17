package net.silas.kieganonium.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.Level;
import net.silas.kieganonium.entity.custom.ThrownJavelin;
import org.jetbrains.annotations.NotNull;

public class JavelinItem extends TridentItem {
    public JavelinItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        // Start charging animation if player is holding down right-click
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity, int timeCharged) {
        if (!(entity instanceof Player player)) return;

        // Ensure we only throw on the server
        if (!level.isClientSide) {
            ThrownJavelin thrownJavelin = new ThrownJavelin(level, player, stack);
            thrownJavelin.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
            level.addFreshEntity(thrownJavelin);
            System.out.println("Spawned javelin at " + thrownJavelin.position());

            // Play throw sound
            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);

            // Remove one javelin from inventory unless in creative mode
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
    }
}
