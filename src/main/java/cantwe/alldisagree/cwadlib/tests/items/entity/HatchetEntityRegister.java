package cantwe.alldisagree.cwadlib.tests.items.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HatchetEntityRegister {
    public static final EntityType<HatchetEntity> HatchetEntityEntityType = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("cwadlib", "throwing_hatchet"),
            FabricEntityTypeBuilder.<HatchetEntity>create(SpawnGroup.MISC, HatchetEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                    .build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS

    );
    public static void initialize() {}
}
