package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectProductpage extends PageBase{

	public SelectProductpage(WebDriver driver) {
		super(driver);
	
	}
	

	@FindBy(xpath = "//a[@title='Women']")
	public WebElement womanMenuButton;
	@FindBy(xpath = "//a[@title='Blouses']")
	public WebElement BlousesButton;
	@FindBy(css = "h5 [title='Blouse']")
	public WebElement productName;
	@FindBy(id = "color_8")
	public WebElement whiteColorButton;
	@FindBy(id = "uniform-group_1")
	public WebElement sizeFiled;
	@FindBy(id = "group_1")
	public WebElement sizeDropdown;
	@FindBy(xpath = "//p[@id='add_to_cart']//span[text()='Add to cart']")
	public WebElement addtoCardButton;
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	public WebElement proceedtocheckoutPopupButton;
	
	
	public void selectProduct() {
		log.info("add item to card");
		// wait until Woman Menu Button appears
		waitVisibility(womanMenuButton, "Woman Menu Button");
		Actions action = new Actions(driver);
		log.info("Hover over Women category ");
		action.moveToElement(womanMenuButton).build().perform();

		// wait until Blouses Button appears
		waitVisibility(BlousesButton, "Blouses Button");
		log.info("Click on Blouse button");
		click(BlousesButton);

		// wait until Product image appears
		waitVisibility(productName, "Product image appears");
		log.info("Click on product image");
		click(productName);

		// driver.get("http://automationpractice.com/index.php?id_product=2&controller=product");
		// wait until Product white Color appears
		waitVisibility(whiteColorButton, "Product white Color");
		log.info("Select White color");
		click(whiteColorButton);
		log.info("Confirm checking White Box Color");

		// wait until Product Size list appears
		waitVisibility(sizeFiled, "Product Size Filed");
		Select select = new Select(sizeDropdown);
		log.info("Select Size Meduim");
		select.selectByVisibleText("M");

		// wait until add to card Button appears
		waitVisibility(addtoCardButton, "Add to card Button");
		log.info("Click on Add to card Button");
		click(addtoCardButton);

		// wait until Product add popup appears
		waitVisibility(proceedtocheckoutPopupButton, "Add to card Button");
		log.info("Click on proceed to checkout Button in product Popup ");
		click(proceedtocheckoutPopupButton);

		

	}
	}

