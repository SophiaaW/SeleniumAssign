/**
 * Created by sophiawen on 5/21/17.
 */
import org.apache.commons.io.input.ReaderInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp {
    public static void main(String[] args) {
        String lastName = "wen";
        String firstName = "Sophia";
        String email = "Sophiawen77@gmail.com";
        String companyName = "Apptimize Candidate";
        String password = "1234Zaqwsx";
        Boolean purchased = false;


            if(args.length == 6){
                lastName = args[0];
                firstName = args[1];
                email = args[2];
                companyName = args[3];
                password = args[4];
                purchased =Boolean.parseBoolean(args[5]);

            } else if (args.length != 0){
                System.out.println("make sure you put your last name. first name, email, company name, password and whether you purchased it before");
                System.exit(0);
            }



        signUp(lastName,firstName,email,companyName,password,purchased);

    }

    public static void signUp(String lastName, String firstName, String email, String companyName, String password, boolean purchased){

        System.setProperty("webdriver.gecko.driver", "/Users/sophiawen/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://apptimize.com/");

        //find the sign in button
        WebElement SignIn = driver.findElement(By.className("navbar__btn-register"));
        SignIn.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //find the first form field and type the first name into the field.
        WebElement fname = driver.findElement(By.id("fname"));
        fname.sendKeys(firstName);

        //Find the lastname form field and type the last name into the field
        WebElement lname = driver.findElement(By.id("lname"));
        lname.sendKeys(lastName);

        //Find the company form field and type the companyname into the field
        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys(companyName);

        //Find the work email form field and type the email into the field
        WebElement workEmail = driver.findElement(By.id("email"));
        workEmail.sendKeys(email);

        //find the password form field and type the password into the field.
        WebElement passw = driver.findElement(By.id("password"));
        passw.sendKeys(password);

        if(purchased){
            WebElement yes = driver.findElement(By.xpath("//input[@type='radio' and @name='purchased' and @value='Yes']"));
            yes.click();
        }else{
            WebElement no = driver.findElement(By.xpath("//input[@type='radio' and @name='purchased' and @value='No']"));
            no.click();
        }

        WebElement checkbox = driver.findElement(By.id("eula"));
        checkbox.click();

        WebElement signUpButton = driver.findElement(By.id("submit"));
        signUpButton.click();

    }
}
