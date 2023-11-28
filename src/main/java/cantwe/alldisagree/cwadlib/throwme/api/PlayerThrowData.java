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
package cantwe.alldisagree.cwadlib.throwme.api;

import cantwe.alldisagree.cwadlib.throwme.packets.CPacketThrow;
import cantwe.alldisagree.cwadlib.throwme.packets.CPacketThrow.State;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class PlayerThrowData {

	//Client
	public int MAX_CHARGE = -1;

	//Both
	CPacketThrow.State action = CPacketThrow.State.NONE;

	//Server
	int chargeTime = -1;

	ItemStack item = ItemStack.EMPTY;

	PlayerEntity user;

	public PlayerThrowData(PlayerEntity player) {
		this.user = player;
	}

	public void setAction(CPacketThrow.State action) {
		this.action = action;
	}

	public State getAction() {
		return this.action;
	}

	public int getChargeTime() {
		return chargeTime;
	}

	public void startCharging(ItemStack stack) {
		this.item=stack.copy();
		chargeTime = PlayerThrowData.getMaximumCharge(user);
	}

	public ItemStack getChargingStack() {
		return item;
	}

	public void resetCharging() {
		this.action = this.action.equals(State.DURING) ? State.FINISH : this.action;
		this.item = ItemStack.EMPTY;
		chargeTime = -1;
	}

	public void setChargeTime(int ticks) {
		chargeTime = ticks;
	}

	public static int getMaximumCharge(PlayerEntity player) {
		return MathHelper.floor(player.getAttackCooldownProgressPerTick()*3.0D);
	}
}
