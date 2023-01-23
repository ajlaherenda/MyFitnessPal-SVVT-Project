package herenda.SVVTProject;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class webTesting {
	
	private static WebDriver webDriver;
	private static String baseUrl;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		//System.setProperty("webdriver.chrome.driver","/Users/ajlaherenda/Downloads/chromedriver"); //lokacija chromedrivera
		System.setProperty("webdriver.chrome.driver", "/Users/ajlaherenda/Downloads/chromedriver_mac64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		webDriver = new ChromeDriver(options);
		baseUrl = "https://www.myfitnesspal.com/";
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		webDriver.quit();
	}
    
	
	/*testing the functionalities/options found behind the START FOR FREE button, using one of us's personal case in the decision making process, 
	 * regarding the direction in which the assessment will go in
	  alongside whether the first title on the last page we are brought to is equal to "How tall are you?"
	*/
	

	@Test
	void testHowTallAreYouTitleContent() throws InterruptedException {
		
		webDriver.get(baseUrl);
		
		//in case we are displayed the cookie message, we will offer some wait time for the user to disclose that
		WebDriverWait longerWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));	
		
		WebElement startForFree = longerWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div[1]/div/a")));
		startForFree.click();

		WebElement continueButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/section/div/main/div/div/div[2]/button")));
		continueButton.click();
		
		WebElement looseWeight = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div/button[1]/p")));
		looseWeight.click();
		webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/nav/button")).click();
		
		WebElement notVeryActive = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > section > div > main > div > form > div > div:nth-child(2) > div > button:nth-child(1) > div > p.MuiTypography-root.MuiTypography-body1.css-ecsye2")));
	    notVeryActive.click();
	    webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[3]/nav/button")).click();
	    
	    //fill out info in order to calculate calories sufficient for that particular goal
	    WebElement femaleRadioButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[1]/div/label[2]/span[1]")));
	    femaleRadioButton.click();
	    
	    
	    WebElement dateOfBirth = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[2]/div/div/div/div/div/button"));
	    dateOfBirth.click();
	    WebElement calendar = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[1]/div[1]/button"));
	    calendar.click();
	    WebElement year = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[102]/button"));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
	    js.executeScript("arguments[0].scrollIntoView(true);", year);
	    year.click();
	    
	    WebElement month = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/button[2]"));
	    
	    for(int i = 0; i < 7; i++)
	    {
	    	month.click();
	    }
	    webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/button[1]")).click();
	    
	    webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[4]/nav/button")).click();
	            
	    Thread.sleep(1000);
	    String text = webDriver.findElement(By.xpath("/html/body/div[1]/section/div/main/div/form/div/div[1]/h1")).getText();
	    String compared_text_value = "How tall are you?";
	    
	    assertEquals(compared_text_value, text);

	}
	
	//test that checks weather we get a exception when creating the profile for a minor like expected
	@Test
	void testMinorAccountCreation() throws InterruptedException {
		
		//first few steps are the same as in the previous test
		
        webDriver.get(baseUrl);
		
		//in case we are displayed the cookie message, we will offer some wait time for the user to disclose that
		WebDriverWait longerWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));	
		
		WebElement startForFree = longerWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div[1]/div/a")));
		startForFree.click();

		WebElement continueButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/section/div/main/div/div/div[2]/button")));
		continueButton.click();
		
		WebElement maintainWeight = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div/button[2]")));
		maintainWeight.click();
		webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/nav/button")).click();
		
		WebElement active = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > section > div > main > div > form > div > div:nth-child(2) > div > button:nth-child(3)")));
	    active.click();
	    webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[3]/nav/button")).click();
	    
	    //fill out info in order to calculate calories sufficient for that particular goal
	    WebElement maleRadioButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[1]/div/label[1]/span[2]")));
	    maleRadioButton.click();
	    
	    
	    WebElement dateOfBirth = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[2]/div/div/div/div/div/button"));
	    dateOfBirth.click();
	    WebElement date = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/button[3]"));
	    date.click();
	    webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[4]/nav/button")).click();
        
	    String warning = webDriver.findElement(By.cssSelector("body > div.MuiDialog-root.MuiModal-root.css-16shgs3 > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiDialogContent-root.css-7bxm9z > p")).getText();
	    assertEquals("You must be 18 or older to use MyFitnessPal.", warning);
	    
	    WebElement contButton = webDriver.findElement(By.cssSelector("body > div.MuiDialog-root.MuiModal-root.css-16shgs3 > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiDialogActions-root.MuiDialogActions-spacing.css-1bqpj75 > a"));
	    contButton.click();
	   
	    Thread.sleep(1000);
		
	} 
	
	
	//we test the creation of the account with personal details of one of us and assert weather we agree on the terms and conditions of myfitnesspal
	@Test
	void testAccountCreation() throws InterruptedException {
        webDriver.get(baseUrl);
		
		//in case we are displayed the cookie message, we will offer some wait time for the user to disclose that
		WebDriverWait longerWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));	
		
		WebElement startForFree = longerWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div[1]/div/a")));
		startForFree.click();

		WebElement continueButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/section/div/main/div/div/div[2]/button")));
		continueButton.click();
		
		WebElement looseWeight = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div/button[1]/p")));
		looseWeight.click();
		webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/nav/button")).click();
		
		WebElement notVeryActive = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > section > div > main > div > form > div > div:nth-child(2) > div > button:nth-child(1) > div > p.MuiTypography-root.MuiTypography-body1.css-ecsye2")));
	    notVeryActive.click();
	    webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[3]/nav/button")).click();
	    
	    //fill out info in order to calculate calories sufficient for that particular goal
	    WebElement femaleRadioButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[1]/div/label[2]/span[1]")));
	    femaleRadioButton.click();
	    
	    
	    WebElement dateOfBirth = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[2]/div/div/div/div/div/button"));
	    dateOfBirth.click();
	    WebElement calendar = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[1]/div[1]/button"));
	    calendar.click();
	    WebElement year = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[102]/button"));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
	    js.executeScript("arguments[0].scrollIntoView(true);", year);
	    year.click();
	    
	    WebElement month = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/button[2]"));
	    
	    for(int i = 0; i < 7; i++)
	    {
	    	month.click();
	    }
	    webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/button[1]")).click();
	    
	    webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[4]/nav/button")).click();
	       
	   
	    WebElement height = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("height-feet")));
	    height.sendKeys("5");
	    webDriver.findElement(By.name("height-inches")).sendKeys("4");
	    webDriver.findElement(By.name("weight_current_value")).sendKeys("114.64");
	    webDriver.findElement(By.id("Goal weight")).sendKeys("110.231");
	    
	    webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[4]/div/nav/button")).click();
	   
	    WebElement weightlossRate = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > section > div > main > div > form > div > div > button.MuiButtonBase-root.MuiToggleButton-root.Mui-selected.MuiToggleButton-sizeMedium.MuiToggleButton-standard.MuiToggleButtonGroup-grouped.MuiToggleButtonGroup-groupedVertical.css-ydgx1x > p")));
	    weightlossRate.click();
	    webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/nav/button/span")).click();
	    
	    
	    WebElement emailAddress = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
	    emailAddress.sendKeys("svvttestaccount@gmail.com");
	    webDriver.findElement(By.name("password")).sendKeys("aBcD1234eF");
	    
	    WebElement consent = webDriver.findElement(By.name("termsConsent"));
	    consent.click();
	    
	    assertEquals(true, consent.isSelected());
	    webDriver.findElement(By.xpath("//*[@id=\"__next\"]/section/div/main/div/form/div/div[4]/button[1]")).click();
	    Thread.sleep(10000);
	}
	
	
	//we test if after selecting the sign up option from the login button we will get a message that contains MyFitnessPal
	@Test
	void testSignUpFromLogIn() throws InterruptedException {
		 webDriver.get(baseUrl);
			
		 //in case we are displayed the cookie message, we will offer some wait time for the user to disclose that
		 WebDriverWait longerWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
		 WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
		 
		 WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		 loginButton.click();
		 Thread.sleep(1000);
		 webDriver.findElement(By.linkText("Sign up now!")).click();
		 WebElement message = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > section > div > main > div > div > div.MuiGrid-root.MuiGrid-item.css-10r4g2f > h1")));
		 String messageText = message.getText();
		 assertTrue(messageText.contains("MyFitnessPal"));
		
	}

	
	
    //we test the login feature using stimuli in form of our own account details (incorrect password) that we will feed the system
	@Test
	void testLogInFeature() throws InterruptedException {
		 webDriver.get(baseUrl);
			
		 //in case we are displayed the cookie message, we will offer some wait time for the user to disclose that
		 WebDriverWait longerWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
		 WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
		 
		 WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		 loginButton.click();
		 WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		 email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		 webDriver.findElement(By.id("password")).sendKeys("netacnasifra");
		 
		 webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();
		 
		 Thread.sleep(6000);
		 WebElement incorrectWarning = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div/div/form/div/div[1]/div[2]"));
		 String incorrectWarningText = incorrectWarning.getText();
		 assertTrue(incorrectWarningText.contains("Incorrect"));
		 
	}
	
	
	
	
	//test to see if the login was successful by ensuring the calorie in take is == to 1620
	@Test 
	void testSuccessOfLogin() throws InterruptedException {
		 webDriver.get(baseUrl);
			
		 //in case we are displayed the cookie message, we will offer some wait time for the user to disclose that
		 WebDriverWait longerWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
		 WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
		 
		 WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		 loginButton.click();
		 WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		 email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		 webDriver.findElement(By.id("password")).sendKeys("krokodil");
		 webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();
		 Thread.sleep(6000);
		 
		 WebElement calories = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/p")));
		 String numberOfCals = calories.getText();
		 assertEquals("1620", numberOfCals); 
		 Thread.sleep(10000);
		
 
	}

	
	/*We test the add food option for the breakfast meal by attempting to add oatmeal, scrolling into it using js and finally adding it as
	 part of the meal if the oats we have scrolled into and have clicked on to are of the brand Quaker.
	*/
	
	@Test
	void testAddQuakerOatsForBreakfast() throws InterruptedException {
		
		
		webDriver.get(baseUrl);
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
				 
		WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		loginButton.click();
		WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		webDriver.findElement(By.id("password")).sendKeys("krokodil");
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();  
		
		WebElement addFood = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/a/button")));
		addFood.click();
		
		WebElement addFoodBreakfast = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Food")));
		addFoodBreakfast.click();
		WebElement search = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		search.sendKeys("Oatmeal");
		webDriver.findElement(By.cssSelector("#searchFoodByName > form > p > input.button")).click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		WebElement optionsToChooseFrom = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("matching")));
		WebElement option = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dry Oatmeal")));
		js.executeScript("arguments[0].scrollIntoView(true);", option);
		option.click();
		WebElement oatmealInfo = webDriver.findElement(By.className("food-description"));
		Thread.sleep(1000);
		String oatmealName = oatmealInfo.getText();
		boolean value = oatmealName.contains("Quaker");
		
		if(value == false) {
		WebElement submitButton = webDriver.findElement(By.id("update_servings"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitButton);
		}	   
	    
	}
	
	
	
	/*We test adding milk as part of our breakfast, in order to match the oatmeal, but this time the amount of the chosen milk is not sufficient, instead we will be entering the amount
	 * of milk we need, adding it to our breakfast and checking if the total amount of proteins (for the milk) is as we have expected it to be.
	*/

	@Test
	void testAddMilkForBreakfast() throws InterruptedException {
		
		webDriver.get(baseUrl);
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
				 
		WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		loginButton.click();
		WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		webDriver.findElement(By.id("password")).sendKeys("krokodil");
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();  
		
		WebElement addFood = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/main/div[1]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/a/button")));
		addFood.click();
		
		WebElement addFoodBreakfast = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Food")));
		addFoodBreakfast.click();
		WebElement search = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		
		search.sendKeys("Milk");
		webDriver.findElement(By.cssSelector("#searchFoodByName > form > p > input.button")).click();
		WebElement option = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Milk, low fat, 1%")));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView(true);", option);
		option.click();
		Thread.sleep(1000);
		//hidden elements issue, so we had for each of those to type the code section below to make them visible
		js.executeScript("document.getElementById('food_entry_quantity').setAttribute('type','text');");
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/form/div/div[1]/input[3]")).click();
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/form/div/div[1]/input[3]")).clear();
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/form/div/div[1]/input[3]")).sendKeys("2.0");
		
		
		WebElement submitButton = webDriver.findElement(By.id("update_servings"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitButton);
	    
	    String milkProtein = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/span[1]"))).getText();
		
		assertEquals("16", milkProtein);
		
		
	} 
	
	
	/*
	 * In this test we will test if the meal we plan to have as our lunch, is going to leave us with a sufficient number of calories for dinner and the snack time, using assertions again.
	 * Prior to add, we will be adding chicken breast, sweet potato and a coke zero to complete our meal, keeping in mind that we will be modifying the amount of each food type.
	 */
	
    @Test
    void testLunchMeal() throws Exception {
    	
    	//base setup for using these features
    	webDriver.get(baseUrl);
    	    	
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
				 
		WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		loginButton.click();
		WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		webDriver.findElement(By.id("password")).sendKeys("krokodil");
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();  
		
		WebElement addFood = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Food")));
		addFood.click();
		
		WebElement lunch = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"diary-table\"]/tbody/tr[3]/td")));
	    WebElement addFoodLunch = webDriver.findElement(RelativeLocator.with(By.className("add_food")).below(lunch));

		addFoodLunch.click();
		WebElement search = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		//adding the chicken
		search.sendKeys("Chicken breast");
		webDriver.findElement(By.xpath("//*[@id=\"searchFoodByName\"]/form/p/input[4]")).click();
		
		WebElement meatOption = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Chicken Breast")));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView(true);", meatOption);
		meatOption.click();
		Thread.sleep(1000);
		
		js.executeScript("document.getElementById('food_entry_quantity').setAttribute('type','text');");
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/form/div/div[1]/input[3]")).click();
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/form/div/div[1]/input[3]")).clear();
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/form/div/div[1]/input[3]")).sendKeys("2.5");
		
		WebElement submitButton = webDriver.findElement(By.id("update_servings"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitButton);
	    
		
		
		//adding the sweet potato
		WebElement lunch1 = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"diary-table\"]/tbody/tr[3]/td")));
	    WebElement addFoodLunch1 = webDriver.findElement(RelativeLocator.with(By.className("add_food")).below(lunch));
		
		addFoodLunch1.click();
		Thread.sleep(1500);

		search.sendKeys("Sweet potato");
		webDriver.findElement(By.xpath("//*[@id=\"searchFoodByName\"]/form/p/input[4]")).click();
		WebElement sideOption = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sweet Potato")));
		js.executeScript("arguments[0].scrollIntoView(true);", sideOption);
		sideOption.click();
		Thread.sleep(1000);
		
		js.executeScript("document.getElementById('food_entry_quantity').setAttribute('type','text');");
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/form/div/div[1]/input[3]")).click();
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/form/div/div[1]/input[3]")).clear();
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/form/div/div[1]/input[3]")).sendKeys("2.0");
		
	  	js.executeScript("arguments[0].click();", submitButton);
	
		
		
		
		Thread.sleep(10000);
    }


	
	/*
	 * In this test we will test the "Quick add" option, since we would like to have chicken breast, sweet potato and a coke zero for lunch, but this is also our yesterday's lunch
	 * so all we have to do is click on the aforementioned button and prove whether it works.
	 */

	
	@Test
	void testQuickAdd() throws InterruptedException {
		//base setup for using these features
    	webDriver.get(baseUrl);
    	    	
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
				 
		WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		loginButton.click();
		WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		webDriver.findElement(By.id("password")).sendKeys("krokodil");
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();  
		
		WebElement addFood = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Food")));
		addFood.click();
		
		WebElement lunch = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"diary-table\"]/tbody/tr[3]/td")));
	    WebElement quickAddLunch = webDriver.findElement(RelativeLocator.with(By.className("toggle_diary_options")).below(lunch));
	    quickAddLunch.click();
	    WebElement copyYesterday = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Copy yesterday")));
	    copyYesterday.click();
	    
	    Thread.sleep(10000);
	}
	
	
	/*Test for writing into our food diary, for a date that has not happened yet, by exercising the calendar option. In order to prove that we have been moved to the 17th of January, we will assert
	 * the total number of calories on that day.
	 */

	
	@Test
	void testDiaryEntryForFutureDates() throws InterruptedException
	{
		//base setup for using these features
    	webDriver.get(baseUrl);
    	    	
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
				 
		WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		loginButton.click();
		WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		webDriver.findElement(By.id("password")).sendKeys("krokodil");
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();  
		
		WebElement addFood = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Food")));
		addFood.click();
		WebElement calendar = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepicker-trigger")));
		calendar.click();
		WebElement date = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("17")));
		date.click();
		WebElement totalCals = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"diary-table\"]/tbody/tr[10]/td[2]")));
		String total = totalCals.getText();
		
		assertEquals("0",total);
		
	}
	
	/*
	 * Test for checking if we can use the option of adding a new food into the database in case we are of the opinion that no database entry satisfies our needs.
	 */
	
	
	@Test
	void testAddFoodToDatabase() throws InterruptedException {
		
		//base setup for using these features
    	webDriver.get(baseUrl);
    	    	
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
				 
		WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		loginButton.click();
		WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		webDriver.findElement(By.id("password")).sendKeys("krokodil");
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();  
		
		WebElement addFood = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Food")));
		addFood.click();
		
		WebElement addFoodDinner = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div[2]/table/tbody/tr[11]/td[1]/a")));
		addFoodDinner.click();
		
		WebElement input = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		input.sendKeys("Ice cream");
		webDriver.findElement(By.cssSelector("#searchFoodByName > form > p > input.button")).click();
		
		WebElement addAFoodToTheDatabase = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add a food to the database")));
		addAFoodToTheDatabase.click();
		
		WebElement foodDescription = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("food_description")));
		foodDescription.sendKeys("Ice cream that does not exist in the database");
		webDriver.findElement(By.xpath("//*[@id=\"buttonPad\"]/input")).click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		WebElement nope = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/p[2]/a")));
		js.executeScript("window.scrollBy(0, 400);");
		nope.click();
	
		WebElement servingSize = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("weight_serving_size")));
		servingSize.sendKeys("100g");
		webDriver.findElement(By.id("servingspercontainer")).sendKeys("1");
		webDriver.findElement(By.xpath("//*[@id=\"buttonPad\"]/input[1]")).click();
		
		
	}
	
	/*
	 * This test examines the water consumption feature, by entering our water intake and asserting the total consumption value.
	 */
	
	@Test
	void testWaterConsumptionFeature() throws InterruptedException {
		

		//base setup for using these features
    	webDriver.get(baseUrl);
    	    	
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
				 
		WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		loginButton.click();
		WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		webDriver.findElement(By.id("password")).sendKeys("krokodil");
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();
		
		WebElement addFood = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Food")));
		addFood.click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		js.executeScript("window.scrollBy(0, 1125);");
		WebElement water250 = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div[4]/div[1]/ul/li[1]")));
		water250.click();
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[4]/div[1]/ul/li[2]")).click();
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[4]/div[1]/ul/li[3]")).click();
		webDriver.findElement(By.className("add-custom-amount")).sendKeys("125");
		webDriver.findElement(By.cssSelector("#main > div.block.water-notes-v2 > div.water-info > p:nth-child(7) > input.button.btn.btn-primary.add-custom-btn")).click();
		
		assertEquals("1875", webDriver.findElement(By.className("water-value-static")).getText());
		
	}
	
	
	/*
	 * The current test takes advantage of the feature, which allows us to change units of measurement by clicking on a variety of buttons, but prior to it being redirected to the according page.
	 */
	
	@Test
	void testModifyUnitsOfMeasurement() throws InterruptedException {
		
		
		//base setup for using these features
    	webDriver.get(baseUrl);
    	    	
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
				 
		WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		loginButton.click();
		WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		webDriver.findElement(By.id("password")).sendKeys("krokodil");
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();
		
		WebElement addFood = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Food")));
		addFood.click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 1125);");
		webDriver.findElement(By.linkText("Change Units")).click();
		
		WebElement pounds = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/main/form/div[1]/div/label[2]/span[2]")));
		pounds.click();
		js.executeScript("window.scrollBy(0, 1300);");
		webDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/form/div[2]/div/label[2]/span[1]/input"));
		webDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/form/div[3]/div/label[2]/span[1]/input"));
		webDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/form/div[5]/div/label[1]/span[1]/input"));
		
		
		WebElement saveChanges = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/main/form/div[6]/button")));
		saveChanges.click();
		
		WebElement alertMessage = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/main/div/div[2]")));
		
		assertTrue(alertMessage.getText().contains("updated")); 
		
	}
	
	

	/* This is a test where we will be scrolling down on the main page, finding the "Jobs" section, since MyFitnessPal is not
	 * only a service provider, but also an employer. Afterwards we are brought to a page to choose from departments, using a select object
	 * which will furthermore show us the list of open positions for our desired "Engineering" department, where we will assert if the position of the iOS intern is performed 
	 * remotely.
	 */
	
	@Test
	void howIsTheJobOfAnIosInternPerformed() throws InterruptedException {
		
		//base setup for using these features
    	webDriver.get(baseUrl);
        Thread.sleep(3000);
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		WebElement jobs = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/footer/div/ul/li[7]")));
		js.executeScript("arguments[0].scrollIntoView(true);", jobs);
		Thread.sleep(3000);
		jobs.click();
	    
		WebElement departments = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("departments-select")));
		Select department = new Select(departments);
		
		js.executeScript("arguments[0].scrollIntoView(true);", departments);
		
		department.selectByValue("36123");
		WebElement iOS = webDriver.findElement(By.linkText("iOS Engineer Intern"));
		WebElement location = webDriver.findElement(RelativeLocator.with(By.className("location")).below(iOS));
		String info = location.getText();
		
		assertEquals("Remote - US", info);
		Thread.sleep(10000);
		
	}
	
	/*
	 * The goal of this test is to go to the "Jobs" section of the web site, select "Engineering" jobs, under which we will be shown the 
	 * "iOS Engineering Intern" position, with which you already got acquainted in the previous task. Here we were furthermore supposed 
	 * to fill out needed details for the application process, but when we have decided to additionally upgrade the test it was found that 
	 * this position is no more available, which is the reason why this
	 * test fails and we thought it would be a nice touch to add a naturally failing test too.
	 */
	
	@Test
	void applyForIosIntern() throws InterruptedException {
		
		webDriver.get(baseUrl);
        Thread.sleep(3000);
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		WebElement jobs = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/footer/div/ul/li[7]")));
		js.executeScript("arguments[0].scrollIntoView(true);", jobs);
		Thread.sleep(3000);
		jobs.click();
	    
		WebElement departments = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("departments-select")));
		Select department = new Select(departments);
		
		js.executeScript("arguments[0].scrollIntoView(true);", departments);
		
		department.selectByValue("36123");
		Thread.sleep(2000);
		WebElement iOS = webDriver.findElement(By.linkText("iOS Engineer Intern"));
		iOS.click();
		//filling out the form
		webDriver.findElement(By.id("first_name")).sendKeys("Faris");
		webDriver.findElement(By.id("last_name")).sendKeys("Delic");
		webDriver.findElement(By.id("email")).sendKeys("farisdelic@gmail.com");
		webDriver.findElement(By.id("phone")).sendKeys("+387 62 333 444");
		WebElement location = webDriver.findElement(By.name("job_application[location]"));
		location.sendKeys("Sarajevo");
		location.sendKeys(Keys.ENTER);
		js.executeScript("window.scrollBy(0, 400);" );
		
	    webDriver.findElement(By.name("job_application[answers_attributes][0][text_value]")).sendKeys("https://www.linkedin.com");
	
	}
	
	/*
	 * The objectives of this test are to visit the "Blog" section on the page, where we will find a particular blog post under the trending
	 * articles with the title "15 Make-Ahead Breakfasts Under 300 Calories" and assert its value.
	 */
	
	
	@Test
	void testBlogContent() throws InterruptedException {
		
		webDriver.get(baseUrl);
		//Some Thread.sleep for handling the cookies
		Thread.sleep(5000);
		WebElement blog = webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div/ul/li[2]/a"));
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView(true);", blog);
		Thread.sleep(3000);
		
		blog.click();
		WebElement arrow = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[1]/ul/button[2]")));
		Thread.sleep(3000);
		for( int i = 0; i <= 3; i++)
		{
		  arrow.click();
		  Thread.sleep(2000);
		}
		webDriver.findElement(By.linkText("15 Make-Ahead Breakfasts Under 300 Calories")).click();
		WebElement title = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[2]/div[2]/section/h1")));
		assertEquals("15 Make-Ahead Breakfasts Under 300 Calories", title.getText());
		
		Thread.sleep(10000);
		
	}
	
	
	/*
	 * The goal of this test is to open the "Recipe" section on the MyFitnessPal blog web site, where we will search for a "Chickpea salad"
	 * and select the first listed option. After opening this page, we will decide to log this recipe into our daily food tracker, due to 
	 * which we will be forwarded to another page, whose url we will be asserting.
	 */
	 @Test
     void testBlogSearchForRecipe() throws InterruptedException
     {
		webDriver.get("https://blog.myfitnesspal.com/recipes/");
    	Thread.sleep(4500);
		WebElement search = webDriver.findElement(By.id("recipe-search"));
    	search.sendKeys("Chickpea salad", Keys.ENTER);
    	Thread.sleep(2500);
    	WebElement firstRecipe = webDriver.findElement(By.linkText("Eat the Rainbow Salad With Lemon Tahini Dressing"));
    	assertEquals("Eat the Rainbow Salad With Lemon Tahini Dressing", firstRecipe.getText());
        firstRecipe.click();    	
    	Thread.sleep(2000);

    	webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[2]/section/div[7]/div[1]/div[1]/div")).click();
    	
    	assertEquals("https://www.myfitnesspal.com/recipe/logit?url=https://blog.myfitnesspal.com/31370-eat-the-rainbow-salad-with-lemon-tahini-dressing2/", webDriver.getCurrentUrl());
    	Thread.sleep(10000);
     }
	
	
	
	/*
	 * The test below contains the attempt of changing the language of the page from English to Italian and afterwards asserting if the transition occured.
	 */
	
	@Test
	void testLanguageChange() throws InterruptedException {
		
		webDriver.get(baseUrl);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		WebElement languages = webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div/div[1]/select"));
		js.executeScript("arguments[0].scrollIntoView(true)", languages);
		Select language = new Select(languages);
		language.selectByValue("it");
		Thread.sleep(3000);
		WebElement headline = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/h1"));
		String text = "La salute inizia da ciò che mangi.";
		
		assertEquals(text, headline.getText());
				
	}

	
	/*
	 * 
	 */
	
	@Test
	void testFindingMapMyRunApp() throws InterruptedException {
		
		webDriver.get(baseUrl);
		Thread.sleep(3000);
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
	
		
	    webDriver.findElement(By.xpath("/html/body/div[1]/div/footer/div/nav/a[4]")).click();
		WebElement search = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-input")));
		search.sendKeys("MapMyRun");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
	}
	
	
	/*
	 * The following test asserts if the most recent exercise is "Walking, 10.5 mins per km, brisk pace".
	 */
	
	@Test
	void testRecentExercise() throws InterruptedException {
		
		//base setup for using these features
    	webDriver.get(baseUrl);
    	    	
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
				 
		WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		loginButton.click();
		
		WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		webDriver.findElement(By.id("password")).sendKeys("krokodil");
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();
		Thread.sleep(5000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/a/button")).click();
		webDriver.findElement(By.linkText("Add Exercise")).click();
		WebElement recentExercise = webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/table/tbody/tr/td[2]"));
		assertEquals("Walking, 10.5 mins per km, brisk pace", recentExercise.getText());

	}

	
	/*
	 * The current test attempts adding the most recent exercise, with it lasting 60.5 minutes and asserting that the amount of burned calories has now changed.
	 */
	
	@Test
	void testAddRecentExercise() throws InterruptedException
	{

		//base setup for using these features
    	webDriver.get(baseUrl);
    	    	
		WebDriverWait shorterWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
				 
		WebElement loginButton = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > header > div > div > a")));
		loginButton.click();
		
		WebElement email = shorterWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("ajla.herenda@treca-gimnazija.edu.ba");
		webDriver.findElement(By.id("password")).sendKeys("krokodil");
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/form/div/div[2]/button[1]")).click();
		Thread.sleep(5000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/a/button")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.linkText("Add Exercise")).click();

		
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/table/tbody/tr/td[1]/input[4]")).click();
		WebElement minutes = webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/table/tbody/tr/td[3]/input[1]"));
		minutes.sendKeys(".5");
		Thread.sleep(1500);
		WebElement caloriesBurned = webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/table/tbody/tr/td[3]/input[5]"));
		assertNotEquals("198", caloriesBurned.getText());
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[2]/div/input")).click();
		
	}
	

/*
 * THIS FILE CONTAINS ALL TESTS FROM THE PROJECT, BUT MAY ALSO CONTAIN TESTS WHICH WE HAVE TRIED TO TACKLE, BUT HAVE DECIDED TO NOT INCLUDE IN THE PROJECT DUE TO JUSTIFIED REASONS.
 */
	
	
	
	
	
	

}
