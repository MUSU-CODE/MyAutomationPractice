import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropdownElementsInOnePage {
   
	static WebDriver driver;//we made WebDriver driver as global variable so we can access it anywhere and in java global variable means static as main() method is static
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver();   // here we're instatiating the global variable i.e static WebDriver driver
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
		//here country and number of employees are two dropdowns
		// one way 
		
		//Select emplyoeeoption = new Select (driver.findElement(By.name("NoOfEmployees"))); //WebElement emplyoeeoption = driver.findElement(By.name("NoOfEmployees"));
		//emplyoeeoption.selectByVisibleText("Denmark");
		
		//Select countryoption = new Select (driver.findElement(By.name("Country")));
		//countryoption.selectByVisibleText("11 - 50");
		
		//another best way for multiple dropdown
		WebElement emplyoeeoption = driver.findElement(By.name("NoOfEmployees"));
		selectFromDropdown(emplyoeeoption,"16 - 20");
		
		WebElement countryoption = driver.findElement(By.name("Country"));
		selectFromDropdown(countryoption,"Argentina");
		
		
	}
        
	public static void selectFromDropdown(WebElement ele,String value) // here selectFromDropdown() is a user defined method which parameter is ele(returns WebElement from dropdown)
	                                                                   // and value (returns String i.e an option which we choose from dropdown)
	                                                                  {
		                                                                Select drp = new Select(ele);
		                                                                
		                                                                List<WebElement> alloptions = drp.getOptions();
		                                                                for(WebElement option:alloptions) { if(option.getText().equals(value)) 
		                                                                                                                                        { option.click();
		                                                                                                                                          break;     }
		                                                                                                  }
	                                                                  }
	
}
