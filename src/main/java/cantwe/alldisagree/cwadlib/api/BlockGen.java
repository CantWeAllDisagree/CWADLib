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

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockGen {
    public static <CWADBlock extends Block> CWADBlock register(CWADBlock block, String name, boolean shouldRegisterItem) {
        Identifier id = new Identifier("cwadlib", name);

        if(shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
            Registry.register(Registry.ITEM, id, blockItem);
        }

        return Registry.register(Registry.BLOCK, id, block);
    }

}
