package task21;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question3 {

	public static void main(String[] args) {
		// Launch browser  
		
		WebDriver driver = new ChromeDriver();
//Launch URL
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
//Maximize the browser
		driver.manage().window().maximize();
		
//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//identifying top frame
		 WebElement topframe = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		 driver.switchTo().frame(topframe);
		 
		 
//Verifying the frames in top frame
		 List<WebElement> framesintop = driver.findElements(By.tagName("frame"));
		 int topframesize = framesintop.size();
		 System.out.println("No: of frames available in the top frame" +topframesize);
		
//Locating all frames in top
		 
		 WebElement leftframe = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		 WebElement middleframe = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		 WebElement rightframe = driver.findElement(By.xpath("//frame[@name='frame-right']"));
//switching to left frame.
		 
		 driver.switchTo().frame(leftframe);
//Locating element in the left frame
		 WebElement leftele = driver.findElement(By.tagName("Body"));
		 String verileft = leftele.getText();
		 
//Verify the text inside the frame		 
		 if (verileft.equals("LEFT"))
		 {
		 System.out.println("Text inside  fram is : LEFT" );
		 }
		 else
		 {
			 System.out.println("Text inside fram is not LEFT");
		 }
			 
		 
//Switing back to top frame
		 driver.switchTo().parentFrame();
		 
//Switching to middle frame
		 driver.switchTo().frame(middleframe);
		 WebElement middleele = driver.findElement(By.id("content"));
		 String verifymiddle = middleele.getText();
		 
//Verify the text inside the frame
		 
		 if (verifymiddle.equals("MIDDLE"))
		 {
		 System.out.println("Text inside fram is : MIDDLE" );
		 }
		 else
		 {
			 System.out.println("Text inside fram is not MIDDLE");
		 }
		
		
//Switching back to top frame
		 driver.switchTo().parentFrame();
		
//Switching to right frame
		
		 driver.switchTo().frame(rightframe);
		 WebElement rightele = driver.findElement(By.tagName("Body"));
		 String verifyright = rightele.getText();

//Verify the text inside the frame
		 
		 if (verifyright.equals("RIGHT"))
		 {
		 System.out.println("Text inside  fram is : RIGHT" );
		 }
		 else
		 {
			 System.out.println("Text inside the frame is not RIGHT");
		 }
		
		
		
//Switching back to top frame
		 driver.switchTo().parentFrame();
		 
//Switching to default content
		 driver.switchTo().defaultContent();
		
//Switching to bottom frame.
		 
		 WebElement bottomframe = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		 driver.switchTo().frame(bottomframe);
		 WebElement bottomele = driver.findElement(By.tagName("Body"));
		 String verifybottom = bottomele.getText();
		 
//Verify the text inside the frame
		 
		 if (verifybottom.equals("BOTTOM"))
		 {
		 System.out.println("Text inside frame is : BOTTOM" );
		 }
		 else
		 {
			 System.out.println("Text inside frame is not BOTTOM");
		 }
				 
//Switching back to top frame
		 driver.switchTo().parentFrame();	
//Switching to default content
		 driver.switchTo().defaultContent();		 

		 
//Since title is not available getting the url
		 System.out.println("The Url is: " +driver.getCurrentUrl());
		
	}

}

