package readingQuizes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class schoology {

	public static void main(String[] args) {
		
		
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam\\eclipse-workspace\\SchoologyTaker\\chromedriver.exe");		    
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--start-maximized");
		  WebDriver driver = new ChromeDriver(options);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  driver.get("https://school.district196.org/login/ldap?destination=home%2Frecent-activity&school=967827650");
			  driver.findElement(By.id("edit-mail")).sendKeys("studentID");
			  WebElement pass = driver.findElement(By.id("edit-pass"));
			  pass.sendKeys("password");
			  pass.submit();
			  
			  String className="AP AMER GOV & POL A";
			  String assignName="14.3 Reading Quiz Due P. 388 - 396";
			  
			 
			  driver.findElement(By.xpath("//*[@id=\"header\"]/header/nav/ul[2]/li[1]/button")).click();
			  driver.findElement(By.xpath("//*[@id=\"header\"]/header/nav/ul[2]/li[1]/ul/li/label/input")).sendKeys(className);
			  
			  
			  driver.findElement(By.xpath("//*[@id=\"header\"]/header/nav/ul[2]/li[1]/ul/li[2]/a")).click();
			  driver.findElement(By.xpath("//*[@id=\"course-profile-materials\"]/div[1]/div[2]/div/div/span")).click();
			  
			  driver.findElement(By.xpath("//*[@id=\"course-profile-materials\"]/div[1]/div[2]/div/ul/li[3]/a")).click();
			  														
			
			
			  boolean searching=true;
			  for(int i=1;searching;i++) {
				  try {
					  WebElement quiz = driver.findElement(By.xpath("//*[@id=\"course-profile-materials\"]/div[2]/div/div["+i+"]/div/div[3]/div[1]/a"));
					  if(quiz.getText().equals(assignName)) {
						  searching=false;
						  driver.findElement(By.xpath("//*[@id=\"course-profile-materials\"]/div[2]/div/div["+i+"]/div/div[3]/div[1]/a")).click();
					  }
				  } catch(NoSuchElementException e) {
					  searching=false;
					  System.out.println("quiz ("+assignName+") not found");
				  }
			  }
			  driver.findElement(By.xpath("//*[@id=\"tabs-wrapper\"]/ul/li[3]/div/a")).click();
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
			  driver.quit();
		  }
	
		  
	}


