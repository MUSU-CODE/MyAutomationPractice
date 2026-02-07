import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
//Code for handling Date Picker with Calendar:
public class DatePickerVideo22 {
 
    public static void main(String[] args) throws InterruptedException {
 
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
        // Launch application
        driver.get("https://www.redbus.in/");
 
        // Define expected date
        String expectedMonthYear = "April 2022";
        String expectedDate = "15";
 
        // Click on the date picker input field
        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
 
        // Loop to find the correct month and year from calendar
        while (true) {
            String currentMonthYear = driver.findElement(By.xpath("//div[@class='rb-calendar']//td[@class='month_year']")).getText(); //xpath for expectedMonthYear
 
            if (currentMonthYear.equals(expectedMonthYear)) {
                break; // Found the correct month and year
            } else {
                // Click on the next month arrow to get to next month
                driver.findElement(By.xpath("//div[@class='rb-calendar']//td[@class='next']")).click(); //xpath of arrow mark
            }
        }
 
        // Select the date from calendar
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='rb-calendar']//td[contains(@class,'wd-date')]")); //xpath of all dates from calendar
 
        for (WebElement dateElement : allDates) {
            String currentDate = dateElement.getText();
            if (currentDate.equals(expectedDate)) {
                dateElement.click();
                break;
            }
        }
 
        Thread.sleep(3000); // Wait to observe the selection
        driver.quit();
    }
}
 
 
//Code for handling Date Picker with Dropdowns:

/*import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class DatePickerDropdown {
 
    public static void main(String[] args) throws InterruptedException {
 
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
        // Launch application
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
 
        // Define expected date
        String expectedDate = "15";
 
        // Click on the date of birth input field
        driver.findElement(By.xpath("//input[@id='dob']")).click();
 
        // Select month from dropdown // in selenium there's select class for dropdown
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")); //xpath of month dropdown
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText("Oct"); // Example: Select October
 
        // Select year from dropdown
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")); //xpath of year dropdown
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("1990"); // Example: Select 1990
 
        // Select the date
        List allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td")); //xpath for all the dates
 
        for (WebElement dateElement : allDates) {
            String currentDate = dateElement.getText();
            if (currentDate.equals(expectedDate)) {
                dateElement.click();
                break;
            }
        }
 
        Thread.sleep(3000); // Wait to observe the selection
        driver.quit();
    }
}*/