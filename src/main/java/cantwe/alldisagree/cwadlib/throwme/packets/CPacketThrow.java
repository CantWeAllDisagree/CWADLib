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
package cantwe.alldisagree.cwadlib.throwme.packets;

import cantwe.alldisagree.cwadlib.throwme.handlers.EventsHandler;
import cantwe.alldisagree.cwadlib.throwme.handlers.PacketHandler;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class CPacketThrow extends BasePacket {
	
	public enum State {
		   NONE((byte)0),
		   START((byte)1),
		   DURING((byte)2),
		   FINISH((byte)3);
		
		   private byte index;
		   private State(byte i) {
			   this.index = i;

		  }
		  public byte toByte() {
				return index;
		  }

		  public static State fromByte(int index) {
			  for(State equipmentslottype : State.values()) {
				  if(equipmentslottype.toByte() == index) {
					  return equipmentslottype;
				  }
			  }
			  return NONE;
			  
		  }
	}
	
	public CPacketThrow(State state) {
		super(PacketHandler.CPACKET_THROW);
		buf.writeByte(state.toByte());
	}

	public static void register() {
		
		ServerPlayNetworking.registerGlobalReceiver(PacketHandler.CPACKET_THROW, (server, player, handler, buf, responseSender) -> {
			CPacketThrow.State action = CPacketThrow.State.fromByte(buf.readByte());

			server.execute(() -> {
				
				EventsHandler.onThrowItem(player, action);
			});
		});
		
	}

}
