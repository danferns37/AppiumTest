import PageObjects.EbayPOM;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EbayTest {

    public AndroidDriver<MobileElement> driver;


    @BeforeClass
    public void setUp() throws MalformedURLException {


        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(FileSystems.getDefault().getPath("config.properties").toAbsolutePath().toString())) {


            // load a properties file
            prop.load(input);



        } catch (IOException ex) {
            ex.printStackTrace();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", prop.getProperty("BROWSER_NAME"));
        capabilities.setCapability("VERSION", prop.getProperty("VERSION"));
        capabilities.setCapability("deviceName",prop.getProperty("deviceName"));
        capabilities.setCapability("platformName",prop.getProperty("platformName"));
        capabilities.setCapability("appPackage",  prop.getProperty("appPackage"));
        capabilities.setCapability("appActivity", prop.getProperty("appActivity")); // This is Launcher a


        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testebay() throws Exception {
       //This method  searches for watch item in ebay app,verifies whether watch was entered in search a
        //and expected pop up returned which comes only when a item is searched on the app in search box
        EbayPOM tpom = new EbayPOM(driver);
        String result = tpom.NewtripMethod("Watch");
        Assert.assertEquals(result,"When you save a search, we'll let you know when a new item is listed");

    }

    @AfterClass
    public void teardown(){
        //close the app
        driver.quit();
    }

}
