// File: src/main/java/com/example/satellite/core/Result.java
package com.example.satellite.core;

import java.util.Objects;

public final class Result {
    private final boolean success;
    private final String message;

    private Result(boolean success, String message) {
        this.success = success;
        this.message = Objects.requireNonNull(message, "message");
    }

    public static Result ok(String message) {
        return new Result(true, message);
    }

    public static Result error(String message) {
        return new Result(false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public String message() {
        return message;
    }
}


