package io.github.gameking1happy.gk1henchants.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.network.chat.Component;

/**
 * Fabric client-side code.
 */
@SuppressWarnings("unused")
public class FabricClient implements ClientModInitializer {
    /**
     * Runs the Fabric mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        Client.initclient();
    }
}
