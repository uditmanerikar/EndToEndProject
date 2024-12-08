package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j



import net.bytebuddy.asm.Advice.This;

public class baseClass  {
	//reuable class
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"OS","browser"})
	public void setup(String os,String br) throws IOException 
	{ 
		
		FileReader f=new FileReader("./src//test//resources//Config.properties");
	    p=new Properties();
	    p.load(f);
		logger=LogManager.getLogger(this.getClass());//Log4j
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if(os.equals("Windows")) 
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if (os.equals("mac"))
			{
				cap.setPlatform(Platform.MAC);	
			}
			else if (os.equals("linux"))
			{
				cap.setPlatform(Platform.LINUX);	
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			switch(br.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome");
			break;
			case "edge": cap.setBrowserName("MicrosoftEdge");
			break;
			case "firefox": cap.setBrowserName("firefox");
			break;
			default: System.out.println("No Browser");
			return;
			}
		driver =new RemoteWebDriver(new URL("http://192.168.1.10:4444/wd/hub"),cap);
		}
			
			if(p.getProperty("execution_env").equalsIgnoreCase("local")) 
			{
				switch(br.toLowerCase())
				{
				case "chrome":driver=new ChromeDriver();
				break;
				case "firefox":driver=new FirefoxDriver();
				break;
				case "edge":driver=new EdgeDriver();
				break;
				default:System.out.println("Invalid browser");
				return;
				}
			}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("ApplicationURL"));
		driver.manage().window().maximize();
	}
	@AfterClass (groups= {"Sanity","Regression","master"})
	public void tearDown() {
		
		driver.quit();
	}
	public String randowmstring() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randowmNumber() {
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	public String randomalphanumeric() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return(generatedString+"@"+generatedNumber);
	}
public String capturescreenshot(String tname) {
	String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot  screenshot=(TakesScreenshot) driver;
	File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
	String TargetFilepath=System.getProperty("user.dir")+"\\screenshots\\"+ tname +" " + timestamp + ".png ";
	File targetFile=new File(TargetFilepath);
	sourceFile.renameTo(targetFile);
	return timestamp;
}

	}
