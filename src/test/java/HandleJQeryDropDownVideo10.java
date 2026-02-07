import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJQeryDropDownVideo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		//here we can choose one option or more than one option or all the options depending on our need
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		selectChoiceValues(driver, "choice 1");// single choice
		//selectChoiceValues(driver, "choice 2","choice 2 3","choice 6","choice 6 2 1","choice 6 2");//multiple choice
		//selectChoiceValues(driver, "ALL");//All choice
		
		//selectChoiceValues(driver, "choice1"); /OR/ selectChoiceValues(driver, "choice1","choice2","choice2.1"); /OR/ selectChoiceValues(driver, "all"); //this got called from generic method
	   //this is single choice value goes to String... value  /OR/ this is multiple choice value goes to String... value  /OR/ this is single choice value goes to String... value  
		

	}   
	
	public static void selectChoiceValues(WebDriver driver , String... value ) //String... value is equal to String value[] and in String... value we can put only one type of element i.e. string type
	{ 
		List<WebElement> choicelists = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));//xpath of all the dropdown element
		if (!value[0].equalsIgnoreCase("all")) //value[0] means 1st element as value is an array
			           //(!value[0].equalsIgnoreCase("all") means if String... value first check if "all" or "All" is passing if it's not passing "all" then it's passing single or multiple choice value
		{
			for(WebElement item:choicelists) //this loop to capture element from choicelists WebEelements and one by one put in item WebElement
			{
				String text=item.getText(); //after getting one by one WebElement item from choicelists we capure it's word and put it in "text"
				for(String val:value) // then we have to compare "text" with our String... value i.e. "value" to check if "text" is equal to our desired item i.e "value" or not
				{
					if(text.equals(val))
					{
						item.click(); // if equal to "value" then click
						break;        // once the inner loop is completed  then from for(WebElement item:choicelists) from "choicelists" one more item will be selected tht item again capture "text" and loop goes on
					}
				}
			}
		}
		
		else // if "if condition" is false and we're puting "all" or "All" value then else execute and every option get selected
		{
			try {
				 for(WebElement item:choicelists)
				     { item.click(); }
			    }
			catch(Exception e)
			    {   }
			
		}
		
	}
	   

}
