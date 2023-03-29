package net.beloiswhite.grandcup.procedures;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.beloiswhite.grandcup.entity.PathfinderEntity;

//modified for 1.16.5, use at your own risk
public class PathfinderModelProcedure extends AnimatedGeoModel<PathfinderEntity.CustomEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(PathfinderEntity.CustomEntity entity) {
		return new ResourceLocation("grandcup", "animations/pathfinder.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(PathfinderEntity.CustomEntity entity) {
		return new ResourceLocation("grandcup", "geo/pathfinder.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(PathfinderEntity.CustomEntity entity) {
		return new ResourceLocation("grandcup", "textures/entities/pathfinder.png");
	}
	/**
	@Override
	public void setCustomAnimations(PathfinderEntity.CustomEntity animatable, int instanceId, AnimationEvent animationEvent) {
	super.setCustomAnimations(animatable, instanceId, animationEvent);
	IBone head = this.getAnimationProcessor().getBone("head");
	EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
	AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
	head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F));
	head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
	 /** **/
}
