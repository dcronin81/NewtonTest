

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class videoBtnTest {
  private WebDriver driver;
  private String baseUrl;
  private String driverLocation = "C:\\newton\\geckodriver.exe";
  private String driverName ="webdriver.gecko.driver";
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty(driverName,driverLocation);
    driver = new FirefoxDriver();
    baseUrl = "http://newtonsoftware.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testVideoBtn() throws Exception {
    driver.get(baseUrl + "/");
    int videoPresent = 0;
    int videoPlaying = 0;
    int videoPaused = 0;
    String playingTime1 = "0";
    String playingTime2 = "0";
    String pauseTime1 = "0";
    String pauseTime2 = "0";
    
    //click open video link
    driver.findElement(By.linkText("Watch our video and learn more about our ATS")).click();
    Thread.sleep(3000);
    String ParentFrame = driver.getWindowHandle( ); 
    
    //Switch to appropriate frame
    driver.switchTo().defaultContent(); // you are now outside both frames
    driver.switchTo().frame(driver.findElement(By.className("venoframe"))); // switch to iframe
    
    //verify video is present
    if( driver.findElement(By.className("video")).isDisplayed()){
    	videoPresent = 1;
    	}
    else
    	videoPresent = 0;
    assertEquals(1, videoPresent);
    
    //play video
    driver.findElement(By.className("play")).click();
    
    
    //verifying playing
    Thread.sleep(2000);
    playingTime1 = driver.findElement(By.className("timecode")).getAttribute("style");
    Thread.sleep(2000);
    playingTime2 = driver.findElement(By.className("timecode")).getAttribute("style");
    if (!playingTime1.equals(playingTime2) ){
    	videoPlaying = 1;
    }
    assertEquals(1, videoPlaying);
    Thread.sleep(1000);
    
    
    //pause video
    driver.findElement(By.className("play")).click();
    Thread.sleep(2000);
    
    //verify pausing video
    Thread.sleep(1000);
    pauseTime1 = driver.findElement(By.className("timecode")).getAttribute("style");
    Thread.sleep(1000);
    pauseTime2 = driver.findElement(By.className("timecode")).getAttribute("style");
    if (pauseTime1.equals(pauseTime2) ){
    	videoPaused = 1;
    }
    assertEquals(1, videoPaused);
    Thread.sleep(1000);
    
    //switch to appropriate frame to close video
    driver.switchTo().defaultContent(); // you are now outside both frames
    driver.switchTo().window(ParentFrame); 
    
    //close video
    driver.findElement(By.className("vbox-close")).click();
    
    //verify video is closed through try and catch
    try {
    	driver.findElement(By.className("video"));
        fail("Video is present");
    } catch (NoSuchElementException ex) {} 

   }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
