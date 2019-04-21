package com.caedes.jcontroller;

import net.java.games.input.Component;


/**
 * @author Musa Kapan aka Cres | Caedes
 *
 * A hat switch represents the directional buttons on a controller.
 *
 * A hat switch will trigger the buttonPressed() event for as long as any direction except for neutral
 * is pressed down.
 *
 * If a controller "slides" from one direction to another or abruptly changes direction, the hat switch
 * will trigger the buttonReleased() event for the direction it is changing from (even from neutral).
 *
 * For example; pressing forward from neutral will trigger both buttonPressed(FORWARD) and
 * buttonReleased(NEUTRAL) at the same time. If the controller were to go from forward to up/forward
 * then it will trigger buttonPressed(UP_FORWARD) and buttonReleased(FORWARD) at once.
 *
 * This way the user can pick which input style fits their implementation best.
 */
public class HatSwitch extends ComponentWrapper implements InputEventGenerator {

    private InputEvent lastEvt;

    public HatSwitch(Component component) {
        super(component);
        lastEvt = null;
    }

    @Override
    public void generateEvent(InputEventListener listener) {
        updateSignal();
        InputEvent currEvt = translate(getCurrentSignal());
        if (currEvt != InputEvent.HS_NEUTRAL) {
            listener.buttonPressed(currEvt);
        }
        if (hasChanged()) {
            listener.buttonReleased(lastEvt);
        }
        lastEvt = currEvt;
    }

    public static InputEvent translate(float input) {
        if (input == 0.125) {
            return InputEvent.HS_UP_LEFT;
        } else if (input == 0.25) {
            return InputEvent.HS_UP;
        } else if (input == 0.375) {
            return InputEvent.HS_UP_RIGHT;
        } else if (input == 0.5) {
            return InputEvent.HS_RIGHT;
        } else if (input == 0.625) {
            return InputEvent.HS_DOWN_RIGHT;
        } else if (input == 0.75) {
            return InputEvent.HS_DOWN;
        } else if (input == 0.875) {
            return InputEvent.HS_DOWN_LEFT;
        } else if (input == 1.0) {
            return InputEvent.HS_LEFT;
        }
        return InputEvent.HS_NEUTRAL;
    }

}
