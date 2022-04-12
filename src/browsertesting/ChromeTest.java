package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeTest {
    public static void main(String[] args) {
        String baseurl="https://demo.nopcommerce.com/";// storing base uRL
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");//setting Webdriver
        WebDriver driver=new ChromeDriver();//creating object of  chrome webdriver
        driver.get(baseurl);// method to invoke URL
        driver.manage().window().maximize();//maximising the windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//Timeout session
        String tile=driver.getTitle();// storing title of the page
        System.out.println("Title of the page : "+tile);// printing the title in console
        String currentURL=driver.getCurrentUrl();// getting current URL
        System.out.println("Current URL of the page is "+currentURL);//Printing the current URl
        String source=driver.getPageSource();//Method to get page source
        System.out.println("Page source : "+source);// Printing the page source
        driver.findElement(By.className("ico-login")).click();// click on to login button
        WebElement emailField=driver.findElement(By.id("Email"));// storing emailField
        emailField.sendKeys("Prime123@gmail.com");// sending keys to email field
        WebElement passwordField=driver.findElement(By.name("Password"));// storing password field
        passwordField.sendKeys("12345");// sending keys to password field
        driver.close();// closing the browser
    }
}
