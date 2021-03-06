package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCheckoutpage extends PageBase {

	public ProductCheckoutpage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@id='center_column']//a[@title='Proceed to checkout']/span")
	public WebElement proceedtocheckoutSummaryButton;
	@FindBy(xpath = "//button[@type='submit'][@name='processAddress']/span")
	public WebElement proceedtocheckoutAddressButton;
	@FindBy(id = "uniform-cgv")
	public WebElement agreeServiceTermsCheckBox;
	@FindBy(xpath = "//button[@type='submit'][@name='processCarrier']/span")
	public WebElement proceedtocheckoutShippingButton;
	@FindBy(className = "bankwire")
	public WebElement payByBankWireButton;
	@FindBy(xpath = "//p[@id='cart_navigation']//button[@type='submit']")
	public WebElement confirmOrderButton;
	@FindBy(xpath = "//p[@class='cheque-indent']//strong[@innertext='Your order on My Store is complete.']")
	public WebElement orderConfirmationMessage;
	@FindBy(xpath = "//a[@title='Back to orders']")
	public WebElement backToOrderButton;
	@FindBy(xpath = "(//table[@id='order-list']//tr//td)[1]")
	public WebElement firstOrderInList;

	public void productCheckout() {
		
		// wait until open summary tab appears
		waitVisibility(proceedtocheckoutSummaryButton, "proceedtocheckoutSummaryButton");
		log.info("Click on proceed to checkout Button in summary tab ");
		click(proceedtocheckoutSummaryButton);

		// wait until proceed to checkout Button in address tab appears
		waitVisibility(proceedtocheckoutAddressButton, "proceedtocheckoutAddressButton");
		log.info("Click on proceed to checkout Button in address tab ");
		click(proceedtocheckoutAddressButton);

		// wait until Agree terms Button in shipping tab appears
		waitVisibility(agreeServiceTermsCheckBox, "Agree terms Button in shipping");
		log.info("Click on Agree terms Button in shipping in shipping tab ");
		click(agreeServiceTermsCheckBox);

		// wait until proceed to checkout Button in shipping tab appears
		waitVisibility(proceedtocheckoutShippingButton, "proceedtocheckoutShippingButton");
		log.info("Click on proceed to checkout Button in shipping tab ");
		click(proceedtocheckoutShippingButton);

		// wait until pay By Bank Wire Button appears
		waitVisibility(payByBankWireButton, "Pay By Bank Wire Button");
		log.info("Click onPay By Bank Wire Button ");
		click(payByBankWireButton);

		// wait until Confirm order Button appears
		waitVisibility(confirmOrderButton, "Confirm order  Button");
		log.info("click on Confirm order  Button ");
		click(confirmOrderButton);

		// wait until Back to Order Button appears
		waitVisibility(backToOrderButton, "Back to Order Button");
		log.info("click on Back to Order Button");
		click(backToOrderButton);

		// wait until The order appears in orders list
		waitVisibility(firstOrderInList, "The order appears in orders");

	}

}
