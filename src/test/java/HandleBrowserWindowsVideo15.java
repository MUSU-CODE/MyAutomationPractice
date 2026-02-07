import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
 
public class HandleBrowserWindowsVideo15 {
 
    public static void main(String[] args) throws InterruptedException {
 
        // Setup ChromeDriver (ensure you have WebDriverManager or ChromeDriver executable path set)
        WebDriverManager.chromedriver().setup(); // If using WebDriverManager
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with your ChromeDriver path
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        //This handling browser comes to picture when we open one URL then after login in tht URL it open another URL to do our work so we need tht 2nd URL to do automation
        //So here we'll learn how to switch between multiple browser windows
 
        // 1. Launch the application URL of first browser window
        driver.get("https://opensource-demo.orangehrmlive.com/");//(https://www.example.com/some-application-with-links";) // Replace with a relevant URL
        
        //getWindowHandle() we can access it by using driver object, by using getWindowHandle() we can access the id of one browser window with is open currently, this'll return a string
        //getWindowHandles() we can access it by using driver object, by using getWindowHandles() we can access the ids of multiple browser windows which all open, this'll return a list of strings
 
        // Get the window handle of the current (parent) window
        String parentWindowID = driver.getWindowHandle();
        System.out.println("Parent Window ID: " + parentWindowID);//ID will be diffrent in each run for the same window
        System.out.println("Parent Window Title: " + driver.getTitle());
 
        // 2. Click on a link in parent window that opens a new browser window/tab
        // Assuming there is a link with specific text or an ID that opens a new window
        // For demonstration, let's imagine the child link is with id="newWindowLink" in HTML code in inspect
        
        /* try {
            driver.findElement(By.id("newWindowLink")).click();
        } catch (Exception e) {
            // Fallback if the above ID is not present, trying with a common link text
            System.out.println("Could not find link by ID, trying by link text...");
            driver.findElement(By.linkText("Click Me to Open New Window")).click();
        } */
  
        Set<String> allWindowIDs = driver.getWindowHandles();
        
        // Approach 1: Using Iterator to get parent and child window IDs
        /*Iterator<String> it = allWindowIDs.iterator();
        String firstWindowID = it.next(); // This will be the parent window ID
        String secondWindowID = it.next(); // This will be the child window ID
 
        System.out.println("Window ID from Iterator (Parent): " + firstWindowID); // These window Id required to switch between window
        System.out.println("Window ID from Iterator (Child): " + secondWindowID);*/
 
        // Approach 2: Using ArrayList to get parent and child window IDs (more common)
         List<String> windowIDsList = new ArrayList(allWindowIDs); //Here converting Set to List using (allWindowIDs) // /OR/ ArrayList<String> windowIDsList = new ArrayList<>(allWindowIDs);
        String parentIDFromList = windowIDsList.get(0); // Index 0 for parent
        String childIDFromList = windowIDsList.get(1);  // Index 1 for child
 
        System.out.println("Window ID from List (Parent): " + parentIDFromList);
        System.out.println("Window ID from List (Child): " + childIDFromList); 
        
        // 3. Switching between multiple browser windows
        // Switch to the child window
        driver.switchTo().window(childIDFromList);
        System.out.println("Switched to Child Window. Title: " + driver.getTitle());
        Thread.sleep(2000); // Wait to observe the switch
 
        // Perform some action on the child window (e.g., get an element, close it)
        // driver.findElement(By.id("someElementInChildWindow")).click();
 
        // Switch back to the parent window
        driver.switchTo().window(parentIDFromList);
        System.out.println("Switched back to Parent Window. Title: " + driver.getTitle());
        Thread.sleep(2000); // Wait to observe the switch
        
        //4.  For Each Loop
        List<String> windowIDsList1 = new ArrayList(allWindowIDs);
        for(String allwindows:windowIDsList1)
        {//System.out.println(allwindows) ;
        	String title = driver.switchTo().window(allwindows).getTitle();
        	System.out.println(title);
        }
 
        // 5. How to close all browser windows (using driver.quit())
        // driver.quit(); // This will close all open browser windows and end the WebDriver session
        //driver.close(); // This will close only the current open window
 
        // 6. How to close specific browser window by choice (using driver.close())
        // This will close the currently focused window
        driver.switchTo().window(childIDFromList); // Switch to child window to close it
        System.out.println("Attempting to close Child Window.");
        driver.close(); // Closes the child window
 
        // The driver's focus is still on the closed window ID, so we need to switch back
        driver.switchTo().window(parentIDFromList);
        System.out.println("Back on Parent Window after closing child. Title: " + driver.getTitle());
        Thread.sleep(2000);
        
        //OR
        for(String allwindows:windowIDsList1)
        {
        	String title = driver.switchTo().window(allwindows).getTitle();
        	if(title.equals("Parent window title which we want to close") || title.equals("another window title which we want to close") )
        	{ driver.close(); }
        }
 
        // Close the parent window and quit the driver session
        driver.quit();
    }
}

