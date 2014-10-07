
import java.io.File;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 
{	
	public static void test(String url)
	{
		//WebDriver driver = new FirefoxDriver();
		File file = new File("C:/Users/IEUser/Downloads/IEDriverServer_Win32_2.39.0/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver();
		
		try 
		{
			String param = "?name=abc#<script>alert('hi')</script>";
			driver.get(url + param);
			driver.get("");
		//	WebDriverWait wait = new WebDriverWait(driver, 5 /*timeout in seconds*/);
			/* if(wait.until(ExpectedConditions.alertIsPresent())==null)
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
		String url = "http://localhost/domxss/test1.html";
		test(url);
	}

}
