package steps;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.JsonDataReader;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductCheckoutpage;
import pages.SelectProductpage;
import tests.TestBase;

public class CardCheckout extends TestBase {
	JsonDataReader JsonReader;
	HomePage homepageobject;
	LoginPage loginObject;
	CreateAccountPage createAccountObject;
	SelectProductpage selectProductObject;
	ProductCheckoutpage productCheckoutObject;

	@Given("^User In Home Page$")
	public void user_in_home_page() throws Throwable {
		log.info("open Home Page");
		homepageobject = new HomePage(driver);
		log.info("Navigate to Sing In Page");
		homepageobject.openSigninPage();
	}

	@When("^User Login With Authorized Account$")
	public void user_login_with_authorized_account() throws Throwable {
		// Read User Data from Json file
		log.info("Read User Data from Json File");
		JsonReader = new JsonDataReader();
		JsonReader.JsonReader();
		log.info("Register With New User Email");
		loginObject = new LoginPage(driver);
		loginObject.loginWithAuthorizedUser(JsonReader.email, JsonReader.password);
		createAccountObject = new CreateAccountPage(driver);
		assertTrue(createAccountObject.accountWelcomeMessage.getText().contains("Welcome to your account"));
	}

	@And("^User Select Product$")
	public void user_select_product() throws Throwable {
		log.info("Select Product and It to the Card");
		selectProductObject = new SelectProductpage(driver);
		selectProductObject.selectProduct();
	}

	@And("^User compelet check out steps with bank wire option$")
	public void user_compelet_check_out_steps_with_bank_wire_option() throws Throwable {
		log.info("Following the checkout procedure");
		productCheckoutObject = new ProductCheckoutpage(driver);
		productCheckoutObject.productCheckout();
	}

	@Then("^The orede added to orders List$")
	public void the_orede_added_to_orders_list() throws Throwable {
		productCheckoutObject = new ProductCheckoutpage(driver);
		log.info("Validate that order was placed in order history page");
		assertTrue(productCheckoutObject.firstOrderInList.isDisplayed());
		log.info("The order was placed in order history page succsefuly ");
		log.info("Sign Out ");
		homepageobject = new HomePage(driver);
		homepageobject.signout();
	}
}