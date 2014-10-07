
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 
{	
	static char [] symbols = {'(', ')', '+', '\''};
	public static void test(String url)
	{
		WebDriver driver = new FirefoxDriver();
	/*	File file = new File("C:/Users/IEUser/Downloads/IEDriverServer_Win32_2.39.0/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver();
	*/	
		try 
		{
		/*	String param = "?#message=alert('hi')";
			driver.get(url + param);
			driver.get("");
			*/
			driver.get(url);
			List<WebElement> elements = new ArrayList<WebElement>();
			elements = driver.findElements(By.ByTagName.tagName("script"));
			String pageSource = driver.getPageSource();
			String eval = "eval(";
			String linesOfCode [] = pageSource.split("\n");
			ArrayList<String> evalLines = new ArrayList<String>(); 
			for(String line : linesOfCode)
			{
				if(Pattern.compile(Pattern.quote(eval)).matcher(line).find())
				{
					int evalIndex = line.indexOf(eval);
					int semicolonIndex = line.indexOf(';');
					String evalVar = line.substring(evalIndex + 5 , semicolonIndex);
					//evalVar = evalVar.replaceAll("',(,),',+,", "");
					for(char symbol : symbols)
					{
						evalVar = evalVar.replace(symbol, ' ');
					}
					evalVar = evalVar.trim();
					evalLines.add(evalVar);
				}
			}
			for(String evalLine : evalLines)
			{
				System.out.println(evalLine);
				for(String lineOfCode : linesOfCode)
				{
					String evalVar = evalLine + "=";
					String evalVar1 = evalLine + " =";
					if(Pattern.compile(Pattern.quote(evalVar)).matcher(lineOfCode).find() ||
							Pattern.compile(Pattern.quote(evalVar1)).matcher(lineOfCode).find())
					{
						System.out.println(lineOfCode);
					}
				}
			}
			
		//	WebDriverWait wait = new WebDriverWait(driver, 5 /*timeout in seconds*/);
		/*	 if(wait.until(ExpectedConditions.alertIsPresent())==null)
			       System.out.println("alert was not present");
			 else
			       System.out.println("alert was present");
		*/
		} 
		catch (UnhandledAlertException uae) 
		{
			// TODO Auto-generated catch block
			System.out.println("Alert recorded");
		}
		driver.close();
		
	}
	
	public static void main(String []args)
	{
		String url = "http://localhost/domxss/test2.html";
		test(url);
	}

}
