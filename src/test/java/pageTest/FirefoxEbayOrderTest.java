package pageTest;

import org.testng.annotations.Test;

import driverSettings.Firefox;
import pageFactory.PageCheckout;
import pageFactory.PageFilteredResult;
import pageFactory.PageGeneralResult;
import pageFactory.PageHome;
import pageFactory.borrar;

import org.testng.annotations.BeforeTest;

import java.text.ParseException;

import org.testng.annotations.AfterTest;

public class FirefoxEbayOrderTest extends Firefox{
	
	PageHome pageHome;
	PageGeneralResult pageResult;
	PageFilteredResult pageResultFiltro;
	PageCheckout pageCheckOut;
	
	@Test(priority=0)
	public void ArticleOrderTest() throws InterruptedException, ParseException {
		driver.get("https://www.ebay.com");
		pageHome = new PageHome(driver);
		pageHome.setLanguage();
		pageHome.searhArticle("shoes");
		pageResult = new PageGeneralResult(driver);	
		pageResult.setBrandText("PUMA");
		pageResult.CheckBrand();
		pageResult.CheckSize();
		pageResult = new PageGeneralResult(driver);
		pageResult.getTotalResults();
		pageResult.SortByPriceAsc();
		pageResultFiltro = new PageFilteredResult(driver);
		pageResultFiltro.SelectItems(5);
		pageResultFiltro.goToShoppingCart();
		pageCheckOut = new PageCheckout(driver);
		pageCheckOut.Checkout();
		
	}
}
