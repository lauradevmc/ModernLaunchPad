package dev.laura.modernLaunchPad.listener;

import dev.laura.modernLaunchPad.ModernLaunchPad;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class LaunchPad implements Listener {

    private final ModernLaunchPad plugin;

    public LaunchPad(ModernLaunchPad plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLaunchPad(PlayerMoveEvent event) {
        // Get the player involved in the move event
        Player player = event.getPlayer();

        // Get the player's current location
        Location location = player.getLocation();

        // Get the block directly in the player position
        Material block = location.getBlock().getType();

        // Get the block directly beneath the player
        Material blockBelow = location.getBlock().getRelative(0, -1, 0).getType();

        // Iterate through all configured launchpads in the configuration file
        for (String key : plugin.getConfig().getConfigurationSection("launchPads").getKeys(false)) {
            // Fetch the type of block for this launchpad from the configuration
            String configuredType = plugin.getConfig().getString("launchPads." + key + ".block.type", "lime_carpet").toUpperCase();

            // Fetch the velocity multiplier for this launchpad
            double velocity = plugin.getConfig().getDouble("launchPads." + key + ".knockback.velocity", 5.0);

            // Check if the block below matches the configured type for this launchpad
            if (blockBelow.equals(Material.valueOf(configuredType)) || block.equals(Material.valueOf(configuredType))) {
                // Fetch the sound configuration for this launchpad
                String soundName = plugin.getConfig().getString("launchPads." + key + ".sound.name", "entity.bat.takeoff").toUpperCase().replace(".", "_");
                float volume = (float) plugin.getConfig().getDouble("launchPads." + key + ".sound.volume", 1.0);
                float pitch = (float) plugin.getConfig().getDouble("launchPads." + key + ".sound.pitch", 1.0);

                // Fetch the effect configuration for this launchpad
                String effectName = plugin.getConfig().getString("launchPads." + key + ".effect.type", "ender_signal").toUpperCase();
                int effectData = plugin.getConfig().getInt("launchPads." + key + ".effect.data", 1);

                // Apply velocity to the player based on the configured values
                player.setVelocity(location.getDirection().multiply(velocity));
                player.setVelocity(new Vector(player.getVelocity().getX(), 1.0D, player.getVelocity().getZ()));

                // Play the configured sound at the player's location
                player.getWorld().playSound(location, Sound.valueOf(soundName), volume, pitch);

                // Play the configured effect at the player's location
                player.getWorld().playEffect(location, Effect.valueOf(effectName), effectData);

                // Stop further iteration as the launchpad has been activated
                break;
            }
        }
    }

}
