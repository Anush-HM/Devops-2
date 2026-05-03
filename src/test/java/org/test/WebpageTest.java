package org.test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebpageTest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // 🔥 auto setup
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://your-github-page-link");
    }
    @Test
    public void titleValidationTest() {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        String expectedTitle = "Webpage Design";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}