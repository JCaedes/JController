package com.caedes.jcontroller;

import net.java.games.input.Component;

/**
 * @author Musa Kapan aka Cres | Caedes
 *
 * A basic implementation of a button. I've opted not to implement the 'buttonTyped' event feature
 * because I don't think it's needed anyways.
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
