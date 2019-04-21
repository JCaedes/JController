package com.caedes.jcontroller;

import net.java.games.input.Component;

public class Slider extends ComponentWrapper implements InputEventGenerator {

    private InputEvent lastEvt;

    public Slider(Component component) {
        super(component);
        configureDeadzone(0.5f);
        this.lastEvt = null;
    }

    @Override
    public void generateEvent(InputEventListener listener) {
        updateSignal();
        InputEvent evt = getTrigger(getCurrentSignal());
        if (evt != InputEvent.TRIGGER_NEUTRAL) {
            listener.sliderPressed(evt, getCurrentSignal());
            listener.buttonPressed(evt);
        }
        if (lastEvt != evt) {
            listener.buttonReleased(lastEvt);
        }
        lastEvt = evt;
    }

    private InputEvent getTrigger(float signal) {
        if (signal != 0) {
            if (signal > 0) {
                return InputEvent.L2;
            } else {
                return InputEvent.R2;
            }
        }
        return InputEvent.TRIGGER_NEUTRAL;
    }
}
