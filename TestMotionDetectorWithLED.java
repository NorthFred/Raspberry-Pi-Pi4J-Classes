/*
 *  Test class: if motion is detected, LED will turn red.  If free, LED is green.
 */

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;


public class TestMotionDetectorWithLED {
    
    public static void main(String[] args) throws InterruptedException {
        
        final GpioController gpio = GpioFactory.getInstance();
        
        // GPIO 15 has been used for the PIR sensor
        final GpioPinDigitalInput pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_15, PinPullResistance.PULL_DOWN);
        
        KeyesRGBLEDControl rgb = new KeyesRGBLEDControl(RaspiPin.GPIO_08, RaspiPin.GPIO_09, RaspiPin.GPIO_07);
        
        pin.setShutdownOptions(true);
        
        pin.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                
                             
                System.out.println("GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
                
                String state = event.getState().toString();
 
                if (state.equals("HIGH"))
                    rgb.showRed();
                else
                    rgb.showGreen();
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
        
 