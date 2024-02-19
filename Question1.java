package task21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) {
	
// Launch browser  
		
		WebDriver driver = new ChromeDriver();
//Launch URL
		driver.get("https://the-internet.herokuapp.com/iframe");
//Maximize the browser
		driver.manage().window().maximize();
//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement parentframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
// switch to frames
		
		driver.switchTo().frame(parentframe);
//Locating the element
		
		WebElement para = driver.findElement(By.xpath("//body[@id='tinymce']"));
		para.clear();
		para.sendKeys("Hello People");
	}

}
