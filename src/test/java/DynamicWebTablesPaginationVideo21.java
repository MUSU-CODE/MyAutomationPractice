import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
 
public class DynamicWebTablesPaginationVideo21 {
 
    public static void main(String[] args) {
 
        // 1. Setup the driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); 
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         
        // Maximize the browser window
        driver.manage().window().maximize();
 
        // 2. Open the application URL
        driver.get("http://demo.opencart.com/admin/index.php");
 
        // 3. Login to the application
        // Locate username field
        WebElement usernameField = driver.findElement(By.id("input-username"));
        usernameField.clear();
        usernameField.sendKeys("demo");
 
        // Locate password field
        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.clear();
        passwordField.sendKeys("demo");
 
        // Locate and click login button
        driver.findElement(By.xpath("//button[@id='submit']")).click(); // Using ID directly would be simpler here
 
        // 4. Navigate to the dynamic web table
        // Click on Sales menu
        driver.findElement(By.xpath("//div[text()='Sales']")).click();
 
        // Click on Sales Orders submenu
        driver.findElement(By.xpath("//div[text()='Sales Orders']")).click();
 
        // 5. Find the total number of pages in tht dynamic table and for xpath here we inspected the "showing 1 to 20 of (426 pages)"
        String paginationText = driver.findElement(By.xpath("//div[@class='table-container']//div[@class='z-paging']//span[contains(text(),'of')]")).getText();
        System.out.println("Full pagination text: " + paginationText);
 
        // Extract the total number of pages (e.g., "showing 1 to 20 of (426 pages)" -> 426) so logic is find index of "(" and index of "pages" and whtever in between tht is out total pages of table 
        String totalPagesStr = paginationText.substring(paginationText.indexOf("( ") + 1, paginationText.indexOf(" pages")-1);//paginationText.indexOf("of ") + 3, paginationText.indexOf(" pages")
                                                           //          (starting index , ending index )     also as index start from 0 so we use +1 above and -1 above bcoz space is there after 426
        int totalPages = Integer.parseInt(totalPagesStr); // here we change string to integer
        System.out.println("Total number of pages: " + totalPages);
 
        // Loop through each page
        //so in dynamic table whichever page is active it'll show <li class="active"> <span>pagenumber 1 or 2</span> </li> so acive tag and span available for active page
        //for inactive page <li> <a herf="page link"> page number 1 or 2 </a> </li> so <a> anker tag available for inactive page
        
         //2) Find How many rows exists in each pages
         for(int p=1;p<=totalPages;p++) // Find the active page element // For the first page, the element might be different (e.g., active class on span)
        { WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
          System.out.println("Active Page: "+active_page.getText());
          active_page.click();
         
        int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size(); //this'll give all rows count of current active page
        System.out.println("Number of rows:"+rows);
         
        //3) Read all the rows from each active page
        for(int r=1;r<=totalPages;r++) { 
        	// Read all data from each rows and desired column on the current page	
        String orderId=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"] //td[2]")).getText(); //td[2] bcoz orderid present in 2nd column
        String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"] //td[3]")).getText();  //td[3] bcoz customername present in 3rd column
        String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"] //td[4]")).getText(); //td[4] bcoz statusid present in 4th column
        
        //System.out.println(orderId+" "+customerName+" "+status);
         
        if(status.equals("Pending")) // Print data only if status is "Pending"
        { System.out.println(orderId+" "+customerName+" "+status); } }
        
        String pageno=Integer.toString(p+1); //after 1 active page i.e r we need to  click  next page to activate it so next page is r+1
         
        driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()=' "+pageno+" ']")).click(); }
                                                                                 //3
        // Close the browser
        driver.quit();
    } }
