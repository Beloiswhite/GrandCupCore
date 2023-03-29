package net.beloiswhite.grandcup.procedures;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.beloiswhite.grandcup.entity.InsomniaPortalEntity;

//modified for 1.16.5, use at your own risk
public class InsomniaPortalModelProcedure extends AnimatedGeoModel<InsomniaPortalEntity.CustomEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(InsomniaPortalEntity.CustomEntity entity) {
		return new ResourceLocation("grandcup", "animations/insomnia_portal.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(InsomniaPortalEntity.CustomEntity entity) {
		return new ResourceLocation("grandcup", "geo/insomnia_portal.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(InsomniaPortalEntity.CustomEntity entity) {
		return new ResourceLocation("grandcup", "textures/entities/insomnia_portal.png");
	}
	/**
	@Override
	public void setCustomAnimations(InsomniaPortalEntity.CustomEntity animatable, int instanceId, AnimationEvent animationEvent) {
	super.setCustomAnimations(animatable, instanceId, animationEvent);
	IBone head = this.getAnimationProcessor().getBone("head");
	EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
	AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
	head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F));
	head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
	 /** **/
}
