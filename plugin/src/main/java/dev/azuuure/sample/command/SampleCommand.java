package dev.azuuure.sample.command;

import com.google.inject.Inject;
import dev.azuuure.sample.api.settings.YamlSettings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.logging.Level;

public class SampleCommand implements CommandExecutor {

    @Inject
    private YamlSettings settings;
    
    @Inject
    private Plugin plugin;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length != 0 && args[0].equalsIgnoreCase("reload")) {
            try {
                settings.reload();
                commandSender.sendMessage("Configuration file reloaded.");
                return true;
            } catch (IOException | InvalidConfigurationException e) {
                commandSender.sendMessage("Failed to reload configuration file!");
                plugin.getLogger().log(Level.SEVERE, "Failed to reload configuration file", e);
                return true;
            }
        }

        if (settings.getBoolean("name-instead", false)) {
            String name = commandSender instanceof Player
                    ? commandSender.getName()
                    : "Console";

            commandSender.sendMessage("Hello " + name + "!");
        } else {
            commandSender.sendMessage("Hello " + settings.getString("hello", "world") + "!");
        }

        return true;
    }
}
