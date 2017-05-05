import com.pi4j.io.gpio.RaspiPin;

public class TestKeyesRGBLEDControl {
    
    public static void main(String[] args) throws InterruptedException {
        
        // Red = GPIO_08, Green = GPIO_09, Blue = GPIO_07.
        KeyesRGBLEDControl rgb = new KeyesRGBLEDControl(RaspiPin.GPIO_08, RaspiPin.GPIO_09, RaspiPin.GPIO_07);
        
        rgb.showBlue();
        
        Thread.sleep(2000);
        
        rgb.showRed();
        
        Thread.sleep(2000);
        
        rgb.showYellow();
        
        Thread.sleep(2000);
        
        rgb.showCyan();
        
        Thread.sleep(2000);
        
        rgb.showWhite();
        
        Thread.sleep(2000);
        
        rgb.showMagenta();
        
        Thread.sleep(2000);
        
        rgb.showGreen();
        
        Thread.sleep(2000);
        
        rgb.lightsOff();
        
        rgb.unprovisionPins();
        
        rgb.shutdownGPIO();
    }
}
