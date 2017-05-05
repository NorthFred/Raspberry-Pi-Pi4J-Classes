/*
 * KEYES RGB LED Common Cathode Control Class
 *
 * Uses Pi4J GPIO libraries (http://www.pi4j.com/)
 * 
 * @Frederik Vermaete 
 * @v.0.1.3 / 2017.05.05
 */

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.Pin;

public class KeyesRGBLEDControl {

    // Attributes
    private final GpioController gpio = GpioFactory.getInstance();
    
    private GpioPinDigitalOutput pin1;
    private GpioPinDigitalOutput pin2;
    private GpioPinDigitalOutput pin3;
    
    // Constructor
    public KeyesRGBLEDControl(Pin rR, Pin gG, Pin bB) throws InterruptedException {
        
        provisionPins(rR, gG, bB);
    }
    
    // Accessors
    public void provisionPins(Pin rR, Pin gG, Pin bB) {
            
        // Provision the pins
        this.pin1 = gpio.provisionDigitalOutputPin(rR, "R", PinState.LOW);
        this.pin2 = gpio.provisionDigitalOutputPin(gG, "G", PinState.LOW);
        this.pin3 = gpio.provisionDigitalOutputPin(bB, "B", PinState.LOW);

        // Set shutdown states for the pins
        this.pin1.setShutdownOptions(true, PinState.LOW);
        this.pin2.setShutdownOptions(true, PinState.LOW);
        this.pin3.setShutdownOptions(true, PinState.LOW);
    }

    // Methods
    public void showRed() {

        this.pin1.high();
        this.pin2.low();
        this.pin3.low();
    }

    public void showGreen() {

        this.pin1.low();
        this.pin2.high();
        this.pin3.low();
    }

    public void showBlue() {

        this.pin1.low();
        this.pin2.low();
        this.pin3.high();
    }

    public void showWhite() {

        this.pin1.high();
        this.pin2.high();
        this.pin3.high();
    }

    public void showYellow() {

        this.pin1.high();
        this.pin2.high();
        this.pin3.low();
    }

    public void showMagenta() {

        this.pin1.high();
        this.pin2.low();
        this.pin3.high();
    }

    public void showCyan() {

        this.pin1.low();
        this.pin2.high();
        this.pin3.high();
    }

    public void lightsOff() {
        
        this.pin1.low();
        this.pin2.low();
        this.pin3.low();
    }
    
    public void unprovisionPins() {
        
        lightsOff();
        gpio.unprovisionPin(this.pin1);
        gpio.unprovisionPin(this.pin2);
        gpio.unprovisionPin(this.pin3);
    }
    
    public void shutdownGPIO() {
        
        gpio.shutdown();
    }
    
    public void unprovisionAndShutdown() {
        
        unprovisionPins();
        shutdownGPIO();
    }
}

