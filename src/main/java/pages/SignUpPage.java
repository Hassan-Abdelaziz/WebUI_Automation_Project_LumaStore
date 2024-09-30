package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;
    public SignUpPage(WebDriver driver){
        this.driver=driver;
    }

    By createAccountLinkButton = By.linkText("Create an Account");
    By firstNameInput = By.cssSelector("[id=\"firstname\"]");
    By firstNameErr = By.cssSelector("[id=\"firstname-error\"]");
    By firstNameNotValidErr = By.xpath("//div[.='First Name is not valid!']");

    By lastNameInput = By.cssSelector("[id=\"lastname\"]");
    By lastNameErr = By.cssSelector("[id=\"lastname-error\"]");
    By lastNameNotValidErr = By.xpath("//div[.='Last Name is not valid!']");

    By emailInput = By.cssSelector("[id=\"email_address\"]");
    By emailErr = By.cssSelector("[id=\"email_address-error\"]");
    By emailAlreadyErr = By.xpath("//div[@class='message-error error message']/div[contains(.,'There is already an account with this email address. If you are sure that it is')]");

    By passwordInput = By.cssSelector("[id=\"password\"]");
    By passwordErr = By.cssSelector("[id=\"password-error\"]");

    By confirmPasswordInput = By.cssSelector("[id=\"password-confirmation\"]");
    By confirmPasswordErr = By.cssSelector("[id=\"password-confirmation-error\"]");

    By createAccountButton = By.cssSelector(".submit");




    public void load(){
        driver.findElement(createAccountLinkButton).click();
    }

    public boolean verifySignUpPageTitle(){
        return driver.getTitle().equalsIgnoreCase("Create New Customer Account");
    }

    public void signUp(String fName, String lName, String email, String password, String confirmPassword){
        driver.findElement(firstNameInput).sendKeys(fName);
        driver.findElement(lastNameInput).sendKeys(lName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
        driver.findElement(createAccountButton).submit();
    }

    public boolean assertFirstNameErrorMsg(){
        return driver.findElement(firstNameErr).isDisplayed();
    }

    public boolean assertFirstNameNotValidErrorMsg(){
        return driver.findElement(firstNameNotValidErr).isDisplayed();
    }

    public boolean assertLastNameErrorMsg(){
        return driver.findElement(lastNameErr).isDisplayed();
    }

    public boolean assertLastNameNotValidErrorMsg(){
        return driver.findElement(lastNameNotValidErr).isDisplayed();
    }

    public boolean assertEmailErrorMsg(){
        return driver.findElement(emailErr).isDisplayed();
    }
    public boolean assertEmailDuplicatedErrorMsg(){
        return driver.findElement(emailAlreadyErr).isDisplayed();
    }

    public boolean assertPasswordErrorMsg(){
        return driver.findElement(passwordErr).isDisplayed();
    }

    public boolean assertConfirmPasswordErrorMsg(){
        return driver.findElement(confirmPasswordErr).isDisplayed();
    }

}
