import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

@Test
public class FileUpload {

    public void fileupload() throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.pdfsimpli.com/pdf-to-jpeg/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//label[@id='unauthContentPlaceHolder_dragUploadPdfMain']")).click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C:\\Users\\IamBh\\OneDrive\\Documents\\Check\\FileUpload.exe");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()=\"LET’S GET STARTED\"]")).click();
        driver.findElement(By.id("small-business-close")).click();
        Thread.sleep(2000);
        WebElement Text=driver.findElement(By.xpath("//button[@title='Free Text']"));
        Text.click();
        Thread.sleep(2000);
      //  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[normalize-space()='GET STARTED']"))));
        driver.findElement(By.xpath("//div/button[@class='btn primary pull-right'][.='GET STARTED']")).click();

        Actions a=new Actions(driver);
        a.moveToElement(Text).click().build().perform();
        a.click(Text).sendKeys("ss").build().perform();
        driver.findElement(By.id("ConvertContinue")).click();

        driver.findElement(By.id("radioJpeg")).click();
        driver.findElement(By.xpath("//div[@class='cong-modal-desktop']/button[@name='download']")).click();
        driver.findElement(By.id("googleBtn")).click();
        driver.close();

            }
}
//shift focus to the file upload windows
//set text path intp file
//click open to upload file
