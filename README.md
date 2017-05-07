# Raspberry-Pi-Pi4J-Classes

Various classes using the Pi4J GPIO libraries to facilitate the use of different sensors

___________________________________________
(1) Keyes RGB LED Control (Common Cathode!)
___________________________________________
  v.0.1.3
  Class: KeyesRGBLEDControl.java
  Test Class: TestKeyesRGBLEDControl.java


________________________________
(2) PIR Motion Detector HC-SR501
________________________________
  v.0.1.5
  Class: PIRMotionDetector.java
  Test Class: TestPIRMotionDetector.java

  NOTE:
  The HC-SR501 detector has a screw to manually change the "delay" setting after HIGH status is triggered.
  The test class "TestPIRDelay" can be used to measure this delay, by waving your hand in front of the sensor.
  
  Test Class: TestPIRMotionListener.java
  This test class implements a listener and event handler when a state change is triggered on the motion detector pin!
