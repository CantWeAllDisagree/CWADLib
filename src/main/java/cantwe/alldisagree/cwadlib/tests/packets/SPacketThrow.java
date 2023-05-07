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
package cantwe.alldisagree.cwadlib.tests.packets;

import java.util.UUID;

import cantwe.alldisagree.cwadlib.tests.handlers.EventsHandler;
import cantwe.alldisagree.cwadlib.tests.handlers.PacketHandler;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class SPacketThrow extends BasePacket {
	
	public SPacketThrow(UUID uuid, int maxChargeTime, boolean isCharging) {
		super(PacketHandler.SPACKET_THROW);
		buf.writeUuid(uuid);
		buf.writeVarInt(maxChargeTime);
		buf.writeBoolean(isCharging);
	}

	public static void register() {
		
		ClientPlayNetworking.registerGlobalReceiver(PacketHandler.SPACKET_THROW, (client, handler, buf, responseSender) -> {
			UUID uuid = buf.readUuid();
			int maxChargeTime = buf.readVarInt();
			boolean isCharging = buf.readBoolean();
			
			client.execute(() -> {
				EventsHandler.onSeverUpdate(uuid, maxChargeTime, isCharging);
			});
		});
		
	}

}
