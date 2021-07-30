package com.stuartkruze.app;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

	public static void main(String[] args) throws InterruptedException {

		String driverPath = "C:/Users/stuar/Desktop/revature-github/2106-java-msa-reston/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();

		driver.get("file:///C:/Users/stuar/Desktop/revature-github/Revature-Projects/Project1/login.html");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement userName = driver.findElement(By.id("user"));
		WebElement pass = driver.findElement(By.id("pass"));
		WebElement btn = driver.findElement(By.id("btn"));

		userName.sendKeys("audiolaboratory@hotmail.com");
		pass.sendKeys("pass");
		btn.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement training = driver.findElement(By.id("training"));
		WebElement desc = driver.findElement(By.id("desc"));
		WebElement dos = driver.findElement(By.id("dos"));
		WebElement cost = driver.findElement(By.id("cost"));
		WebElement Dpass = driver.findElement(By.id("Dpass"));
		WebElement types = driver.findElement(By.id("types"));
		WebElement univ = driver.findElement(By.id("univ"));
		WebElement just = driver.findElement(By.id("just"));
		WebElement work = driver.findElement(By.id("work"));
		WebElement sub = driver.findElement(By.id("sub"));
		WebElement pending = driver.findElement(By.id("pending"));
		
		training.sendKeys("Rutgers University");
		desc.sendKeys("PHP class");
		dos.sendKeys("01/21/21");
		cost.sendKeys("300");
		Dpass.click();
		types.click();
		univ.click();
		just.sendKeys("want it");
		work.sendKeys("2 weeks");
		sub.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		pending.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement grade = driver.findElement(By.id("grade"));
		WebElement ds = driver.findElement(By.id("ds"));
		WebElement contact = driver.findElement(By.id("contact"));
		
		grade.sendKeys("A");
		ds.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		contact.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement lname = driver.findElement(By.id("lname"));
		WebElement sub2 = driver.findElement(By.id("sub"));
		WebElement login = driver.findElement(By.id("login"));
		
		
		lname.sendKeys("Dulay");
		sub2.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		login.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement userName2 = driver.findElement(By.id("user"));
		WebElement pass2 = driver.findElement(By.id("pass"));
		WebElement btn2 = driver.findElement(By.id("btn"));

		userName2.sendKeys("JohnAGarcia@jourrapide.com");
		pass2.sendKeys("pass");
		btn2.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		Select dropdown = new Select(driver.findElement(By.id("names")));
		dropdown.selectByVisibleText("Karen Rowley");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		WebElement a = driver.findElement(By.id("appp"));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		a.click();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement login2 = driver.findElement(By.id("login"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		login2.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement userName3 = driver.findElement(By.id("user"));
		WebElement pass3 = driver.findElement(By.id("pass"));
		WebElement btn3 = driver.findElement(By.id("btn"));

		userName3.sendKeys("DanielFBelanger@rhyta.com");
		pass3.sendKeys("pass");
		btn3.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Select dropdown2 = new Select(driver.findElement(By.id("names")));
		dropdown2.selectByVisibleText("Karen Rowley");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		WebElement a2 = driver.findElement(By.id("appp"));
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		a2.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement login3 = driver.findElement(By.id("login"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		login3.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement userName4 = driver.findElement(By.id("user"));
		WebElement pass4 = driver.findElement(By.id("pass"));
		WebElement btn4 = driver.findElement(By.id("btn"));

		userName4.sendKeys("MarilynBShelton@rhyta.com");
		pass4.sendKeys("pass");
		btn4.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		Select dropdown3 = new Select(driver.findElement(By.id("names")));
		dropdown3.selectByVisibleText("Karen Rowley");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement a3 = driver.findElement(By.id("appp"));
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		a3.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
		
		}
}