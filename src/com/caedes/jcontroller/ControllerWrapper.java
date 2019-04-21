package com.caedes.jcontroller;

import net.java.games.input.Component;
import net.java.games.input.Controller;

import java.util.ArrayList;

/**
 * @author Musa Kapan aka Cres | Caedes
 *
 * Container class for jinput's Controller class. Holds the components that make up this controller in the form
 * of input generators. An input listener can be attached to this class through which the events triggered by the
 * components will be sent.
 *
 * TODO: dynamic detection of components, support for XBOX 360 controllers, etc
 */
public class ControllerWrapper {

    private Controller controller;
    private ArrayList<InputEventGenerator> generators;
    private InputEventListener listener;

    public ControllerWrapper(Controller controller) {
        this.controller = controller;
        this.generators = new ArrayList<>();
        this.listener = null;
        configureComponents();
    }

    private void configureComponents() {
        Component[] components = controller.getComponents();
        Slider yLeft = new Slider(components[0]);
        Slider xLeft = new Slider(components[1]);
        generators.add(new Analog(InputEvent.LEFT_ANALOG, xLeft, yLeft));
        Slider yRight = new Slider(components[2]);
        Slider xRight = new Slider(components[3]);
        generators.add(new Analog(InputEvent.RIGHT_ANALOG, xRight, yRight));
        generators.add(new Slider(components[4]));
        generators.add(new Button(components[5], InputEvent.CROSS));
        generators.add(new Button(components[6], InputEvent.CIRCLE));
        generators.add(new Button(components[7], InputEvent.SQUARE));
        generators.add(new Button(components[8], InputEvent.TRIANGLE));
        generators.add(new Button(components[9], InputEvent.L1));
        generators.add(new Button(components[10], InputEvent.R1));
        generators.add(new Button(components[11], InputEvent.SHARE));
        generators.add(new Button(components[12], InputEvent.OPTIONS));
        generators.add(new Button(components[13], InputEvent.L3));
        generators.add(new Button(components[14], InputEvent.R3));
        generators.add(new HatSwitch(components[15]));

    }

    public void update() {
        controller.poll();
        if (listener != null) {
            for (InputEventGenerator g : generators) {
                g.generateEvent(listener);
            }
        }
    }

    public void setListener(InputEventListener listener) {
        this.listener = listener;
    }

    public Controller getController() {
        return controller;
    }

}
