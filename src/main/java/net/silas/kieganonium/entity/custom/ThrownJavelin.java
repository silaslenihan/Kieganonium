package net.silas.kieganonium.entity.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.silas.kieganonium.entity.ModEntities;
import net.silas.kieganonium.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class ThrownJavelin extends ThrownTrident implements ItemSupplier {
    private final ItemStack javelinStack;

    public ThrownJavelin(EntityType<? extends ThrownTrident> entityType, Level level) {
        super(entityType, level);
        this.javelinStack = new ItemStack(ModItems.JAVELIN.get());
    }

    public ThrownJavelin(Level level, LivingEntity thrower, ItemStack stack) {
        super(ModEntities.THROWN_JAVELIN.get(), level);

        this.setOwner(thrower);

        // ** Move to the thrower's eye position (minus a little) **
        this.setPos(thrower.getX(), thrower.getEyeY() - 0.1D, thrower.getZ());

        this.javelinStack = stack.copy();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGround && this.getOwner() instanceof Player player) {
            this.returnToThrower(player);
            this.discard();
        }
    }

    private void returnToThrower(Player player) {
        if (!player.getInventory().add(this.javelinStack)) {
            this.spawnAtLocation(this.javelinStack);
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        this.playSound(SoundEvents.TRIDENT_RETURN, 1.0F, 1.0F);

        double x = hitResult.getLocation().x();
        double y = hitResult.getLocation().y();
        double z = hitResult.getLocation().z();

        explode(x, y, z);

        strikeLightningAt(x, y, z);
        strikeLightningAt(x, y, z);
        strikeLightningAt(x, y, z);
    }


    @Override
    protected void onHitBlock(BlockHitResult hitResult) {
        super.onHitBlock(hitResult);

        double x = hitResult.getBlockPos().getX() + 0.5D;
        double y = hitResult.getBlockPos().getY();
        double z = hitResult.getBlockPos().getZ() + 0.5D;

        explode(x, y, z);

        strikeLightningAt(x, y, z);
        strikeLightningAt(x, y, z);
        strikeLightningAt(x, y, z);
    }

    private void explode(double x, double y, double z) {
        if (!this.level().isClientSide) {
            this.level().explode(
                    this,
                    x, y, z,
                    5.0F,
                    Level.ExplosionInteraction.TNT
            );
        }
    }


    private void strikeLightningAt(double x, double y, double z) {
        if (!this.level().isClientSide) {
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(this.level());
            if (lightning != null) {
                lightning.moveTo(x, y, z);
                lightning.setCause(this.getOwner() instanceof ServerPlayer player ? player : null);
                this.level().addFreshEntity(lightning);
            }
        }
    }

    @Override
    public @NotNull ItemStack getItem() {
        return javelinStack;
    }
}
