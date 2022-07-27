package TogeeSmoke.Togee;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class Example {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
		prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
		option.setExperimentalOption("prefs", prefs);

		
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		//WebDriver driver=new ChromeDriver();  
	    
				
		// Launching chrome browser  
		driver.manage().window().maximize();
		driver.navigate().to("http://www.google.com/");
		
		// opening Togee client
		String url = "https://host.togee.io/";
		driver.get(url);
	    
	    //Clicking on the CTA button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("chat_plugin_icon")).click();
		
		//select the room type (private in this case) and move next
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("togee_card2")).click();
		driver.findElement(By.className("footer_next_btn")).click();
		
		//Creating the room
		driver.findElement(By.className("name_input")).sendKeys("Armishh");
		driver.findElement(By.className("cw_footer_create_btn")).click();
		
		//Sending message
        driver.findElement(By.className("tlss_feature_message")).click();
      		
        for (int i=1; i<=50; i++)
        {
      			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      			driver.findElement(By.className("tlss_message_input")).sendKeys("Armishh" + i);	
      			driver.findElement(By.className("tlss_message_input_send_icon")).click();					
      	}
		
		
		/*Inviting the participants
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.className("tlss_invitation_button")).click();
				
		
		//Turning the camera on
		driver.findElement(By.className("tlss_camera_enabled_icon")).click();
		
		//Draw doodle on the screen
		driver.findElement(By.className("tlss_feature_doddle")).click();
		driver.findElement(By.className("tlss_doddle_color_picker_button")).click();
		driver.findElement(By.className("tlss_doddle_color3")).click();
		
		// Create object of actions class
		Actions act=new Actions(driver);

		// find element which we need to drag
		WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));

		// find element which we need to drop
		WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));

		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();

		
			
		/*Open the menu handle
		WebElement handle = driver.findElement(By.className("tlss_drag_menu_bar"));
		
		//copying the clip board content into a variable	 
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        String paste = (String) c.getContents(null).getTransferData(DataFlavor.stringFlavor);
        
        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.gecko.driver", "C:\\GecoDriver\\geckodriver.exe");
        
        //Instantiating driver object and launching browser
        driver = new FirefoxDriver();
        
        //Using get() method to join as a viewer
        driver.get(paste); 
        //playing the show
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("video-play-button")).click();
        
        //Sending message
        driver.findElement(By.className("tlss_feature_message")).click();
      		
        for (int i=1; i<=10; i++)
        {
      			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      			driver.findElement(By.className("tlss_message_input")).sendKeys("Armishh" + i);	
      			driver.findElement(By.className("tlss_message_input_send_icon")).click();					
      	}
      		
      	driver.findElement(By.className("tlss_feature_message")).click();
      		
      	//Marking the page as starred
      	driver.findElement(By.className("tlss_feature_star")).click();
      	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      	
      	**/	
	}
}
