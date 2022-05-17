package Tests;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Pages.PrisijungimasPage;
import Pages.RegistracijaPage;

public class PA1 extends TestsParameters {
	
	//Panaudos Atvejis PA1 - Naujo vartotojo registracija
	
		@Test
		public void PA1PS1() throws Exception {
			
			PrisijungimasPage pp = new PrisijungimasPage(driver);
			pp.RegistruotiLink();
			RegistracijaPage rp = new RegistracijaPage(driver);
			Thread.sleep(1000);
			
			// Visi imanomi Username/Password/PasswordConfirm deriniai (praleisti/neteisingi/teisingi)
			// privalo buti skaitomi is duomenu failo Lentele1.txt
			
			System.out.println("PA1PS1 testas: Naujo vartotojo registracija (pozityvus ir negatyvus testas).");
			resultsToFile("PA1PS1 testas: Naujo vartotojo registracija (pozityvus ir negatyvus testas).",Log);
			
			ArrayList<String> numbers = getTestDataArray("src/test/resources/Lentele1.txt");
			int a = numbers.size();
			for(int i=0;i<a;i++){
				String[] number = numbers.get(i).split(",",4);
					
				rp.SignUp(number[0],number[1],number[2]);				
				
				Thread.sleep(1000);
				try {
					String str = driver.findElement(By.xpath("//span[@id='username.errors']")).getText();
					System.out.println(str);
					resultsToFile("Klaida PA1PS1: '"+str+"'. Lentelė1.txt, eil."+(i+1),Log);
				}catch(Exception e) {
					System.out.println("Ok");
					resultsToFile("PA1PS1: '"+"Ok"+"'. Lentelė1.txt, eil."+(i+1),Log);				
				}

				Thread.sleep(1000);
				try {
					String str = driver.findElement(By.xpath("//span[@id='password.errors']")).getText();
					System.out.println(str);
					resultsToFile("Klaida PA1PS1: '"+str+"'. Lentelė1.txt, eil."+(i+1),Log);
				}catch(Exception e) {
					System.out.println("Ok");
					resultsToFile("PA1PS1: '"+"Ok"+"'. Lentelė1.txt, eil."+(i+1),Log);				
				}
				
				Thread.sleep(1000);
				try {
					String str = driver.findElement(By.xpath("//span[@id='passwordConfirm.errors']")).getText();
					System.out.println(str);
					resultsToFile("Klaida PA1PS1: '"+str+"'. Lentelė1.txt, eil."+(i+1),Log);
				}catch(Exception e) {
					System.out.println("Ok");
					resultsToFile("PA1PS1: '"+"Ok"+"'. Lentelė1.txt, eil."+(i+1),Log);				
				}

				Thread.sleep(2000);
			}
			TearDown();
			SetUp();
		}
	
}

