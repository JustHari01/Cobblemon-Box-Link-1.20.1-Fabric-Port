package com.emperdog.boxlink.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;

public class FabricPacketHandler {

    public static void handlePCPacket(final RequestOpenPCPacket data, ServerPlayer player) {
        BoxLinkServerPayloadHandler.handlePCPacket(data, player);
    }

    public static void registerPackets() {
        ServerPlayNetworking.registerGlobalReceiver(RequestOpenPCPacket.ID,
                (server, player, handler, buf, responseSender) -> {
                    RequestOpenPCPacket data = new RequestOpenPCPacket(buf.readUUID());
                    server.execute(() -> handlePCPacket(data, player));
                });
    }
}
