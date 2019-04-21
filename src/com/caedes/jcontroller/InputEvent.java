package com.caedes.jcontroller;

/**
 * @author Musa Kapan aka Cres | Caedes
 *
 * All the input events that can be triggered by a controller.
 *
 * TODO: names need to be abstracted if we want to allow for different controller types.
 */
public enum InputEvent {

    CROSS,
    SQUARE,
    TRIANGLE,
    CIRCLE,
    SHARE,
    OPTIONS,
    L1,
    R1,
    L3,
    R3,

    HS_NEUTRAL,
    HS_UP,
    HS_UP_RIGHT,
    HS_RIGHT,
    HS_DOWN_RIGHT,
    HS_DOWN,
    HS_DOWN_LEFT,
    HS_LEFT,
    HS_UP_LEFT,

    LEFT_ANALOG,
    RIGHT_ANALOG,

    L2,
    R2,
    TRIGGER_NEUTRAL;

}
