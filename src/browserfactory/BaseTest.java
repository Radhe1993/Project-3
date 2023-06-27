package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest
{
    String baseUrl = "http://the-internet.herokuapp.com/login";
    public   WebDriver driver;

    public void openUrl()
    {
          driver = new ChromeDriver();
          driver.get(baseUrl);
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
