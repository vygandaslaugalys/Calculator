package Tests;

import org.testng.annotations.Test;
import Pages.HomePage;

public class PA3 extends TestsParameters {
	
	//Panaudos Atvejis PA3 - Prisijungusio vartotojo atsijungimas
	
	@Test
	public void PA3PS1() throws Exception {

		HomePage hp = new HomePage(driver);
		Thread.sleep(1000);
		takeSnapShot(driver); // Ar tikrai prisijungę ?
		
		System.out.println("PA3PS1 testas: Vartotojo atsijungimas (pozityvus testas).");
		resultsToFile("PA3PS1 testas: Vartotojo atsijungimas (pozityvus testas).",Log);
		
		try {
			hp.Logout();
			System.out.println("PA3PS1: pavyko atsijungti.");
			resultsToFile("PA3PS1: pavyko atsijungti.",Log);
		}catch(Exception e) {
			System.out.println("Klaida PA3PS1: nepavyko atsijungti.");
			resultsToFile("Klaida PA3PS1: nepavyko atsijungti.",Log);
		}
		takeSnapShot(driver); // Ar tikrai pavyko atsijungti ?
		Thread.sleep(2000);
	}
}
