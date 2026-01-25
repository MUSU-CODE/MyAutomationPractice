import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // Set the path of chromedriver.exe

		// Initialize Chrome browser
		WebDriver driver = new ChromeDriver();

		// Open Google
		driver.get("https://www.google.com");

		// Maximize window
		driver.manage().window().maximize();

		// Close the browser (optional)
		driver.quit();

	}

}
