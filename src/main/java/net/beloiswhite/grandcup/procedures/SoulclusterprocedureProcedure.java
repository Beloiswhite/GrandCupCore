package net.beloiswhite.grandcup.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.beloiswhite.grandcup.particle.SoultrackParticle;
import net.beloiswhite.grandcup.item.YellowfluoritItem;
import net.beloiswhite.grandcup.item.WhitefluoritItem;
import net.beloiswhite.grandcup.item.SoulclusterItem;
import net.beloiswhite.grandcup.item.RedfluoritItem;
import net.beloiswhite.grandcup.item.GreenfluoritItem;
import net.beloiswhite.grandcup.item.BluefluoritItem;
import net.beloiswhite.grandcup.block.YellowfluoritblockBlock;
import net.beloiswhite.grandcup.block.WhitefluoritblockBlock;
import net.beloiswhite.grandcup.block.RedfluoritblockBlock;
import net.beloiswhite.grandcup.block.GreenfluoritblockBlock;
import net.beloiswhite.grandcup.block.BluefluoritblockBlock;
import net.beloiswhite.grandcup.GrandcupMod;

import java.util.Map;
import java.util.HashMap;

public class SoulclusterprocedureProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GrandcupMod.LOGGER.warn("Failed to load dependency world for procedure Soulclusterprocedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GrandcupMod.LOGGER.warn("Failed to load dependency x for procedure Soulclusterprocedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GrandcupMod.LOGGER.warn("Failed to load dependency y for procedure Soulclusterprocedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GrandcupMod.LOGGER.warn("Failed to load dependency z for procedure Soulclusterprocedure!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GrandcupMod.LOGGER.warn("Failed to load dependency entity for procedure Soulclusterprocedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RedfluoritItem.block)) : false)
				&& ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(GreenfluoritItem.block)) : false)
				&& ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(BluefluoritItem.block)) : false)
				&& ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(YellowfluoritItem.block)) : false)
				&& ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(WhitefluoritItem.block))
						: false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(RedfluoritItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(GreenfluoritItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(BluefluoritItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(YellowfluoritItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(WhitefluoritItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if ((world.getBlockState(new BlockPos(x - 2, y + 2, z + 5))).getBlock() == GreenfluoritblockBlock.block
					&& (world.getBlockState(new BlockPos(x - 5, y + 2, z + 1))).getBlock() == BluefluoritblockBlock.block
					&& (world.getBlockState(new BlockPos(x + 3, y + 2, z + 4))).getBlock() == WhitefluoritblockBlock.block
					&& (world.getBlockState(new BlockPos(x + 3, y + 2, z - 4))).getBlock() == RedfluoritblockBlock.block
					&& (world.getBlockState(new BlockPos(x + 5, y + 1, z - 1))).getBlock() == YellowfluoritblockBlock.block
					&& (world.getBlockState(new BlockPos(x - 3, y + 2, z - 4))).getBlock() == WhitefluoritblockBlock.block) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						world.addParticle(SoultrackParticle.particle, x, y, z, 0, 0, 0);
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								world.addParticle(SoultrackParticle.particle, x, y, z, 0, 0, 0);
								new Object() {
									private int ticks = 0;
									private float waitTicks;
									private IWorld world;

									public void start(IWorld world, int waitTicks) {
										this.waitTicks = waitTicks;
										MinecraftForge.EVENT_BUS.register(this);
										this.world = world;
									}

									@SubscribeEvent
									public void tick(TickEvent.ServerTickEvent event) {
										if (event.phase == TickEvent.Phase.END) {
											this.ticks += 1;
											if (this.ticks >= this.waitTicks)
												run();
										}
									}

									private void run() {
										world.addParticle(SoultrackParticle.particle, x, y, z, 0, 0, 0);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private IWorld world;

											public void start(IWorld world, int waitTicks) {
												this.waitTicks = waitTicks;
												MinecraftForge.EVENT_BUS.register(this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(TickEvent.ServerTickEvent event) {
												if (event.phase == TickEvent.Phase.END) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												world.addParticle(SoultrackParticle.particle, x, y, z, 0, 0, 0);
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private IWorld world;

													public void start(IWorld world, int waitTicks) {
														this.waitTicks = waitTicks;
														MinecraftForge.EVENT_BUS.register(this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(TickEvent.ServerTickEvent event) {
														if (event.phase == TickEvent.Phase.END) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														world.addParticle(SoultrackParticle.particle, x, y, z, 0, 0, 0);
														if (world instanceof ServerWorld) {
															LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
															_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x, y, z)));
															_ent.setEffectOnly(true);
															((World) world).addEntity(_ent);
														}
														if (world instanceof World && !world.isRemote()) {
															ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
																	new ItemStack(SoulclusterItem.block));
															entityToSpawn.setPickupDelay((int) 40);
															entityToSpawn.setNoDespawn();
															world.addEntity(entityToSpawn);
														}
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 10);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 10);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 10);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 10);
			} else {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(RedfluoritItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GreenfluoritItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(BluefluoritItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(YellowfluoritItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WhitefluoritItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		}
	}
}
