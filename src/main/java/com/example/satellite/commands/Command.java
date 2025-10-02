// File: src/main/java/com/example/satellite/commands/Command.java
package com.example.satellite.commands;

import com.example.satellite.core.Result;
import com.example.satellite.domain.Satellite;

public interface Command {
    Result execute(Satellite satellite);
}

