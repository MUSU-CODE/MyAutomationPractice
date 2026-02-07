import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
 
// Main class to handle links
public class HandleLinksVideo16 {
 
    public static void main(String[] args) {
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
 
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
 
        // Launch application
        driver.get("[https://www.amazon.in");
 
        // Example: Locating a link using linkText()
        // WebElement todaysDealsLink = driver.findElement(By.linkText("Today's Deals"));
        // todaysDealsLink.click();
 
        // Example: Locating a link using partialLinkText() means from "Best Deal" inner text we only use"Best" here
        // WebElement bestSellersLink = driver.findElement(By.partialLinkText("Best"));
        // bestSellersLink.click();
 
        // Capture all links from the web page
        List<WebElement> linkList = driver.findElements(By.tagName("a")); //as all links present inside anker tag <a> so we wrote "a"
 
        // Print the total number of links
        System.out.println("Number of links present: " + linkList.size());
 
        // Iterate and print each link's text and href attribute
        for (int i = 0; i < linkList.size(); i++) {
            WebElement link = linkList.get(i); // this get(i) will extract one webelement i.e i from the list of webelements
            String linkText = link.getText();// this getText() will extract the link text
            String href = link.getAttribute("href");// this getAttribute() will extract the target page link
            System.out.println(linkText + " - " + href);// when there'll be no linkText then getText() will fetch nthing so linkText will print "null"
        }
 
        // Another way to iterate using for-each loop
        for (WebElement link : linkList) { //here link is a variable which return type is webelement
            String linkText = link.getText();
            String href = link.getAttribute("href");
            System.out.println(linkText + " - " + href);
        }
 
        // Close the browser
        // driver.quit();
    }
}
 
// Class to handle broken links so broken link is a hyperlink on a web page that no longer works because its target destination is inaccessible or non-existent
class HandleBrokenLinks {
 
    public static void main(String[] args) throws IOException {
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
 
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
 
        // Launch application with broken links
        driver.get("http://www.deadlinkcity.com/");
 
        // Capture all links from the web page
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
 
        int brokenLinksCount = 0;
 
        for (WebElement ele : linksList) {
            String url = ele.getAttribute("href"); //if we found status code as greater than 400 then tht link is broken
                                                   //here url is in string format
            // Check if the URL is empty or null
            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty or null but not broken: " + ele.getText());
                continue; // Skip to the next link
            }
            
          //if the URL is not empty then to check if it's broken we use HttpURLConnection class
            URL linkUrl = new URL(url); // here we take string format url in (url) and use URL Class fromjava.net package
                                       // and Create a URL object then string format url converted to actual link format URL
 
            try{ // Open a connection to the URL
                HttpURLConnection httpConn = (HttpURLConnection) linkUrl.openConnection(); // = (HttpURLConnection) this typecasting hppend here
 
                // Connect the URL to server
                httpConn.connect();
 
                // Get the response code
                int responseCode = httpConn.getResponseCode();
 
                // Check if the response code indicates a broken link (e.g., 400 or higher)
                if (responseCode >= 400) {
                    System.out.println(responseCode + url + " is - Broken Link");
                    brokenLinksCount++;
                } else {
                    System.out.println(url + " - " + responseCode + " is - Valid Link");
                }
 
                // Disconnect the connection
                httpConn.disconnect();
 
            } catch (Exception e) {
                // Handle exceptions during URL connection
                //System.out.println(url + " - Exception: " + e.getMessage() + " - Broken Link (likely)");
                //brokenLinksCount++;
            	//catch block can be empty too if not needed
            }
        }
 
        System.out.println("Number of broken links: " + brokenLinksCount);
 
        // Close the browser
        driver.quit();
    }
}