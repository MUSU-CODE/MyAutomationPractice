//The video demonstrates how to handle iframes in Selenium WebDriver using Java. Here's a detailed breakdown of the code used for different scenarios:
//frames r used for horizontally and vertically spilitting of the screen
//iframe is when we try to show content of another page in our page like while scrolling article advertise come
//iframe comes with <iframe > </iframe> tag
// Common setup for all examples
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
public class HandleIFrameVideo18 {
 
    public static void main(String[] args) throws InterruptedException { //InterruptedException used here bcoz Thread.Sleep() we used here
 
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
 
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
 
        // Maximize browser window (optional but good practice)
        driver.manage().window().maximize();
 
        // Navigate to the application URL
        driver.get("YOUR APPLICATION URL_HERE"); // Replace with the actual URL
 
        // --- Example 1: Interacting with a single iframe by name or WebElement or Index value ---
        // Switch to the iframe using its name
        driver.switchTo().frame("packageListFrame"); // "packageListFrame" is the name of the frame which is an attribute value or we can pass ID of the frame instead of name of the frame
        
        //OR// driver.switchTo().frame(WebElement);
       //OR// driver.switchTo().frame(0); // 0 means frame's index value so according index value we can pas 1 or 2 or 3 etc.
 
        // Locate and click an element inside the frame (which name we put above i.e "packageListFrame") of our web page
        driver.findElement(By.xpath("//a[contains(text(),'SomeLinkText')]")).click(); // Replace with actual element xpath
 
        // Switch back to the default content (main page)  needed so we can click nect frame
        driver.switchTo().defaultContent();
  
        Thread.sleep(3000);
        
        // Switch to the second iframe by name
        driver.switchTo().frame("packageFrame");
        // Click on an element in the second iframe
        driver.findElement(By.xpath("//a[contains(text(),'SecondLink')]")).click();
        // Switch back to the default content
        driver.switchTo().defaultContent();
        
        Thread.sleep(3000);
 
        // Switch to the third iframe by name
        driver.switchTo().frame("classFrame");
        // Click on an element in the third iframe
        driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click(); // Example element
        // Switch back to the default content
        driver.switchTo().defaultContent();
 
        // --- Example 2: Handling inner iframes (nested iframes) ---
        // Navigate to the application URL with nested iframes
        driver.get("YOURNESTEDIFRAMEAPPLICATIONURL_HERE"); // Replace with the actual URL
 
        // Locate the outer iframe as a WebElement using xpath
        WebElement outerIframe = driver.findElement(By.xpath("//iframe[@src='outer.html']")); // Replace with actual xpath of outer iframe
        // gO the outer iframe
        driver.switchTo().frame(outerIframe);  // In nested iframe we don't need to go to main page to click child frame after parent frame came
 
        // Locate the inner iframe as a WebElement (it's inside the outer iframe)
        WebElement innerIframe = driver.findElement(By.xpath("//iframe[@src='inner.html']")); // Replace with actual xpath
        // Switch to the inner iframe
        driver.switchTo().frame(innerIframe);
 
        // Now you are inside the innermost iframe, interact with its elements
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello from inner iframe"); // Example: enter text into an input field
 
        // Switch back to the parent frame (from inner to outer iframe)
        driver.switchTo().parentFrame();
 
        // Now you are in the outer iframe, you can interact with its elements
        // (Optional: Perform actions in the outer iframe here)
 
        // Switch back to the default content (main page from outer iframe)
        driver.switchTo().defaultContent();
 
        // --- Example 3: Using index to switch to iframes (for iframes without name/ID) ---
        // Navigate to the application URL with iframes
        driver.get("YOURINDEXIFRAMEAPPLICATIONURL_HERE"); // Replace with the actual URL
 
        // Switch to the outer iframe by its name 
        driver.switchTo().frame("iframeResult"); // Assuming the outer iframe is the first one on the page
 
        // Switch to the inner iframe by its index (if it's the first iframe inside the current iframe, index is 0)
        // This is only if the inner iframe is the FIRST iframe within the currently focused outer iframe
        driver.switchTo().frame(0);
 
        // Get text from an element inside the innermost iframe
        String innerFrameText = driver.findElement(By.xpath("//p[contains(text(),'Some text')]")).getText();
        System.out.println("Text from inner iframe: " + innerFrameText);
 
        // Switch back to the parent frame (from inner to outer iframe)
        driver.switchTo().parentFrame();
 
        // Get text from an element in the outer iframe / parent frame (after switching back from inner)
        String outerFrameText = driver.findElement(By.xpath("//p[contains(text(),'you can use the height']")).getText();
        System.out.println("Text from outer iframe: " + outerFrameText);
 
        // Switch back to the default content (main page)
        driver.switchTo().defaultContent();
 
        // Close the browser
        driver.quit();
    }
}