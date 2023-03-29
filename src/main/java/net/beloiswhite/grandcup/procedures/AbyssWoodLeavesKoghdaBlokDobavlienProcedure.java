package net.beloiswhite.grandcup.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.beloiswhite.grandcup.block.AbyssvineBlock;
import net.beloiswhite.grandcup.GrandcupMod;

import java.util.Map;

public class AbyssWoodLeavesKoghdaBlokDobavlienProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GrandcupMod.LOGGER.warn("Failed to load dependency world for procedure AbyssWoodLeavesKoghdaBlokDobavlien!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GrandcupMod.LOGGER.warn("Failed to load dependency x for procedure AbyssWoodLeavesKoghdaBlokDobavlien!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GrandcupMod.LOGGER.warn("Failed to load dependency y for procedure AbyssWoodLeavesKoghdaBlokDobavlien!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GrandcupMod.LOGGER.warn("Failed to load dependency z for procedure AbyssWoodLeavesKoghdaBlokDobavlien!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (Math.random() < 0.1) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.AIR) {
				world.setBlockState(new BlockPos(x, y - 1, z), AbyssvineBlock.block.getDefaultState(), 3);
			}
		}
	}
}
