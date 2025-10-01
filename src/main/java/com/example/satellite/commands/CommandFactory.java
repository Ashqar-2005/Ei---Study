// File: src/main/java/com/example/satellite/commands/CommandFactory.java
package com.example.satellite.commands;

import com.example.satellite.core.ValidationException;
import com.example.satellite.domain.Orientation;
import java.util.Locale;

public final class CommandFactory {

    public Command parse(String line) {
        final String normalized = line.trim();
        final int spaceIdx = normalized.indexOf(' ');
        final String verb = (spaceIdx == -1 ? normalized : normalized.substring(0, spaceIdx)).toLowerCase(Locale.ROOT);
        final String arg = (spaceIdx == -1 ? "" : normalized.substring(spaceIdx + 1).trim());

        switch (verb) {
            case "rotate":
                if (arg.isEmpty()) {
                    throw new ValidationException("rotate command requires an orientation: North|South|East|West");
                }
                Orientation o = parseOrientation(arg);
                return new RotateCommand(o);
            case "activatepanels":
                return new ActivatePanelsCommand();
            case "deactivatepanels":
                return new DeactivatePanelsCommand();
            case "collectdata":
                return new CollectDataCommand();
            default:
                throw new ValidationException("Unknown command: " + verb);
        }
    }

    private Orientation parseOrientation(String s) {
        switch (s.toLowerCase(Locale.ROOT)) {
            case "north": return Orientation.North;
            case "south": return Orientation.South;
            case "east":  return Orientation.East;
            case "west":  return Orientation.West;
            default:throw new ValidationException("Invalid orientation: " + s + " (expected North|South|East|West)");
        }
    }
}

