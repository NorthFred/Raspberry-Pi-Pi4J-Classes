/*
 * HC-SR501 PIR Motion Detector: Pin Listener demonstration
 *
 * Uses Pi4J GPIO libraries (http://www.pi4j.com/)
 * 
 * @Frederik Vermaete 
 * @v.1.0.0 / 2017.05.07
 * 
 * Add a pinListener to the motion detector's pin.
 * The pinListener can provide certain actions while the rest of the program is running.
 * 
 */

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class TestPIRMotionListener {
    
    public static void main(String[] args) throws InterruptedException {
        
        final GpioController gpio = GpioFactory.getInstance();
        
        // GPIO 15 has been used for the PIR sensor
        final GpioPinDigitalInput pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_15, PinPullResistance.PULL_DOWN);
        
        pin.setShutdownOptions(true);
        
        pin.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                
                System.out.println("GPIO PIN STATE CHANGE: " + event.getPin() + " = " +event.getState());
            }
        });
        
        while (true) {
            
            // While the rest of the program is running, the pin listener will provide certain actions when the pin state is changed.
            Thread.sleep(500);
        
        }
        
        //gpio.unprovisionPin(pin);
        
        //gpio.shutdown();
    }
}
        
 