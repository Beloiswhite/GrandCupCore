package net.beloiswhite.grandcup.procedures;

import software.bernie.geckolib3.renderers.geo.IGeoRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import com.mojang.blaze3d.matrix.MatrixStack;

//modified for 1.16.5, use at your own risk
public class PathfinderLayerProcedure extends GeoLayerRenderer {
	private static final ResourceLocation LAYER = new ResourceLocation("grandcup", "textures/entities/pathfinder_glow.png");
	private static final ResourceLocation MODEL = new ResourceLocation("grandcup", "geo/pathfinder.geo.json");

	public PathfinderLayerProcedure(IGeoRenderer<?> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, Entity entityLivingBaseIn, float limbSwing,
			float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		RenderType cameo = RenderType.getEyes(LAYER);
		matrixStackIn.push();
		matrixStackIn.scale(1.0f, 1.0f, 1.0f);
		matrixStackIn.translate(0.0d, 0.0d, 0.0d);
		this.getRenderer().render(this.getEntityModel().getModel(MODEL), entityLivingBaseIn, partialTicks, cameo, matrixStackIn, bufferIn,
				bufferIn.getBuffer(cameo), packedLightIn, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
		matrixStackIn.pop();
	}
}
