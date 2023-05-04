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

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

import static cantwe.alldisagree.cwadlib.api.ItemGen.registerBlock;

public class BlockReg {

    public static Block CWAD_Block;
    public static void init() {
       CWAD_Block = registerBlock(new Block(AbstractBlock.Settings.of(Material.METAL).sounds(BlockSoundGroup.AMETHYST_CLUSTER)),
                "cwad_block", true);
    }

}
