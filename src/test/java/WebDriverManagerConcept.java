import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {
		    
		WebDriverManager.chromedriver().setup(); //WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new ChromeDriver();     //WebDriver driver=new FirefoxDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		//this xpath locator was pointing to the single webelement
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));//findElement() returns single WebElement
		searchbox.sendKeys("XYZ");//this will put "XYZ" in searchbox
		
		//this xpath locator was pointing to the multiple webelements
		WebElement footer = driver.findElement(By.xpath("//section[@class='footer-upper']//a"));// here locator //section[@class='footer-upper'] was matching to 1 element but we put anker tag //a so all footer elements matching now i.e. 23
		System.out.println(footer.getText()); //first link in footer was Sitemap which got printed bcoz we used findElement() instead of findElements() and findElement() returns single WebElement even if mutiple WebElements are linked with our xpath locator
		
		//this xpath locator is not present in the given website
		// WebElement ele = driver.findElement(By.xpath("//button[@class='footer-upper']"));// so findElement() method throws NoSuchElementException:Unable to locate element:{"method":"xpath","selector":"//button[@class='footer-upper']"}
		
		List<WebElement> footpath = driver.findElements(By.xpath("//section[@class='footer-upper']//a"));//findElements() returns list of WebElements i.e List<WebElement> if mutiple WebElements are linked with our xpath locator otherwise if single WebElement is linked with our xpath locator it'll return single WebElement
		System.out.println("Number of Elements Captured:"+ footpath.size()); // output is 23
		for(WebElement ele:footpath)
		                            { System.out.println(ele.getText()); }
		
		// for findElement() we can directly perform the action as it give single element but for findElements() we have to use loop to perform the action as it give multiple elements
		
		//this xpath locator is not present in the given website
		List<WebElement> elem = driver.findElements(By.xpath("//button[@class='footer-upper']"));// so findElements() method 
		System.out.println("Number of Elements Captured:"+ elem.size()); // output is o
		
	}

}

