import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.interactions.Action; // Note: This is an interface
 
public class SliderHandlingVideo24 {
 
    public static void main(String[] args) {
 
        // 1. Setup WebDriver
        // Using WebDriverManager to set up Chrome driver
        WebDriverManager.chromedriver().setup(); 
        //System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver.exe"); // Manual setup if not using WebDriverManager
 
        WebDriver driver = new ChromeDriver();
 
        // 2. Launch Application
        driver.get("[https://jqueryui.com/resources/demos/slider/default.html"); // URL for the slider example
        driver.manage().window().maximize();
 
        // 3. Handle Slider - Minimum Price Slider
        WebElement minSlider = driver.findElement(By.xpath("//div[@id='slider']/span[1]"));//xpath of slider starting end i.e left one which move towards right
 
        // Get Location and Size of the web element (for demonstration purposes)
        Point minLocation = minSlider.getLocation(); // getLocation() will give x and y coordinate of webelement
        System.out.println("The location of the minimum slider: " + minLocation);
 
        Dimension minSize = minSlider.getSize(); // getSize() will give height and width of webelement
        System.out.println("Height and width of the minimum slider: " + minSize);
 
        // Perform drag and drop for the minimum slider // drag is a mouse action so we use action class
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(minSlider, 100, 0).perform(); // Move 100 pixels to the right on X-axis
                                    //x-axis,y-axis
 
        // Get updated location and size after movement
        minLocation = minSlider.getLocation();
        System.out.println("Location of the minimum slider after movement: " + minLocation);
 
        minSize = minSlider.getSize();
        System.out.println("Height and width of the minimum slider after movement: " + minSize);
 
        // 4. Handle Slider - Maximum Price Slider
        WebElement maxSlider = driver.findElement(By.xpath("//div[@id='slider']/span[2]")); //xpath of slider ending start i.e right one which move towards left
        // Perform drag and drop for the maximum slider (moving left)
        actions.dragAndDropBy(maxSlider, -100, 0).perform(); // Move 100 pixels to the left on X-axis
 
        // Get updated location and size after movement (optional)
        Point maxLocation = maxSlider.getLocation();
        System.out.println("Location of the maximum slider after movement: " + maxLocation);
 
        Dimension maxSize = maxSlider.getSize();
        System.out.println("Height and width of the maximum slider after movement: " + maxSize);
 
        // 5. Close the browser (optional, added for completeness)
        // driver.quit();
    }
}
 
// Separate script for 'Actions vs Action' and 'build() vs perform()'
/*public class ActionsVsAction {
 
    public static void main(String[] args) {
 
        // 1. Setup WebDriver
        WebDriverManager.chromedriver().setup(); // Uncomment if using WebDriverManager library
        
        WebDriver driver = new ChromeDriver();
 
        // 2. Launch Application
        driver.get("http://automationpractice.com/index.php"); // Example URL for mouse over action
        driver.manage().window().maximize();
 
        // 3. Locate the element for mouse hover
        WebElement womenLink = driver.findElement(By.xpath("//a[@title='Women']"));
 
        // 4. Using Actions class to perform mouse over
        Actions actions = new Actions(driver);
 
        // Method 1: Using .perform() directly and perform() internally call build().perform()
        actions.moveToElement(womenLink).perform();
 
        // Method 2: Using .build().perform()
        // actions.moveToElement(womenLink).build().perform();
 
        // Method 3: Storing the action in an Action interface variable (for demonstration) and Actions is a class
        // Action mouseOverAction = actions.moveToElement(womenLink).build(); // only build() will create an action which we store in action interface
        // mouseOverAction.perform(); //perform() will complete the action
 
        // Optional: Add a delay to observe the effect
        try {
            Thread.sleep(3000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // 5. Close the browser
        driver.quit();
    }
}*/
