//1. Implicit Wait Example = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
 
public class implicitWeightExampleVideo19 {
 
    public static void main(String[] args) {
 
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
 
        // Implicit Wait we use only once to applicable for all the elements to handle synchronization issue
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//disadvantage of implicitlyWait() is it's maximum duration is 10 second so if an element need more than 10 second to load then implicitlyWait() might throw error
 
        driver.findElement(By.name("q")).sendKeys("selenium", Keys.RETURN);//Keys.RETURN this is a mouse press key for return while sendkeys "selenium" put "selenium" word in search box
        driver.findElement(By.xpath("//h3[normalize-space()='Selenium WebDriver']")).click();// after "selenium" word entered it'll show selenium webdriver link so here here we took the xpath of selenium webdriver link and click on it
 
        driver.quit(); // Added to close the browser after execution
    }
}
 
 
//2. Explicit Wait Example

/* import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
 
public class explicitWeightExampleOne {
 
    public static void main(String[] args) {
 
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
 
        // Explicit Wait
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(11)); // created an instance or object of WebDriverWait
 
        driver.findElement(By.name("q")).sendKeys("selenium", Keys.RETURN); //searched "selenium" on google search
 
        // for this one WebElement we put Explicit Wait so if we want to put exlicit wait on other element then we have to newly define explicit wait for tht particular element
        WebElement ele = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Selenium WebDriver']"))); //(By.xpath("//h3[normalize-space()='Selenium WebDriver']") is the locator here
        ele.click();                                     //visibilityOfElementLocated() method we used here in ExpectedCondition
 
        driver.quit(); // Added to close the browser after execution
    }
}*/
 
 
//3. Generic Explicit Wait Method (from the video's explanation) which can put explicit wait on multiple Webelements by calling waitForElementPresent() tht we created here

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
 
public class explicitWeightExampleTwo { // Renamed for clarity
 
    // Generic Method for Explicit Wait
    public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
 
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        // Example usage:
        By elementLocator = By.xpath("//h3[normalize-space()='Selenium WebDriver']");
        WebElement element = waitForElementPresent(driver, elementLocator, 10);
        element.click();
        
    }
}*/
 
 
//4. Fluent Wait Example

/*import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.NoSuchElementException; // Corrected import based on video's intent
 
public class fluentWeightExampleOne { 
//FluentWait similar to Explicit Wait but additionally give pooling time and ignore exception . Here pooling time is if we put pooling time 5 second and maximum wait is 30 second then our wait will go and check for the present of element every 5 seconds within tht total 30 second
//As ExplicitWait FluentWait is also element specific so we have to call FluentWait method/variable we created for any element we want to wait
 
    public static void main(String[] args) {
 
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
 
        // Fluent Wait Declaration
        Wait myWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class); // Corrected exception class based on video's intent
 
        driver.findElement(By.name("q")).sendKeys("selenium", Keys.RETURN);
 
        // Fluent Wait Usage
        WebElement element = myWait.until(new Function<WebDriver , WebElement>(){
                                                                                 public WebElement apply(WebDriver driver)
                                                                                 {return driver.findElement(By.xpath("//h3[text()='Selenium WebDriver']")); } } );
        element.click();
 
        driver.quit(); // Added to close the browser after execution
    }
}*/
 
 
//5. Generic Fluent Wait Method (from the video's explanation) which can put fluent wait on multiple Webelements by calling waitForElementWithFluentWait() tht we created here

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.NoSuchElementException;
 
public class fluentWeightExampleTwo { // Renamed for clarity
 
    // Generic Fluent Wait Method
    public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator) {
        Wait wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2)) // Changed to 2 seconds pooling time 
                .ignoring(NoSuchElementException.class);
                
         WebElement ele = wait.until(new Function<WebDriver,WebElement>() {
                                                                           public WebElement apply(WebDriver driver)
                                                                           {return driver.findElement(locator); } } );       
 
        return ele ;
    }
 
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
 
        driver.findElement(By.name("q")).sendKeys("selenium", Keys.RETURN);
 
        // Usage of Generic Fluent Wait Method
        By elementLocatorHere = By.xpath("//h3[normalize-space()='Selenium WebDriver']");
        WebElement element = waitForElementWithFluentWait(driver, elementLocatorHere); // as waitForElementWithFluentWait() method is static so we can directly call it
        element.click();
 
        driver.quit();
    }
}*/