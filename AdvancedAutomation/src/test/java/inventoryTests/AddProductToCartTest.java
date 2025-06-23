package inventoryTests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;
@Listeners(genericUtilities.ListenersImplementationUtility.class)
public class AddProductToCartTest extends BaseClass {
//
//	public static void main(String[] args) throws IOException {
//
//		// Create Object of Utilities
//		FileUtility fUtil = new FileUtility();
//		SeleniumUtility sUtil = new SeleniumUtility();
//
//		// Read the Common Data from Property file
//		String URL = fUtil.readDataFromPropertyFile("url");
//		String USERNAME = fUtil.readDataFromPropertyFile("username");
//		String PASSWORD = fUtil.readDataFromPropertyFile("password");

@Test(groups="SmokeSuite")
public void tc_001_AddProductToCartTest() throws IOException
{
	// Read The Test Data from excel File
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Inventory", 1, 2);

//		// Step 1: Launch the browser
//		WebDriver driver = new ChromeDriver();
//		sUtil.maximizeWindow(driver);
//		sUtil.addImplicitlyWait(driver);
//
//		// Step 2: Load the URL
//		driver.get(URL);
//
//		// Step 3: Login to Application
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(USERNAME, PASSWORD);

		// Step 4: Click on product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnProduct(driver, PRODUCTNAME);

		//Step 5: add product to Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Step 5: Navigate to cart
		ip.clickOnCartContainerBtn();

		// Step 6: Validate for the product in Cart
		//		CartPage cp = new CartPage(driver);
		//		String productInCart = cp.captureItemName();
		//		
		//		if (productInCart.equals(PRODUCTNAME)) {
		//			System.out.println(productInCart);
		//			System.out.println("PASS");
		//		} else {
		//			System.out.println("FAIL");
		//		}


		// Step 6: Validate for the product in Cart

		CartPage cp = new CartPage(driver);

		String productInCart = cp.captureItemName();

		Assert.assertEquals (productInCart, PRODUCTNAME);
		//Assert.fail();

		System.out.println(productInCart);

		Assert.assertTrue(productInCart.equals(PRODUCTNAME));
		// Step 7: Logout of Application
		//ip.logoutOfApp();

	}

}