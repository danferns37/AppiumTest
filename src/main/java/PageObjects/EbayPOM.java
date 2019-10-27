package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class EbayPOM {
    AppiumDriver  driver;

    public EbayPOM(AppiumDriver driver) {

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.ebay.mobile:id/button_register")
    MobileElement Register;

    @AndroidFindBy(id = "com.ebay.mobile:id/search_box")
    MobileElement Search_box;

    @AndroidFindBy(id = "com.ebay.mobile:id/search_src_text")
    MobileElement Search_text_box;

    @AndroidFindBy(id = "com.ebay.mobile:id/text_slot_1")
    MobileElement Pop_up_check;


    public String NewtripMethod(String item) throws InterruptedException {


         Search_box.click();
         Search_text_box.sendKeys(item);
         Search_text_box.getText().toString().contains(item);

         Actions action = new Actions(driver);
         driver.getKeyboard().pressKey(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(Pop_up_check));


         return Pop_up_check.getText().toString();


    }
}

