package cantwe.alldisagree.cwadlib;

import cantwe.alldisagree.cwadlib.util.entity.ThrowableItemReg;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class CWADLibClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ThrowableItemReg.ThrowableItemEntityEntityType, FlyingItemEntityRenderer::new);
    }
}
