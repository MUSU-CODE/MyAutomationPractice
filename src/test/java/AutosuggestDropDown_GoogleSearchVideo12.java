/* import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
 
public class AutosuggestDropDown_BingSearch {
 
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
 
        // Create ChromeDriver instance
        WebDriver driver = new ChromeDriver();
 
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
        // Launch application URL
        driver.get("[https://www.bing.com");//(https://www.bing.com";)
 
        // Maximize the browser window
        driver.manage().window().maximize();
 
        // Find the search box element and enter text in search box through .sendkey() method
        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
 
        // Find all auto-suggested options
        List<WebElement> optionslist = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
 
        // Print the size of auto-suggestions
        System.out.println("Size of auto suggestions: " + optionslist.size());
 
        // Iterate through all the options and click on "selenium download"->our desired option value
        for (WebElement listItem : optionslist) {
            if (listItem.getText().contains("download")) { // if we use .contain method then only download is sufficient as we already put sendKeys("selenium") but instead of .contains("download") we can write full .equals("selenium download")
                listItem.click();
                break; // Exit the loop after clicking
            }
        }
         driver.quit(); // to close the browser after execution
    }
} */
 
// another program

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
 
public class AutosuggestDropDown_GoogleSearchVideo12 {
 
    public static void main(String[] args) throws InterruptedException { // Added InterruptedException for Thread.sleep
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
 
        // Create ChromeDriver instance
        WebDriver driver = new ChromeDriver();
 
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 
        // Launch application URL
        driver.get("https://www.google.com");//(https://www.google.com";)
 
        // Maximize the browser window
        driver.manage().window().maximize();
 
        // Find the search box element and enter text
        driver.findElement(By.name("q")).sendKeys("java tutorial");
 
        // Introduce a small wait to allow suggestions to load (for demonstration)
        Thread.sleep(3000); // 3 seconds wait
 
        // Find all auto-suggested options
        List<WebElement> optionslist = driver.findElements(By.xpath("//li[@class='sa_sg']//div[@role='option']//div[1]//span"));
 
        // Print the size of auto-suggestions
        System.out.println("Size of auto suggestions: " + optionslist.size());
 
        // Iterate through the options and click on "java tutorial for beginners"
        for (WebElement listItem : optionslist) {
            if (listItem.getText().contains("beginners")) {
                listItem.click();
                break; // Exit the loop after clicking
            }
        }
        driver.quit(); // to close the browser after execution
    }
} 