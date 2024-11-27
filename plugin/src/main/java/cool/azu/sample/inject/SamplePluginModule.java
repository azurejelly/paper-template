package cool.azu.sample.inject;

import com.google.inject.AbstractModule;
import cool.azu.sample.SamplePlugin;
import cool.azu.sample.inject.bukkit.BukkitModule;
import cool.azu.sample.inject.listener.ListenerModule;
import cool.azu.sample.inject.loader.LoaderModule;
import cool.azu.sample.inject.settings.SettingsModule;

import java.util.Arrays;
import java.util.Collection;

public class SamplePluginModule extends AbstractModule {

    private final SamplePlugin plugin;

    public SamplePluginModule(SamplePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        getModules().forEach(this::install);
    }

    private Collection<? extends AbstractModule> getModules() {
        return Arrays.asList(
                new BukkitModule(plugin),
                new SettingsModule(),
                new LoaderModule(),
                new ListenerModule()
        );
    }
}
