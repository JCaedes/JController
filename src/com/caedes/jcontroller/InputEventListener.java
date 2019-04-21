package com.caedes.jcontroller;

/**
 * @author Musa Kapan aka Cres | Caedes
 *
 * The main connector between this API and any implementation of it. Heavily inspired by how Java deals
 * with KeyEvents but slightly adjusted obviously to allow for analogs.
 */
public interface InputEventListener {

    void buttonPressed(InputEvent evt);

    void buttonReleased(InputEvent evt);

    void analogMoved(InputEvent evt, float x, float y);

    void sliderPressed(InputEvent evt, float intensity);

}
