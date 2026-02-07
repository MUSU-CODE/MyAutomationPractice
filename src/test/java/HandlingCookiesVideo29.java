import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
import java.util.Set;
 
public class HandlingCookiesVideo29 {
 
    public static void main(String[] args) {
 
        // 1. Setup the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 
        // Launch the application
        driver.get("http://demo.nopcommerce.com/");
 
        // 2. Capture cookies from the browser //cookies are temporary file created by browser while visiting any website so cookies we can detele or it automatically delete so in this program we're checking if the cookies properly creating and deleting or not 
        System.out.println("--- Capturing Initial Cookies ---");
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of cookies: " + cookies.size());
 
        // 3. Print cookies from the browser (details)
        System.out.println("--- Details of Initial Cookies ---");
        for (Cookie cookie : cookies) {
            System.out.println("Cookie Name: " + cookie.getName() + " : Cookie Value: " + cookie.getValue());
        }
 
        // 4. How to add a cookie to the browser
        System.out.println("n--- Adding a New Cookie ---");
        Cookie newCookie = new Cookie("mycookie123", "123456"); //here Cookie class object created
        driver.manage().addCookie(newCookie); // cookie added here
 
        // Verify the cookie count after adding
        cookies = driver.manage().getCookies(); // Recapture the whole cookies
        System.out.println("Size of cookies after adding: " + cookies.size());
 
        // 5. How to delete a specific cookie from the browser (by object)
        System.out.println("n--- Deleting a Specific Cookie by Object ---");
        // driver.manage().deleteCookie(newCookie); // Option 1: Delete by cookie object
 
        // 6. How to delete a specific cookie from the browser (by name)
        System.out.println("--- Deleting a Specific Cookie by Name ---");
        driver.manage().deleteCookieNamed("mycookie123"); // Option 2: Delete by cookie name
 
        // Verify the cookie count after deletion
        cookies = driver.manage().getCookies(); // Recapture cookies
        System.out.println("Size of cookies after deletion: " + cookies.size());
 
        // 7. How to delete all cookies from the browser
        System.out.println("n--- Deleting All Cookies ---");
        driver.manage().deleteAllCookies();
 
        // Verify the cookie count after deleting all
        cookies = driver.manage().getCookies(); // Recapture cookies
        System.out.println("Size of cookies after deleting all: " + cookies.size());
 
        // Close the browser
        driver.quit();
    }
}
//driver.manage().getCookies(); // Return The List of all Cookies
//driver.manage().addCookie(arg0); //Create and add the cookie // put cookie object reference name in place of arg0
//driver.manage().deleteCookie(arg0); // Delete specific cookie // put cookie object reference name in place of arg0
//driver.manage().deleteCookieNamed (arg0); // Delete specific cookie according Name // put cookie name in place of arg0
//driver.manage().deleteAllCookies(); // Delete all cookies
 