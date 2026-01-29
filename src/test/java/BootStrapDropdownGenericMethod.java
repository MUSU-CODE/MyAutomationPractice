import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropdownGenericMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//BootStrapDropdown is where we don't use <select> </select> select tag instead we use anker tag <a> </a> and button tag<button> </button>
		
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hdfc.bank.in/");
		
		driver.manage().window().maximize();//this will maximize our window
		
		//for "Product Type" dropdown
		driver.findElement(By.xpath("div[@class='selector-wraplist productType option-box']//div[@class='sBtn-text']")).click();//this'll click on dropdown
		
		//inside <ul></ul> ul tag all dropdown options are present and inside ul tag there is list tag <li></li> where in each list tag each option present
		List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='options']//li")); //this xpath will capture all the options in the dropdown
		System.out.println("Number of options: "+productTypes.size());// this will print the size of "productTypes" which shows how many options in the dropdown present
		
		selectOptionFromDropDown(productTypes,"Accounts");
		
		//for(WebElement option1:productTypes ) { if(option1.getText().equals("Accounts")) 
        //                                       {option1.click();          
        //                                         break;        }
		//                                     }     
		
		
		
		//for "Product Option" dropdown
		driver.findElement(By.xpath("div[@class='selector-wraplist productType option-box']//div[@class='sBtn-text']")).click();//this'll click on dropdown
				
		//inside <ul></ul> ul tag all dropdown options are present and inside ul tag there is list tag <li></li> where in each list tag each option present
		List<WebElement> productOptions = driver.findElements(By.xpath("//ul[@class='options']//li")); //this xpath will capture all the options in the dropdown
		System.out.println("Number of options: "+productOptions.size());// this will print the size of "productTypes" which shows how many options in the dropdown present
		
		selectOptionFromDropDown(productOptions,"Salary Accounts"); // here we cll selectOptionFromDropDown() and input WebElements , desired option value i.e option_value
		
	}
	  
	public static void selectOptionFromDropDown(List<WebElement> drop_options,String option_value)// here selectOptionFromDropDown() is a user defined method which parameter is
	          //drop_options(returns List of WebElements from dropdown) and option_value (returns String i.e options which shown in dropdown which is our expected value)
	  { for(WebElement opt:drop_options ) //from all the WebElements options i.e. "drop_options" here we read each one option to "opt"
	      { if(opt.getText().equals(option_value)) //if one of the option "opt" have our desired value i.e "Accounts" / "Salary Accounts" out of all option values "option_value"
                 { opt.click();  //we click on it        
                    break;        //then we close the loop
                 }
           }  
	   }
	

}
