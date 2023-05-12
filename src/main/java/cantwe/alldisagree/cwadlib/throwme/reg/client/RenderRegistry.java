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
package cantwe.alldisagree.cwadlib.throwme.reg.client;

import cantwe.alldisagree.cwadlib.throwme.reg.EntityReg;
import cantwe.alldisagree.cwadlib.throwme.renderer.WeaponThrowRenderer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class RenderRegistry {

	public static void registerRenderers() {
		EntityRendererRegistry.register(EntityReg.WEAPONTHROW, WeaponThrowRenderer::new);
		
	}
}
