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
package cantwe.alldisagree.cwadlib.throwme.api;

import cantwe.alldisagree.cwadlib.CWADLibMain;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemGen {
    public static <CWADItem extends Item> CWADItem registerItem(CWADItem item, String itemName) {
        // Create the identifier for the item.
        Identifier itemID = new Identifier(CWADLibMain.ModID, itemName);
        return Registry.register(Registry.ITEM, itemID, item);
    }
    public static <CWADBlock extends Block> CWADBlock registerBlock(CWADBlock block, String name, boolean shouldRegisterItem) {
        Identifier blockID = new Identifier(CWADLibMain.ModID, name);

        if(shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
            Registry.register(Registry.ITEM, blockID, blockItem);
        }
        return Registry.register(Registry.BLOCK, blockID, block);
    }
}

