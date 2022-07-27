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

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {


	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws HeadlessException, UnsupportedFlavorException, IOException, InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		
		//Allowing the camera and mic permissions
		Map<String, Object> prefs = new HashMap<String, Object>();
	    
	    option.addArguments("auto-select-desktop-capture-source=Entire screen");
	    //chromeOptions: [auto-select-desktop-capture-source="Entire screen"];
		prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
		prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
		option.setExperimentalOption("prefs", prefs);

		
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//WebDriver driver=new ChromeDriver();  
	    		
		//Maximizing the browser 
		driver.manage().window().maximize();
		
		//Opening togee client
		driver.navigate().to("https://dropinn.shop/");
		
		//Waiting for the CTA button to display
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("chat_plugin_icon")));
	    
	    //Clicking on the CTA button
		driver.findElement(By.className("chat_plugin_icon")).click();
		
		//Select the room type (private in this case) and move next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("togee_card2")));
		driver.findElement(By.className("togee_card2")).click();
		driver.findElement(By.className("footer_next_btn")).click();
		
		//Creating the room
		driver.findElement(By.className("name_input")).sendKeys("Armishh");
		driver.findElement(By.className("cw_footer_create_btn")).click();
		
		//Inviting the participants
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tlss_invitation_button")));
		driver.findElement(By.className("tlss_invitation_button")).click();
		Thread.sleep(5000);
		
		//Turning the screenshare on
		driver.findElement(By.className("tlss_feature_screen_share")).click();
		
		//Sending message
        driver.findElement(By.className("tlss_feature_message")).click();
      		
        for (int i=1; i<=10; i++)
        {
      			driver.findElement(By.className("tlss_message_input")).sendKeys("Armishh" + i);	
      			driver.findElement(By.className("tlss_message_input_send_icon")).click();					
      	}
        
        //Closing the message option
        driver.findElement(By.className("tlss_feature_message")).click();
      	
        
		//Turning the camera on (the mic gets enabled by default with it)
		driver.findElement(By.className("tlss_camera_enabled_icon")).click();
		
		
		// Create object of actions class
		Actions act = new Actions(driver);
	
		//Draw doodle on the screen
		driver.findElement(By.className("tlss_feature_doddle")).click();
		driver.findElement(By.className("tlss_doddle_color_picker_button")).click();
		driver.findElement(By.className("tlss_doddle_color2")).click();	
				 
		WebElement from1 = driver.findElement(By.xpath("//*[@data-id='bags']"));
		WebElement to1 = driver.findElement(By.xpath("//*[@data-id='shoes']")); 
		act.dragAndDrop(from1, to1).perform();
		
		driver.findElement(By.className("tlss_doddle_color3")).click();
		WebElement from2 = driver.findElement(By.xpath("//*[@data-id='blazers']"));
		WebElement to2 = driver.findElement(By.cssSelector("img[src='https://dropinn.shop/wp-content/uploads/2022/05/unsplash_b4Xk6bzgQWU-1-240x300.png']"));	
		act.dragAndDrop(from2, to2).perform();
		
		driver.findElement(By.className("tlss_doddle_color4")).click();	
		WebElement from3 = driver.findElement(By.xpath("//*[@data-id='hoodies']"));
		WebElement to3 = driver.findElement(By.cssSelector("img[src='https://dropinn.shop/wp-content/uploads/2022/05/unsplash_KVDSfJ79_JU-240x300.png']"));
		act.dragAndDrop(from3, to3).perform();
				
		driver.findElement(By.className("tlss_doddle_color8")).click();	
		WebElement from4 = driver.findElement(By.xpath("//*[@data-id='tops']"));
		WebElement to4 = driver.findElement(By.cssSelector("img[src='https://dropinn.shop/wp-content/uploads/2022/05/unsplash_SLDpJ6UB1Qs-200x300.png']"));
		act.dragAndDrop(from4, to4).perform();
		
		//undoing the doodle
		
		driver.findElement(By.className("tlss_doddle_undo_icon_container")).click();
		driver.findElement(By.className("tlss_doddle_undo_icon_container")).click();
		
		//redoing the doodle		
		driver.findElement(By.className("tlss_doddle_redo_icon_container")).click();
		driver.findElement(By.className("tlss_doddle_redo_icon_container")).click();
		
		//Closing the doodle option
		driver.findElement(By.className("tlss_feature_doddle")).click();
		  	
      	//Marking the home page as favorite
		driver.findElement(By.className("tlss_feature_star")).click();
		
		//Waiting for the page to be marked favorite
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'tlss_fs_container')]//*[local-name()='svg']/*[local-name()='path'][@style='fill: rgb(255, 255, 255);']")));
		
		//Navigate to the other page when home screen gets marked favorite
		WebElement shoe = driver.findElement(By.cssSelector("img[src='https://dropinn.shop/wp-content/uploads/2022/05/unsplash_b4Xk6bzgQWU-1-240x300.png']"));
      	act.doubleClick(shoe).build().perform();
      	
      	//Marking the other page as favorite again
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tlss_feature_star")));
      	driver.findElement(By.className("tlss_feature_star")).click();
      	
      	//Waiting for the page to be marked favorite
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'tlss_fs_container')]//*[local-name()='svg']/*[local-name()='path'][@style='fill: rgb(255, 255, 255);']")));
          	 
        // scrolling up the menu handle
     	WebElement drag = driver.findElement(By.className("tlss_dmb_child1"));		
        act.clickAndHold(drag).moveByOffset(0,-40).release().perform();
        
        //scrolling down the menu handle again
     	//act.clickAndHold(drag).moveByOffset(0,40).release().perform();
      	
		//sending starred items to the email      
        wait.until(ExpectedConditions.presenceOfElementLocated (By.className("tlss_sclc_send_email_input")));
        driver.findElement(By.className("tlss_sclc_send_email_input")).sendKeys("Armish719@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.className("tlss_sclc_send_email_button")).click();
        Thread.sleep(2000);
              
        //Ending the room
        driver.findElement(By.className("tlss_starred_page_list_footer_end_room_button")).click();
        Thread.sleep(2000);
        
        //sending recordings and insights to the email
        driver.findElement(By.className("tpsc_sdc_input")).sendKeys("Armish719@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.className("tpsc_sdc_send_button")).click();
        Thread.sleep(2000);
        
        //sending starred items to an email after ending the show
        driver.findElement(By.xpath("//*[contains(text(),'See starred items')]")).click();
        driver.findElement(By.className("tlss_sclc_send_email_input_post")).sendKeys("Armish719@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.className("tlss_sclc_send_email_button_post")).click();
        driver.findElement(By.className("tlss_drag_menu_bar_container_text_post")).click();
        Thread.sleep(2000);
        
        //visiting the client site
        driver.findElement(By.xpath("//*[contains(text(),'Go to')]")).click();
        
        /*
        					
		//Copying the clip board content into a variable	 
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        String paste = (String) c.getContents(null).getTransferData(DataFlavor.stringFlavor);
        
        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.gecko.driver", "C:\\GecoDriver\\geckodriver.exe");
        
        //Instantiating driver object and launching browser
        driver = new FirefoxDriver();
        
        //Using get() method to join as a viewer
        driver.get(paste); 
        //playing the show
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("video-play-button")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("video-play-button")).click();
        
        **/        
	}
}
