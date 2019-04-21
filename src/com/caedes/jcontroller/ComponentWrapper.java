package com.caedes.jcontroller;

import net.java.games.input.Component;

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