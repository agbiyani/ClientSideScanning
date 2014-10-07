
import java.io.File;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Test3 
{	
	public static String [] attackStrings = {
		"#message=abc",
		"#message=alert(1)",//if eval sink 
		"?message=abc#<script>alert(1)</script>" // If document.write is the sink
		};
	public static void test(String url)
	{
		//To launch Firefox
	//	 WebDriver driver = new FirefoxDriver();
	
		//To launch IE
/*		File file = new File("C:/Users/IEUser/Downloads/IEDriverServer_Win32_2.39.0/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver();
	*/	
		WebDriver driver = null;
		try 
		{
		/*	String param = "?#message=alert('hi')";
			driver.get(url + param);
			driver.get("");
			*/
			for(String str : attackStrings)
			{
				driver = new FirefoxDriver();
				System.out.println(str);
				driver.get(url + str);
				driver.close();
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
		finally
		{
			if(driver != null)
				driver.close();
		}
		
	}
	
	public static void main(String []args)
	{
		String url = "http://localhost/domxss/test2.html";
		test(url);
	}

}
