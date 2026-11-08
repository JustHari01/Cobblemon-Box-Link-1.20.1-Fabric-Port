package com.emperdog.boxlink.event;

import com.emperdog.boxlink.BoxLinkClient;
import com.emperdog.boxlink.network.RequestOpenPCPacket;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.Minecraft;

public class FabricClientEvents {
    public static void register() {
        ClientTickEvents.START_CLIENT_TICK.register((minecraft) -> {
            Minecraft client = Minecraft.getInstance();
            if (BoxLinkClient.openPCKey.consumeClick() && client.isWindowActive() && client.player != null) {
                ClientPlayNetworking.send(RequestOpenPCPacket.ID,
                        PacketByteBufs.create().writeUUID(client.player.getUUID()));
            }
        });

        KeyBindingHelper.registerKeyBinding(BoxLinkClient.openPCKey);
    }
}
