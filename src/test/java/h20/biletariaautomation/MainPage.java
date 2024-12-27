package h20.biletariaautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// page_url = https://www.jetbrains.com/
public class MainPage {
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Ok'])[1]")
    public WebElement okButton;

    @FindBy(xpath = "//li[contains(@class, 'link_settore')]//a")
    public List<WebElement> sektoret;
    @FindBy(xpath = "(//img[@class='textmiddle'])[1]")
    public WebElement okayButton;
    @FindBy(xpath = "(//div[normalize-space()='Select the sector:'])[1]")
    public WebElement sectorTextPage;
    @FindBy(xpath = "//input[@id=\"aggiungicarrellocorto\"]")
    public WebElement addToCartButton;
    @FindBy(css = "g[cursor='pointer']")
    public List<WebElement> availableSeats;
    @FindBy(css = "li[id=\"login\"]")
    public WebElement loginButton;
    @FindBy(css = "#google-btn")
    public WebElement googleButton;
    String[] remainingSectors = {
            // North Stand
            "N101", "N102", "N103", "N104", "N105", "N106",
            "N201", "N202", "N203", "N204", "N205", "N206", "N207",

            // South Stand
            "S101", "S102", "S103", "S104", "S105",
            "S201", "S202", "S203", "S204", "S205",

            // Corner sections excluded from W and E
            "V101", "V102", "V103", "V201", "V202"
    };
    String[] diagonalSectors = {
            "N206", "N207",  // Top-left corner
            "E201", "E202",  // Top-middle-left
            "E210", "E211",  // Top-middle-right
            "S201", "S202",  // Bottom-right corner
            "E109", "S101"   // Bottom-left corner
    };
    public void marrimTextSektorve(){
        for(WebElement s : sektoret){
            System.out.println(s.getText());
        }}

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
