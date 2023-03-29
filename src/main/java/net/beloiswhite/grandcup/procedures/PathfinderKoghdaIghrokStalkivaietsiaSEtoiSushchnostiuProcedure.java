package net.beloiswhite.grandcup.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.beloiswhite.grandcup.item.SoulclusterItem;
import net.beloiswhite.grandcup.GrandcupMod;

import java.util.Map;
import java.util.Iterator;

public class PathfinderKoghdaIghrokStalkivaietsiaSEtoiSushchnostiuProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GrandcupMod.LOGGER.warn("Failed to load dependency entity for procedure PathfinderKoghdaIghrokStalkivaietsiaSEtoiSushchnostiu!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				GrandcupMod.LOGGER
						.warn("Failed to load dependency sourceentity for procedure PathfinderKoghdaIghrokStalkivaietsiaSEtoiSushchnostiu!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (!entity.world.isRemote())
			entity.remove();
		if (sourceentity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(SoulclusterItem.block);
			((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) sourceentity).container.func_234641_j_());
		}
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).setHealth((float) 1);
		if (sourceentity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("grandcup:soul_cluster_pick_up"));
			AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
	}
}
