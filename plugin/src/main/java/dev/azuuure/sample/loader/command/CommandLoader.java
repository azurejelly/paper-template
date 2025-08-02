package dev.azuuure.sample.loader.command;

import com.google.inject.Inject;
import dev.azuuure.sample.SamplePlugin;
import dev.azuuure.sample.api.Loader;
import dev.azuuure.sample.command.MiniMessageCommand;
import dev.azuuure.sample.command.SampleCommand;

public class CommandLoader implements Loader {

    @Inject
    private SamplePlugin plugin;

    @Inject
    private SampleCommand sampleCommand;

    @Inject
    private MiniMessageCommand miniMessageCommand;

    @Override
    public void load() {
        plugin.getCommand("minimessage-sample").setExecutor(miniMessageCommand);
        plugin.getCommand("sample").setExecutor(sampleCommand);
    }
}
