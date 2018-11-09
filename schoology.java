package readingQuizes;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class schoology {

	public static void main(String[] args) {
		
		
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam\\eclipse-workspace\\SchoologyTaker\\chromedriver.exe");		    
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--start-maximized");
		  WebDriver driver = new ChromeDriver(options);
			  driver.get("https://school.district196.org/login/ldap?destination=home%2Frecent-activity&school=967827650");
			  WebElement mail = driver.findElement(By.id("edit-mail"));
			  mail.sendKeys("787115");
			  WebElement pass = driver.findElement(By.id("edit-pass"));
			  pass.sendKeys("w3irDpa$$w0rD");
			  pass.submit();
			  WebDriverWait wait = new WebDriverWait(driver, 5);
			  //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"header\\\"]/header/nav/ul[1]/li[2]/div/button")));
			  driver.findElement(By.xpath("//*[@id=\"header\"]/header/nav/ul[2]/li[1]/button")).click();
			  driver.findElement(By.xpath("//*[@id=\"header\"]/header/nav/ul[2]/li[1]/ul/li/label/input")).sendKeys("AP AMER GOV & POL A");
			  driver.findElement(By.xpath("//*[@id=\"header\"]/header/nav/ul[2]/li[1]/ul/li[2]/a")).click();
			  driver.findElement(By.xpath("//*[@id=\"course-events\"]/div[2]/div/div[4]/h4/a")).click();
			  driver.findElement(By.xpath("//*[@id=\"tabs-wrapper\"]/ul/li[3]/div/a")).click();
			  //driver.findElement(By.xpath("//*[@id=\"begin-test-quiz\"]")).click();
			  driver.findElement(By.xpath("//*[@id=\"edit-resume-1\"]")).click();
		  
			  
			  String aSum = driver.findElement(By.xpath("//*[@id=\"assessment-fill-status\"]")).getText();
			  
			  
			  
			  String[] getQNum  = aSum.split(" ",5);
			  int numQs = Integer.parseInt(getQNum[3]);
			  
			  String[]qs = new String[numQs];
			  
			  for(int i=3; i<numQs+3; i++) {
				  String qNum = driver.findElement(By.xpath("//*[@id=\"s-assessment-question-fill-form\"]/div/div["+i+"]/div[1]/span[1]")).getText();
				  String q = driver.findElement(By.xpath("//*[@id=\"s-assessment-question-fill-form\"]/div/div["+i+"]/div[1]/div/p")).getText();
				  if(q.equals(" ")) {
					  qs[i-3]=qNum + "\nNO QUESTION";
				  } else {
					  qs[i-3]=qNum + "\n" + q;
				  }
			  }
			  
			  for(String s:qs)System.out.println(s);
		  }
	
		  
	}


