
package net.beloiswhite.grandcup.entity.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.geo.render.built.GeoBone;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.beloiswhite.grandcup.procedures.PathfinderModelProcedure;
import net.beloiswhite.grandcup.entity.PathfinderEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PathfinderRenderer extends GeoEntityRenderer<PathfinderEntity.CustomEntity> {
	@Override
	public ResourceLocation getEntityTexture(PathfinderEntity.CustomEntity entity) {
		return new ResourceLocation("grandcup:textures/entities/pathfinder.png");
	}

	public PathfinderRenderer(EntityRendererManager renderManager) {
		super(renderManager, new PathfinderModelProcedure());
		this.shadowSize = 0.5F;
	}

	@Override
	public void renderEarly(PathfinderEntity.CustomEntity animatable, MatrixStack stackIn, float ticks, IRenderTypeBuffer renderTypeBuffer,
			IVertexBuilder vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float partialTicks) {
		super.renderEarly(animatable, stackIn, ticks, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue,
				partialTicks);
	}

	@Override
	public RenderType getRenderType(PathfinderEntity.CustomEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void renderRecursively(GeoBone bone, MatrixStack matrixStack, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red,
			float green, float blue, float alpha) {
		super.renderRecursively(bone, matrixStack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
