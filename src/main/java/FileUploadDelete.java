import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

@Test
public class FileUploadDelete {
    public void fileupload() throws IOException, InterruptedException {
       String downloadpath= System.getProperty("user.dir");
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

        chromePrefs.put("profile.default_content_settings.popups", 0);

        chromePrefs.put("download.default_directory", downloadpath);
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://altoconvertpdftojpg.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("browse")).click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C:\\Users\\IamBh\\OneDrive\\Documents\\Check\\UploadFile.exe");
        Thread.sleep(2000);
       driver.findElement(By.id("submit_btn")).click();
       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-download']"))).click();
       //File f=new File("C:\\Users\\IamBh\\Downloads\\Worksheet.zip");
        //Download the file specfic project not in the download folder
        Thread.sleep(2000);
        File f =new File(downloadpath+"/Worksheet.zip");
       if(f.exists())
       {
           System.out.println("File Found");
           f.delete();
       }

    }
}
