package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DressSite {

    private WebDriver driver;
    private static Logger LOGGER = Logger.getGlobal();

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/resources/drivers/chromedriver.exe");
        
        ChromeOptions cOptions = new ChromeOptions();
		cOptions.setHeadless(false);
		
		driver = new ChromeDriver(cOptions);
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
                
        

    }
    
    @After
    public void tearDown() {
        driver.quit();
        
    }
    
    @Test
    public void dressSearch() {
        LOGGER.warning("Connecting to site");
        driver.get("http://automationpractice.com/index.php");
        WebElement search = driver.findElement(By.cssSelector("#search_query_top"));
        String item = "dress";
    	search.sendKeys(item);
        WebElement submit = driver.findElement(By.cssSelector("#searchbox > button"));
        submit.click();
        WebElement resultItem = driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.product_img_link > img") );
        resultItem.click();
        WebElement itemName = driver.findElement(By.cssSelector("h1"));
        assertEquals("Printed Summer Dress", itemName.getText());
        
    }
}
