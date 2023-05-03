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
package cantwe.alldisagree.cwadlib.tests.blocks;

import cantwe.alldisagree.cwadlib.api.BlockGen;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class BlockReg extends BlockGen {
    public static final Block CWAD_Block = register(new Block(AbstractBlock.Settings.of(Material.METAL).sounds(BlockSoundGroup.AMETHYST_CLUSTER)),
            "cwad_block", true);

    public static void initialize() {}
}
