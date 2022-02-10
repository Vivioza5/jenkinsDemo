package Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
        driver = Chrome.getInstanceOfChrome();
    }

    @Test
    public void login() {
        String login_url = "https://opensource-demo.orangehrmlive.com/";
        driver.get(login_url);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        System.out.println(driver.getTitle());
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
