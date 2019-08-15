package pageFactory;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageGeneralResult {

	private WebDriver driver;
	private WebDriverWait wait; 
	@FindBy(xpath = "(//span[contains(@class,'gh-eb-Geo-txt')])[1]")
	private WebElement language;
	@FindBy(xpath = "//input[@id='gh-ac']")
	private WebElement txtArticle;	
	@FindBy(xpath = "//input[@id='gh-btn']")
	private WebElement btnSearch;	
	@FindBy(xpath = "//span[@class='cbx x-refine__multi-select-cbx'][contains(.,'PUMA')]")
	private WebElement chckBrand;
	@FindBy(xpath = "//h1[contains(@class,'srp-controls__count-heading')]")
	private WebElement lblResultCount;	
	@FindBy(xpath = "(//div[contains(@class,'srp-controls__control--legacy')])[3]")
	private WebElement btnSortBy;
	
	public PageGeneralResult(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 90);
		PageFactory.initElements(driver,this);
	}
	
	public void setBrandText(String brand){
		if(driver.findElements(By.xpath("//input[@id='w3-w5-0[0]']")).size()>0){
		      driver.findElement(By.xpath("//input[@id='w3-w5-0[0]']")).click();
		}else{
			driver.findElement(By.xpath("//input[@id='w3-w12-0[0]']")).click();
		}
	}
		
	public void CheckBrand(){
		wait.until(ExpectedConditions.elementToBeClickable(chckBrand));
		chckBrand.click();
	}
	
	public void CheckSize(){
		if(driver.findElements(By.xpath("(//span[@class='cbx x-refine__multi-select-cbx'][contains(.,'10')])[1]")).size()>0){
			driver.findElement(By.xpath("(//span[@class='cbx x-refine__multi-select-cbx'][contains(.,'10')])[1]")).click();
		}else{
			driver.findElement(By.xpath("(//a[contains(.,'10')])[1]")).click();;
		}
	}
	
	public Integer getResultCount(){
		wait.until(ExpectedConditions.visibilityOf(lblResultCount));
		String[] arr = lblResultCount.getText().split(" ", 2); 
		return Integer.parseInt(arr[0].trim().replace(",",""));
	}
	
	public void SortByPriceAsc(){
		try{
			Actions does = new Actions(driver);
			wait.until(ExpectedConditions.visibilityOf(txtArticle));
			does.moveToElement(txtArticle).moveToElement(btnSortBy).moveToElement(driver.findElement(By.xpath("//span[contains(.,'Price + Shipping: lowest first')]"))).click().build().perform();
		}catch(Exception e){
			System.out.println(e);
		}		
	}
	
	public void getTotalResults(){
		System.out.println("Total Resuts found : " + getResultCount());
	}
	
	
	
}
