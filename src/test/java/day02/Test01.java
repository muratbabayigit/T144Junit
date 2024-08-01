package day02;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test01 {
   static WebDriver driver;
   static String email="mb@mb.com";
   static String pass="1478963";
   static String name="Murat";

    /*
            1-https://www.automationexercise.com/ adresine gidin
            2-Üye kayıt sayfasına geçiş yapın
            3-Yeni bir üye kaydı oluşturun
            4-Üye kaydı olışturulduğunu doğrulayın
            5-Yeni üye bilgileri ile siteye giriş yapın
            6-Doğru bilgilerle Üye girişi yapılabildiğini doğrulayın
     */
    @BeforeAll
    public static void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {Thread.sleep(3000); driver.quit();
         }

    @BeforeEach
    public void beforeTest(){
        driver.get("https://www.automationexercise.com/");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("Test tamamlandı.Sonuçları kontrol ediniz");
    }
    @Test
    public void test01() throws InterruptedException {
        Faker faker=new Faker();

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("first_name")).sendKeys("Murat");
        driver.findElement(By.id("last_name")).sendKeys("Yiğit");
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("state")).sendKeys(faker.address().state());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("zipcode")).sendKeys(faker.address().zipCode());
        driver.findElement(By.id("mobile_number")).sendKeys(faker.phoneNumber().phoneNumber());
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        String expectedResult="ACCOUNT CREATED!";
        String actualResult=driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        assertEquals(expectedResult,actualResult);
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        driver.findElement(By.xpath("//*[@href='/logout']")).click();
    }
    @Test
    public void test02(){
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
        String expectText="Delete Account";
        String actualText=driver.findElement(By.xpath("//*[@href='/delete_account']")).getText();
        assertEquals(expectText,actualText);
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();


    }








}
