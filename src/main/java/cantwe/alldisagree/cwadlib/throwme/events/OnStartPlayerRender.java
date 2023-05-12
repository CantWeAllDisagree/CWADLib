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
package cantwe.alldisagree.cwadlib.throwme.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.entity.player.PlayerEntity;

public interface OnStartPlayerRender {
    Event<OnStartPlayerRender> EVENT = EventFactory.createArrayBacked(OnStartPlayerRender.class,
        (listeners) -> (renderer, player) -> {
            for (OnStartPlayerRender listener : listeners) {
                listener.interact(renderer, player);
            }

    });
    void interact(PlayerEntityRenderer renderer, PlayerEntity entity);
}
