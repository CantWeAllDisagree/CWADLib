package cantwe.alldisagree.cwadlib.util.entity;

import cantwe.alldisagree.cwadlib.tests.items.ItemReg;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
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
        super(ThrowableItemReg.ThrowableItemEntityEntityType, owner, world); // null will be changed later
    }

    public ThrowableItemEntity(World world, double x, double y, double z) {
        super(ThrowableItemReg.ThrowableItemEntityEntityType, x, y, z, world); // null will be changed later
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
}
