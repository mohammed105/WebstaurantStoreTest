package com.demo.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Hello {

	public static void main(String[] args) throws InterruptedException {
	    System.setProperty("webdriver.chromedriver.driver", "C:\\driver");
		 WebDriver driver =new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.get("https://www.webstaurantstore.com/");
	     
	   WebElement mainMenu=driver.findElement(By.xpath("//a[@href='/restaurant-equipment.html']"));
	   Actions action=new Actions(driver);
	   try {
		   action.moveToElement(mainMenu).perform();
	} catch (Exception e) {
		// TODO: handle exception
	}
	   
	        WebElement childMenu=driver.findElement(By.linkText("Stainless Steel Work Tables with Undershelf"));
	        String pagetitlle= driver.getTitle();
	         System.out.println(pagetitlle);
	        action.moveToElement(childMenu).click().build().perform();
	    
            	List <WebElement> links=driver.findElements(By.tagName("a"));
     	         int size=links.size();
     	         
     	         System.out.println("total links   " + size);
     	  
     	         for(int i=0; i<size; i++) {
     	        	  
                  	 if(links.get(i).getAttribute("href").contains("table")) {
                  		 String tabletext = links.get(i).getText();
                  		 System.out.println(tabletext);
                      }
                  	 else { System.out.println("There is no table related link title");}
     	         } 
     	         
     	         
     	               List<WebElement> addlinks=driver.findElements(By.xpath("//input[@name=\"addToCartButton\"]"));
     	               int addsize =addlinks.size();
     	               System.out.println(addsize);
     	             
     	               for(int j=0; j<addsize; j++) {
     	            	  addlinks.get(addsize-1).click(); 
     	            	  Thread.sleep(10000);
     	             //   Alert alert = driver.switchTo().alert();
     	               //  alert.dismiss();
     	            	  driver.findElement(By.xpath("//span[@id=\"cartItemCountSpan\"]")).click();
     	            	  driver.findElement(By.name("quantityButtonDown")).click();
     	            	 // driver.close();
     	               }
              	 
     	       
	}

}
