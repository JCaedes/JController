package com.caedes.jcontroller;

public class Analog implements InputEventGenerator {

    private Slider xSlider, ySlider;
    private InputEvent evt;

    public Analog(InputEvent evt, Slider x, Slider y) {
        this.xSlider = x;
        this.ySlider = y;
        this.evt = evt;
        xSlider.configureDeadzone(0.3f);
        ySlider.configureDeadzone(0.3f);
    }

    @Override
    public void generateEvent(InputEventListener listener) {
        xSlider.updateSignal();
        ySlider.updateSignal();
        if (xSlider.hasChanged() || ySlider.hasChanged()) {
            listener.analogMoved(evt, xSlider.getCurrentSignal(), ySlider.getCurrentSignal());
        }
    }



}
