package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrisijungimasPage  extends PageParameters{
	
	//1. Lokatoriai
	
	By inputUsername = By.xpath("//input[@name='username']");
	By inputPassword = By.xpath("//input[@name='password']");

	By buttonPrisijungti = By.xpath("//button [@type='submit']");
	By hrefRegistruoti = By.xpath("//a[text()='Sukurti naują paskyrą']");
	
	
	//2. Konstruktorius
	
	public PrisijungimasPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. Metodai
	
	public void LogIn(String Username, String Password)
	{
		driver.findElement(inputUsername).clear();
		driver.findElement(inputUsername).sendKeys(Username);
		driver.findElement(inputPassword).clear();
		driver.findElement(inputPassword).sendKeys(Password);
		driver.findElement(buttonPrisijungti).click();
	}

	public void RegistruotiLink()
	{
		driver.findElement(hrefRegistruoti).click();
	}


}
