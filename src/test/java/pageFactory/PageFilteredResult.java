package pageFactory;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import items.Item;

public class PageFilteredResult {

	private WebDriver driver;
	private WebDriverWait wait;
	private PageAddtoCart pageAddtoCart;
	private Item item;
	
	public PageFilteredResult(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 90);
		PageFactory.initElements(driver,this);
	}
		
	 public void SelectItems(Integer count) throws InterruptedException, ParseException{
		
		Thread.sleep(1000);
		ArrayList<Item> order = new ArrayList<Item>();
		
		for(int i=1;i<=count;i++){
			 WebElement txtName = driver.findElement(By.xpath("(//h3[@class='s-item__title'])["+i+"]"));
			 WebElement txtPrice = driver.findElement(By.xpath("(//span[@class='s-item__price'])["+i+"]"));
			 		
			 String itemName = txtName.getText();
			 String rawitemPrice = txtPrice.getText(); 
			 
			 item = new Item(itemName,PriceToDouble(rawitemPrice));
			 order.add(item);
			 txtName.click();
			 Thread.sleep(3000);
			 pageAddtoCart = new PageAddtoCart(driver);
			 pageAddtoCart.AddToCart();
			 returnPage();
		}			 
		
		System.out.println("Total Products (" + count +") selected : ");
		for(int i=0;i<5;i++){
			System.out.println("Item ("+ (i+1) +")" + order.get(i).getName() + " / Price : " + order.get(i).getPrice());
		}
		
		NamesOrderASC(order,count);
		PricesOrderDESC(order,count);						
		
	 }	
	 
	 
	 public double PriceToDouble(String rp) throws ParseException{
		 
		 String[] price = rp.split(" ");	
		 String p = price[1].trim();
		 NumberFormat format = NumberFormat.getInstance(Locale.US);    
		 Number priceNumber = format.parse(p);
		 
		 return priceNumber.doubleValue();
	 }
	 
	 public void NamesOrderASC(ArrayList<Item> order, Integer count){
		 
		Collections.sort(order, new Comparator<Item>(){
	         public int compare(Item s1, Item s2) {
	        	 return s1.getName().compareToIgnoreCase(s2.getName());
	         }
		});
			
		System.out.println("\n Products Order by Name (ASC): ");
		for(int i=0;i<count;i++){
			System.out.println("Item ("+ (i+1) +")" + order.get(i).getName() + " / Price : " + order.get(i).getPrice());
		}
			 
	 }
	 
	 public void PricesOrderDESC(ArrayList<Item> order, Integer count){
			
		 	Collections.sort(order, new Comparator<Item>(){
	            public int compare(Item s1, Item s2) {
	              return s1.getPrice().compareTo(s2.getPrice());
	           }
			});
			
			Collections.reverse(order);	
			
			System.out.println("\n Products Order by Price (DESC): ");
			for(int i=0;i<count;i++){
				System.out.println("Item ("+ (i+1) +")" + order.get(i).getName() + " / Price : " + order.get(i).getPrice());
			}
	 }
	 
    	public void returnPage(){
			
			driver.navigate().back();
			
		}
    	
    	public void goToShoppingCart(){
    		WebElement cart = driver.findElement(By.xpath("//a[@href='https://cart.payments.ebay.com/sc/view']"));
    		cart.click();
    	}
    	
}

