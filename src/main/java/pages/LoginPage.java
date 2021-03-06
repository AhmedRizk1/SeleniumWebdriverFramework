package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Register With New User Email Elements
	@FindBy(id = "email_create")
	public WebElement emailCreateInputFiled;
	@FindBy(id = "SubmitCreate")
	public WebElement CreateAccountButton;
	
	// Login with authorized Use Elements
	@FindBy(id = "email")
	public WebElement emailFiled;
	@FindBy(id = "passwd")
	public WebElement passwordfiled;
	@FindBy(id = "SubmitLogin")
	public WebElement signinButton;
	
	
	public  void registerWithNewUserEmail(String email) {
		
		// Wait Until Email Create Input Filed appears
		waitVisibility(emailCreateInputFiled, "Email Create Input Filed");
		writeText(emailCreateInputFiled, email);
		
		// Wait Until Create Account Button appears
		waitVisibility(CreateAccountButton, "Create Account Button");
		log.info("Click on Create Account Button");
		click(CreateAccountButton);
	}

	public void loginWithAuthorizedUser(String email, String password) {

		log.info("Login with authorized user");
		
		// Wait Until Email Filed appears
		waitVisibility(emailFiled, "Email Filed");
		log.info("Enter User Email");
		writeText(emailFiled, email);
		
		// Wait Until Password Filed appears
		waitVisibility(passwordfiled, "Password Filed");
		log.info("Enter User Password");
		writeText(passwordfiled, password);
		
		// Wait Until Sign in Button appears
		waitVisibility(signinButton, "Signin Button");
		log.info("Click on sign in Button");
		click(signinButton);

	}

	

}
