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
package cantwe.alldisagree.cwadlib.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class CWADLibItemGroup {

    public static <TabImg extends Supplier<ItemStack>> ItemGroup register(TabImg groupimg, String tabName){
        // Create the identifier for the group.
        Identifier groupID = new Identifier("cwadlib", tabName);

        // Build group and Display Img
        return FabricItemGroupBuilder.build(groupID, groupimg);
    }
    public static void initialize() {}
}