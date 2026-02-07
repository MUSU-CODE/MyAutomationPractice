import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
import java.util.List;
 
public class WebTableOneVideo20{
 
    public static void main(String[] args) {
 
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selenium.dev/downloads/");
        
        //in html tables are present under <table> tag and table header present under <thead> tag and <th> tag and table body present under <tbody> tag
        //for table row <tr> tag is there and for table data <td> tag is there
 
        // Find number of rows in the table so numbers of<tr> tag=number of rows in the table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));//so to point all rows we wrote /tbody/tr 
        System.out.println("Total number of rows in a table: " + rows.size());
 
        // Find number of columns in the table
        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='table']/thead/tr/th"));//so to point all columns we wrote /thead/tr/th
        System.out.println("Total number of columns in a table: " + columns.size());
 
        // Retrieve specific row and column data (e.g., Java from row 1, column 1 so tr[1]/td[1])
        WebElement value = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]"));
        String valueWritten = value.getText();
        System.out.println("The value is: " + valueWritten);
 
        System.out.println("Data from the table:");
 
        // Retrieve all rows and all columns data
        for (int r = 1; r <= rows.size(); r++) { // outer for loop represent number of rows
            for (int c = 1; c <= columns.size(); c++) { // inner for loop represent number of columns // for each row the inner for loop will print all the columns
                String data = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + r + "]/td[" + c + "]")).getText();// line 30 copied but we can't directly pass variables in xpath so we use ["+ variable r or c+"]
                System.out.print(data + "   ");
            }
            System.out.println(); // Move to the next row line after printing each row
        }
 
        System.out.println("nPrinting Release Date and Version Number for Java Language:");
 
        // Print Release Date and Version Number of Java Language
        for (int r = 1; r <= rows.size(); r++) { // Here we go through every row to find where ""Java is written and where we found "Java" is written that rows column only get printed so we took /tr[" + r + "]/td[1] means all row one column
            String language = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[" + r + "]/td[1]")).getText();
 
            if (language.equals("Java")) {
                String versionNumber = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[" + r + "]/td[2]")).getText();//as version present in 2nd column so td[2] written but row is same  so tr["+r+"]
                String releaseDate = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[" + r + "]/td[3]")).getText();//as version present in 3rd column so td[3] written but row is same so tr["+r+"]
 
                System.out.println("Language: " + language + ", Version: " + versionNumber + ", Release Date: " + releaseDate);
            }
        }
 
        driver.quit(); // Close the browser
    }
}