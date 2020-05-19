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


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class DepartmentsSort {
    WebDriver driver = Driver.getDriver();


    @Test
    public void test1() {
        WebElement allDepartments = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(allDepartments);
        String actual = select.getFirstSelectedOption().getText();
        String expected = "All Departments";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        WebElement allDepartments = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(allDepartments);
        List<WebElement> all = select.getOptions();
        BrowserUtils.wait(3);
        //List <String> sorted= new ArrayList<>();
        List <String> notSorted = new ArrayList<>();

        for (WebElement each:all) {
        notSorted.add(each.getText());
        }
        System.out.println("not sorted: "+notSorted);
        List <String> sorted= new ArrayList<>(notSorted);

        sorted.sort(Comparator.naturalOrder());
        System.out.println("sorted: " +sorted);

        Assert.assertNotEquals(notSorted,sorted);
    }






    @BeforeMethod
    public void setup () {
    driver.get("http://www.amazon.com");
        BrowserUtils.wait(5);


    }
    @AfterMethod
    public void teardown () {
        driver.close();
}

}
