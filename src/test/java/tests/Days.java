package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;
import java.util.List;
import java.util.Random;

public class Days {
    private  WebDriver driver = Driver.getDriver();


    @Test
    public void test1 () {
        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//input[starts-with(@id, 'gwt-debug-cwCheckBox')]")) ;
        List<WebElement> allLabels=driver.findElements(By.xpath("//input[starts-with(@id, 'gwt-debug-cwCheckBox')]//following-sibling::label"));
        int counter = 0;
        while (counter<3) {

            Random random = new Random();
            int randomCheckbox = random.nextInt(allCheckboxes.size());

            if (allCheckboxes.get(randomCheckbox).isEnabled()) {
                allCheckboxes.get(randomCheckbox).click();
                System.out.println("Selected checkbox is " + allLabels.get(randomCheckbox).getText());
                allCheckboxes.get(randomCheckbox).click();
                BrowserUtils.wait(1);

                if (allLabels.get(randomCheckbox).getText().equals("Friday")) {
                    counter++;

                }
            }
        }
         
    }


    @BeforeMethod
    public void setup () {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown () {
        driver.close();
    }
}
