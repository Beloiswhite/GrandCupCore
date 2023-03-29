package net.beloiswhite.grandcup.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;

import net.beloiswhite.grandcup.GrandcupMod;

import java.util.Map;

public class InsomniaPortalNaturalnoieUsloviiePoiavlieniiaSushchnostiProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GrandcupMod.LOGGER.warn("Failed to load dependency world for procedure InsomniaPortalNaturalnoieUsloviiePoiavlieniiaSushchnosti!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.THE_NETHER)) {
			return true;
		}
		return false;
	}
}
