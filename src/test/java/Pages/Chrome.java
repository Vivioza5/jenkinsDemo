package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ReadConfig;
import utils.ReadProperty;

import java.io.IOException;
public class Chrome {
private static WebDriver instanceOfChrome = null;

    private Chrome() {
    }
    private static ChromeOptions chromeOptions = new ChromeOptions();
    private static ChromeOptions setOptions() throws IOException {
        int width = Integer.parseInt(ReadConfig.get("width"));
        int height = Integer.parseInt(ReadConfig.get("height"));
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--window-size=" +  width+ "," + height);
        return chromeOptions;
    }


    public static WebDriver getInstanceOfChrome() throws IOException {
        if (instanceOfChrome == null) {
            WebDriverManager.chromedriver().setup();
            instanceOfChrome = new ChromeDriver(setOptions());
            instanceOfChrome.manage().deleteAllCookies();
        }
        return instanceOfChrome;
    }

    public static void quitInstance() {
        instanceOfChrome.manage().deleteAllCookies();
        instanceOfChrome.quit();
        instanceOfChrome = null;
    }

    public static void openUrl(String url) throws IOException {
        instanceOfChrome=getInstanceOfChrome();
        instanceOfChrome.get(url);
    }
}
