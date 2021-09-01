package dev.masa.masuitecore.bukkit;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.UUID;

public class CoreMessageListener implements PluginMessageListener {

    private final MaSuiteCore plugin;

    CoreMessageListener(MaSuiteCore p) {
        plugin = p;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!"BungeeCord".equals(channel)) {
            return;
        }
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));

        String subchannel;
        try {
            subchannel = in.readUTF();
            if ("MaSuiteCore".equals(subchannel)) {
                String childchannel = in.readUTF();
                if ("AddPlayer".equals(childchannel)) {
                    MaSuiteCore.onlinePlayers.add(in.readUTF());
                }
                if ("RemovePlayer".equals(childchannel)) {
                    MaSuiteCore.onlinePlayers.remove(in.readUTF());
                }
                if ("ApplyCooldown".equals(childchannel)) {
                    MaSuiteCore.cooldownService.applyCooldown(in.readUTF(), UUID.fromString(in.readUTF()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
