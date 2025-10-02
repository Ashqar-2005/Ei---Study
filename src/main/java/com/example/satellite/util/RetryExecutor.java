// File: src/main/java/com/example/satellite/util/RetryExecutor.java
package com.example.satellite.util;

import com.example.satellite.core.Result;
import java.util.function.Supplier;

/**
 * Simple transient error handler with capped retries and jitter backoff.
 * Intended for operations that could fail intermittently (e.g., file IO).
 * Domain validation errors should not be retried.
 */
public final class RetryExecutor {
    private RetryExecutor() {}

    public static Result execute(Supplier<Result> action) {
        final int maxAttempts = 3;
        long backoffMs = 50L;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                return action.get();
            } catch (RuntimeException ex) {
                // Distinguish transient vs permanent errors heuristically if needed.
                // Here we retry generically, then surface the last error.
                if (attempt == maxAttempts) {
                    return Result.error(ex.getMessage());
                }
                try {
                    // Using Thread.sleep for simple retry backoff (3 attempts).
                    // In production, consider ScheduledExecutorService for non-blocking retries.
                    Thread.sleep(backoffMs + (long)(Math.random() * 25));
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    return Result.error("Interrupted during retry: " + ie.getMessage());
                }
                backoffMs *= 2;
            }
        }
        // Unreachable, but required by compiler paths
        return Result.error("Unknown error");
    }
}

