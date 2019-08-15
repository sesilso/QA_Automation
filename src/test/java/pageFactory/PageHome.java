package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHome {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id='gh-eb-Geo-a-default']/span[2]")
	WebElement idioma;
	@FindBy(xpath = "//input[@id='gh-ac']")
	private WebElement txtArticle;	
	@FindBy(xpath = "//input[@id='gh-btn']")
	private WebElement btnSearch;
	
	public PageHome(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);		
	}
	
	public void setLanguage(){
		if(idioma.getText().equals("Español")){
			idioma.click();
			driver.findElement(By.xpath("//span[@class='gh-eb-Geo-txt'][contains(.,'English')]")).click();
			Actions does = new Actions(driver);
			does.moveToElement(txtArticle);
		}	
	}
	
	public void setArticle(String art){
		wait.until(ExpectedConditions.elementToBeClickable(txtArticle));
		txtArticle.sendKeys(art);
	}
	
	public void clickSearch(){
		wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
		btnSearch.click();
	}
	
	public void searhArticle(String article){
		setArticle(article);
		clickSearch();
	}	

}
