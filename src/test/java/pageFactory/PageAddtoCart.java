package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAddtoCart {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[@id='isCartBtn_btn']")
	WebElement btnAdd;
	
	@FindBy(xpath = "//select[@id='msku-sel-1']")
	WebElement slctsize;
	
	public PageAddtoCart(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 90);
		PageFactory.initElements(driver,this);
	}
	
	public void clickAdd(){
		wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
		btnAdd.click();		
	}
	
	public void confirmSelectedSize(){
		if(driver.findElements(By.xpath("//select[@id='msku-sel-1']")).size()>0){
			Select selected = new Select(slctsize);
			String selectedtext = selected.getFirstSelectedOption().getText();
			
			if(selectedtext.contains("Selec")){
				Select selectopt = new Select(slctsize);
				selectopt.selectByVisibleText("US 10 / UK 9 / 280mm");
			}
		}
	}
	
	public void AddToCart() throws InterruptedException{
		confirmSelectedSize();
		clickAdd();
		Thread.sleep(1000);
		driver.navigate().back();		
	}
	
}
