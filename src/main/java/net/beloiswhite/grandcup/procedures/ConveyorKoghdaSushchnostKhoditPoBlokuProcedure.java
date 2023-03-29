package net.beloiswhite.grandcup.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.beloiswhite.grandcup.GrandcupMod;

import java.util.Map;
import java.util.Collections;

public class ConveyorKoghdaSushchnostKhoditPoBlokuProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GrandcupMod.LOGGER.warn("Failed to load dependency world for procedure ConveyorKoghdaSushchnostKhoditPoBloku!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GrandcupMod.LOGGER.warn("Failed to load dependency x for procedure ConveyorKoghdaSushchnostKhoditPoBloku!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GrandcupMod.LOGGER.warn("Failed to load dependency y for procedure ConveyorKoghdaSushchnostKhoditPoBloku!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GrandcupMod.LOGGER.warn("Failed to load dependency z for procedure ConveyorKoghdaSushchnostKhoditPoBloku!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GrandcupMod.LOGGER.warn("Failed to load dependency entity for procedure ConveyorKoghdaSushchnostKhoditPoBloku!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ItemEntity) {
			if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos(x, y, z))) == Direction.NORTH) {
				entity.setMotion(0, 0, (-0.125));
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((entity.getPosX()), (entity.getPosY() + 0.015), (entity.getPosZ()));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), (entity.getPosY() + 0.015), (entity.getPosZ()),
								_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
					}
				}
			}
			if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos(x, y, z))) == Direction.SOUTH) {
				entity.setMotion(0, 0, 0.125);
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((entity.getPosX()), (entity.getPosY() + 0.015), (entity.getPosZ()));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), (entity.getPosY() + 0.015), (entity.getPosZ()),
								_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
					}
				}
			}
			if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos(x, y, z))) == Direction.WEST) {
				entity.setMotion((-0.125), 0, 0);
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((entity.getPosX()), (entity.getPosY() + 0.015), (entity.getPosZ()));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), (entity.getPosY() + 0.015), (entity.getPosZ()),
								_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
					}
				}
			}
			if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos(x, y, z))) == Direction.EAST) {
				entity.setMotion(0.125, 0, 0);
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((entity.getPosX()), (entity.getPosY() + 0.015), (entity.getPosZ()));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), (entity.getPosY() + 0.015), (entity.getPosZ()),
								_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
					}
				}
			}
		}
	}
}
