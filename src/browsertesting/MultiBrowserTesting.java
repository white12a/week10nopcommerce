package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTesting {
    static String browser = "Chrome";
    static String baseURL = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
             driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("not valid browser");
        }
        driver.get(baseURL);
        driver.manage().window().maximize();//maximising the windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//Timeout session
        String tile = driver.getTitle();// storing title of the page
        System.out.println("Title of the page : " + tile);// printing the title in console
        String currentURL = driver.getCurrentUrl();// getting current URL
        System.out.println("Current URL of the page is " + currentURL);//Printing the current URl
        String source = driver.getPageSource();//Method to get page source
        System.out.println("Page source : " + source);// Printing the page source
        driver.findElement(By.className("ico-login")).click();// click on to login button
        WebElement emailField = driver.findElement(By.id("Email"));// storing emailField
        emailField.sendKeys("Prime123@gmail.com");// sending keys to email field
        WebElement passwordField = driver.findElement(By.name("Password"));// storing password field
        passwordField.sendKeys("12345");// sending keys to password field
        driver.close();// closing the browser
    }
}
