package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {
    public static void main(String[] args) {
       // WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.hepsiburada.com/");
        String title=driver.getTitle();
        String expectedText="Hepsiburada.com";

        if (title.contains(expectedText)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
        driver.quit();




    }
}
