package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageParameters {

	//1. Lokatoriai

	// Logout
	By linkLogOut = By.xpath("//*[@onclick=\"document.forms['logoutForm'].submit()\"]");
	
	//2. Konstruktorius
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. Metodai
	
	public void Logout()
	{
		driver.findElement(linkLogOut).click();
	}

}
