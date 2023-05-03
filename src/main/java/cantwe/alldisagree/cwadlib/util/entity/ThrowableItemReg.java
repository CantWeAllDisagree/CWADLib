package cantwe.alldisagree.cwadlib.util.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ThrowableItemReg {
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
