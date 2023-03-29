package net.beloiswhite.grandcup.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.beloiswhite.grandcup.item.SoulclusterItem;
import net.beloiswhite.grandcup.entity.PathfinderEntity;
import net.beloiswhite.grandcup.GrandcupMod;

import java.util.Map;
import java.util.HashMap;

public class SoulclusterKoghdaPriedmietVInvientarieProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPickup(EntityItemPickupEvent event) {
			PlayerEntity entity = event.getPlayer();
			ItemStack itemstack = event.getItem().getItem();
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
			dependencies.put("itemstack", itemstack);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GrandcupMod.LOGGER.warn("Failed to load dependency world for procedure SoulclusterKoghdaPriedmietVInvientarie!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GrandcupMod.LOGGER.warn("Failed to load dependency x for procedure SoulclusterKoghdaPriedmietVInvientarie!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GrandcupMod.LOGGER.warn("Failed to load dependency y for procedure SoulclusterKoghdaPriedmietVInvientarie!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GrandcupMod.LOGGER.warn("Failed to load dependency z for procedure SoulclusterKoghdaPriedmietVInvientarie!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GrandcupMod.LOGGER.warn("Failed to load dependency entity for procedure SoulclusterKoghdaPriedmietVInvientarie!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GrandcupMod.LOGGER.warn("Failed to load dependency itemstack for procedure SoulclusterKoghdaPriedmietVInvientarie!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getItem() == SoulclusterItem.block) {
			if (entity instanceof PlayerEntity || entity instanceof ServerPlayerEntity) {
				if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("grandcup:soul_cluster_pick_up")))
								.isDone()
						: false)) {
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
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")),
										SoundCategory.MASTER, (float) 1, (float) 3);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")),
										SoundCategory.MASTER, (float) 1, (float) 3, false);
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										"\u00A77*\u0432\u044B \u0447\u0443\u0432\u0441\u0442\u0432\u0443\u0435\u0442\u0435 \u0441\u0442\u0440\u0430\u0445, \u043F\u043E \u0441\u043F\u0438\u043D\u0435 \u043F\u0440\u043E\u0431\u0435\u0433\u0430\u0435\u0442 \u043B\u0435\u0433\u043A\u0430\u044F \u0434\u0440\u043E\u0436\u044C...*"),
										(false));
							}
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
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("ambient.cave")),
												SoundCategory.MASTER, (float) 2, (float) (-1));
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("ambient.cave")),
												SoundCategory.MASTER, (float) 2, (float) (-1), false);
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
												"\u00A77-\"\u0411\u0443\u0434\u044C \u043E\u0441\u0442\u043E\u0440\u043E\u0436\u0435\u043D... \u043E\u043D - \u043E\u0431\u044F\u0437\u0430\u0442\u0435\u043B\u044C\u043D\u043E \u0442\u0435\u0431\u044F \u043D\u0430\u0439\u0434\u0451\u0442...\""),
												(false));
									}
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
											if (world instanceof World && !world.isRemote()) {
												((World) world).playSound(null, new BlockPos(x, y, z),
														(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("ambient.cave")),
														SoundCategory.MASTER, (float) 1, (float) 0);
											} else {
												((World) world).playSound(x, y, z,
														(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("ambient.cave")),
														SoundCategory.MASTER, (float) 1, (float) 0, false);
											}
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
													if (world instanceof World && !world.isRemote()) {
														((World) world).playSound(null, new BlockPos(x, y, z),
																(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																		.getValue(new ResourceLocation("ambient.cave")),
																SoundCategory.MASTER, (float) 1, (float) 2);
													} else {
														((World) world).playSound(x, y, z,
																(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																		.getValue(new ResourceLocation("ambient.cave")),
																SoundCategory.MASTER, (float) 1, (float) 2, false);
													}
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
															if (world instanceof World && !world.isRemote()) {
																((World) world).playSound(null, new BlockPos(x, y, z),
																		(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																				.getValue(new ResourceLocation("ambient.cave")),
																		SoundCategory.MASTER, (float) 2, (float) 4);
															} else {
																((World) world).playSound(x, y, z,
																		(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																				.getValue(new ResourceLocation("ambient.cave")),
																		SoundCategory.MASTER, (float) 2, (float) 4, false);
															}
															if (world instanceof ServerWorld) {
																Entity entityToSpawn = new PathfinderEntity.CustomEntity(PathfinderEntity.entity,
																		(World) world);
																entityToSpawn.setLocationAndAngles(
																		(entity.world
																				.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getLook(1f).x * 2,
																								entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
																						RayTraceContext.BlockMode.OUTLINE,
																						RayTraceContext.FluidMode.NONE, entity))
																				.getPos().getX() - 5),
																		y,
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * 2,
																						entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getZ() - 5),
																		(float) 0, (float) 0);
																entityToSpawn.setRenderYawOffset((float) 0);
																entityToSpawn.setRotationYawHead((float) 0);
																if (entityToSpawn instanceof MobEntity)
																	((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
																			world.getDifficultyForLocation(entityToSpawn.getPosition()),
																			SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
																world.addEntity(entityToSpawn);
															}
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 40);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 40);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 60);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 40);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
				}
			}
		}
	}
}
