// JavaScriptExecutorUtil.java (Utility Class)
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class JavaScriptExecutorUtilVideo28 { // we didn't create a main method bcoz it's a reusable class created for only clling the method
 
    // Method to draw border around an element
    public static void drawBorder(WebDriver driver, WebElement element) { //we made all method static so we can call it directly or by using class name
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element); //'3px solid red' this we can change on our need
    }
 
    // Method to get the title of the page
    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }
 
    // Method to click on an element
    public static void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);
    }
 
    // Method to generate an alert
    public static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");
    }
 
    // Method to refresh the browser
    public static void refreshBrowserByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }
 
    // Method to scroll down the page
    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
 
    // Method to scroll up the page
    public static void scrollPageUp(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }
 
    // Method to zoom in/out the page
    public static void zoomPageByJS(WebDriver driver, int percentage) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.body.style.zoom='" + percentage + "%'");
    }
 
    // Method to flash an element
    public static void flash(WebDriver driver, WebElement element) throws InterruptedException {
        String currentColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) { // flash the element 10 times
            changeColor("rgb(0,200,0)", element, driver); // Green color
            Thread.sleep(100);
            changeColor(currentColor, element, driver); // another color
            Thread.sleep(100);
        }
    }
 
    // Helper method to change element color for flash an element in the flash () we created
    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
    }
}