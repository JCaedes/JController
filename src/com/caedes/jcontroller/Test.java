package com.caedes.jcontroller;

public class Test {

    public static void main(String[] args) {

        //Step 1: configure the connected controllers

        Controllers.getInstance().setup();
        if (Controllers.getInstance().getActiveControllers().length == 0) {
            System.out.println("No controllers found. Test application will exit.");
            System.exit(0);
        }

        //Step 2: select a controller from the configured ones and attach a listener to it

        ControllerWrapper controller = Controllers.getInstance().getActiveControllers()[0];
        controller.setListener(new InputEventListener() {
            @Override
            public void buttonPressed(InputEvent evt) {

            }

            @Override
            public void buttonReleased(InputEvent evt) {
                System.out.println("Button released: "+evt);
            }

            @Override
            public void analogMoved(InputEvent evt, float x, float y) {

            }

            @Override
            public void sliderPressed(InputEvent evt, float intensity) {

            }
        });

        //Step 3: start the controller thread to process inputs

        Controllers.getInstance().getThread().start();
    }


}