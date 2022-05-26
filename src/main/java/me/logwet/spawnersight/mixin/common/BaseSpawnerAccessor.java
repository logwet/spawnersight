package me.logwet.spawnersight.mixin.common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BaseSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BaseSpawner.class)
public interface BaseSpawnerAccessor {
    @Invoker("getEntityId")
    ResourceLocation getEntityIdInvoker();
}
