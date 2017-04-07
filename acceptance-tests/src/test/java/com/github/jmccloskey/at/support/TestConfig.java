package com.github.jmccloskey.at.support;

public class TestConfig {

    public static String host() {
        return Boolean.parseBoolean(System.getenv("IS_DOCKER")) ? "api" : "localhost";
    }
}
