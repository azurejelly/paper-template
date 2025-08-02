package dev.azuuure.sample.inject;

import com.google.inject.AbstractModule;
import dev.azuuure.sample.SamplePlugin;
import dev.azuuure.sample.inject.bukkit.BukkitModule;
import dev.azuuure.sample.inject.listener.ListenerModule;
import dev.azuuure.sample.inject.loader.LoaderModule;
import dev.azuuure.sample.inject.settings.SettingsModule;

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
