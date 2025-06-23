package genericUtilities;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class Base {

    public WebDriver driver;
    public FileUtility fUtil = new FileUtility();
    public SeleniumUtility sUtil = new SeleniumUtility();

    @BeforeMethod
    public void setup() throws IOException {
        // Launch Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the URL
        String URL = fUtil.readDataFromPropertyFile("url");
        driver.get(URL);

        // Perform Login
        String USERNAME = fUtil.readDataFromPropertyFile("username");
        String PASSWORD = fUtil.readDataFromPropertyFile("password");

        LoginPage lp = new LoginPage(driver);
        lp.loginToApp(USERNAME, PASSWORD);
    }

    @AfterMethod
    public void teardown() {
        try {
            // Logout if login was successful
            InventoryPage ip = new InventoryPage(driver);
            ip.logoutOfApp();
        } catch (Exception e) {
            System.out.println("Logout skipped due to exception: " + e.getMessage());
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}