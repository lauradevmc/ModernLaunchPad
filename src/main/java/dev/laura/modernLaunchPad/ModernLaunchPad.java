package dev.laura.modernLaunchPad;

import dev.laura.modernLaunchPad.commands.ReloadConfig;
import dev.laura.modernLaunchPad.listener.LaunchPad;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class ModernLaunchPad extends JavaPlugin {

    @Override
    public void onEnable() {
        // Save default config
        saveDefaultConfig();
        // Register launchpad events
        Bukkit.getPluginManager().registerEvents(new LaunchPad(this), this);
        // Register reload config command
        getCommand("reloadmodernlaunchpad").setExecutor(new ReloadConfig(this));
    }

}
