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
import cantwe.alldisagree.cwadlib.tests.items.THatchet;
import net.fabricmc.api.ModInitializer;

public class CWADLibMain implements ModInitializer {
    @Override
    public void onInitialize() {

        THatchet.initialize();

        ItemGroupGen.initialize();







    }
}
