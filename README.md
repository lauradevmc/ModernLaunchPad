
# **ModernLaunchPad Plugin**

Welcome to **ModernLaunchPad**, a fully customizable Minecraft plugin that enhances your lobby experience with interactive launchpads! 🚀✨
Give this repository a star! ⭐

## **Features**
- 🎵 **Customizable Sound**: Choose from a variety of Minecraft sounds to play when using the launchpad.
- 💥 **Special Effects**: Add visual effects like ender signals for a dazzling experience.
- 🛠️ **Fully Customizable**: Change the launchpad block type, knockback strength, and more.
- 🔄 **Easy Reload Command**: Use the `/reloadml` command to instantly reload the plugin with your changes.

## **How to Use**
1. **Set up a Launchpad**: The plugin allows you to define multiple launchpads with different sounds, effects, and knockback strengths.
2. **Activate**: Step on a launchpad block to activate the effects and experience a thrilling ride into the air!
3. **Customization**: Adjust settings for each launchpad through the configuration file, where you can define:
    - **Sound**: Set the sound effect when a player uses the launchpad.
    - **Effect**: Choose a particle effect for a visually stunning experience.
    - **Block**: Customize the block type for your launchpad.
    - **Knockback**: Control the strength of the knockback when the launchpad is activated.

## **Configuration Example**

You can fully configure each launchpad in the `config.yml` file. Below is an example configuration:

```yaml
# ModernLaunchPad Configuration - Fully customizable!
# Reference lists:
# - Sounds: https://www.digminecraft.com/lists/sound_list_pc.php
# - Effects: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Effect.html

launchPads:
  1:
    sound:
      # The sound played when the launchpad is used
      name: entity.bat.takeoff
      volume: 1.0
      pitch: 1.0
    effect:
      # The effect activated when the launchpad is used
      type: ender_signal
      data: 1 # Additional data values (depends on the effect type)
    block:
      # The block type used as the launchpad
      type: lime_carpet
    knockback:
      # The strength of the knockback when using the launchpad
      velocity: 5.0
```

## **Commands**

### `/reloadml`
- **Permission**: `modernlaunchpad.reload`
- **Description**: Reloads the plugin configuration. This is especially useful after making changes to the `config.yml` file.

---

## **Links**
- 💖 [Donate](https://buymeacoffee.com/lauradev)
- 🚀 [Request New Features](https://github.com/lauradevmc/ModernLaunchPad/issues) (Just open a issue)

## **License**
ModernLaunchPad is an **OpenSource** plugin. Feel free to contribute, make improvements, and share your feedback!

---

Enjoy your flight! 🚀🎮
