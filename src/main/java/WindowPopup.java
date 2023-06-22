
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class WindowPopup {

    public void windowpopup()
    {
       //System.setProperty("webdriver.chrome.driver","C:\\Users\\IamBh\\IdeaProjects\\Windowpopup\\src\\Driver\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        //http://username:password@siteurl
        driver.get("http://admin:admin@the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.linkText("Basic Auth")).click();
        driver.close();
    }
}
