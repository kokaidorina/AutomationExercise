import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.IndexPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestAutomationExercise {
    WebDriver driver;

    @BeforeEach
    public void intit() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testItemNames() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.navigateUrl();
        indexPage.searchItem("dress");
        String[]actualRes=indexPage.getItems();
        String[] expectedResults = {"Sleeveless Dress", "Stylish Dress", "Sleeves Top and Short - Blue & Pink", "Sleeveless Unicorn Patch Gown - Pink",
                "Cotton Mull Embroidered Dress", "Blue Cotton Indie Mickey Dress", "Long Maxi Tulle Fancy Dress Up Outfits -Pink",
                "Sleeveless Unicorn Print Fit & Flare Net Dress - Multi", "Rose Pink Embroidered Maxi Dress"};
        Assertions.assertArrayEquals(expectedResults, actualRes);
    }

}
