package net.beloiswhite.grandcup.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.beloiswhite.grandcup.entity.InsomniaPortalEntity;
import net.beloiswhite.grandcup.GrandcupMod;

import java.util.Map;

public class ForcedNetherHeartTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GrandcupMod.LOGGER.warn("Failed to load dependency world for procedure ForcedNetherHeartTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GrandcupMod.LOGGER.warn("Failed to load dependency x for procedure ForcedNetherHeartTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GrandcupMod.LOGGER.warn("Failed to load dependency y for procedure ForcedNetherHeartTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GrandcupMod.LOGGER.warn("Failed to load dependency z for procedure ForcedNetherHeartTickUpdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GrandcupMod.LOGGER.warn("Failed to load dependency entity for procedure ForcedNetherHeartTickUpdate!");
			return;
		}
		if (dependencies.get("immediatesourceentity") == null) {
			if (!dependencies.containsKey("immediatesourceentity"))
				GrandcupMod.LOGGER.warn("Failed to load dependency immediatesourceentity for procedure ForcedNetherHeartTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
		if ((world.getFluidState(new BlockPos(x, y, z)).getBlockState()).getBlock() == Blocks.LAVA
				|| (world.getFluidState(new BlockPos(x, y, z)).getBlockState()).getBlock() == Blocks.LAVA) {
			if (entity.getPosY() - y >= 20) {
				if ((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.THE_NETHER)) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new InsomniaPortalEntity.CustomEntity(InsomniaPortalEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, (y + 2), z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if (!immediatesourceentity.world.isRemote())
				immediatesourceentity.remove();
		}
	}
}
