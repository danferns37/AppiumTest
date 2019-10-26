# AppiumTest
This is a test on ebay app through appium to verfy the search of a item on ebay ,whether the item is correctly searched and expected pop up is returned
This test is coded in java and appium and runs on android device 
Steps to execute this test

1) Start Appium server on the laptop at 127.0.0.1:4723
2) Install Ebay Android app through playstore on the android device
The configurations of the apppackage and appactivitity in config.properties file  should be correct.
Connect the android device to the laptop through USB cable and make sure the android device is connected by enabling developer options and debugging on.
Do a adb devices to check whether the device is listed before running below test.
3)Clone this repository https://github.com/danferns37/AppiumTest.git
4) Once cloned opened this cloned folder in Intellij (this is a maven project)
5) Then right click on the pom.xml and add to maven project since this is a maven project
6) Please not the jdk used here  and jdk  set up is 10.0.2
7) Right click on the EbayTest class in src/test/java folder and this executes the test 

