package cool.azu.sample;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import cool.azu.sample.loader.Loader;
import cool.azu.sample.inject.SamplePluginModule;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public class SamplePlugin extends JavaPlugin {

    @Inject private Set<Loader> loaders;
    private Injector injector;

    @Override
    public void onEnable() {
        setupInjector();

        loaders.forEach(Loader::load);
        getLogger().info(getDescription().getName() + " version " + getDescription().getVersion() + " has been enabled.");
    }

    @Override
    public void onDisable() {
        loaders.forEach(Loader::load);
        getLogger().info(getDescription().getName() + " version " + getDescription().getVersion() + " has been disabled.");
    }

    /**
     * Creates a new injector for us to use throughout the plugin.
     * This will also allow existing injected fields in this class (e.g. <code>loaders</code>) to work.
     */
    private void setupInjector() {
        this.injector = Guice.createInjector(new SamplePluginModule(this));
        this.injector.injectMembers(this);
    }

    /**
     * Returns the {@link Injector} used by the plugin,
     * which might be used to create child injectors.
     *
     * @return The {@link Injector} used by the plugin.
     */
    public Injector getInjector() {
        return this.injector;
    }
}