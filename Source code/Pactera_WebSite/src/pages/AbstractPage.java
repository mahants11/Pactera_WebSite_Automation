package pages;
import org.openqa.selenium.WebDriver;
import test.AbstractTestDriver;


/**
 * @Description Abstract base class for all page object classes.
 * @author 		Mahantesh
 */

public class AbstractPage {
	protected WebDriver driver;

	public AbstractPage (WebDriver driver)
	{
		this.driver =driver;
	}
	
	public HomePage navigatePactera()
	{
		driver.navigate().to(AbstractTestDriver.BaseURL);
		return new HomePage(driver);
	}
}