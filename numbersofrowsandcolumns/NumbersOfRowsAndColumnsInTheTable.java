package com.numbersofrowsandcolumns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NumbersOfRowsAndColumnsInTheTable {

	public static void main(String[] args) {
		 int totalNumberOfNumericValues = 0;
		 int sum = 0;
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		 driver.get("file:///C:/Users/VINAYAK/Desktop/table.html");
		 driver.manage().window().maximize();
		 
		 WebElement table = driver.findElement(By.xpath("/html/body/table"));
		 List<WebElement> totalNumberOfRows = table.findElements(By.tagName("tr"));
		 List<WebElement> totalNumberOfColumns = table.findElements(By.tagName("th"));
		 int rowsCount = totalNumberOfRows.size();
		 int columnCount = totalNumberOfColumns.size();
		 int row = driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr")).size();
		 int column = driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/*")).size();
		 
		 
		 System.out.println("Total Number of Rows "+rowsCount);
		 System.out.println("Total Number of Columns "+columnCount);
		 
		 
		 List<WebElement>  names = driver.findElements(By.xpath("//table[@id ='example']/tbody/tr/td[3]"));
		 
		 System.out.println("Numeric values present in the table are");
		 for(int i = 0; i <= names.size()-1; i++ ) {
			 totalNumberOfNumericValues++;
			 String value = names.get(i).getText();
			 int totalSum = Integer.parseInt(value);
			 sum = sum + totalSum;
			 System.out.println(value);
			 
		 }
		 System.out.println("Total Number of Numeric values present "+ totalNumberOfNumericValues);
		 System.out.println("Total sum is "+sum);
		 driver.close();
		 

	}

}