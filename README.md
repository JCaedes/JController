# JController

Author: Musa Kapan

Credits: Endolf for jinput which this API is based upon.

Super basic implementation of jinput for Dualshock4 controllers with an event driven endpoint for easy implementation.

<h1>How to use</h1>

First make sure you have the .dll files in your javapath.

<code>
  
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
</code>

<h1>Also works in Processing 3.4</h1>

Simply copy <b>JController.jar</b> from <b>out/artifacts/JController_jar/</b> and put in the <b>code/</b> folder in your sketch's directory.

<h1>TODO</h1>

<ul>
  <li>Controller configuration (deadzone, etc)</li>
  <li>XBOX 360 controller support</li>
  <li>dynamic component detection</li>
</ul>
