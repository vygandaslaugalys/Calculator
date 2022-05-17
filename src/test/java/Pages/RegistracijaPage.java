package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistracijaPage extends PageParameters{
	
	//1. Lokatoriai
	
	By inputUsername = By.xpath("//input[@name='username']");
	By inputPassword = By.xpath("//input[@name='password']");
	By inputPasswordConfirm = By.xpath("//input[@name='passwordConfirm']");

	By buttonSukurti = By.xpath("//button[@type='submit']");
	
	//2. Konstruktorius
	
	public RegistracijaPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. Metodai
	
	public void SignUp(String Username, String Password, String PasswordConfirm) {
		driver.findElement(inputUsername).clear();
		driver.findElement(inputUsername).sendKeys(Username);
		driver.findElement(inputPassword).clear();
		driver.findElement(inputPassword).sendKeys(Password);
		driver.findElement(inputPasswordConfirm).clear();
		driver.findElement(inputPasswordConfirm).sendKeys(PasswordConfirm);	
		driver.findElement(buttonSukurti).click();
	}
	

}
