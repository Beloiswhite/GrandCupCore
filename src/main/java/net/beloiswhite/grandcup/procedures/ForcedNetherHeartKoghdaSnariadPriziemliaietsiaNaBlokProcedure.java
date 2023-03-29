package net.beloiswhite.grandcup.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.beloiswhite.grandcup.item.ForcedNetherHeartItem;
import net.beloiswhite.grandcup.GrandcupMod;

import java.util.Map;

public class ForcedNetherHeartKoghdaSnariadPriziemliaietsiaNaBlokProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GrandcupMod.LOGGER.warn("Failed to load dependency world for procedure ForcedNetherHeartKoghdaSnariadPriziemliaietsiaNaBlok!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GrandcupMod.LOGGER.warn("Failed to load dependency x for procedure ForcedNetherHeartKoghdaSnariadPriziemliaietsiaNaBlok!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GrandcupMod.LOGGER.warn("Failed to load dependency y for procedure ForcedNetherHeartKoghdaSnariadPriziemliaietsiaNaBlok!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GrandcupMod.LOGGER.warn("Failed to load dependency z for procedure ForcedNetherHeartKoghdaSnariadPriziemliaietsiaNaBlok!");
			return;
		}
		if (dependencies.get("immediatesourceentity") == null) {
			if (!dependencies.containsKey("immediatesourceentity"))
				GrandcupMod.LOGGER
						.warn("Failed to load dependency immediatesourceentity for procedure ForcedNetherHeartKoghdaSnariadPriziemliaietsiaNaBlok!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
		if (!immediatesourceentity.world.isRemote())
			immediatesourceentity.remove();
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ForcedNetherHeartItem.block));
			entityToSpawn.setPickupDelay((int) 10);
			entityToSpawn.setNoDespawn();
			world.addEntity(entityToSpawn);
		}
	}
}
