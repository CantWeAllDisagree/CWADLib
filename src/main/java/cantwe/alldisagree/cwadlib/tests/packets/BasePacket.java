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

import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public abstract class BasePacket {
	
	private Identifier identifier;
	
	protected PacketByteBuf buf;
	
	public BasePacket(Identifier id) {
		this.identifier = id;
		this.buf = new PacketByteBuf(Unpooled.buffer());
	}
	
	public PacketByteBuf getBuf() {
		return this.buf;
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
}
