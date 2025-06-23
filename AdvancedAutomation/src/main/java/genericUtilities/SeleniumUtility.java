package genericUtilities;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
This class consists of generic methods related to Selenium tool

@author Chaitra M
 */
public class SeleniumUtility {

	public void maximizeWindow(WebDriver driver) {

		driver.manage().window().maximize();
	}

	/**This method will minimize the window

	@param driver
	 */

	public void minimizeWindow(WebDriver driver)

	{
		driver.manage().window().minimize();
	}
	/**This method will add implicitly wait for 10 seconds

	@param driver
	 */

	public void addImplicitlyWait(WebDriver driver)

	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**This method will wait for 10 seconds for the Webelement to be visible

	@param driver

	@param element
	 */

	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**This method will wait for 10 seconds for the Webelement to be Clickable

	@param driver

	@param element
	 */

	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**

	This method will handle dropdown by

	@param element

	@param index
	 */
	public void handleDropDown (WebElement element, int index)

	{

		Select s =new Select(element);

		s.selectByIndex(index);
	}

	/**

	This method will handle dropdown by visible Tel

	@param element

	@param VisibleText
	 */

	public void handleDropDown (WebElement element, String VisibleText)

	{

		Select s = new Select(element);

		s.selectByVisibleText (VisibleText);
	}

	/**This method will handle dropdown by value

	@param element

	 * @param VisibleText

	 */

	public void handleDropDown(String value, WebElement element)

	{

		Select s = new Select(element);

		s.selectByValue(value);

	}
	/** This method will perform mouse hovering Action on a web element

	@param driver

	@param element
	 */

	public void mouseHoverAction (WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);

		act.moveToElement(element).perform();

	}
	//drag and drop, Double click, right click, click and hold, release, scroll

	/**This method will perform Drag and drop Action
   @param driver
   @param src Element
    @param target Element
	 */

	public void dragAndDropAction (WebDriver driver, WebElement srcEle, WebElement tarEle)

	{

		Actions act =new Actions (driver);

		act.dragAndDrop(srcEle, tarEle).perform();

	}
	
	/**This method will perform double Click Action on a web element

	@param driver

	@param element

	*/

	public void doubleClickAction (WebDriver driver, WebElement element)

	{

	Actions act = new Actions (driver);

	act.doubleClick(element).perform();

	}
	

	/**

	This method will perform Right click Action on a web element

	@param driver

	* @param element

	*/

	public void rightClickAction (WebDriver driver, WebElement element)

	{

	Actions act = new Actions (driver);

	act.contextClick(element).perform();
	}
	
	/** This method will perform click and hold Action on a web element

	@param driver

	@param element
	*/

	public void ClickAndHoldAction(WebDriver driver, WebElement element)

	{

	Actions act= new Actions (driver);

	act.clickAndHold(element).perform();

	}

	/** This method will perform release ActionIon a web element

	@param driver

	@param element
	*/

	public void releaseAction (WebDriver driver, WebElement element)

	{
		Actions act = new Actions(driver);
		act.release(element).perform();
	}

	/**This method will perform scroll Action on a webelement

	* @param driver

	* @param element

	*/
	public void scrollAction (WebDriver driver, WebElement element)

	{

	Actions act =  new Actions (driver);

	act.scrollToElement(element).perform();

	}
//
//	public void captureScreenshot(WebDriver sdriver, String screenshotname) {
//		// Convert WebDriver object to TakesScreenshot
//	    TakesScreenshot ts = (TakesScreenshot) sdriver;
//
//	    // Capture screenshot as an image file
//	    File source = ts.getScreenshotAs(OutputType.FILE);
//
//	    // Define the destination path where the screenshot will be saved
//	    String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotname + ".png";
//
//	    // Create destination file object
//	    File finalDestination = new File(destination);
//
//	    try {
//	        // Copy screenshot file to destination
//	        FileUtils.copyFile(source, finalDestination);
//	        System.out.println("Screenshot saved to: " + destination);
//	    } catch (IOException e) {
//	        System.out.println("Failed to save screenshot: " + e.getMessage());
//	    }
//		
//	}
	
	/**This method will capture the screenshot and return the path to Caller

			@param driver

			@param screenshotname

			@return

			@throws IOException
			*/

			public String captureScreenshot (WebDriver driver, String screenshotname) throws IOException

			{

			TakesScreenshot ts= (TakesScreenshot) driver;

			File src=ts.getScreenshotAs (OutputType.FILE);

			File dst = new File("./Screenshots/"+screenshotname+".png");

			FileHandler.copy(src,dst);

			return dst.getAbsolutePath(); //For Extent Reports

			}


}

