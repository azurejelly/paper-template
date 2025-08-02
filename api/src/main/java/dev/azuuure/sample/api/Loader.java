package dev.azuuure.sample.api;

public interface Loader {

    void load();

    default void unload() {}
}