package me.logwet.spawnersight.mixin.common;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public abstract class LevelMixin {
    @Inject(method = "method_18473", at = @At("TAIL"), cancellable = true, remap = false)
    private static void overrideProfilerString(
            BlockEntity blockEntity, CallbackInfoReturnable<String> cir) {
        if (BlockEntityType.MOB_SPAWNER.equals(blockEntity.getType())
                && blockEntity instanceof SpawnerBlockEntity) {
            SpawnerBlockEntity spawnerBlockEntity = (SpawnerBlockEntity) blockEntity;
            cir.setReturnValue(
                    cir.getReturnValue()
                            + "["
                            + ((BaseSpawnerAccessor) spawnerBlockEntity.getSpawner())
                                    .getEntityIdInvoker()
                                    .toString()
                            + "]");
        }
    }
}
