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
package cantwe.alldisagree.cwadlib.tests.reg;

import cantwe.alldisagree.cwadlib.api.ItemGen;
import cantwe.alldisagree.cwadlib.tests.cmenu.TestGroups;
import cantwe.alldisagree.cwadlib.tests.CWADThrowMeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;


public class ItemReg extends ItemGen {

    public static Item T_HATCHET;
    public static Item T_CLEAVER;
    public static Item SATCHEL;

    public static void init() {
        T_HATCHET = registerItem(new CWADThrowMeItem(new FabricItemSettings().maxCount(7).group(TestGroups.TEST_GROUP), 3,1, ToolMaterials.IRON), "throwing_hatchet");
        T_CLEAVER = registerItem(new CWADThrowMeItem(new FabricItemSettings().maxCount(3).group(TestGroups.TEST_GROUP), 4,2, ToolMaterials.IRON), "throwing_cleaver");
        SATCHEL = registerItem(new Item(new FabricItemSettings().group(TestGroups.TEST_GROUP)), "satchel");
    }
}