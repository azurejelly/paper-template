package cool.azu.sample.command;

import jakarta.inject.Inject;
import cool.azu.sample.settings.YamlSettings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MiniMessageCommand implements CommandExecutor {

    @Inject
    private YamlSettings settings;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(settings.getString("player-only", "This command can only be ran by players!"));
            return true;
        }

        player.sendMessage(settings.getComponent("mini-message"));
        return true;
    }
}
