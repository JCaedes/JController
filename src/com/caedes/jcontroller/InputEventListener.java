package com.caedes.jcontroller;

public interface InputEventListener {

    void buttonPressed(InputEvent evt);

    void buttonReleased(InputEvent evt);

    void analogMoved(InputEvent evt, float x, float y);

    void sliderPressed(InputEvent evt, float intensity);

}
