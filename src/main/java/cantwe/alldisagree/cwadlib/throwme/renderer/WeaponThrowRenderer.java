/*               | Copyright (c) 2023 CantWeAllDisagree |
|
|   This program is free software: you can redistribute it and/or modify
|   it under the terms of the GNU Affero General Public License as published by
|   the Free Software Foundation, version 3 of the License, or
|   (at your option) any later version.
|
|   This program is distributed in the hope that it will be useful,
|   but WITHOUT ANY WARRANTY; without even the implied warranty of
|   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
|   GNU Affero General Public License for more details.
*/
package cantwe.alldisagree.cwadlib.throwme.renderer;

import cantwe.alldisagree.cwadlib.throwme.entity.projectile.ThrowMeEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public class WeaponThrowRenderer extends FlyingItemEntityRenderer<ThrowMeEntity> {

   private final ItemRenderer itemRenderer;
	
   public WeaponThrowRenderer(EntityRendererFactory.Context renderManagerIn) {
	   super(renderManagerIn);
	   this.itemRenderer = renderManagerIn.getItemRenderer();
   }

	public void render(ThrowMeEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					   VertexConsumerProvider bufferIn, int packedLightIn) {

		float degrees = entityIn.getRotationAnimation(partialTicks);

		float scale = 0.75F;
		matrixStackIn.push();
			matrixStackIn.translate(0.F, 0.15F, 0.0F);
			matrixStackIn.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(partialTicks, entityIn.prevYaw, entityIn.getYaw()) - 90.0F));
			matrixStackIn.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(-degrees));
			matrixStackIn.scale(scale, scale, scale);
	
			int count = entityIn.getItemStack().getCount();
	
			this.itemRenderer.renderItem(entityIn.getStack(), ModelTransformation.Mode.FIXED, packedLightIn,
					OverlayTexture.DEFAULT_UV, matrixStackIn, bufferIn, entityIn.getId());
			if (count > 32) {
				matrixStackIn.translate(-0.05F, -0.05F, -0.05F);
				this.itemRenderer.renderItem(entityIn.getStack(), ModelTransformation.Mode.FIXED,
						packedLightIn, OverlayTexture.DEFAULT_UV, matrixStackIn, bufferIn, entityIn.getId());
			}
		matrixStackIn.pop();
	}
}