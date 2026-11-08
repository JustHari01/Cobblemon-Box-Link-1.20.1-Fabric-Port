package com.emperdog.boxlink.network;

import com.emperdog.boxlink.BoxLinkCommon;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

public record RequestOpenPCPacket(UUID uuid) {

    public static final ResourceLocation ID = new ResourceLocation(BoxLinkCommon.MOD_ID, "open_pc");
}
