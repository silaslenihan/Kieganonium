package net.silas.kieganonium.event;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.silas.kieganonium.Kieganonium;
import net.silas.kieganonium.item.custom.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Kieganonium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        // Only do this if the old player actually died
        if (event.isWasDeath()) {
            Player newPlayer = event.getEntity();

            // Reset each attribute to its normal default
            if (newPlayer.getAttribute(Attributes.SCALE) != null) {
                newPlayer.getAttribute(Attributes.SCALE).setBaseValue(1.0F);
            }
            if (newPlayer.getAttribute(Attributes.BLOCK_INTERACTION_RANGE) != null) {
                newPlayer.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).setBaseValue(4.5F);
            }
            if (newPlayer.getAttribute(Attributes.ENTITY_INTERACTION_RANGE) != null) {
                newPlayer.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).setBaseValue(3.0F);
            }
            if (newPlayer.getAttribute(Attributes.MOVEMENT_SPEED) != null) {
                newPlayer.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1F);
            }
            if (newPlayer.getAttribute(Attributes.STEP_HEIGHT) != null) {
                newPlayer.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.6F);
            }
            if (newPlayer.getAttribute(Attributes.JUMP_STRENGTH) != null) {
                newPlayer.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.42F);
            }
            if (newPlayer.getAttribute(Attributes.GRAVITY) != null) {
                newPlayer.getAttribute(Attributes.GRAVITY).setBaseValue(0.08F);
            }
            if (newPlayer.getAttribute(Attributes.SAFE_FALL_DISTANCE) != null) {
                newPlayer.getAttribute(Attributes.SAFE_FALL_DISTANCE).setBaseValue(3.0F);
            }
        }
    }
}