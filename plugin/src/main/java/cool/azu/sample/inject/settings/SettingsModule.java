package cool.azu.sample.inject.settings;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import cool.azu.sample.api.settings.YamlSettings;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.Plugin;

import java.io.IOException;

public class SettingsModule extends AbstractModule {

    @Provides
    @Singleton
    public YamlSettings provideYamlSettings(Plugin plugin) {
        try {
            return new YamlSettings(plugin, "config");
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException("Could not initialize YAML configuration", e);
        }
    }
}
