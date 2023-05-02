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

