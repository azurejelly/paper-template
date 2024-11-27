package cool.azu.sample.inject.bukkit;

import com.google.inject.AbstractModule;
import cool.azu.sample.SamplePlugin;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

import static com.google.inject.name.Names.named;

public class BukkitModule extends AbstractModule {

    private final SamplePlugin plugin;

    public BukkitModule(SamplePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(SamplePlugin.class).toInstance(plugin);
        bind(Plugin.class).toInstance(plugin);
        bind(JavaPlugin.class).toInstance(plugin);
        bind(Server.class).toInstance(plugin.getServer());
        bind(File.class).annotatedWith(named("dataFolder")).toInstance(plugin.getDataFolder());
        bind(PluginManager.class).toInstance(plugin.getServer().getPluginManager());
    }
}
