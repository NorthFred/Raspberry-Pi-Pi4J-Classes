import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class TestPIRMotionDetector {
    
    public static void main(String[] args) throws InterruptedException {
        
        // Pin selection (input pin 14 == Pi4J GPIO 15)
        PIRMotionDetector detector = new PIRMotionDetector(RaspiPin.GPIO_15);
    
        // Get the current state of the motion detector: HIGH = motion, LOW = idle.
        System.out.println("Current state: " + detector.getState());
        
        // Boolean methods
        System.out.println("Is state HIGH: " + detector.isPinStateHigh());
        System.out.println("Is state LOW: " + detector.isPinStateLow());
       
        
        detector.unprovisionPin();
        
        detector.shutdownGPIO();
    }
}
