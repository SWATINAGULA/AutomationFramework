package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCartUsingDDT {

	public static void main(String[] args) throws IOException {
		//Read the Common Data from Property file

		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");

		Properties p =new Properties();

		p.load(fis);

		String URL= p.getProperty("url");

		String USERNAME = p.getProperty("username");

		String PASSWORD = p.getProperty("password");
		
		//Read The Test Data from excel File

		FileInputStream fise = new FileInputStream("./src/test/resources/TestData.xlsx");

		Workbook wb= WorkbookFactory.create(fise);

		Sheet sh = wb.getSheet("Inventory");

		Row rw =  sh.getRow(1);

		Cell cl = rw.getCell(2);

		String PRODUCTNAME = cl.getStringCellValue();

		// Step 1: Launch the browser

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Step 2: Load the URL

		driver.get(URL);
		// Step 3: Login to Application

		driver.findElement(By.id("user-name")).sendKeys (USERNAME);

		driver.findElement(By.id("password")).sendKeys (PASSWORD);

		driver.findElement(By.name("login-button")).click();

		// Step 4: Add Product to Cart

		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click(); 
		driver.findElement(By.xpath("//button[.='Add to cart']")).click();

		// Step 5: Navigate to cart

		driver.findElement(By.id("shopping_cart_container")).click();

		// Step 6: Validate for the product in Cart

		String productInCart  = driver.findElement(By.className("inventory_item_name")).getText();
		if(productInCart.equals(PRODUCTNAME))
		{
			System.out.println(productInCart);
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}

	}

}
