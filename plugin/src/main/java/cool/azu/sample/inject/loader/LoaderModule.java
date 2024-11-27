package cool.azu.sample.inject.loader;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import cool.azu.sample.api.Loader;
import cool.azu.sample.loader.command.CommandLoader;
import cool.azu.sample.loader.listener.ListenerLoader;

public class LoaderModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Loader> loaderMultibinder = Multibinder.newSetBinder(binder(), Loader.class);
        loaderMultibinder.addBinding().to(CommandLoader.class);
        loaderMultibinder.addBinding().to(ListenerLoader.class);
    }
}
