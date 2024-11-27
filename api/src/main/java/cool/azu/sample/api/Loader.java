package cool.azu.sample.api;

public interface Loader {

    void load();

    default void unload() {}
}