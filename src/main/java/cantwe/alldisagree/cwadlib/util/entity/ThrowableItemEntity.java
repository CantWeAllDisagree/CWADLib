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

package cantwe.alldisagree.cwadlib.util.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ThrowableItemEntity extends ThrownItemEntity {
    public ThrowableItemEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    public ThrowableItemEntity(World world, LivingEntity owner) {
        super(ThrowableItemEntity.ThrowableItemEntityEntityType, owner, world); // null will be changed later
    }

    public ThrowableItemEntity(World world, double x, double y, double z) {
        super(ThrowableItemEntity.ThrowableItemEntityEntityType, x, y, z, world); // null will be changed later
    }

    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 3); // deals damage
    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            this.kill(); // kills the projectile
        }

    }
    public static final EntityType<ThrowableItemEntity> ThrowableItemEntityEntityType = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("cwadlib", "throwable_item"),
            FabricEntityTypeBuilder.<ThrowableItemEntity>create(SpawnGroup.MISC, ThrowableItemEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // Projectile Dimensions
                    .trackRangeBlocks(4).trackedUpdateRate(10) // Tracks Projectile
                    .build() // Builds Entity
    );
    public static void initialize() {}
}
