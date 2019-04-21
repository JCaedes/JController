package com.caedes.jcontroller;

import net.java.games.input.Component;

/**
 * @author Musa Kapan aka Cres | Caedes
 *
 * A slider is a hardware component that can output a signal ranging between -1.0 and 1.0.
 * 2 sliders make up an analog and a single slider is used to handle input from the L2 and R2 triggers
 * of a Dualshock4 controller.
 *
 * That latter part is what makes this iffy. Incase you hadn't noticed yet, if you press down R2 and L2 together,
 * neither of them will output a signal. That's because they counteract eachother to the point where the output
 * of the common slider becomes 0. For simplicity's sake, events triggered by a slider will pass through as
 * sliderPressed() and buttonPressed().
 */
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
