//seleenium tool alone can't do db testing but by integrating it with jdbc it can do db testing
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DatabaseTestingVideo32 {
 
    public static void main(String[] args) throws SQLException {
 
        // --- Data for UI Registration and Database Validation ---
        String customer_firstName = "John";
        String customer_lastName = "Doe";
        String customer_email = "johndoe123@example.com";
        String customer_telephone = "1234567890";
        String customer_password = "password123";
 
        // --- UI User Registration (Selenium WebDriver) ---
        WebDriverManager.chromedriver().setup(); // Set up Chrome driver
        WebDriver driver = new ChromeDriver(); // Initialize Chrome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        driver.get("http://localhost/opencart/upload/");// Launch application URL
        driver.manage().window().maximize(); // Maximize window
 
        try {
            // Navigate to registration page
            driver.findElement(By.xpath("//a[@title='My Account']")).click();//click on 'my account' button
            driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();//then click on'register' link button then registration form will open
 
            // Fill registration form using xpath of each box and putting our details using sendkeys() method
            driver.findElement(By.name("firstname")).sendKeys(customer_firstName);
            driver.findElement(By.name("lastname")).sendKeys(customer_lastName);
            driver.findElement(By.name("email")).sendKeys(customer_email);
            driver.findElement(By.name("telephone")).sendKeys(customer_telephone);
            driver.findElement(By.name("password")).sendKeys(customer_password);
            driver.findElement(By.name("confirm")).sendKeys(customer_password);
 
            // Agree to privacy policy checkbox and click continue
            driver.findElement(By.name("agree")).click();
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
 
            // Verify confirmation message of 'Your account has been created' by taking xpath of 'Your account has been created'
            String confirmationMessage = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
 
            if (confirmationMessage.equals("Your Account Has Been Created!")) {
                System.out.println("Registration successful from the UI application");
            } else {
                System.out.println("Registration not successful");
            }
 
        } catch (Exception e) {
            System.out.println("Some problem in the application: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
 
        // --- Database Validation (JDBC) ---
         
        try {
            // Establish database connection using connection class object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/opencart", "root", "");
                                                          //this is connection string         ,username,password
            // Create statement class object through the connection class object reference
            Statement stmt = con.createStatement();
 
            // Define SQL query to retrieve specific columns
            String query = "SELECT firstname, lastname, email, telephone FROM oc_customer"; //this is pure sql query
 
            // Execute query using statement class object reference and get result set and put it in ResultSet class object reference
            ResultSet rs = stmt.executeQuery(query);
            
            boolean recordFound = false; // Status variable to track if record is found and we put this out of while loop so we can access it out of while loop in if (recordFound==false)
 
            // Iterate through the result set stored in rs using while loop bcoz we don't knw exactly how many result are there
            while (rs.next()) {//rs.next() condition will check if the next record is available or not (if next record available then condition true while loop execute if not while loop stop)
                String db_firstName = rs.getString("firstname"); //inside getString() parenthesis whatever written example "firstname" is the exact column/field name tht showing in our db
                String db_lastName = rs.getString("lastname");
                String db_email = rs.getString("email");
                String db_telephone = rs.getString("telephone"); //db_firstName,db_lastName,db_email,db_telephone this much we collected from first row
                                                                              
                // Compare retrieved data with expected data
                if (db_firstName.equals(customer_firstName)  &&
                		db_lastName.equals(customer_lastName) &&     //as customer_password is inencrypted form we can't verify tht
                		db_email.equals(customer_email) &&
                		db_telephone.equals(customer_telephone)) 
                    
                { System.out.println("Record found in the table. Test Passed.");
                    recordFound = true;
                    break; // Exit loop once record is found
                }
            }
 
            // Check if record was not found after iterating all results
            if (recordFound==false) {
                System.out.println("Record not found. Test Failed.");
            }
 
            // Close database resources
            rs.close();
            stmt.close();
            con.close();
 
        } catch (SQLException e) {
            System.out.println("Database connection or query error: " + e.getMessage());
        }
    }
}