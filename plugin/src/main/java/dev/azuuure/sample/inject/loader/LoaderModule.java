package dev.azuuure.sample.inject.loader;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import dev.azuuure.sample.api.Loader;
import dev.azuuure.sample.loader.command.CommandLoader;
import dev.azuuure.sample.loader.listener.ListenerLoader;

public class LoaderModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Loader> loaderMultibinder = Multibinder.newSetBinder(binder(), Loader.class);
        loaderMultibinder.addBinding().to(CommandLoader.class);
        loaderMultibinder.addBinding().to(ListenerLoader.class);
    }
}
