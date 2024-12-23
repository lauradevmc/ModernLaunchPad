package dev.laura.modernLaunchPad.commands;

import dev.laura.modernLaunchPad.ModernLaunchPad;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadConfig implements CommandExecutor {

    private final ModernLaunchPad plugin;

    public ReloadConfig(ModernLaunchPad plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // Check if sender has permission
        if (sender.hasPermission("modernlaunchpad.reload")) {
            // Reload plugin config
            plugin.reloadConfig();
            // Send success message
            sender.sendMessage(ChatColor.GREEN + "ModernLaunchPad reloaded successfully.");
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command.");
        }
        return true;
    }

}
