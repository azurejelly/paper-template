package dev.azuuure.sample.inject.listener;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import dev.azuuure.sample.listener.PlayerDeathListener;
import dev.azuuure.sample.listener.PlayerJoinListener;
import org.bukkit.event.Listener;

public class ListenerModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Listener> listeners = Multibinder.newSetBinder(binder(), Listener.class);
        listeners.addBinding().to(PlayerDeathListener.class);
        listeners.addBinding().to(PlayerJoinListener.class);
    }
}
