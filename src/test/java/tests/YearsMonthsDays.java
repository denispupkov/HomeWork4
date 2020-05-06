package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

import java.time.Month;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.List;
import java.util.Random;


public class YearsMonthsDays {
    private WebDriver driver = Driver.getDriver();


    @Test
    public void test2 () {
        WebElement dropdownMenu = driver.findElement(By.id("year"));
        Select select = new Select(dropdownMenu);
        List <WebElement> dropdownList = select.getOptions();

        Random random =new Random();
        int index = random.nextInt(dropdownList.size());
        select.selectByIndex(index);
        int year = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Chosen year: "+year);

        


        BrowserUtils.wait(3);

        for (int i = 1; i <13 ; i++) {


            WebElement dropdownMonths = driver.findElement(By.id("month"));
            Select select2 = new Select(dropdownMonths);
            List <WebElement> allMonths = select2.getOptions();
            select2.selectByIndex(i-1);
            System.out.print(allMonths.get(i-1).getText());


            WebElement dropdownDays = driver.findElement(By.id("day"));
            Select select3 = new Select(dropdownDays);
            List<WebElement> allDays = select3.getOptions();
            int actual = allDays.size();
            YearMonth yearMonthObject = YearMonth.of(year, 2);
            int daysInMonth = yearMonthObject.lengthOfMonth();
            int numDays;
            if (daysInMonth>28) {
                 numDays = Month.of(i).length(true);
            }
            else {
                numDays = Month.of(i).length(false);
            }


            Assert.assertEquals(numDays, actual);
            System.out.println(": "+numDays+" days");
            BrowserUtils.wait(3);
        }












                }



    @BeforeMethod
    public void setup () {
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown () {
        driver.close();
    }
}



