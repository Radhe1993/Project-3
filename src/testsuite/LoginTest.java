package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest
{
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setBaseUrl()
    {
        openUrl();
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials()
    {
          // Enter “tomsmith” username
          driver.findElement(By.id("username")).sendKeys("tomsmith");
         //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@ class='fa fa-2x fa-sign-in']")).click();
        String expected = "You logged into a secure area!\n" +
                "×";

        String actual = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals("Message",expected,actual);
        System.out.println(actual);

    }
    @Test
    public void verifyTheUsernameErrorMessage()
    {
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@ class='fa fa-2x fa-sign-in']")).click();
        // Your username is invalid!
        String expected = "Your username is invalid!\n" +
                "×";
        String actual = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals("Message",expected,actual);
       System.out.println(actual);

    }
    @Test
    public void verifyThePasswordErrorMessage()
    {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//i[@ class='fa fa-2x fa-sign-in']")).click();
        // Your password is invalid!
        String expected = "Your password is invalid!\n" +
                "×";
        String actual = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals("Message",expected,actual);
        System.out.println(actual);
    }
}
