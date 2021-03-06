package steps;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.github.javafaker.Faker;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.JsonDataReader;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import tests.TestBase;

public class CreateUseAccount extends TestBase {

	JsonDataReader JsonReader;
	HomePage homepageobject;
	CreateAccountPage createAccountObject;
	LoginPage loginObject;
	// Use Faker as Data provider for Email to provide new Email every account creation
	Faker faker = new Faker();
	String newEmail = faker.internet().emailAddress();

	@Given("^User in home page$")
	public void user_in_home_page() {
		log.info("open Home Page");
		homepageobject = new HomePage(driver);
		log.info("Navigate to Sing In Page");
		homepageobject.openSigninPage();
	}

	@When("^User Register With the New Account Email$")
	public void user_register_with_the_new_account_email() throws IOException, ParseException {
		log.info("Register With New User Email");
		loginObject = new LoginPage(driver);
		loginObject.registerWithNewUserEmail(newEmail);
	}

	@And("^User Fill The Presonal Information$")
	public void user_fill_the_presonal_information() throws IOException, ParseException {

		// Read User Data from Json file
		log.info("Read User Data from Json File");
		JsonReader = new JsonDataReader();
		JsonReader.JsonReader();
		log.info("Fill User Personal Data");
		createAccountObject = new CreateAccountPage(driver);
		createAccountObject.userPersonalInformation(JsonReader.firstname, JsonReader.lastname, newEmail,
				JsonReader.password, JsonReader.phoneNumber, JsonReader.address, JsonReader.city, JsonReader.state,
				JsonReader.postCode);
	}

	@Then("^The registration page displayed successfully$")
	public void the_registration_page_displayed_successfully() {
		log.info("Verify That User Account created sucssefully");
		createAccountObject = new CreateAccountPage(driver);
		assertTrue(createAccountObject.accountWelcomeMessage.getText().contains("Welcome to your account"));
		log.info("The User Account created sucssefully");
		log.info("Sign Out ");
		homepageobject = new HomePage(driver);
		homepageobject.signout();
	}
}
