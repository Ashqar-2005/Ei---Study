// File: src/main/java/com/example/satellite/App.java
package com.example.satellite;

import com.example.satellite.commands.Command;
import com.example.satellite.commands.CommandFactory;
import com.example.satellite.core.Result;
import com.example.satellite.domain.Satellite;
import com.example.satellite.logging.LoggerProvider;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class App {
    private static final Logger LOG = LoggerProvider.getLogger(App.class.getName());

    public static void main(String[] args) {
        LOG.info("Satellite Command System started");
        final Satellite satellite = Satellite.initial();
        final CommandFactory factory = new CommandFactory();

        printHelp();

        // No while(true): the loop respects the input stream lifecycle
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                if ("exit".equalsIgnoreCase(line)) {
                    LOG.info("Exiting on user request");
                    break;
                }
                if ("status".equalsIgnoreCase(line)) {
                    System.out.println(satellite.statusReport());
                    continue;
                }
                if ("help".equalsIgnoreCase(line)) {
                    printHelp();
                    continue;
                }

                try {
                    final Command command = factory.parse(line);
                    final Result result = command.execute(satellite);
                    if (result.isSuccess()) {
                        System.out.println("OK: " + result.message());
                    } else {
                        System.out.println("ERROR: " + result.message());
                    }
                } catch (Exception ex) {
                    LOG.log(Level.WARNING, "Command execution failed: " + line, ex);
                    System.out.println("ERROR: " + ex.getMessage());
                }
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Fatal error in input loop", ex);
            System.err.println("Fatal error: " + ex.getMessage());
        } finally {
            LOG.info("Satellite Command System terminated");
        }
    }

    private static void printHelp() {
        System.out.println("🚀 Satellite Command System");
        System.out.println("Commands:");
        System.out.println("- rotate North|South|East|West");
        System.out.println("- activatePanels");
        System.out.println("- deactivatePanels");
        System.out.println("- collectData");
        System.out.println("- status");
        System.out.println("- help");
        System.out.println("- exit");
        System.out.println("Examples:");
        System.out.println("rotate west");
        System.out.println("activatePanels");
        System.out.println("collectData");
    }
}
    


