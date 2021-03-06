package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "login")
	public WebElement SignInButton;
	@FindBy(css = "a[title='Log me out']")
	public WebElement SignOutButton;

	public void openSigninPage() {
		log.info("open URL link ");
		driver.get("http://automationpractice.com/index.php");
		// Wait Until Login Button appears
		waitVisibility(SignInButton, "Login Button");
		log.info("Click on Sign in Button ");
		click(SignInButton);
	}

	public void signout() {
		// Wait Until Sign Out Button appears
		waitVisibility(SignOutButton, "Sign Out Button");
		log.info("Click on Sign Out Button ");
		click(SignOutButton);
	}

}