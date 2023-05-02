package cantwe.alldisagree.cwadlib;

import cantwe.alldisagree.cwadlib.tests.items.entity.HatchetEntityRegister;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class CWADLibClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(HatchetEntityRegister.HatchetEntityEntityType, FlyingItemEntityRenderer::new);
    }
}
