package com.moer.api;

public interface IApi {
    default boolean isPresent() {
        return true;
    }
}
