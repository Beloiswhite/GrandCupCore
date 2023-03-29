package net.beloiswhite.grandcup.procedures;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.beloiswhite.grandcup.entity.LoltEntity;

//modified for 1.16.5, use at your own risk
public class LoltModelProcedure extends AnimatedGeoModel<LoltEntity.CustomEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(LoltEntity.CustomEntity entity) {
		return new ResourceLocation("grandcup", "animations/nether_lolt.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(LoltEntity.CustomEntity entity) {
		return new ResourceLocation("grandcup", "geo/nether_lolt.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(LoltEntity.CustomEntity entity) {
		return new ResourceLocation("grandcup", "textures/entities/nether_lolt.png");
	}
	/**
	@Override
	public void setCustomAnimations(LoltEntity.CustomEntity animatable, int instanceId, AnimationEvent animationEvent) {
	super.setCustomAnimations(animatable, instanceId, animationEvent);
	IBone head = this.getAnimationProcessor().getBone("head");
	EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
	AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
	head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F));
	head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
	 /** **/
}
