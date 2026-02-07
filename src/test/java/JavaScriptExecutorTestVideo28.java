// JavaScriptExecutorTest.java (Main class)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class JavaScriptExecutorTestVideo28 {
 
    public static void main(String[] args) throws Exception {
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        
        //JavaScriptExecutor is an interface which contain executeScript() method to execute JS
         
        //Syntax
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript(JavaScript, args);
        
        //for each action below we create a reusable method in JavaScriptExecutorUtilVideo28 class then whenever we want to perform an action we call tht method from JavaScriptExecutorUtilVideo28 class
        
        // Drawing border and taking screenshot
        WebElement logoElement = driver.findElement(By.xpath("//img[@title='Your Store']"));
        JavaScriptExecutorUtilVideo28.drawBorder(driver, logoElement);
        Thread.sleep(3000); // Wait to see the border
 
        // Taking screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Screenshots/logo.png";
        File destination = new File(path);
        FileHandler.copy(source, destination);
        System.out.println("Screenshot captured for logo element.");
 
        // Get page title
        String pageTitle = JavaScriptExecutorUtilVideo28.getTitleByJS(driver);
        System.out.println("Page Title: " + pageTitle);
 
        // Click on an element
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        JavaScriptExecutorUtilVideo28.clickElementByJS(driver, registerLink);
        Thread.sleep(2000);
 
        // Generate alert
        JavaScriptExecutorUtilVideo28.generateAlert(driver, "This is my alert!");
        Thread.sleep(2000);
        driver.switchTo().alert().accept(); // Accept the alert
 
        // Refresh page
        JavaScriptExecutorUtilVideo28.refreshBrowserByJS(driver);
        Thread.sleep(2000);
 
        // Scroll down and up
        JavaScriptExecutorUtilVideo28.scrollPageDown(driver);
        Thread.sleep(3000);
        JavaScriptExecutorUtilVideo28.scrollPageUp(driver);
        Thread.sleep(3000);
 
        // Zoom in/out
        JavaScriptExecutorUtilVideo28.zoomPageByJS(driver, 50); // Zoom out to 50%
        Thread.sleep(3000);
        JavaScriptExecutorUtilVideo28.zoomPageByJS(driver, 150); // Zoom in to 150%
        Thread.sleep(3000);
        JavaScriptExecutorUtilVideo28.zoomPageByJS(driver, 100); // Reset to 100%
        Thread.sleep(3000);
 
        // Flash element means highlighting the element or bug
        JavaScriptExecutorUtilVideo28.flash(driver, logoElement);
        Thread.sleep(5000);
 
        driver.quit();
    }
}
 
