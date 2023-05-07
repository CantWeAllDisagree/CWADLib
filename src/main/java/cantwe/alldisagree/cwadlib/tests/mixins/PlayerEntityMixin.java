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
package cantwe.alldisagree.cwadlib.tests.mixins;

import cantwe.alldisagree.cwadlib.tests.api.PlayerThrowData;
import cantwe.alldisagree.cwadlib.tests.events.OnStartPlayerTick;
import cantwe.alldisagree.cwadlib.tests.interfaces.IPlayerEntityMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements IPlayerEntityMixin {
	
	
	public PlayerThrowData throwPower = new PlayerThrowData((PlayerEntity)(Object) this);
	
	@Override
    public void setThrowPower(PlayerThrowData value) {
    	this.throwPower = value;
    }
	
	@Override
    public PlayerThrowData getThrowPower() {
    	return this.throwPower;
    }
	
	@Inject(at = @At("HEAD"), method = "tick")
	private void init(CallbackInfo info) {
		OnStartPlayerTick.EVENT.invoker().interact((PlayerEntity)(Object)this);
	}
}
