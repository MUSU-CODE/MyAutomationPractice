import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSortedOrNotVideo11 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://twoplugs.com/"); //(https://twoplugs.com/";)
		driver.manage().window().maximize();
		
		// 4. Click on the "Live Posting" link
        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
 
        // 5. Locate the dropdown element
        WebElement drpElement = driver.findElement(By.name("category_id"));
 
        // 6. Create a Select class instance
        Select drpSelect = new Select(drpElement);
 
        // 7. Get all options from the dropdown and store it in options variable using getOptions() variable
        List<WebElement> options = drpSelect.getOptions();
 
        // 8. Create two ArrayLists to store option text values from above WebElements 'options'
        ArrayList originalList = new ArrayList();
        ArrayList tempList = new ArrayList();// rn originalList,tempList are empty as they newly created
 
        // 9. Populate both lists (originalList,tempList) with the text values of the dropdown options
        for (WebElement option : options) { // this loop created so we can iterate each option from "options" and put in'option'
            originalList.add(option.getText()); //here .add() method add text in originalList and .get text() fetch text from 'option'
            tempList.add(option.getText()); // rn originalList,tempList are full
        }
 
        // Print the original and temporary lists before sorting (for demonstration)
        System.out.println("Original List: " + originalList);
        System.out.println("Temporary List (before sorting): " + tempList);
 
        // 10. Sort the temporary list using sort() method
        Collections.sort(tempList);
 
        // Print the original and temporary lists after sorting (for demonstration)
        System.out.println("Original List (after temp sort): " + originalList);
        System.out.println("Temporary List (after sorting): " + tempList);
 
        // 11. Compare the original list with the sorted temporary list
        if (originalList.equals(tempList)) {
            System.out.println("Dropdown Sorted");
        } else {
            System.out.println("Dropdown Unsorted");
        }
 
        // 12. Close the browser
        driver.close();
    }
}