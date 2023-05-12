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
package cantwe.alldisagree.cwadlib.throwme.cmenu;

import cantwe.alldisagree.cwadlib.CWADLibMain;
import cantwe.alldisagree.cwadlib.throwme.reg.BlockReg;
import cantwe.alldisagree.cwadlib.throwme.reg.ItemReg;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import cantwe.alldisagree.cwadlib.throwme.api.ItemGroupGen;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class TestGroups extends ItemGroupGen {
    public static final ItemGroup TEST_GROUP = register(() -> new ItemStack(ItemReg.T_HATCHET),"cwadlib", "test");
    public static final ItemGroup TEST_GROUP_2 = FabricItemGroupBuilder.create(
                    new Identifier(CWADLibMain.ModID, "test2"))
            .icon(() -> new ItemStack(BlockReg.CWAD_Block))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(BlockReg.CWAD_Block));
            })
            .build();
}
