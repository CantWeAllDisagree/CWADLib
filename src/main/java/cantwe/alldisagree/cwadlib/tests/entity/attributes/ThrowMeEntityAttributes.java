package cantwe.alldisagree.cwadlib.tests.entity.attributes;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;


public class ThrowMeEntityAttributes extends EntityAttributes {

    public static final EntityAttribute GENERIC_THROWN_DAMAGE = EntityAttributes.register("generic.thrown_damage", new ClampedEntityAttribute("attribute.name.generic.thrown_damage", 4.0, 0.0, 1024.0));

}
