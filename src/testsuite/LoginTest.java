package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup(){

        openBrowser(baseUrl);
    }
    @Test
    //userSholdLoginSuccessfullyWithValidCredentials
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        // Enter user name
        sendTextToElement(By.id("username"),"tomsmith");
        //Enter Password
       sendTextToElement(By.name("password"),"SuperSecretPassword!");
       //Click on Login button
        clickOnElement(By.className("radius"));

        //Verify the text “Secure Area”
//        String expectedMessage = "Secure Area";
//        String actualMessage = getTextFromElement(By.xpath("//div[@class='example']//h2"));
//        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
        verifyText("Secure Area","Secure Area","Can not verify Message : ");
        getTextFromElement(By.xpath("//div[@class='example']//h2"));
    }

        @Test

        public void  verifyTheUsernameErrorMessage() {
            //Enter “tomsmith1” username
            sendTextToElement(By.id("username"), "tomsmith1");
            //find the password field element
            sendTextToElement(By.name("password"), "SuperSecretPassword!");
            //Click on Login button
            clickOnElement(By.className("radius"));
            //Verify the error message “Your username is invalid!
//            String expectedMessage = "Your username is invalid!";
//            String actualMessage = getTextFromElement(By.id("flash"));
//            Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
            verifyText("Your username is invalid!","Your username is invalid!","Can not verify Message : ");
            getTextFromElement(By.id("flash"));
        }

        @Test
    public void verifyThePasswordErrorMessage(){
            //Enter “tomsmith1” username
            sendTextToElement(By.id("username"),"tomsmith");
            //find the password field element
            sendTextToElement(By.name("password"),"SuperSecretPassword");
            //Click on Login button
            clickOnElement(By.className("radius"));
            //Verify the error message “Your password is invalid!
//            String expectedMessage = "Your password is invalid!";
//            String actualMessage = getTextFromElement(By.id("flash"));
//            Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
            verifyText("Your password is invalid!","Your password is invalid!","Can not verify Message : ");
            getTextFromElement(By.id("flash"));
           closeBrowser();
        }
    }


