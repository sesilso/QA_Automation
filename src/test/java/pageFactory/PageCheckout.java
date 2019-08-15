package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCheckout {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//button[contains(@data-test-id,'cta-top')]")
	WebElement btncheckout;
	
	@FindBy(xpath = "//button[@id='gxo-btn']")
	WebElement btnAsGuest;
	
	@FindBy(xpath = "//div[contains(@class,'dialog__body')]")
	WebElement frmDialog;
	
	public PageCheckout(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 90);
		PageFactory.initElements(driver,this);
	}
	
	public void ClickCheckout(){
		wait.until(ExpectedConditions.elementToBeClickable(btncheckout));
		btncheckout.click();
	}

	public void Checkout() throws InterruptedException{
		System.out.println("Ending automated testing...");
		ClickCheckout();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(frmDialog).moveToElement(btnAsGuest).click().build().perform();
		
	}
	
	
}
