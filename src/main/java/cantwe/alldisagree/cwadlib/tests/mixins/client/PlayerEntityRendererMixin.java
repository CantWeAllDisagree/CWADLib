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
package cantwe.alldisagree.cwadlib.tests.mixins.client;

import cantwe.alldisagree.cwadlib.tests.events.OnStartPlayerRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin{
	
	@Inject(method = "setModelPose", at = @At("TAIL"))
	private void setModelPose(AbstractClientPlayerEntity player, CallbackInfo info) {
		OnStartPlayerRender.EVENT.invoker().interact(((PlayerEntityRenderer)(Object)this), player);
	}
}
