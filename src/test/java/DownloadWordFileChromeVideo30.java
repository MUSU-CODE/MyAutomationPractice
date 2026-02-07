// For Chrome Browser - Download Word File to a Custom Directory
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;
 
public class DownloadWordFileChromeVideo30 {
    public static void main(String[] args) {
        // Define the custom download location
        String downloadFilePath = System.getProperty("user.dir") + "\\Downloads"; // "user.dir" gives current working project location inside where we created "\\Downloads" location
 
        //to set downloadFilePath in chrome browser download path we Create HashMap,Create ChromeOptions and set experimental options
        // Create HashMap for preferences
        HashMap prefs = new HashMap();
        prefs.put("download.default_directory", downloadFilePath);// "download.default_directory" is key and downloadFilePath is value
 
        // Create ChromeOptions and set experimental options
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
 
        // Set up WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Initialize ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);
        
        //if we didn't Define the custom download location and all above steps then file would be downloaded in the default location set in browser
 
        // Navigate to the application URL
        driver.get("http://your-application-url-here.com");//website where there r files to download
        // Maximize the browser window
        driver.manage().window().maximize();
 
        // Click the download button for the Word document
        driver.findElement(By.xpath("//a[contains(@href, '.doc')]")).click(); // XPath of download button of the file
 
        // Close the browser
        // driver.quit();
    }
}
 
// For Edge Browser - Download Word File to a Custom Directory (same as above only diffrence is instead of ChromeOption we create EdgeOptions and instead of chromedriver() we create edgedriver())
 
/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.HashMap;
import java.util.Map;
 
public class DownloadWordFileEdge {
    public static void main(String[] args) {
        // Set up WebDriverManager
        WebDriverManager.edgedriver().setup();
 
        // Define the custom download location
        String downloadFilePath = System.getProperty("user.dir") + "Downloads";
 
        // Create HashMap for preferences
        HashMap prefs = new HashMap();
        prefs.put("download.default_directory", downloadFilePath);
 
        // Create EdgeOptions and set experimental options
        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("prefs", prefs);
 
        // Initialize EdgeDriver with options
        WebDriver driver = new EdgeDriver(options);
 
        // Navigate to the application URL
        driver.get(" // Replace with actual URL from video context
 
        // Maximize the browser window
        driver.manage().window().maximize();
 
        // Click the download button for the Word document
        driver.findElement(By.xpath("//a[contains(@href, '.doc')]")).click(); // Adjust XPath as needed based on video
 
        // Close the browser
        // driver.quit();
    }
}*/
 
// For Firefox Browser - Download Word File to a Custom Directory and Handle Mime Type (FireFox is little diffrent than chrome and Edge browser)
 
/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
 
public class DownloadWordFileFirefox {
    public static void main(String[] args) {
        // Define the custom download location if we customize the download location
        String downloadFilePath = System.getProperty("user.dir") + "\\Downloads";
 
        // Create FirefoxProfile class object
        FirefoxProfile profile = new FirefoxProfile();
 
        // Set preferences for Firefox //we set these preferences and set the Firefoxprofile object reference below so in firefox whn we download file a additional window which used to come won't come
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword"); // Mime type for .doc files
        profile.setPreference("browser.download.folderList", 2); // here if key we put 0= in desktop file will download, 1= in downloads ile will download, 2= in custom download location we gave above there file will download
        profile.setPreference("browser.download.dir", downloadFilePath);
        //profile.setPreference("browser.download.useDownloadDir", true);
         
        // Create FirefoxOptions and set the Firefoxprofile object reference
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        
        // Set up WebDriverManager
        WebDriverManager.firefoxdriver().setup();
  
        // Initialize FirefoxDriver with options
        WebDriver driver = new FirefoxDriver(options);
 
        // Navigate to the application URL
        driver.get(" // Replace with actual URL from video context);
 
        // Maximize the browser window
        driver.manage().window().maximize();
 
        // Click the download button for the Word document
        driver.findElement(By.xpath("//a[contains(@href, '.doc')]")).click(); // Adjust XPath as needed based on video
 
        // Close the browser
        // driver.quit();
    }
}*/
 
// For Chrome Browser - Download PDF File directly
 
/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
 
public class DownloadPDFFileChrome {
    public static void main(String[] args) {
         
        // Define the custom download location
        String downloadFilePath = System.getProperty("user.dir") + "\\Downloads";
 
        // Create HashMap for preferences
        HashMap preference = new HashMap<>();
        prefs.put("download.default_directory", downloadFilePath);
        prefs.put("plugins.alwaysopenpdf_externally", true); // Important for PDF download which will help dowload pdf file instead of only viewing
 
        // Create ChromeOptions and set experimental options
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preference);
 
        // Set up WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Initialize ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);
        
        
        // Navigate to the application URL (replace with actual PDF URL from video context)
        driver.get("[http://your-application-url-here.com/pdf-download-page");
 
        // Maximize the browser window
        driver.manage().window().maximize();
 
        // Click the download button for the PDF document
        driver.findElement(By.xpath("//a[contains(@href, '.pdf')]")).click(); // Adjust XPath as needed based on video
 
        // Close the browser
        // driver.quit();
    }
}*/
 
// For Edge Browser - Download PDF File directly (similar to Chrome)
 
/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.HashMap;
import java.util.Map;
 
public class DownloadPDFFileEdge {
    public static void main(String[] args) {
        // Set up WebDriverManager
        io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
 
        // Define the custom download location
        String downloadFilePath = System.getProperty("user.dir") + "Downloads";
 
        // Create HashMap for preferences
        Map prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilePath);
        prefs.put("plugins.alwaysopenpdf_externally", true); // Important for PDF download
 
        // Create EdgeOptions and set experimental options
        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("prefs", prefs);
 
        // Initialize EdgeDriver with options
        WebDriver driver = new EdgeDriver(options);
 
        // Navigate to the application URL (replace with actual PDF URL from video context)
        driver.get("
 
        // Maximize the browser window
        driver.manage().window().maximize();
 
        // Click the download button for the PDF document
        driver.findElement(By.xpath("//a[contains(@href, '.pdf')]")).click(); // Adjust XPath as needed based on video
 
        // Close the browser
        // driver.quit();
    }
}*/
 
// For Firefox Browser - Download PDF File directly and Handle Mime Type
 
/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
 
public class DownloadPDFFileFirefox {
    public static void main(String[] args) {
        // Set up WebDriverManager
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
 
        // Define the custom download location
        String downloadFilePath = System.getProperty("user.dir") + "Downloads";
 
        // Create FirefoxProfile
        FirefoxProfile profile = new FirefoxProfile();
 
        // Set preferences for Firefox
        profile.setPreference("pdfjs.disabled", true); // Disable built-in PDF viewer //Important for PDF download
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); // Mime type for .pdf files
        profile.setPreference("browser.download.folderList", 2); // 0=desktop, 1=downloads, 2=custom
        profile.setPreference("browser.download.dir", downloadFilePath);
        profile.setPreference("browser.download.useDownloadDir", true);
        
        // Create FirefoxOptions and set the profile
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
 
        // Initialize FirefoxDriver with options
        WebDriver driver = new FirefoxDriver(options);
 
        // Navigate to the application URL (replace with actual PDF URL from video context)
        driver.get("application url");
 
        // Maximize the browser window
        driver.manage().window().maximize();
 
        // Click the download button for the PDF document
        driver.findElement(By.xpath("//a[contains(@href, '.pdf')]")).click(); // Adjust XPath as needed based on video
 
        // Close the browser
        // driver.quit();
    }
}*/