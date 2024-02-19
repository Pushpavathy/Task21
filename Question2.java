package task21;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {

	public static void main(String[] args) {
		
		// Launch browser  
		
				WebDriver driver = new ChromeDriver();
		//Launch URL
				
				driver.get("https://the-internet.herokuapp.com/windows");
				
		//Maximize the browser
				driver.manage().window().maximize();
				
		//wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Find click here and perform click
				
				WebElement clickhere = driver.findElement(By.xpath("//a[contains(text(),'Click')]"));
				clickhere.click();
				
		//Getting title of the original window		
				String wincont = driver.getTitle();
				System.out.println("Current window title is " +wincont);
		
		//Window handles & switch to new window		
				
				Set<String> windowHandles = driver.getWindowHandles();
				List<String>lastwin = new ArrayList<>(windowHandles);
				driver.switchTo().window(lastwin.get(1));
				String newwintitle = driver.getTitle();
				System.out.println("new  window title is " +newwintitle);
			//Displys the text and closes the tab
				
				WebElement newwin = driver.findElement(By.xpath("//div[@class='example']"));
				System.out.println(newwin.getText());
				
				driver.close();
				
		//	switch to original window	
				driver.switchTo().window(lastwin.get(0));
		// get the text
				String upwin = driver.getTitle();
				System.out.println("The orginal window title is " +upwin);
				{
					if(wincont.equals(upwin))
							{
								System.out.println("The original window is active");
							}
					else
						System.out.println("The original window is not active");
				}
//Close the browser instance
				driver.quit();
	}

}
