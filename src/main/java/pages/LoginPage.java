package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

        WebDriver driver;
    public LoginPage(WebDriver driver){
       this.driver=driver;
    }

    By signInLinkButton = By.linkText("Sign In");
    By emailInput = By.cssSelector("[id=\"email\"]");
    By passwordInput = By.cssSelector("[id=\"pass\"]");
    By signInSubmitButton = By.cssSelector("[id=\"send2\"]");
    By emailErrorMsg = By.cssSelector("[id=\"email-error\"]");
    By passErrorMsg = By.cssSelector("[id=\"pass-error\"]");
    By singInErrorMsg = By.cssSelector(".message-error");


    public void load(){
        driver.findElement(signInLinkButton).click();
    }

    public boolean verifyLoginPageTitle(){
        return driver.getTitle().equalsIgnoreCase("Customer Login");
    }

    public void login(String email, String password){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signInSubmitButton).submit();
    }

    public boolean assertSignInErrorMsg(){
        return driver.findElement(singInErrorMsg).isDisplayed();
    }

    public boolean assertEmptyMailErrorMsg(){
        return driver.findElement(emailErrorMsg).isDisplayed();
    }

    public boolean assertEmptyPassErrorMsg(){
        return driver.findElement(passErrorMsg).isDisplayed();
    }




}
