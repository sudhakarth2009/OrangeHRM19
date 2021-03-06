package firstdemo6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tco4_Data_Provider5 {
	WebDriver driver;
 
	//Step1 declared my global variables
	//String UserName="Admin",Password="admin123";
	//String Job_Title="Java2",Job_Description="Java Course2",Job_Note="Java details2";
	
	
	//step1
	 @DataProvider(name = "Test1")
	  public static Object[][] MyData() throws Exception {
	        return new Object[][] { 
	        	{ "Admin","admin123","Java4","Java Course4","Java details4" },
	        	{ "Admin","admin123","Java5","Java Course5","Java details5" },
	        	{ "Admin","admin123","Java6","Java Course6","Java details6" }
	        	};
	  }
	 
	
	
	//step2
	@Test(dataProvider="Test1")
	public void loginTest(String TestURL,String UserName,String Password,String Job_Title,String Job_Description, String  Job_Note ) throws Exception //step3
	{
		
		//Creating T1 object for the class tc03
		tco4_Data_Provider5  T2= new tco4_Data_Provider5();
		
		//calling my methods
		T2.OpenBrowser(TestURL);
		
		//step2
		T2.Login(UserName,Password);
		
		//step2
		T2.AddJobs(Job_Title,Job_Description,Job_Note);
		
		T2.CloseBrowser();
		
	}
	
	
	
	
	public  void OpenBrowser(String TestURL1) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		driver.get(TestURL1);
	}
	
	
	public void Login(String Uname,String PWD) throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys(Uname);
		findElement(By.name("txtPassword")).sendKeys(PWD);
		findElement(By.id("btnLogin")).click();
	}
	
	public void AddJobs(String Job_Title1,String Job_Description1,String Job_Note1) throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(Job_Title1);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(Job_Description1);
		findElement(By.id("jobTitle_note")).sendKeys(Job_Note1);
		findElement(By.id("btnSave")).click();	
	}
	
	
	public void CloseBrowser() throws Exception
	{
		  driver.quit();
	}
	
	
	
	 public  WebElement findElement(By by) throws Exception 
	 {
	
			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
	 }

	
	
}
