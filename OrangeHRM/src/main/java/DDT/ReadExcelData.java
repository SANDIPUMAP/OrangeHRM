package DDT;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadExcelData {
	@Test
	public void meth() throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
		 driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		FileInputStream ip = new FileInputStream("E:\\lendings.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(ip);
		XSSFSheet sheet = workbook.getSheetAt(1);
		XSSFSheet sheet2 = workbook.getSheet("Sheet1");
		
		

			
		
			int rowcount1 = sheet2.getLastRowNum();
			
			for (int i =1;i<rowcount1 ;i++) {
			XSSFRow currentRow =	sheet2.getRow(i);
				String username = currentRow.getCell(0).getStringCellValue();
				String passward = currentRow.getCell(1).getStringCellValue();
				String res = currentRow.getCell(2).getStringCellValue();
				
				WebElement user=	driver.findElement(By.id("txtUsername"));
				user.clear();
				user.sendKeys(username);
				WebElement pass=driver.findElement(By.id("txtPassword"));
				pass.clear();
				pass.sendKeys(passward);
				driver.findElement(By.id("btnLogin")).click();

				String exp ="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
				String	url =driver.getCurrentUrl();
				
				if(res.contentEquals("valid")) {
					
					if(url.contentEquals(exp)) {
						driver.findElement(By.id("welcome")).click();
						
						driver.findElement(By.xpath("//a[text()='Logout']")).click();
						Assert.assertTrue(true);}
					        
					
					    else {
						Assert.assertTrue(false);}
					}
					
					else if (res.contentEquals("invalid")) {
						if(url.contentEquals(exp)) {
							driver.findElement(By.id("welcome")).click();
							
							driver.findElement(By.xpath("//a[text()='Logout']")).click();
							Assert.assertTrue(false);
						}
						else {
							Assert.assertTrue(true);
						}
					 
				}
				}
				
			}
	}
			
	
			
			 
