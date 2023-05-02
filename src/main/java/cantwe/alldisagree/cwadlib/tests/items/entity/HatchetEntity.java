package cantwe.alldisagree.cwadlib.tests.items.entity;

import cantwe.alldisagree.cwadlib.tests.items.THatchet;
import cantwe.alldisagree.cwadlib.tests.items.TItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class HatchetEntity extends ThrownItemEntity {
    public HatchetEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public HatchetEntity(World world, LivingEntity owner) {
        super(HatchetEntityRegister.HatchetEntityEntityType, owner, world); // null will be changed later
    }

    public HatchetEntity(World world, double x, double y, double z) {
        super(HatchetEntityRegister.HatchetEntityEntityType, x, y, z, world); // null will be changed later
    }

    @Override
    protected Item getDefaultItem() {
        return THatchet.T_HATCHET; // We will configure this later, once we have created the ProjectileItem.
    }
    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        int i = entity instanceof BlazeEntity ? 3 : 0; // sets i to 3 if the Entity instance is an instance of BlazeEntity
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)i); // deals damage
    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            this.kill(); // kills the projectile
        }

    }
}
