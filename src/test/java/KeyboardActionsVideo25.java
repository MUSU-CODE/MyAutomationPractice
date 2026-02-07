import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class KeyboardActionsVideo25 {
 
    public static void main(String[] args) throws InterruptedException {
 
        // Setting up the Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 
        // Launching the application
        driver.get("[https://www.google.com/");
        driver.manage().window().maximize();
 
        // Creating Actions class object
        Actions act = new Actions(driver);
 
        // Performing single key actions
        act.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000); // Adding sleep to observe the action
        act.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.SPACE).perform();
        Thread.sleep(2000);
 
        driver.quit();
    }
}
 
 
/*
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class KeyboardActionMultipleKeys {
 
    public static void main(String[] args) throws InterruptedException {
 
        // Setting up the Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 
        // Launching the application
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();
 
        // Locating the input elements
        WebElement input1 = driver.findElement(By.id("textbox1"));
        WebElement input2 = driver.findElement(By.id("textbox2"));
 
        // Passing text into the first input box
        input1.sendKeys("Welcome to Selenium");
 
        // Creating Actions class object
        Actions actions = new Actions(driver);
 
        // Performing Control + A (Select All)
        actions.keyDown(Keys.CONTROL); //we pressed the control key
        actions.sendKeys("a"); // we press A key
        actions.keyUp(Keys.CONTROL); // we release control key
        actions.perform();
        Thread.sleep(2000);
 
        // Performing Control + C (Copy)
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
 
        // Pressing TAB to move to the second input box
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(2000);
 
        // Performing Control + V (Paste)
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
 
        // Comparing the text in both input boxes
        String text1 = input1.getAttribute("value");//getAttribute("value") will give us the text written 
        String text2 = input2.getAttribute("value");
 
        if (text1.equals(text2)) {
            System.out.println("Text copied successfully!");
        } else {
            System.out.println("Text not copied!");
        }
 
        driver.quit();
    }
}*/