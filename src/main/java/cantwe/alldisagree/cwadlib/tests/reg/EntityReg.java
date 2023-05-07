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
package cantwe.alldisagree.cwadlib.tests.reg;

import cantwe.alldisagree.cwadlib.CWADLibMain;
import cantwe.alldisagree.cwadlib.tests.entity.projectile.ThrowMeEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityReg {
    public static final EntityType<ThrowMeEntity> WEAPONTHROW = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(CWADLibMain.ModID, "cwadlib"),
            FabricEntityTypeBuilder.<ThrowMeEntity>create(SpawnGroup.MISC, ThrowMeEntity::new).trackRangeBlocks(4).trackedUpdateRate(20).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build()
    );
    public static void registerEntities() {

    }
}
