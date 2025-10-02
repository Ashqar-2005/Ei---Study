// File: src/main/java/com/example/satellite/commands/DeactivatePanelsCommand.java
package com.example.satellite.commands;

import com.example.satellite.core.Result;
import com.example.satellite.domain.Satellite;
import com.example.satellite.util.RetryExecutor;

public final class DeactivatePanelsCommand implements Command {
    @Override
    public Result execute(Satellite satellite) {
        return RetryExecutor.execute(() -> {
            satellite.deactivatePanels();
            return Result.ok("Solar panels deactivated");
        });
    }
}

