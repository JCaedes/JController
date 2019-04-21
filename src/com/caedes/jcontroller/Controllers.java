package com.caedes.jcontroller;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

public class Controllers implements Runnable {

    private static Controllers instance;

    private Thread thread;
    private ControllerWrapper[] activeControllers;
    private boolean running;

    private Controllers() {
        this.thread = new Thread(this);
        this.activeControllers = null;
        this.running = true;
    }

    public void setup() {
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        int count = 0;
        for (Controller c : controllers) {
            if (c.getName().contains("XBOX")) {
                count++;
            }
        }
        activeControllers = new ControllerWrapper[count];
        count = 0;
        for (Controller c : controllers) {
            if (c.getName().contains("XBOX")) {
                activeControllers[count] = new ControllerWrapper(c);
                count++;
            }
        }
    }

    public ControllerWrapper[] getActiveControllers() {
        return activeControllers;
    }

    public void shutdown() {
        running = false;
        instance = null;
    }

    public static Controllers getInstance() {
        if (instance == null) {
            instance = new Controllers();
        }
        return instance;
    }

    @Override
    public void run() {
        while (running) {
            for (ControllerWrapper cw : activeControllers) {
                cw.update();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public Thread getThread() {
        return thread;
    }

}
