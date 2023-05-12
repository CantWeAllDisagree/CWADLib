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
package cantwe.alldisagree.cwadlib.throwme.mixins.client;

import cantwe.alldisagree.cwadlib.throwme.events.OnFOVUpdate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin{
	
	@Inject(method = "getFovMultiplier", at = @At("RETURN"), cancellable = true)
	private void getSpeed(CallbackInfoReturnable<Float> info) {
		PlayerEntity player = (PlayerEntity) (Object) this;

		float amount = info.getReturnValue();
		
		float result = OnFOVUpdate.EVENT.invoker().interact(player, amount);

		info.setReturnValue(result);
		
		
	}
}
