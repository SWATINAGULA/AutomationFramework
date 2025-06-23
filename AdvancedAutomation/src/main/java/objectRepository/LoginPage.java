package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule - 1 create a seperate Pom Class for every web page
	
	//Rule 2: Identify the web elements using @FindBy, @FindBys, @FindAll
	
	//Declaration 
	@FindBy(id = "user-name") 
	private WebElement usernameEdt;
	
	@FindBy(id = "password")
	private WebElement passwordEdt;
	
	@FindBy(name = "login-button")
	private WebElement loginBtn;
	
	//Rule 3: Create a constructor for element initialization
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Provide Getters to access the web elements
	
	//Utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void loginToApp(String USERNAME, String PASSWORD) {
		
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
		
	
	
	}
	
	
	
}