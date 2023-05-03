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
