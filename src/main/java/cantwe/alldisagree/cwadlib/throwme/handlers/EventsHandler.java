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
package cantwe.alldisagree.cwadlib.throwme.handlers;

import cantwe.alldisagree.cwadlib.throwme.items.CWADThrowMeAxeItem;
import cantwe.alldisagree.cwadlib.throwme.items.CWADThrowMeSwordItem;
import cantwe.alldisagree.cwadlib.throwme.api.PlayerThrowData;
import cantwe.alldisagree.cwadlib.throwme.entity.projectile.ThrowMeEntity;
import cantwe.alldisagree.cwadlib.throwme.events.*;
import cantwe.alldisagree.cwadlib.throwme.interfaces.IPlayerEntityMixin;
import cantwe.alldisagree.cwadlib.throwme.packets.CPacketThrow;
import cantwe.alldisagree.cwadlib.throwme.packets.CPacketThrow.State;
import cantwe.alldisagree.cwadlib.throwme.packets.SPacketThrow;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

import java.util.UUID;

public class EventsHandler{
	public static boolean wasPressed = false;



	public static void onThrowItem(ServerPlayerEntity serverplayer, CPacketThrow.State action){

		ServerWorld world = serverplayer.getWorld();
		ItemStack stack = serverplayer.getMainHandStack();

		//boolean isThrowable = ConfigRegistry.COMMON.get().experimental.shouldThrowItemsToo;
		boolean isThrowable = false;
		
		boolean haveAttributes = stack.getItem() instanceof CWADThrowMeSwordItem || stack.getItem() instanceof CWADThrowMeAxeItem;

		PlayerThrowData data = ((IPlayerEntityMixin) serverplayer).getThrowPower();

		if (haveAttributes && !stack.isEmpty()) {

			//boolean cdConfig = ConfigRegistry.COMMON.get().general.notUseWhenCooldown;
			boolean cdConfig = false;

			serverplayer.getItemCooldownManager().getCooldownProgress(stack.getItem(), 1.0F);
			data.setAction(action);

			if(action.equals(State.START) && data.getChargeTime() <= 0) {
				data.startCharging(stack);
			}

			if(action.equals(State.FINISH) && data.getChargeTime() >= 0 ) {

				float baseThrow = 0;
				float baseExhaustion = 0.05F;
				float modThrow = 1.0F;

				if(Math.signum(PlayerThrowData.getMaximumCharge(serverplayer)) != 0.0F) {
					modThrow = 1.F - (data.getChargeTime()/(float)PlayerThrowData.getMaximumCharge(serverplayer));
				}

				data.resetCharging();

				//double defaultVelocity = ConfigRegistry.COMMON.get().defaults.velocityDefault;
				double defaultVelocity = 2.0D;

				//if (ConfigRegistry.COMMON.get().experimental.shouldThrowItemsToo){
				//	baseThrow = (float) defaultVelocity;
				//}

				baseThrow = 20 / serverplayer.getAttackCooldownProgressPerTick();
				baseExhaustion = serverplayer.getAttackCooldownProgressPerTick()/20;

				if(baseThrow>0) {

					boolean shouldDestroy = modThrow > 0.99;
					//double baseDamage = ConfigRegistry.COMMON.get().defaults.baseDamageDefault;
					double baseDamage = 1.0D;
					double toolMultiplier = 0.0D;

					baseDamage = (float) serverplayer.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);

					int types = 0;
						/*if(stack.getItem() instanceof AxeItem) {
							toolMultiplier += ConfigRegistry.COMMON.get().multipliers.tools.axeMultiplier;
							types++;
						}
						if(stack.getItem() instanceof HoeItem) {
							toolMultiplier += ConfigRegistry.COMMON.get().multipliers.tools.hoeMultiplier;
							types++;
						}
						if(stack.getItem() instanceof PickaxeItem) {
							toolMultiplier += ConfigRegistry.COMMON.get().multipliers.tools.pickaxeMultiplier;
							types++;
						}
						if(stack.getItem() instanceof ShovelItem) {
							toolMultiplier += ConfigRegistry.COMMON.get().multipliers.tools.shovelMultiplier;
							types++;
						}
						if(stack.getItem() instanceof SwordItem) {
							toolMultiplier = ConfigRegistry.COMMON.get().multipliers.tools.swordMultiplier;
							types++;
						}*/

						toolMultiplier = 1.D;
						types++;


					toolMultiplier/= types;

					if(toolMultiplier == 0.0F) {
						toolMultiplier = 1.0F;
					}

					int size = serverplayer.isSneaking() ? stack.getCount() : 1;

					double bDamageMul = 0.25D;
					double sDamageMul = 0.0D;
					double mDamageMul = 0.50D;
					double totalDamage = (baseDamage)*(1*bDamageMul + modThrow*mDamageMul) + (size*sDamageMul);
					totalDamage*=toolMultiplier;

					double bVelocityMul = 0.25D;
					double sVelocityMul = 0.005D;
					double mVelocityMul = 0.4D;
					double totalVelocity = (baseThrow)*(1*bVelocityMul + modThrow*mVelocityMul) - (size*sVelocityMul);
					totalVelocity*=toolMultiplier;

					double bExhaustionMul = 0.075D;
					double sExhaustionMul = 0.01D;
					double mExhaustionMul = 2.0D;
					double totalExhaustion = (baseExhaustion)*(1*bExhaustionMul + modThrow*mExhaustionMul) + (size*sExhaustionMul);
					totalExhaustion*=toolMultiplier;

					ThrowMeEntity thrownEntity = new ThrowMeEntity(world, serverplayer, shouldDestroy, (float) totalDamage, stack.split(size));
					thrownEntity.setVelocity(serverplayer, serverplayer.getPitch(), serverplayer.getYaw(), 0.0F, (float) totalVelocity, 1.0F);
					serverplayer.addExhaustion((float) totalExhaustion);

					world.spawnEntity(thrownEntity);


					SoundEvent soundevent = SoundEvents.ENTITY_FISHING_BOBBER_THROW;
					thrownEntity.playSound(soundevent, 1.0F, 1.0F);

				}
			}
			((IPlayerEntityMixin) serverplayer).setThrowPower(data);
		}
	}

	public static void registerEvents(){
		OnStartPlayerTick.EVENT.register((player)->{
			if(!player.world.isClient()) {
				PlayerThrowData throwMe = ((IPlayerEntityMixin)player).getThrowPower();

				boolean changedItem = !ItemStack.areEqual(throwMe.getChargingStack(), player.getMainHandStack());

				if (changedItem) {
					throwMe.resetCharging();
				}

				if (throwMe.getChargeTime() > 0) {
					throwMe.setChargeTime(throwMe.getChargeTime() - 1);
				}

				if(throwMe.getAction().equals(CPacketThrow.State.START) || throwMe.getAction().equals(CPacketThrow.State.FINISH)) {

					PacketHandler.sendToAll(player, new SPacketThrow(player.getUuid(), PlayerThrowData.getMaximumCharge(player), throwMe.getAction().equals(CPacketThrow.State.START)));

					if(throwMe.getAction().equals(CPacketThrow.State.FINISH)) {
						throwMe.setAction(State.NONE);
					}
				}
			}else {
				PlayerThrowData throwMe = ((IPlayerEntityMixin)player).getThrowPower();

				if(throwMe.getChargeTime() > 0) {
					 throwMe.setChargeTime(throwMe.getChargeTime()-1);
				 }
			}
		});

	}

	public static void onSeverUpdate(UUID playerUUID, int maxChargeTime, boolean isCharging) {
		assert MinecraftClient.getInstance().world != null;
		PlayerEntity playerentity = MinecraftClient.getInstance().world.getPlayerByUuid(playerUUID);
		if(playerentity != null) {

			PlayerThrowData throwMe = ((IPlayerEntityMixin)playerentity).getThrowPower();
			throwMe.MAX_CHARGE = maxChargeTime;

			if(isCharging) {
				throwMe.setChargeTime(maxChargeTime);
			}

			throwMe.setAction(isCharging ? State.DURING : State.NONE);

		}
	}

	public static void registerClientEvents() {
		OnHeldItemRender.EVENT.register((renderer, player, tickDelta, pitch, hand, swingProgress, item, equipProgress, matrices, vertexConsumers, light)->{

			PlayerThrowData throwMe = ((IPlayerEntityMixin)player).getThrowPower();

			if(throwMe.getAction().equals(State.DURING)) {

				float preProgress = 1.0F;

				if(Math.signum(throwMe.MAX_CHARGE) != 0.0F && throwMe.getChargeTime() > 0) {
					float lerp = MathHelper.lerp(tickDelta, throwMe.getChargeTime()+1, throwMe.getChargeTime());
					preProgress = 1.F- lerp /throwMe.MAX_CHARGE;
				}

				float progress = MathHelper.clamp(preProgress, 0.F, 1.0F);

				matrices.translate(0.0D, 0.0F, progress * 0.50F);
				matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(progress * 10.0F));
				matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(progress * 40.0F));

			}
		});

		OnStartPlayerRender.EVENT.register((renderer, player)->{

			PlayerThrowData throwMe = ((IPlayerEntityMixin)player).getThrowPower();
			if(throwMe.getAction().equals(State.DURING)) {
					if(player instanceof AbstractClientPlayerEntity) {
						Arm hand = player.getMainArm();
						if(hand == Arm.RIGHT)
							renderer.getModel().rightArmPose = BipedEntityModel.ArmPose.THROW_SPEAR;
						else
							renderer.getModel().leftArmPose = BipedEntityModel.ArmPose.THROW_SPEAR;
					}
			}
		});

		OnApplySlow.EVENT.register((player)->{
			PlayerThrowData throwMe = ((IPlayerEntityMixin)player).getThrowPower();
			return throwMe.getAction().equals(State.DURING);
		});

		OnFOVUpdate.EVENT.register((player, amount)->{

			PlayerThrowData throwMe = ((IPlayerEntityMixin)player).getThrowPower();

			int maxChargeTime = throwMe.MAX_CHARGE;

			int chargeTime = throwMe.getChargeTime();

			boolean isCharging = throwMe.getAction().equals(State.DURING);
			float f = amount;

			 if(isCharging) {

		         float f1 = 1.0F;

		         if(Math.signum(maxChargeTime) != 0.0F && chargeTime > 0) {
		        	 float lerp = MathHelper.lerp(MinecraftClient.getInstance().getTickDelta(), chargeTime+1, chargeTime);
					 f1 = MathHelper.clamp(1.0F- lerp / maxChargeTime, 0.F, 1.0F);
				 }
		         if (f1 > 1.0F) {
		            f1 = 1.0F;
		         } else {
		            f1 = f1 * f1;
		         }

		         f *= 1.0F + f1 * 0.15F;
			 }
			return f;
		});

		ClientTickEvents.END_WORLD_TICK.register(client -> {

			boolean pressed = KeyBindingHandler.KEYBINDING.isPressed();

			if (pressed) {
				PacketHandler.sendToServer(new CPacketThrow(EventsHandler.wasPressed ? CPacketThrow.State.DURING: CPacketThrow.State.START));
				EventsHandler.wasPressed = true;
			}else if(EventsHandler.wasPressed){
				PacketHandler.sendToServer(new CPacketThrow(CPacketThrow.State.FINISH));
				EventsHandler.wasPressed = false;
			}
		});
	}
}



