

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RequestBtnTest {
  private WebDriver driver;
  private String driverLocation = "C:\\newton\\geckodriver.exe";
  private String driverName ="webdriver.gecko.driver";
  private String baseUrl;
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
  public void testRequestBtn() throws Exception {
	  
	//Open Newton landing page
    driver.get(baseUrl + "/");
    String validEmail;
    
    // open request demo link
    driver.findElement(By.linkText("Request a Demo")).click();
    
    //enter strinds into fields
    driver.findElement(By.id("firstName")).clear();
    driver.findElement(By.id("firstName")).sendKeys("David");
    driver.findElement(By.id("lastName")).clear();
    driver.findElement(By.id("lastName")).sendKeys("Cronin");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("asdfjaosdfoa*&h");
    driver.findElement(By.id("phone_number")).clear();
    driver.findElement(By.id("phone_number")).sendKeys("720-281-7406");
    driver.findElement(By.id("company")).clear();
    driver.findElement(By.id("company")).sendKeys("testing something");
    
    //select drop down
    new Select(driver.findElement(By.id("size"))).selectByIndex(1);
    
    //Submit form
    driver.findElement(By.className("submit")).click();
    
    //Verify Email is invalid
    validEmail = driver.findElement(By.id("email")).getAttribute("class");
    System.out.println(validEmail);
    assertEquals("invalid", validEmail);
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
