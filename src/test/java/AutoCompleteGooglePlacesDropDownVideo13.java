import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class AutoCompleteGooglePlacesDropDownVideo13 {
 
    public static void main(String[] args) throws InterruptedException {
 
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
 
        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();
 
        // Launch the application
        driver.get("https://www.twoplugs.com/");//(https://www.twoplugs.com/";)
 
        // Maximize the browser window
        driver.manage().window().maximize();
 
        // Click on "Live Posting" link
        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
 
        // Find the search box element, the dropdown autocomplete values element can't be inspected bcoz the autocomplete directly coming from API at run time
        WebElement searchBox = driver.findElement(By.id("autocomplete"));
 
        // Clear any existing value in the search box
        searchBox.clear();
        Thread.sleep(3000); // For demonstration, to observe the clear action
 
        // Send search text
        searchBox.sendKeys("toronto");
        Thread.sleep(3000); // For demonstration, to observe the suggestions appearing
 
        String text; 
        do {// we using do while bcoz we don't knw how many options are there and also options are only coming for the relatable keyword we put 
            // Press Down Arrow key to navigate through suggestions
            searchBox.sendKeys(Keys.ARROW_DOWN); // Keys.ARROW_DOWN this will press the down arrow key on keyboard and put a value inside input search box
            Thread.sleep(3000); // For demonstration, to observe navigation
 
            // Get the value from the input box (which updates as suggestions are highlighted)
            text = searchBox.getAttribute("value"); // here getText() method can't fetch the value inside search box so we use getAttribute() method and store it inside String text
 
            // Print the current text for debugging/observation
            System.out.println(text);
 
            // Check if the desired value is found
            if (text.equals("Toronto, OH, USA")) {
                searchBox.sendKeys(Keys.ENTER); // Keys.ENTER will Press Enter key from keyboard to select the value
                                                //we use Keys.keyboardInputs bcoz these Autocomplete options are not web elements so we can't get their path so sending keys from keyboard
                break; // Exit the loop once the value is selected
            }
        } while (!text.isEmpty()); // Continue as long as the text box is not empty so we use .isEmpty()
 
        // Keep the browser open for a few seconds to observe the final state
        Thread.sleep(3000);
 
        // Close the browser
        driver.quit();
    }
}