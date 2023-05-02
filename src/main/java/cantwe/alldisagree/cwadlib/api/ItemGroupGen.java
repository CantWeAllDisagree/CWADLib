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

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroup;

import java.util.function.Supplier;

public class ItemGroupGen {

    // Used to create new tabs for modded items/blocks
    public static <TabImg extends Supplier<ItemStack>> ItemGroup register(TabImg groupImg,String modID, String tabName){
        // Create the identifier for the group.
        Identifier groupID = new Identifier(modID, tabName);

        // Build group and Display Img
        return FabricItemGroupBuilder.build(groupID, groupImg);
    }
    public static void initialize() {}
}