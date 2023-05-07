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
package cantwe.alldisagree.cwadlib.tests.handlers;

import cantwe.alldisagree.cwadlib.CWADLibMain;
import cantwe.alldisagree.cwadlib.tests.packets.BasePacket;
import cantwe.alldisagree.cwadlib.tests.packets.CPacketThrow;
import cantwe.alldisagree.cwadlib.tests.packets.EntitySpawnPacket;
import cantwe.alldisagree.cwadlib.tests.packets.SPacketThrow;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class PacketHandler {
	
	public static final Identifier SPAWN_PACKET = new Identifier(CWADLibMain.ModID, "spawn_packet");
	
	public static final Identifier CPACKET_THROW = new Identifier(CWADLibMain.ModID, "cpacket_throw");
	
	public static final Identifier SPACKET_THROW = new Identifier(CWADLibMain.ModID, "spacket_throw");
	
	public static void registerClientListeners() {
		EntitySpawnPacket.register();
		SPacketThrow.register();
	}
	
	public static void registerServerListeners() {
		CPacketThrow.register();
	}
	
	public static void sendToServer(BasePacket packet) {
		ClientPlayNetworking.send(packet.getIdentifier(), packet.getBuf());
	}
	
	public static void sendToAll(Entity entity, BasePacket packet) {
		for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) entity.world, entity.getBlockPos())) {
            ServerPlayNetworking.send(player, packet.getIdentifier(), packet.getBuf());
        }
	}
}
