package dev.masa.masuitecore.bukkit.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import dev.masa.masuitecore.bukkit.MaSuiteCore;
import dev.masa.masuitecore.bukkit.chat.Formator;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;


public class MaSuiteCommand extends BaseCommand {

    private final MaSuiteCore plugin;
    private final Formator formator = new Formator();

    public MaSuiteCommand(MaSuiteCore plugin) {
        this.plugin = plugin;
    }

    @CommandAlias("masuite")
    @CommandPermission("masuite.info")
    @Description("Information about MaSuite")
    public void masuiteCommand(CommandSender sender) {
        TextComponent textComponent = new TextComponent();
        textComponent.addExtra("&9MaSuiteCore &8v" + plugin.getDescription().getVersion());
        PluginManager pm = plugin.getServer().getPluginManager();

        formator.sendMessage(sender, " &8&lMaSuiteCore &9v" + plugin.getDescription().getVersion());
        if (pm.getPlugin("MaSuiteHomes") != null && pm.getPlugin("MaSuiteHomes").isEnabled()) {
            formator.sendMessage(sender, " &8&lMaSuiteHomes &9v" + pm.getPlugin("MaSuiteHomes").getDescription().getVersion());
        }
        if (pm.getPlugin("MaSuiteChat") != null && pm.getPlugin("MaSuiteChat").isEnabled()) {
            formator.sendMessage(sender, " &8&lMaSuiteChat &9v" + pm.getPlugin("MaSuiteChat").getDescription().getVersion());
        }
        if (pm.getPlugin("MaSuiteWarps") != null && pm.getPlugin("MaSuiteWarps").isEnabled()) {
            formator.sendMessage(sender, " &8&lMaSuiteWarps &9v" + pm.getPlugin("MaSuiteWarps").getDescription().getVersion());
        }
        if (pm.getPlugin("MaSuiteTeleports") != null && pm.getPlugin("MaSuiteTeleports").isEnabled()) {
            formator.sendMessage(sender, " &8&lMaSuiteTeleports &9v" + pm.getPlugin("MaSuiteTeleports").getDescription().getVersion());
        }
        if (pm.getPlugin("MaSuitePortals") != null && pm.getPlugin("MaSuitePortals").isEnabled()) {
            formator.sendMessage(sender, " &8&lMaSuitePortals &9v" + pm.getPlugin("MaSuitePortals").getDescription().getVersion());
        }
        formator.sendMessage(sender, " &8&lSupport link &9https://discord.gg/sZZG6Jq");
    }
}
