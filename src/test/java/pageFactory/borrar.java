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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class borrar {
	
	public static void main(String[] args) throws ParseException {

		String sad="- select - ";
		if(sad.contains("selet")){
			System.out.println("si contine");
		}else
		{
			System.out.println("nooooo");
		}
		}
		
//		NumberFormat format = NumberFormat.getInstance(Locale.US);    
//		 Number number = format.parse("10.23"); 
//
//		 // Now you can get number values from the object (like int, long, double)
//		 System.out.println(number.intValue()); 
//		
//	    Item2 s1  = new Item2("2",33.84);
//	    Item2 s2 = new Item2("1", 100.30);
//	    Item2 s3 = new Item2("3", 27.07);
//
//	        ArrayList<Item2> studList = new ArrayList<Item2>();
//	        studList.add(s1);
//	        studList.add(s2);
//	        studList.add(s3);
//	       
//	        System.out.println("before sorting %%%%%%%% "+ studList.get(0).getName() + " - " + studList.get(1).getName()+ " - " + studList.get(2).getName() );
//	        System.out.println("before sorting %%%%%%%% "+ studList.get(0).getPrice() + " - " + studList.get(1).getPrice()+ " - " + studList.get(2).getPrice() );
//	       
//	        Collections.sort(studList, new Comparator<Item2>(){
//	             public int compare(Item2 s1, Item2 s2) {
//	            	
//	               return s1.getName().compareToIgnoreCase(s2.getName());
//	            }
//	        });
//
//	        System.out.println("after sorting %%%%%%%% "+ studList.get(0).getName() + " - " + studList.get(1).getName()+ " - " + studList.get(2).getName() );
//	        System.out.println("after sorting %%%%%%%% "+ studList.get(0).getPrice() + " - " + studList.get(1).getPrice()+ " - " + studList.get(2).getPrice() );
//	  }
}

