package cool.azu.sample.loader.listener;

import com.google.inject.Inject;
import cool.azu.sample.loader.Loader;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.Set;

public class ListenerLoader implements Loader {

    @Inject
    private Set<Listener> listeners;

    @Inject
    private PluginManager pluginManager;

    @Inject
    private Plugin plugin;

    @Override
    public void load() {
        listeners.forEach(listener -> pluginManager.registerEvents(listener, plugin));
    }
}
