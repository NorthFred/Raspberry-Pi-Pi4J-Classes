/*
 * HC-SR501 PIR Motion Detector: Delay Setting Checker.
 *
 * Uses Pi4J GPIO libraries (http://www.pi4j.com/)
 * 
 * @Frederik Vermaete 
 * @v.1.0.1 / 2017.05.07
 * 
 * This script checks the delay value on the HC-SR501 Motion Detector.
 * The delay can be manually set by rotating a screw on the sensor,
 * but the real delay value must be tested.
 * 
 * This program checks the time it takes for the pin to drop back to low state.
 * 
 */

import com.pi4j.io.gpio.RaspiPin;


public class TestPIRDelay {
    
    public static void main(String[] args) throws InterruptedException {
        
        // Pin selection (Pi4J GPIO 15)
        PIRMotionDetector detector = new PIRMotionDetector(RaspiPin.GPIO_15);
   
        // Waiting for the pin state to be low before starting the test
        System.out.println("Waiting for sensor to reach idle status.");
        
        while (detector.isPinStateHigh() == true) {
            System.out.print('.');
            Thread.sleep(1000);
        }
        
        System.out.println("Idle state OK.");
        System.out.println();
        System.out.println("Wave your hand in front of the detector to initiate a HIGH signal. Remove your hand instantly again!");
        
        while (detector.isPinStateLow() == true) {
            //wait
        }
        System.out.println("Movement detected!");
        
        // Logging the start time of switch to HIGH state           
        long startTime = System.currentTimeMillis();
        
        while (detector.isPinStateHigh() == true) {
            //wait
        }
        
        long stopTime = System.currentTimeMillis();
            
        System.out.println();      
        System.out.println("The delay of the sensor is set to: " + (stopTime - startTime) + " ms.");        
        
        detector.unprovisionPin();
        
        detector.shutdownGPIO();
    }
}
