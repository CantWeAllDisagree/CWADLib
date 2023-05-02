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
package cantwe.alldisagree.cwadlib.tests.items;

import cantwe.alldisagree.cwadlib.tests.testgroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import cantwe.alldisagree.cwadlib.api.ItemGen;

public class THatchet extends ItemGen{

    public static final Item T_HATCHET = register(new TItem(new FabricItemSettings().maxCount(7).group(testgroups.TEST_GROUP)), "throwing_hatchet");

    public static void initialize() {}
}