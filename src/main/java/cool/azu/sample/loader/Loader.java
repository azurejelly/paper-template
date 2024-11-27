package cool.azu.sample.loader;

public interface Loader {

    void load();

    default void unload() {}
}
