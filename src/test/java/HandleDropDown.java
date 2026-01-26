import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// If dropdown is using select tag in html script then To handle drop down in Selenium we can't directly perform any action we have to use select class and we put WebElement inside select class object,
		//inside select class there is three methods available i.e. selectByVisibleText(), selectByValue(), selectByIndex()  BUT If the dropdown is not using select tag then there’s other ways to handle them
		//In dropdown each select tag i.e dropdown box is one element then there is each  option tags i.e. dropdown options coming in the drop down is also another elements
        
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver=new ChromeDriver();     
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		WebElement dropcountry = driver.findElement(By.id("input-country"));
		
		Select dropdowncountryoption = new Select (dropcountry);
		
		dropdowncountryoption.selectByVisibleText("Denmark");
		
		//dropdowncountryoption.selectByValue("10");// some times value attribute not present in html code then we can't use .selectByValue() but here value attribute present <option value="1" xpath="1">Afghanistan</option>
		
		//dropdowncountryoption.selectByIndex(0);// here we put index number so 0 means first option tag which is <option value="" xpath="1"></option>  then index 1 is <option value="1" xpath="1">Afghanistan</option>
	    
		//selecting option from dropdown without using methods of select class
		 
		List<WebElement> alloptions = dropdowncountryoption.getOptions(); // here we use .getOptions() in FindElements to get all the options in dropdown
		 
		for(WebElement option:alloptions) // we put "alloptions" variable in "option" variable which will return WebElement
		                                  { if(option.getText().equals("Cuba")) // if we getText "Cuba"
	                                         option.click();                    // then click on it
		                                     break;          }                  // after clicking and selecting cuba , break the loop

	}

}
