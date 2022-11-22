/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class TemperatureSensor implements Sensor{
    private boolean isOn;
    private int value;

    public TemperatureSensor() {
        this.isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn() {
        this.isOn = true;
    }

    public void setOff() {
        this.isOn = false;
    }

    public int read() {
        if (isOn) {
            return new Random().nextInt(61) - 30;
        } else {
            throw new IllegalStateException("Illegal state!");
        }
    }
}
