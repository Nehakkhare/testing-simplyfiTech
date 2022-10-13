package com.simplifitech;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class Simplifitech {
	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://simplyfi.tech/");
		driver.manage().window().maximize();
		implicitWait(10);
	}

	public void testBankingProductsSimba() throws InterruptedException, IOException {
		driver.findElements(By.xpath("//li[@class='dropdown-holder menu-list']")).get(0).click();
		implicitWait(10);
		driver.findElement(By.linkText("SIMBA")).click();
		implicitWait(10);
	}

	public void testBankingProductsInvoizo() throws InterruptedException, IOException {
		driver.findElements(By.xpath("//li[@class='dropdown-holder menu-list']")).get(0).click();
		implicitWait(10);
		driver.findElement(By.linkText("INVOIZO")).click();
		implicitWait(10);
	}

	public void testBankingProductsInterCompany() throws InterruptedException, IOException {
		driver.findElements(By.xpath("//li[@class='dropdown-holder menu-list']")).get(0).click();
		implicitWait(10);
		driver.findElement(By.linkText("INTERCOMPANY")).click();
		implicitWait(10);
	}

	public void testBankingProductsVideo() throws InterruptedException, IOException {
		driver.findElements(By.xpath("//li[@class='dropdown-holder menu-list']")).get(0).click();
		implicitWait(10);
		driver.findElement(By.linkText("Video KYC")).click();
		implicitWait(10);
	}

	public void testBankingProductsOCR() throws InterruptedException, IOException {
		driver.findElements(By.xpath("//li[@class='dropdown-holder menu-list']")).get(0).click();
		implicitWait(10);
		driver.findElement(By.linkText("OCR")).click();
		implicitWait(10);
	}

	public void testBankingProductsLmsLos() throws InterruptedException, IOException {
		driver.findElements(By.xpath("//li[@class='dropdown-holder menu-list']")).get(0).click();
		implicitWait(10);
		driver.findElement(By.linkText("LMS & LOS")).click();
		implicitWait(10);
	}

	public void testCompanyOurStory() throws InterruptedException, IOException {
		driver.findElements(By.xpath("//li[@class='dropdown-holder menu-list']")).get(1).click();
		implicitWait(10);
		Thread.sleep(1000);
	}

	public void testCompanyWhySimplyFI() throws InterruptedException, IOException {
		driver.findElements(By.xpath("//li[@class='dropdown-holder menu-list']")).get(1).click();
		implicitWait(10);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Why SimplyFI")).click();
		implicitWait(10);
	}

	public void testCompanyOurJourney() throws InterruptedException, IOException {
		driver.findElements(By.xpath("//li[@class='dropdown-holder menu-list']")).get(1).click();
		implicitWait(10);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Our Journey")).click();
		implicitWait(10);
	}

	public void testScheduleMeeting() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//li[@class=' demo-button']")).click();
		implicitWait(10);
	}

	

	public void testQuickLinks() throws InterruptedException, IOException {
		driver.findElement(By.linkText("Why SimplyFI")).click();
		implicitWait(10);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Contact Us")).click();
		implicitWait(10);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Innovation")).click();
		implicitWait(10);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Blogs")).click();
		implicitWait(10);
	}

	public void testAboutSimplyFI() throws InterruptedException, IOException {
		driver.findElement(By.linkText("Company Information")).click();
		implicitWait(10);
		driver.findElement(By.linkText("Careers")).click();
		implicitWait(10);
		driver.findElement(By.linkText("News and Press")).click();
		implicitWait(10);
		driver.findElement(By.linkText("Events")).click();
		implicitWait(10);
	}

	public void testSiteInformation() throws InterruptedException, IOException {
		driver.findElement(By.linkText("Privacy")).click();
		implicitWait(10);
		driver.findElement(By.linkText("Terms of Use")).click();
		implicitWait(10);
		driver.findElement(By.linkText("Copyright")).click();
		implicitWait(10);
		driver.findElement(By.linkText("Sitemap")).click();
		implicitWait(10);
	}

	public void testSubscribeUs() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//h4[contains(text(),'Subscribe Us')]/..//form//input")).sendKeys("abc@gmail.com");
		implicitWait(10);
		driver.findElement(By.xpath("//h4[contains(text(),'Subscribe Us')]/..//form//input")).submit();
		implicitWait(10);

	}

	private void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	private void takeScreenshot() throws IOException {
		String path = "Screenshots/image/";
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		Date date = new Date();
		String fileName = date.toString().replace(":", "_") + ".jpg";
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File(path+fileName));
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException, IOException {
		takeScreenshot();
		Thread.sleep(3000);
		driver.quit();
	}

}
