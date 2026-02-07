import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
 
public class CaptureScreenshotsVideo26 {
 
    public static void main(String[] args) throws Exception {
 
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // WebDriver is an interface implemented by RemoteWebDriver class then RemoteWebDriver class extends to EdgeDriver,CHromeDriver etc class
                                               // RemoteWebDriver Class implemented the TakeScreenshot interface and JavascriptExecutor interface too
        // Launch the application
        driver.get("https://demo.nopcommerce.com/");
 
        // Maximize the browser window for full page screenshot
        driver.manage().window().maximize();
 
        // 1. Capture Full Page Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver; //TakesScreenshot is an interface //as driver is the instance variable of WebDriver so we typecaste it to (TakesScreenshot)
        // if instead of WebDriver driver = new ChromeDriver(); we wrote ChromeDriver driver = new ChromeDriver(); means if instead of driver as Webdriver object we created driver as ChromeDriver object then we won't need the type cast to (TakeScreenshot) as ChromeDriver class is already implementing TakeScreenshot interface but WebDriver interface doesn't
        File srcFile = ts.getScreenshotAs(OutputType.FILE); //OutputType.FILE means the screenshot will come as file and getScreenshotAs() returntype is file so we wrote File srcFile
        File trgFile = new File("./screenshots/homepage.png"); // by creating a File object we put "./screenshots/homepage.png" which is our local folder path but homepage.png name we created
        FileUtils.copyFile(srcFile, trgFile);
        System.out.println("Full page screenshot captured!");
 
        // 2. Capture Screenshot of a Section/Portion of the Page
        // Find the featured products section by its XPath
        WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        //as we're using WebElement (WebElement section) here so we don't need TakesScreenshot interface object to use getScreenshotAs() bcoz we can cll getScreenshotAs() using WebElement variable i.e. section here
        File sectionSrcFile = section.getScreenshotAs(OutputType.FILE); // this is source bcoz we can't see this directly so we need to create target file
        File sectionTrgFile = new File("./screenshots/featuredproducts.png"); // this is target file
        FileUtils.copyFile(sectionSrcFile, sectionTrgFile); //this line copy source to target file //this line throw exception so we added throws Exception
        System.out.println("Section screenshot captured!");
 
        // 3. Capture Screenshot of a Specific Web Element
        // Find the logo element by its XPath
        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File logoSrcFile = logo.getScreenshotAs(OutputType.FILE);
        File logoTrgFile = new File("./screenshots/logo.png");
        FileUtils.copyFile(logoSrcFile, logoTrgFile);
        System.out.println("Element screenshot captured!");
 
        // Close the browser
        driver.close();
    }
}