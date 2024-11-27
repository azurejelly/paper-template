package cool.azu.sample.loader.command;

import com.google.inject.Inject;
import cool.azu.sample.SamplePlugin;
import cool.azu.sample.loader.Loader;
import cool.azu.sample.command.MiniMessageCommand;
import cool.azu.sample.command.SampleCommand;

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
