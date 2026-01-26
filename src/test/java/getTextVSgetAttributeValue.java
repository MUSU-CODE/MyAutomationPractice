import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextVSgetAttributeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver=new ChromeDriver();     
		driver.get("https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F");
		
		WebElement emailinputbox = driver.findElement(By.id("Email"));
		
		//capturing text from email input box and we found tht text is present inside "value" attribute i.e (value=\"admin@yourstore.com\") so we put "value" inside getAttribute() 
		System.out.println("Result from (value=\"admin@yourstore.com\") using getAttribute() method: "+emailinputbox.getAttribute("value"));
		
		System.out.println("Result from (value=\"admin@yourstore.com\") using getText() method: "+emailinputbox.getText());
		
		emailinputbox.clear();//.clear() will clear any text present in the box previously
		emailinputbox.sendKeys("new@gmail.com");//.sendKeys("") will input our text in the box
		
		//<input name="email" id="user" value="admin@yourstore.com">abc@mail.com</input>
		// here Attributes are "name","id","value" which are inside input tag <input --- ></input> or any anker tag like <h1 --- > </h1>
		//only attributes are allowed inside getAttribute() method and getAttribute() method fetch the text contained by an attribute in a html document
		 
		//abc@mail.com --->called as "inner text" bcoz it present in between input tag <input> --- </input> or any anker tag like <h1>---</h1>
		//getText() method doesn't take any input but getText() method output is "inner text" of an element --> abc@gmail.com
		
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		
		System.out.println("Result of login button using getAttribute() method: "+button.getAttribute("type"));
		System.out.println("Result of login button using getAttribute() method: "+button.getAttribute("class"));
		
		System.out.println("Result of login button using getText() method: "+button.getText());
		
	}

}
