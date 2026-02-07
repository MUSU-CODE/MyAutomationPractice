//1. Capturing Tooltip of a Web Element
 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class ToolTipVideo27 {
    public static void main(String[] args) {
        // Setup Chrome Driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 
        // Launch application
        driver.get("https://jqueryui.com/tooltip/"); 
 
        // Switch to the frame as the element is inside one
        driver.switchTo().frame(0);
 
        // Locate the web element (e.g., input box)
        WebElement element = driver.findElement(By.xpath("YOURELEMENTXPATH_HERE")); // Replace with actual XPath
 
        // Get the tooltip text from the 'title' attribute
        String tooltipText = element.getAttribute("title");
 
        // Print the tooltip text
        System.out.println("Tooltip Text: " + tooltipText);
 
        // Close the browser
        driver.quit();
    }
}
 
 
/*2. Opening a Link in a New Tab
 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class OpenLinkInNewTab {
    public static void main(String[] args) {
        // Setup Chrome Driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 
        // Launch application
        driver.get("https://demo.nopcommerce.com/"); 
 
        // Locate the link to be opened in a new tab
        WebElement newline = driver.findElement(By.linkText("Register")); // Example: "Register" link
 
        // Use Keys.chord to combine Control + Return (Enter)
        String newTabKeys = Keys.chord(Keys.CONTROL, Keys.RETURN);
 
        // Send the key combination from above to the link "newline" to open it in a new tab
        newline.sendKeys(newTabKeys);
 
        // You might want to add a delay here to observe the new tab
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Close the browser
        driver.quit();
    }
}*/
 
 
/*3. Opening URLs in Multiple Tabs & Windows (Selenium 4 onwards)
 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class OpenUrlsInTwoTabsOrWindows {
    public static void main(String[] args) {
        // Setup Chrome Driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 
        // Open the first URL
        driver.get("https://demo.nopcommerce.com/"); 
 
        // Open a new tab and switch to it
        driver.switchTo().newWindow(WindowType.TAB); //WindowType.TAB means opening new tab for the link opencart
        // Open the second URL in the new tab
        driver.get("https://www.opencart.com/"); 
 
        // You can also open a new window instead of a tab:
        // driver.switchTo().newWindow(WindowType.WINDOW);
        // driver.get("https://demo.nopcommerce.com/"); 
         
         // by using "switch" command we can move from one browser window to another browser window and navigate
         
        // You might want to add a delay here to observe the multiple tabs/windows
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Close all browser windows
        driver.quit();
    }
}*/
 
 
/*4. Capturing Size & Location of a Web Element
 

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class SizeAndLocationOfElement {
    public static void main(String[] args) {
        // Setup Chrome Driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 
        // Launch application
        driver.get("https://opensource-demo.orangehrmlive.com/"); 
 
        // Maximize the browser window (optional, but good practice for consistent results)
        driver.manage().window().maximize();
 
        // Locate the web element (e.g., a logo)
        WebElement logo = driver.findElement(By.xpath("YOURLOGOXPATH_HERE")); // Replace with actual XPath
 
        // --- Capturing Location ---
 
        // Method 1: Using getLocation()
        Point location = logo.getLocation();
        System.out.println("Location (X, Y) Both is: " + logo.getLocation());
        System.out.println("Only X Coordinate is : " + location.getX()); // we use location.getX() for only X location 
        System.out.println("Only Y Coordinate is: " + location.getY());
 
        // Method 2: Using getRect()
        org.openqa.selenium.Rectangle rect = logo.getRect();
        System.out.println("Location (X, Y) using getRect: " + logo.getRect());
        System.out.println("X Coordinate using getRect: " + rect.getX());
        System.out.println("Y Coordinate using getRect: " + rect.getY());
 
        // --- Capturing Size ---
 
        // Method 1: Using getSize()
        Dimension size = logo.getSize();
        System.out.println("Size (Width, Height): " + logo.getSize());
        System.out.println("Width: " + size.getWidth()); // we use size.getWidth() for only width 
        System.out.println("Height: " + size.getHeight());
 
        // Method 2: Using getRect()
        System.out.println("Size (Width, Height): " + logo.getRect().getDimension());
        System.out.println("Width using getRect: " + logo.getRect().getDimension().getWidth());
        System.out.println("Height using getRect: " + logo.getRect().getDimension().getHeight());
 
 
        // Close the browser
        driver.quit();
    }
}*/