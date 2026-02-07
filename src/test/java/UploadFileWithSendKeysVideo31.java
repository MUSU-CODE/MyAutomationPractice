import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
 
public class UploadFileWithSendKeysVideo31 {
 
    public static void main(String[] args) throws InterruptedException {
 
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://monsterindia.com/");
 
        // --- Using sendKeys() method ---
        // Locate the element which accepts the file upload i.e. upload resume and click then after clicking a box will come to input our file
        driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();
        
        // In the video, tht box's element has an input tag inside which type="file" attribute is there in html syntax //we can use directly sendkeys() when we find type="file" in upload box html syntax
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\UsersadminDesktop\\sample.pdf"); //inside sendkeys() we Provide the absolute path of the file to be uploaded
 
        // Add a delay to observe the upload (optional)
        Thread.sleep(5000); // 5 seconds
 
        driver.quit();
    }
}
 
 

/*import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
 
public class UploadFileWithRobotClass {
 
    public static void main(String[] args) throws InterruptedException, AWTException {
 
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://monsterindia.com/");
 
        // --- Using Robot Class --- bcoz tht box's element doesn't have type="file" attribute inside input tag of html syntax
        // Locate the button that opens the file upload dialog
        // This element is initially problematic as directly .click() method doesn't work here, so using JavascriptExecutor to click it
        WebElement uploadresumeButton = driver.findElement(By.xpath("//button[normalize-space()='Choose File']"));
 
        // Using JavascriptExecutor to click the button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", uploadresumeButton);
 
        // Add a delay to ensure the dialog opens
        Thread.sleep(3000); // 3 seconds
 
       // Create a Robot class instance
        Robot rb = new Robot();
        robot.delay(1000); // 1 second delay
        
        // File path to be uploaded
        String filePath = "C:\\UsersadminDesktop\\sample.pdf";
        // Create a StringSelection object with the file path
        StringSelection ss = new StringSelection(filePath);
        
        // Get the system clipboard and set the StringSelection ss using Toolkit class methods
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); //this do Ctrl+C to copy the file path from where resume to be uploaded
               
        // Press Ctrl+V (paste) to the file path into the 'file name' inbox field
        rb.keyPress(KeyEvent.VK_CONTROL); // clicked Ctrl
        rb.keyPress(KeyEvent.VK_V); // clicked V
        rb.keyRelease(KeyEvent.VK_V); //realease V
        rb.keyRelease(KeyEvent.VK_CONTROL); //release Ctrl
 
        // Add a small delay after pasting
        rb.delay(1000);
 
        // Press Enter to confirm the file selection (or click the "Open" button)
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
 
        // Add a delay to observe the upload (optional)
        Thread.sleep(5000); // 5 seconds
 
        driver.quit();
    }
}*/