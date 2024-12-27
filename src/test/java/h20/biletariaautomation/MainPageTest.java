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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

        String pageSource= driver.getPageSource();
        if (pageSource.contains("serbia")){
            Assert.fail();
        }else {
            Assert.assertTrue(true);
        }

    }
//    @Test(priority = 0)
//    public void confirmThePage() throws InterruptedException {
////        Cookie jsessionIdCookie = new Cookie("JSESSIONID", "1F2B10604281BC3812B2900642822861", "al.ebileta.al", "/biglietteria", null, true, true);
////        Cookie complianceCookie = new Cookie("complianceCookie", "accepted", "al.ebileta.al", "/", null, false, false);
//
//        mainPage.okayButton.click();
//
////        driver.manage().addCookie(complianceCookie);
////        driver.manage().addCookie(jsessionIdCookie);
//        driver.navigate().refresh();
//
////        driver.get("https://al.ebileta.al/biglietteria/listaEventiPub.do");
////        Thread.sleep(1000);
////        Assert.assertEquals(driver.getCurrentUrl(),"https://al.ebileta.al/biglietteria/listaEventiPub.do");
//
//    }
//
//@Test(priority = 1)
//public void marrimTextSektorve() throws InterruptedException {Thread.sleep(4000);
//
//
//    ArrayList<String> sektoret = new ArrayList<String>();
//
//
//    for (WebElement s : mainPage.sektoret) {
//        String combinedText = s.getText();
//        // Split the text into an array using space as delimiter
//        String[] values = combinedText.split("\\s");  // Split by one or more spaces
//        if (values[0].contains("Fusha")) {
//            continue;
//        }
//        String sector = values[0]; // e.g., Fusha
//        String availability = values[1]; // e.g., Availability
//        String status = values[2]; // e.g., Soldout
//        String str = values[3];
//
//        System.out.println(Arrays.toString(values));
//        if (values[3].contains("Soldout")) {
//
//        } else {
//            sektoret.add(values[1]);
//        }
//        if(kerkimiDiagonal(sektoret)){
//            WebElement clickableParent = s.findElement(By.xpath(".."));
//            clickableParent.click();}
//
//    }
//
//}
//
//@Test(priority = 2)
//public void selectOkButton() throws InterruptedException {
//
//    for (WebElement seat : mainPage.availableSeats) {
//       seat.click();
//        break;
//    }
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(mainPage.okButton));
//    okButton.click();
//
//   // WebElement googleButton= wait.until(ExpectedConditions.elementToBeClickable(mainPage.googleButton));
//    //googleButton.click();
//    Thread.sleep(50000);
//}
//@Test(priority =3)
//public void selektimiVendeve(){
//    for (WebElement seat : mainPage.availableSeats) {
//        // Click on the first 4 seats
//        for (int i = 0; i < 4; i++) {
//            seat.click();
//        }
//        break;  // Break after clicking 4 seats
//    }
//}
//public boolean kerkimiDiagonal(ArrayList<String> sc){
//    ArrayList<String> diagonalSectors = new ArrayList<>();
//    diagonalSectors.add("N206");
//    diagonalSectors.add("N207");
//    diagonalSectors.add("E201");
//    diagonalSectors.add("E202");
//    diagonalSectors.add("E210");
//    diagonalSectors.add("E211");
//    diagonalSectors.add("S201");
//    diagonalSectors.add("S202");
//    diagonalSectors.add("E109");
//    diagonalSectors.add("S101");
//    for (String sector : sc) {
//        if (diagonalSectors.contains(sector)) {
//            System.out.println(sector);
//            return true;
//
//        }
//
//    }
//    return false;
//
//}
//
//public boolean kerkimiMasPorte(ArrayList<String> sc){
//        List<String> remainingSectors = new ArrayList<>();
//        remainingSectors.add("N101");
//        remainingSectors.add("N102");
//        remainingSectors.add("N103");
//        remainingSectors.add("N104");
//        remainingSectors.add("N105");
//        remainingSectors.add("N106");
//        remainingSectors.add("N201");
//        remainingSectors.add("N202");
//        remainingSectors.add("N203");
//        remainingSectors.add("N204");
//        remainingSectors.add("N205");
//        remainingSectors.add("S101");
//        remainingSectors.add("S102");
//        remainingSectors.add("S103");
//        remainingSectors.add("S104");
//        remainingSectors.add("S105");
//        remainingSectors.add("S201");
//        remainingSectors.add("S202");
//        remainingSectors.add("S203");
//        remainingSectors.add("S204");
//        remainingSectors.add("S205");
//        remainingSectors.add("V101");
//        remainingSectors.add("V102");
//        remainingSectors.add("V103");
//        remainingSectors.add("V201");
//        remainingSectors.add("V202");
//        for (String sector : sc) {
//            if (remainingSectors.contains(sector)) {
//                System.out.println(sector);
//                return true;
//            }
//        }
//        return false;
//    }

}

