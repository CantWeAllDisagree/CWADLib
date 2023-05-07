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
package cantwe.alldisagree.cwadlib;

import cantwe.alldisagree.cwadlib.api.ItemGroupGen;
import cantwe.alldisagree.cwadlib.tests.handlers.EnchantmentHandler;
import cantwe.alldisagree.cwadlib.tests.handlers.EventsHandler;
import cantwe.alldisagree.cwadlib.tests.handlers.PacketHandler;
import cantwe.alldisagree.cwadlib.tests.reg.BlockReg;
import cantwe.alldisagree.cwadlib.tests.reg.ConfigRegistry;
import cantwe.alldisagree.cwadlib.tests.reg.EntityReg;
import cantwe.alldisagree.cwadlib.tests.reg.ItemReg;
import net.fabricmc.api.ModInitializer;

public class CWADLibMain implements ModInitializer {

    public static final String ModID = "cwadlib";
    @Override
    public void onInitialize() {

        ItemReg.init();
        ItemGroupGen.initialize();
        BlockReg.init();


        ConfigRegistry.registerConfig();
        EntityReg.registerEntities();
        EnchantmentHandler.registerEnchantments();
        EventsHandler.registerEvents();
        PacketHandler.registerServerListeners();

    }
}
