    // Handling JavaScript Alert with only an OK button as these JS alerts (all discussed in this programs) coming directly from browser so we can't inspect these popups
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;
	 
	public class AlertsListVideo17 {
	 
	    public static void main(String[] args) throws InterruptedException {
	 
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://the-internet.herokuapp.com/javascriptalerts");
	 
	        // Click the button to trigger the alert
	        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
	 
	        // Switch to the alert and accept it (clicks OK)
	        Alert alertWindow = driver.switchTo().alert();
	        Thread.sleep(3000); // Wait to see the alert
	        alertWindow.accept(); // Clicks OK
	 
	        System.out.println("Successfully closed alert with OK button");
	 
	        // Handling JavaScript Alert with OK and Cancel buttons
	        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click(); // this'll click the button which will open the JS PopUp
	        Thread.sleep(3000);
	        Alert confirmAlert = driver.switchTo().alert();
	        confirmAlert.accept(); // the accept () will Clicks OK on tht JS Alert popup then the alert will close
	        System.out.println("Successfully closed confirm alert by clicking OK");
	 
	        Thread.sleep(2000);
	 
	        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
	        Thread.sleep(3000);
	        confirmAlert = driver.switchTo().alert();
	        confirmAlert.dismiss(); // the dismiss () will Clicks Cancel on tht JS Alert popup then the alert will close
	        System.out.println("Successfully closed confirm alert by clicking Cancel");
	 
	        // Handling JavaScript Alert with an Input Box (Prompt)
	        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
	        Thread.sleep(3000);
	        Alert promptAlert = driver.switchTo().alert();
	        // Get text from the alert
	        String alertMessage = promptAlert.getText();
	        System.out.println("Alert message: " + alertMessage);
	 
	        // Send text to the input box
	        promptAlert.sendKeys("Welcome");
	        Thread.sleep(3000);
	        promptAlert.accept(); // Clicks OK
	 
	        System.out.println("Successfully handled prompt alert");
	 
	        driver.quit();
	    }
	}
	 
	// Handling Authentication Pop-ups
	/*import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;
	 
	public class AuthenticationPopups {
	 
	    public static void main(String[] args) throws InterruptedException {
	 
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        //driver.get("http://the-internet.herokuapp.com/basicauth"); //instead of directly putting link for tht authentication  site we put username and password after https:// then we'// put the link
	                                                                     //so when the link open it'll take username and password from get() and will authenticate
	        // URL format for authentication: [http://username:password@URL]->(http://username:password@URL)
	        // Example: [http://admin:admin@the-internet.herokuapp.com/basicauth]->(http://admin:admin@the-internet.herokuapp.com/basicauth)
	        driver.get("http://admin:admin@the-internet.herokuapp.com/basicauth");
	 
	        // Thread.sleep(5000); // To observe the login
	        driver.quit();
	    }
	}*/
	 
	// Handling Permission Pop-ups (Show Notifications ALLOW OR BLOCK)
	/*import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import io.github.bonigarcia.wdm.WebDriverManager;
	 
	public class PermissionPopups {
	 
	    public static void main(String[] args) throws InterruptedException {
	 
	        WebDriverManager.chromedriver().setup();
	 
	        // Create ChromeOptions object to handle browser settings
	        ChromeOptions options = new ChromeOptions();
	 
	        // Add "--disable-notifications" argument to disable notifications
	        options.addArguments("--disable-notifications");
	 
	        // Pass the ChromeOptions object to the ChromeDriver constructor
	        WebDriver driver = new ChromeDriver(options);
	 
	        driver.get("[https://www.redbus.in/");
	 
	        Thread.sleep(5000); // To observe if the notification appears
	        driver.quit();
	    }
	}*/