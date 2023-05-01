package cantwe.alldisagree.cwadlib.testitem;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class THatchet implements ModInitializer {

    public static final Item T_HATCHET =
            Registry.register(Registry.ITEM, new Identifier("cwadlib", "throwing_knife"),
        new Item(new FabricItemSettings()));
    @Override
    public void onInitialize() {}
}