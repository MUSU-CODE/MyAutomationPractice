import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // Set the path of chromedriver.exe
		WebDriver driver = new ChromeDriver();// Initialize Chrome browser

		driver.get("https://www.google.com");// Open Google

		driver.manage().window().maximize();// Maximize window

		driver.quit();// Close the browser (optional)

		// Webdriver is an interface which is implemented by Chrome driver class for chrome browser, Firefox driver class for fire fox browser, edge driver class for edge browser & these classes use webdriver interface methods
		// To launch Chrome/Firefox/Edge driver first download Chrome/Firefox/Edge driver from online then setProperty(key,value)
		// System.setProperty("webdriver.chrome.driver","give local path of the chrome driver\\chromedriver.exe");
		// For Firefox driver here ("webdriver.gecko.driver","give local path of the Firefox driver\\geckodriver.exe");
        // After System.setProperty("") create object of chrome driver class
		// ChromeDriver driver = new ChromeDriver(); // OR //WebDriver driver=new ChromeDriver(); Writting this, This will import a package related to Chrome driver in our class
		// FirefoxDriver driver = new FirefoxDriver(); //OR //WebDriver driver=new FirefoxDriver(); Writting this, This will import a package related to Firefox driver in our class

		// OR

		//If we don't want to manually download the browser and manually write the path of the browser then we use WebDriverManager API. 
		//By using WebDriverManager API we can directly specify the method which will launch any of our required browser. To get the WebDriverManager we go to maven project in pom.xml then there we have to add a dependency of WebDriverManager. 
		//For that we need to go online and search  maven repository and then in there Search for WebDriverManager Then open the latest version copy the dependency and paste it in pom. XML Once we have the dependency it will automatically download required jar file.
		//Using another way i.e using WebDriverManager Class to launch any browser
		//WebDriverManager.chromedriver().setup(); // For FireFox Browser // WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new ChromeDriver(); // For FireFox Browser // WebDriver driver=new FirefoxDriver();

		//driver.get("https://");// this will open the url of the particular application

		//System.out.println("Title of the opened web page is" + driver.getTitile()); // Any WebPage-> right click-> view page source-> inside title tag the tile is there<title>New Tab</title>
		//System.out.println("Url of the opened web page is" + driver.getCurrentUrl());
		//System.out.println("HTMLCode which is PageSource of the opened web page is" + driver.getPageSource());

		// To check if WebElement is displayed,enabled,selected we have 3 methods i.e isDisplayed(),isEnabled(),isSelected() These are conditional Methods which will return true or false.
		// For this we use XPath (from selector hub)
		//WebElement searchStore = driver.findElement(By.xpath(" //span[@id='search-toggle-txt'] "));
		//System.out.println("Display status:" + searchStore.isDisplayed());// true
		//System.out.println("Enabled status:" + searchStore.isEnabled());// to see if the element able to take the input from user;

		// isSelected() used for radio bottom & check boxes & dropdown
		//WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		//WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));

		//System.out.println(male.isSelected()); // False
		//System.out.println(female.isSelected()); // False

		//male.click(); // selects and click on male radio button

		//System.out.println(male.isSelected()); // True
		//System.out.println(female.isSelected()); // False

		//female.click(); // selects and click on female radio button

		//System.out.println(male.isSelected()); // False I
		//System.out.println(female.isSelected()); // True

		//driver.get("https://www.snapdeal.com");// first snapdeal page will open
		//driver.navigate().to("https://www.amazon.com");// then amazon page will open as navigate().to() act same as get();
		//driver.navigate().back();// this command will take us from amazon page to snapdeal page
		//driver.navigate().forward();// this command will take us from snapdeal page to amazon page
		//driver.navigate().refresh();// this command will refresh or reload our current page

	}

}
