/*
 * HC-SR501 PIR Motion Detector Control Class
 *
 * Uses Pi4J GPIO libraries (http://www.pi4j.com/)
 * 
 * @Frederik Vermaete 
 * @v.0.1.7 / 2017.05.07
 */

import com.pi4j.io.gpio.*;


public class PIRMotionDetector {

    // Attributes
    // Create GPIO controller
    private final GpioController gpio = GpioFactory.getInstance();
    
    private GpioPinDigitalInput pin;

    // Constructor
    public PIRMotionDetector(Pin pin) throws InterruptedException {
        
        provisionPin(pin);
    }     
    
    // Accessors
    public void provisionPin(Pin pin) {
            
        // Provision the input pin. Internap pull down resistor ENABLED.
        this.pin = gpio.provisionDigitalInputPin(pin, PinPullResistance.PULL_DOWN);

        // Set shutdown state for the pin
        this.pin.setShutdownOptions(true);
    }

    // Methods
    public boolean isPinStateHigh() {
        
        return this.pin.getState().isHigh();
        
    }
    
    public boolean isPinStateLow() {
        
        return this.pin.getState().isLow();
        
    }
    
    public Object getState() {
       
        return this.pin.getState();
    }   

    public void unprovisionPin() {
        
        gpio.unprovisionPin(this.pin);
    }
    
    public void shutdownGPIO() {
        
        gpio.shutdown();
    }
    
    public void unprovisionAndShutdown() {
        
        unprovisionPin();
        shutdownGPIO();
    }
    
    @Override
    public String toString() {
        
        return this.pin.toString();
    }
}
