package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends PageBase {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	// Create user Elements
	@FindBy(className = "account_creation")
	public WebElement accountCreationForm; // Account form used for Assertion
	@FindBy(id = "id_gender1")
	public WebElement radioButtonofMaleGender;
	@FindBy(id = "customer_firstname")
	public WebElement firstNameInputFiled;
	@FindBy(id = "customer_lastname")
	public WebElement lastNameInputFiled;
	@FindBy(id = "email")
	public WebElement emailInputFiled;
	@FindBy(id = "passwd")
	public WebElement passwordInputFiled;
	@FindBy(id = "address1")
	public WebElement addressInputFiled;
	@FindBy(id = "city")
	public WebElement cityInputFiled;
	@FindBy(id = "uniform-id_state")
	public WebElement stateFiled;
	@FindBy(id = "id_state")
	public WebElement stateIdDropdwon;
	@FindBy(id = "postcode")
	public WebElement postcodeInputFiled;
	@FindBy(id = "id_country")
	public WebElement countryInputFiled;
	@FindBy(id = "phone_mobile")
	public WebElement mobilePhoneInputFiled;
	@FindBy(id = "submitAccount")
	public WebElement RegistertButton;
	@FindBy(className = "info-account")
	public WebElement accountWelcomeMessage;

//	// Create User data using Java Faker
//	Faker faker = new Faker();
//	String firstName = faker.name().firstName();
//	String LastName = faker.name().lastName();
//	String email = faker.internet().emailAddress();
//	String password = faker.lorem().characters(5, 8, true, true);
//	String phoneNumber = faker.phoneNumber().cellPhone();
//	String address = faker.address().fullAddress();
//	String city = faker.address().cityName();
//	String postCode = faker.address().zipCode().substring(0, 5);

	public void userPersonalInformation(String firstName, String LastName, String email, String password,
			String phoneNumber, String address, String city, String state, String postCode) {

		// Wait until account creation form appears
		waitVisibility(accountCreationForm, "Account Creation Form");
		// Wait until Radio Button of Male Gender appears
		waitVisibility(radioButtonofMaleGender, "Radio Button of Male Gender");
		click(radioButtonofMaleGender);
		// Wait Until First Name Input Filed appears
		waitVisibility(firstNameInputFiled, "First Name Input Filed");
		writeText(firstNameInputFiled, firstName);
		// Wait Until Last Name Input Filed appears
		waitVisibility(lastNameInputFiled, "Last Name Input Filed");
		writeText(lastNameInputFiled, LastName);
		// Wait Until Password Input Filed appears
		waitVisibility(passwordInputFiled, "Password Input Filed");
		writeText(passwordInputFiled, password);
		// Wait Until Address Input Filed appears
		waitVisibility(addressInputFiled, "Address Input Filed");
		writeText(addressInputFiled, address);
		// Wait Until City Input Filed appears
		waitVisibility(cityInputFiled, "City Input Filed");
		writeText(cityInputFiled, city);
		// Wait Until State Filed appears
		waitVisibility(stateFiled, "State Filed");
		// create select object to select from dropdown list
		Select select = new Select(stateIdDropdwon);
		select.selectByVisibleText(state);
		// Wait Until Zip/Postal Code Input Filed appears
		waitVisibility(postcodeInputFiled, "Zip/Postal Code Input Filed");
		writeText(postcodeInputFiled, postCode);
		// Wait Until Phone Number Input Filed appears
		waitVisibility(mobilePhoneInputFiled, "Phone Number Input Filed");
		writeText(mobilePhoneInputFiled, phoneNumber);
		// Wait Until Register Button appears
		waitVisibility(RegistertButton, "Register Button");
		click(RegistertButton);
		// Wait Until Account page appears
		waitVisibility(accountWelcomeMessage, "Account page");
	}

}