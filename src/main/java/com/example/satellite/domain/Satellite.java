// File: src/main/java/com/example/satellite/domain/Satellite.java
package com.example.satellite.domain;

import com.example.satellite.core.DomainException;
import com.example.satellite.core.ValidationException;

import java.util.Objects;

public final class Satellite {
    private Orientation orientation;
    private PanelsStatus panelsStatus;
    private int dataCollected;

    private Satellite(Orientation orientation, PanelsStatus panelsStatus, int dataCollected) {
        this.orientation = Objects.requireNonNull(orientation, "orientation");
        this.panelsStatus = Objects.requireNonNull(panelsStatus, "panelsStatus");
        if (dataCollected < 0) {
            throw new ValidationException("Data collected cannot be negative");
        }
        this.dataCollected = dataCollected;
    }

    public static Satellite initial() {
        return new Satellite(Orientation.North, PanelsStatus.Inactive, 0);
    }

    public synchronized void rotate(Orientation newOrientation) {
        if (newOrientation == null) throw new ValidationException("Orientation cannot be null");
        this.orientation = newOrientation;
    }

    public synchronized void activatePanels() {
        this.panelsStatus = PanelsStatus.Active;
    }

    public synchronized void deactivatePanels() {
        this.panelsStatus = PanelsStatus.Inactive;
    }

    public synchronized void collectData() {
        if (panelsStatus != PanelsStatus.Active) {
            throw new DomainException("Solar panels are not Active; cannot collect data");
        }
        // Increment by 10 units; bounded to prevent overflow in very long runs
        if (dataCollected <= Integer.MAX_VALUE - 10) {
            this.dataCollected += 10;
        } else {
            throw new DomainException("Data storage limit reached");
        }
    }

    public synchronized Orientation getOrientation() {
        return orientation;
    }

    public synchronized PanelsStatus getPanelsStatus() {
        return panelsStatus;
    }

    public synchronized int getDataCollected() {
        return dataCollected;
    }

    public synchronized String statusReport() {
        return String.format(
                "Orientation: %s | Solar Panels: %s | Data Collected: %d",
                orientation, panelsStatus, dataCollected
        );
    }
}

