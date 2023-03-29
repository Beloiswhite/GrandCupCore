package net.beloiswhite.grandcup.procedures;

import net.beloiswhite.grandcup.GrandcupMod;

import java.util.Map;

public class AbyssconfusedparticleDopolnitielnoieUsloviieIstiechieniiaSrokaDieistviiaChastitsProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GrandcupMod.LOGGER.warn(
						"Failed to load dependency y for procedure AbyssconfusedparticleDopolnitielnoieUsloviieIstiechieniiaSrokaDieistviiaChastits!");
			return false;
		}
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		if (y < 60) {
			return true;
		}
		return false;
	}
}
