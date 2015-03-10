package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @Description Abstract class for the driver object. this class is extended by all classes which requires driver object
 */

public class AbstractTestDriver {

	protected static  WebDriver driver;
	private static String _TestSuiteName="Pactera.com";
	public static String BROWSER 		= "";
	public static String DRIVER_PATH ="";

	// Test Environment information
	public static String BaseURL 		= "http://www.pactera.com/"; 

	// Timeout values in seconds
	public static final int QUICK_TIMEOUT = 10;
	public static final int MAX_TIMEOUT   = 120;

	// Search String informations
	public static String SEARCH_STRING 	= "Test Automation";

	/**
	 * @Description this is a setUpBeforeClass,executed before test suite execution
	 */
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		//User need to input Browser and corresponding Driver.exe path through command line
		seletcBrowser();
		System.out.println("********************************* Executing Test Suite : " + _TestSuiteName + "  *********************************");
		System.out.println("");
	}

	/**
	 * @Description this is a tearDownAfterClass,executed after test suite execution
	 */

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("********************************* End of Test Suite : " + _TestSuiteName + "  *********************************");
	}

	/**
	 * @Description this is a setup method for test method. this method is called before executing each test method
	 */

	@Before
	public void setUp() throws Exception {

		// Initialize browser 
		driver = initializeDriver();
	}

	/**
	 * @Description this is a tear-down method for test method. this method is called after executing each test method
	 */

	@After
	public void tearDown() throws Exception {
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("");

		try {
			driver.quit();
		} catch (Throwable e) {
		}
	}

	/**
	 * @Description Method to initialize the driver instance
	 * @return 		WebDriver :- instance of the WebDriver
	 * @throws 		Exception
	 */

	private WebDriver initializeDriver() throws Exception {

		WebDriver driver;
		DesiredCapabilities capabilities;

		// Initialize webdriver instance
		if ("FIREFOX".equals(BROWSER)) {
			driver = new FirefoxDriver();
		} else if ("IE".equals(BROWSER)) {
			System.setProperty("webdriver.ie.driver",DRIVER_PATH );
			driver = new InternetExplorerDriver();
		} else if ("IE_32_BIT".equals(BROWSER)) {
			System.setProperty("webdriver.ie.driver", DRIVER_PATH);
			driver = new InternetExplorerDriver();
		} else if ("IE_64_BIT".equals(BROWSER)) {
			System.setProperty("webdriver.ie.driver", DRIVER_PATH);
			driver = new InternetExplorerDriver();
		} else if ("CHROME".equals(BROWSER)) {
			System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
			driver = new ChromeDriver();
		} else if ("SAFARI".equals(BROWSER)) {
			capabilities = DesiredCapabilities.safari();
			capabilities.setCapability("webdriver.safari.noinstall", true);
			driver = new SafariDriver(capabilities);
		} else if ("PHANTOM_JS".equals(BROWSER)) {
			capabilities = DesiredCapabilities.phantomjs();
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, DRIVER_PATH);
			driver = new PhantomJSDriver(capabilities);
		} else {

			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(MAX_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	/**
	 * @Description Method to get the input for Browser and it's corresponding EXE
	 * @return 	:Nothing
	 */

	private static void seletcBrowser() {
		System.out.println("Please select approrite browser which is installed on your machine:(IE/FIREFOX/CHROME)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			BROWSER = reader.readLine();

			if(BROWSER.equals("IE"))
			{
				System.out.println("Executing Test Cases in IE");
				System.out.println("Please Enter the IE Driver Path");
				BufferedReader path = new BufferedReader(new InputStreamReader(System.in));
				DRIVER_PATH = path.readLine();
			}
			else if(BROWSER.equals("FIREFOX"))
			{
				System.out.println("Executing Test Cases in FIREFOX");
			}

			else if(BROWSER.equals("CHROME"))
			{
				System.out.println("Executing Test Cases in CHROME");
				System.out.println("Please Enter the Chrome Driver Path");
				BufferedReader path = new BufferedReader(new InputStreamReader(System.in));
				DRIVER_PATH = path.readLine();
			}
			else
			{
				System.out.println("Executing Test Cases in default browser:FireFox");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}





