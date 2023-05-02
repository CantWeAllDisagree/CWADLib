package cantwe.alldisagree.cwadlib.api;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemGen {
    public static <CWADItem extends Item> CWADItem register(CWADItem item, String itemName) {
        // Create the identifier for the item.
        Identifier itemID = new Identifier("cwadlib", itemName);
        return Registry.register(Registry.ITEM, itemID, item);
    }
}

