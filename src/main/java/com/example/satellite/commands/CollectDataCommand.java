// File: src/main/java/com/example/satellite/commands/CollectDataCommand.java
package com.example.satellite.commands;

import com.example.satellite.core.Result;
import com.example.satellite.domain.Satellite;
import com.example.satellite.util.RetryExecutor;

public final class CollectDataCommand implements Command {
    @Override
    public Result execute(Satellite satellite) {
        return RetryExecutor.execute(() -> {
            satellite.collectData();
            return Result.ok("Collected 10 units. Total: " + satellite.getDataCollected());
        });
    }
}

