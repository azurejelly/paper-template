package cool.azu.sample.inject.listener;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import cool.azu.sample.listener.PlayerDeathListener;
import cool.azu.sample.listener.PlayerJoinListener;
import org.bukkit.event.Listener;

public class ListenerModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Listener> listeners = Multibinder.newSetBinder(binder(), Listener.class);
        listeners.addBinding().to(PlayerDeathListener.class);
        listeners.addBinding().to(PlayerJoinListener.class);
    }
}
