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
package cantwe.alldisagree.cwadlib.tests;

import cantwe.alldisagree.cwadlib.tests.items.THatchet;
import net.minecraft.block.Blocks;
import cantwe.alldisagree.cwadlib.api.ItemGroupGen;
import net.minecraft.item.ItemStack;
public class testgroups extends ItemGroupGen {
    public static final net.minecraft.item.ItemGroup TEST_GROUP = register(() -> new ItemStack(THatchet.T_HATCHET), "test");
    public static final net.minecraft.item.ItemGroup TEST_GROUP2 = register(() -> new ItemStack(Blocks.CRYING_OBSIDIAN), "test2");
}
