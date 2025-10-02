// File: src/main/java/com/example/satellite/commands/ActivatePanelsCommand.java
package com.example.satellite.commands;

import com.example.satellite.core.Result;
import com.example.satellite.domain.Satellite;
import com.example.satellite.util.RetryExecutor;

public final class ActivatePanelsCommand implements Command {
    @Override
    public Result execute(Satellite satellite) {
        return RetryExecutor.execute(() -> {
            satellite.activatePanels();
            return Result.ok("Solar panels activated");
        });
    }
}

