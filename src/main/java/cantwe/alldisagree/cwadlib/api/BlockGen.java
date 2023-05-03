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
