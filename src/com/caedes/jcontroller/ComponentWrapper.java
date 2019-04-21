package com.caedes.jcontroller;

import net.java.games.input.Component;

/**
 * @author Musa Kapan aka Cres | Caedes
 *
 * Container class for jinput's component class. Also holds the last signal and the current signal sent by the
 * hardware component to allow us to make out which event should be sent through implementations of this class.
 *
 * The deadzone attribute is not used for buttons or hat switches but is useful for sliders. This can be used to
 * counteract sensitivity of analogs and triggers.
 */
public class ComponentWrapper {

    private Component component;

    private float deadzone;
    private float lastSignal;
    private float currentSignal;

    public ComponentWrapper(Component component) {
        this.component = component;
        this.lastSignal = 0f;
        this.currentSignal = 0f;
        this.deadzone = 0.0f;
    }

    public void updateSignal() {
        lastSignal = currentSignal;
        currentSignal = component.getPollData();
        if (deadzone != 0.0f) {
            currentSignal = correctedValue(currentSignal);
        }
    }

    public void configureDeadzone(float deadzone) {
        this.deadzone = deadzone;
    }

    private float correctedValue(float f) {
        if (Math.abs(f) <= deadzone) {
            return 0;
        }
        return f;
    }

    public float getLastSignal() {
        return lastSignal;
    }

    public float getCurrentSignal() {
        return currentSignal;
    }

    public boolean hasChanged() {
        return lastSignal != currentSignal;
    }
}