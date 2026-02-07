//1. Mouse Right-Click Action

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class MouseRightClickActionVideo23 {
 
    public static void main(String[] args) {
 
        // Set up the Chrome browser
        WebDriverManager.chromedriver().setup();
 
        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();
 
        // Launch the application URL
        driver.get("http://deluxe-menu.com/popup-mode-demo.html");// Example URL
 
        // Maximize the page
        driver.manage().window().maximize();
 
        // Find the element to perform right-click on
        WebElement button = driver.findElement(By.xpath("//img[@src='[http://deluxe-menu.com/img/popup.gif'](http://deluxe-menu.com/img/popup.gif')")); // XPath of buttom on which we need to right click 
 
        // Create an Actions class instance
        Actions act = new Actions(driver);
 
        // Perform right-click action (context click)
        act.contextClick(button).perform();
    }
}
 
 
//2. Mouse Double-Click Action

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class MouseDoubleClickAction {
 
    public static void main(String[] args) {
 
        // Set up the Chrome browser
        WebDriverManager.chromedriver().setup();
 
        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();
 
        // Launch the application URL
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5evondblclick3");
 
        // Maximize the page
        driver.manage().window().maximize();
 
        // Switch to the iframe containing the elements
        driver.switchTo().frame("iframeResult"); // Assuming the iframe has an ID "iframeResult"
 
        // Find the first input field (field one)
        WebElement fieldOne = driver.findElement(By.xpath("//input[@id='field1']")); // Example XPath of 1st input box
 
        // Clear existing text and send new text to field one
        fieldOne.clear();
        fieldOne.sendKeys("Welcome to Selenium");
 
        // Find the copy text button on which double click action performed
        WebElement button = driver.findElement(By.xpath("//button[text()='Copy Text']")); // XPath of copy text button
 
        // Create an Actions class instance
        Actions act = new Actions(driver);
 
        // Perform double-click action
        act.doubleClick(button).perform();
    }
}*/
 
 
//3. Mouse Drag and Drop Action

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class MouseDragAndDropAction {
 
    public static void main(String[] args) {
 
        // Set up the Chrome browser
        WebDriverManager.chromedriver().setup();
 
        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();
 
        // Launch the application URL
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html"); // Example URL
 
        // Maximize the page (optional)
        driver.manage().window().maximize();
 
        // Capture source and target elements
        WebElement rom = driver.findElement(By.id("box6")); // Example box ID where "Rom" present // rom is source element
        WebElement italy = driver.findElement(By.id("box106")); // Example box ID where "Italy" present //italy is target element
 
        // Create an Actions class instance
        Actions act = new Actions(driver);
 
        // Perform drag and drop action
        act.dragAndDrop(rom, italy).perform();
    }
}*/
 
 
//4. Mouse Drag and Drop Images

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class MouseDragAndDropImages {
 
    public static void main(String[] args) {
 
        // Set up the Chrome browser
        WebDriverManager.chromedriver().setup();
 
        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();
 
        // Launch the application URL
        driver.get("https://www.w3schools.com/html/html5draganddrop.asp");
 
        // Maximize the page
        driver.manage().window().maximize();
 
        // Switch to the iframe (if the elements are inside an iframe)
        // Assuming iframe has a specific XPath if no ID/Name is available
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[contains(@src,'tryit.asp')]")); // Example XPath for iframe
        driver.switchTo().frame(iframeElement);
 
        // Capture source elements (images)
        WebElement itemOne = driver.findElement(By.xpath("//img[@id='drag1']")); // Example XPath for first draggable image
        WebElement itemTwo = driver.findElement(By.xpath("//img[@id='drag2']")); // Example XPath for second draggable image
 
        // Capture target element (trash/drop zone)
        WebElement trashElement = driver.findElement(By.xpath("//div[@id='div2']")); // Example XPath for the trash/drop zone
 
        // Create an Actions class instance
        Actions act = new Actions(driver);
 
        // Move first item to trash
        act.dragAndDrop(itemOne, trashElement).perform();
 
        // Move second item to trash
        act.dragAndDrop(itemTwo, trashElement).perform();
    }
}*/
 
 
//5. Mouse Hover Action

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class MouseHoverAction {
 
    public static void main(String[] args) {
 
        // Set up the Chrome browser
        WebDriverManager.chromedriver().setup();
 
        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();
 
        // Launch the application URL
        driver.get("http://tutorialsninja.com/demo/"); // Example URL
 
        // Maximize the page
        driver.manage().window().maximize();
 
        // Find the "Desktops" menu element
        WebElement desktopsMenu = driver.findElement(By.xpath("//a[text()='Desktops']")); // Example XPath
 
        // Find the "Mac" sub-menu item element
        WebElement macMenuItem = driver.findElement(By.xpath("//a[text()='Mac (1)']")); // Example XPath
 
        // Create an Actions class instance
        Actions act = new Actions(driver);
 
        // Perform mouse hover on "Desktops" and then "Mac" by using moveToElement(), followed by a click on "Mac"
        act.moveToElement(desktopsMenu)
           .moveToElement(macMenuItem)
           .click()
           .perform(); // perform() method must use when use Action class
    }
}*/