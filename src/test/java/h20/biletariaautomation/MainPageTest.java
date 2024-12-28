package h20.biletariaautomation;

import com.beust.ah.A;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.*;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;


    @BeforeSuite
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        // Add cookies to the driver



        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://al.ebileta.al/biglietteria/listaEventiPub.do");
        Thread.sleep(5000);
            driver.manage().deleteAllCookies();
        mainPage = new MainPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void pageSource(){

        String pageSource= driver.getPageSource().toLowerCase();


            if (pageSource.contains("serbia") ||
                pageSource.contains("andorra") ||
                pageSource.contains("andorre") ||
                pageSource.contains("andorrë") ||
                pageSource.contains("shqiperi") ||
                pageSource.contains("shqipëri")) {
            Assert.fail("Biletat e Shqiperis jan ketu");
        }else {
            Assert.assertTrue(true,"ska bileta vl");
        }

    }


}

