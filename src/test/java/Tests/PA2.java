package Tests;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Pages.PrisijungimasPage;

public class PA2 extends TestsParameters {
	
	//Panaudos Atvejis PA2 - Registruoto vartotojo prisijungimas
	
	@Test
	public void PA2PS1() throws Exception {

		PrisijungimasPage pp = new PrisijungimasPage(driver);
		
		Thread.sleep(2000);

		// Visi imanomi Username/Password deriniai (praleisti/neteisingi/teisingi)
		// privalo buti skaitomi is duomenu failo Lentele2.txt
		
		System.out.println("PA2PS1 testas: Esamo vartotojo prisijungimas (pozityvus ir negatyvus testas).");
		resultsToFile("PA2PS1 testas: Esamo vartotojo prisijungimas (pozityvus ir negatyvus testas).",Log);
		
		ArrayList<String> numbers = getTestDataArray("src/test/resources/Lentele2.txt");
		int a = numbers.size();
		for(int i=0;i<a;i++){
			String[] number = numbers.get(i).split(",",3);		
			pp.LogIn(number[0],number[1]);
			Thread.sleep(1000);
			try {
				String str = driver.findElement(By.xpath("//span[contains(text(),'prisijungimo vardas')]")).getText();
				System.out.println(str);
				resultsToFile("Klaida PA2PS1: '"+str+"'. Lentelė2.txt, eil."+(i+1),Log);
			}catch(Exception e) {
				System.out.println("Ok");
				resultsToFile("PA2PS1: '"+"Ok"+"'. Lentelė2.txt, eil."+(i+1),Log);				
			}
		}
		Thread.sleep(1000);
	}
}
