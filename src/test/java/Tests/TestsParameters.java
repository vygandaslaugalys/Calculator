package Tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestsParameters {

	protected static WebDriver driver;
	public String Log = "src/test/resources/rezultatai.txt"; // Cia bus surasomi visu Testu rezultatai
	
	@BeforeTest
	public void SetUp() throws Exception {
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.navigate().to("localhost:8080/skaiciuotuvas");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public static void TearDown() {
		driver.manage().deleteAllCookies();
		//driver.close(); // kazkodel tai meta daug klaidu - todel naudosim quit
		driver.quit();
	}
	
	public static ArrayList<String> getTestDataArray(String myFile) throws NumberFormatException, IOException {
		// for reading the file
		// reading text file into ArrayList in Java 6
		ArrayList<String> listOfLines = new ArrayList<String>();
		String line;
		  
		FileReader FR = new FileReader(myFile);
		BufferedReader BR = new BufferedReader(FR);
		line = BR.readLine();
	    
	    while (line != null) {
	    	listOfLines.add(line);
	        line = BR.readLine();
	    }

	    BR.close();
		return listOfLines;
		}
	
	public static void takeSnapShot(WebDriver webdriver) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
      	String filePath = "src/test/resources/"+timeStamp+".png";
        File DestFile=new File(filePath);
       //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

	public static void resultsToFile(String text, String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName, true); //open file to write info
		BufferedWriter bw = new BufferedWriter(fw); //teksto rasymui
		PrintWriter pw = new PrintWriter(bw); //kaskart irasineti atskiroje eiluteje.
		pw.println(text);		
		pw.close(); //uzdarome irasinejimo faila.
	}
}
