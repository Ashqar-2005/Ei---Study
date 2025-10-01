// File: src/main/java/com/example/satellite/logging/LoggerProvider.java
package com.example.satellite.logging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.*;

public final class LoggerProvider {
    private static volatile boolean initialized = false;
    private static final Logger ROOT = Logger.getLogger("com.example.satellite");

    private LoggerProvider() {}

    public static Logger getLogger(String name) {
        if (!initialized) {
            synchronized (LoggerProvider.class) {
                if (!initialized) {
                    setup();
                    initialized = true;
                }
            }
        }
        return Logger.getLogger(name);
    }

    private static void setup() {
        ROOT.setUseParentHandlers(false);
        ROOT.setLevel(Level.INFO);

        final ConsoleHandler console = new ConsoleHandler();
        console.setLevel(Level.INFO);
        console.setFormatter(new SimpleFormatter());
        ROOT.addHandler(console);

        try {
            Path logsDir = Path.of("logs");
            if (!Files.exists(logsDir)) {
                Files.createDirectories(logsDir);
            }
            final FileHandler file = new FileHandler("logs/app.log", true);
            file.setLevel(Level.FINE);
            file.setFormatter(new SimpleFormatter());
            ROOT.addHandler(file);
        } catch (IOException ex) {
            // Fallback gracefully; console logging remains
            ROOT.log(Level.WARNING, "Failed to initialize file logging; continuing with console only", ex);
        }
    }
}

