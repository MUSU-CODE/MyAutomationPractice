import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class HandleCheckboxVideo14 {
 
    public static void main(String[] args) {
 
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
 
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
 
        // Launch the application
        driver.get("file:///path/to/your/checkbox_application.html"); // Replace with your actual application URL
 
        // 1. How to select a specific checkbox?
        System.out.println("Selecting a specific checkbox (Monday)");
        WebElement mondayCheckbox = driver.findElement(By.xpath("//input[@id='monday']"));
        mondayCheckbox.click();
        System.out.println("Monday checkbox selected.");
 
        // Add a small wait to see the selection (optional)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Deselect the specific checkbox for the next examples
        mondayCheckbox.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // 2. How to select all checkboxes (using normal for loop)?
        System.out.println("nSelecting all checkboxes using a normal for loop...");
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        System.out.println("Total number of checkboxes: " + checkboxes.size());
 
        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
        System.out.println("All checkboxes selected using normal for loop.");
 
        // Add a small wait to see the selection (optional)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Deselect all checkboxes for the next examples
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
 
        // 3. How to select all checkboxes (using for-each loop)?
        System.out.println("nSelecting all checkboxes using a for-each loop...");
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
        System.out.println("All checkboxes selected using for-each loop.");
 
        // Add a small wait to see the selection (optional)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Deselect all checkboxes for the next examples
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
 
        // 4. How to select multiple checkboxes by choice (e.g., Monday and Sunday)?
        System.out.println("nSelecting checkboxes based on choice (Monday and Sunday)...");
        for (WebElement checkbox : checkboxes) {
            String checkboxName = checkbox.getAttribute("id"); // Assuming 'id' attribute holds the day name in html syntax in inspect
            if (checkboxName.equalsIgnoreCase("monday") || checkboxName.equalsIgnoreCase("sunday")) {
                checkbox.click();
            }
        }
        System.out.println("Monday and Sunday checkboxes selected.");
 
        // Add a small wait to see the selection (optional)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Deselect all checkboxes for the next examples
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
 
        // 5. How to select the last N checkboxes from total X checkboxes (e.g., last 2)? so formula is X-N=Y So Y number is the starting index
        System.out.println("nSelecting the last 2 checkboxes...");
        int totalCheckboxes = checkboxes.size();
        int checkboxesToSelectFromLast = 2;
 
        for (int i = totalCheckboxes - checkboxesToSelectFromLast; i < totalCheckboxes; i++) { //so int i = Y
            checkboxes.get(i).click();
        }
        System.out.println("Last 2 checkboxes selected.");
 
        // Add a small wait to see the selection (optional)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Deselect all checkboxes for the next examples
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
 
        // 6. How to select the first N checkboxes (e.g., first 3)?
        System.out.println("nSelecting the first 3 checkboxes...");
        int checkboxesToSelectFromFirst = 3;
 
        for (int i = 0; i < checkboxesToSelectFromFirst; i++) {
            checkboxes.get(i).click();
        }
        System.out.println("First 3 checkboxes selected.");
 
        // Add a small wait to see the selection (optional)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        // Close the browser
        driver.quit();
        System.out.println("nBrowser closed. Automation script finished.");
    }
}