package com.caedes.jcontroller;

import net.java.games.input.Component;

/**
 * L    C   OUT
 * 0    0   no output
 * 1    0   released
 * 0    1   pressed
 * 1    1   pressed
 */
public class Button extends ComponentWrapper implements InputEventGenerator {

    private InputEvent evt;

    public Button(Component component, InputEvent evt) {
        super(component);
        this.evt = evt;
    }

    @Override
    public void generateEvent(InputEventListener listener) {
        updateSignal();
        if (getCurrentSignal() == 1.0f) {
            listener.buttonPressed(evt);
        } else if (hasChanged()) {
            listener.buttonReleased(evt);
        }
    }

}
