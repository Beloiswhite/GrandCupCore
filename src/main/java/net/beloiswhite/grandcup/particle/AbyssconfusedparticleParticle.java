
package net.beloiswhite.grandcup.particle;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.particles.ParticleType;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.Minecraft;

import net.beloiswhite.grandcup.procedures.AbyssconfusedparticleDopolnitielnoieUsloviieIstiechieniiaSrokaDieistviiaChastitsProcedure;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbyssconfusedparticleParticle {
	public static final BasicParticleType particle = new BasicParticleType(false);

	@SubscribeEvent
	public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
		event.getRegistry().register(particle.setRegistryName("abyssconfusedparticle"));
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerParticle(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
	}

	@OnlyIn(Dist.CLIENT)
	private static class CustomParticle extends SpriteTexturedParticle {
		private final IAnimatedSprite spriteSet;
		private float angularVelocity;
		private float angularAcceleration;

		protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
			super(world, x, y, z);
			this.spriteSet = spriteSet;
			this.setSize((float) 0.3, (float) 0.3);
			this.particleScale *= (float) 0.8;
			this.maxAge = (int) Math.max(1, 100 + (this.rand.nextInt(40) - 20));
			this.particleGravity = (float) 0.1;
			this.canCollide = false;
			this.motionX = vx * 0;
			this.motionY = vy * 0;
			this.motionZ = vz * 0;
			this.angularVelocity = (float) 0.1;
			this.angularAcceleration = (float) 0;
			this.selectSpriteRandomly(spriteSet);
		}

		@Override
		public IParticleRenderType getRenderType() {
			return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
		}

		@Override
		public void tick() {
			super.tick();
			this.prevParticleAngle = this.particleAngle;
			this.particleAngle += this.angularVelocity;
			this.angularVelocity += this.angularAcceleration;
			double x = this.posX;
			double y = this.posY;
			double z = this.posZ;
			if (AbyssconfusedparticleDopolnitielnoieUsloviieIstiechieniiaSrokaDieistviiaChastitsProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("y", y)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				this.setExpired();
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public CustomParticleFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
				double zSpeed) {
			return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}
}
