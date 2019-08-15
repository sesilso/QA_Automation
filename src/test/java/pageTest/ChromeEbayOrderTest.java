package pageTest;

import java.text.ParseException;

import org.testng.annotations.Test;

import driverSettings.Chrome;
import pageFactory.PageGeneralResult;
import pageFactory.PageHome;
import pageFactory.PageCheckout;
import pageFactory.PageFilteredResult;
import pageFactory.borrar;

public class ChromeEbayOrderTest extends Chrome{
  
	PageHome pageHome;
	borrar obj;
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

