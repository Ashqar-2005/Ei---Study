// File: src/main/java/com/example/satellite/commands/RotateCommand.java
package com.example.satellite.commands;

import com.example.satellite.core.Result;
import com.example.satellite.domain.Orientation;
import com.example.satellite.domain.Satellite;
import com.example.satellite.util.RetryExecutor;

public final class RotateCommand implements Command {
    private final Orientation orientation;

    public RotateCommand(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public Result execute(Satellite satellite) {
        return RetryExecutor.execute(() -> {
            satellite.rotate(orientation);
            return Result.ok("Orientation set to " + orientation);
        });
    }
}

