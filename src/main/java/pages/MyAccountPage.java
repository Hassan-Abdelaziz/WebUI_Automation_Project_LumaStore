package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    WebDriver driver;
    public MyAccountPage(WebDriver driver){
        this.driver=driver;
    }

    By successSignUpMsg = By.xpath("//div[.='Thank you for registering with Main Website Store.']");
    By accountInfoButton = By.xpath("//li[.='Account Information']");
    By changePassword = By.cssSelector("#change-password");
    By currentPasswordInput = By.cssSelector("#current-password");
    By newPasswordInput = By.cssSelector("#password");
    By confirmNewPasswordInput = By.cssSelector("#password-confirmation");
    By changeMail = By.cssSelector("#change-email");
    By emailInput = By.cssSelector("#email");
    By saveButton = By.cssSelector(".save");
    By currentPasswordErr = By.cssSelector("#current-password-error");
    By newPasswordErr = By.cssSelector("#password-error");
    By confirmPasswordErr = By.cssSelector("#password-confirmation-error");
    By emailErr = By.cssSelector("#email-error");
    By wrongPasswordErr = By.xpath("//div[.=\"The password doesn't match this account. Verify the password and try again.\"]");
    By changeSuccess = By.xpath("//div[.='You saved the account information.']");

    public boolean assertSuccessSignUpMsg(){
        return driver.findElement(successSignUpMsg).isDisplayed();
    }

    public boolean verifyMyAccountPageTitle(){
        return driver.getCurrentUrl().matches("https://magento.softwaretestingboard.com/customer/account/");
    }

    public void navToAccInfoPage(){
        driver.findElement(accountInfoButton).click();
    }

    public boolean verifyAccountInformationPageTitle(){
        return driver.getCurrentUrl().matches("https://magento.softwaretestingboard.com/customer/account/edit/");
    }

    public void changePassword(String currentPass, String newPass, String confirmNewPass){
        driver.findElement(changePassword).click();
        driver.findElement(currentPasswordInput).sendKeys(currentPass);
        driver.findElement(newPasswordInput).sendKeys(newPass);
        driver.findElement(confirmNewPasswordInput).sendKeys(confirmNewPass);
        driver.findElement(saveButton).submit();
    }

    public boolean assertSuccessChangeMsg(){
        return driver.findElement(changeSuccess).isDisplayed();
    }

    public void changeMail(String newMail, String currentPass){
        driver.findElement(changeMail).click();
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(newMail);
        driver.findElement(currentPasswordInput).sendKeys(currentPass);
        driver.findElement(saveButton).submit();
    }

    public boolean assertCurrentPasswordErrorMsg(){
        return driver.findElement(currentPasswordErr).isDisplayed();
    }

    public boolean assertNewPasswordErrorMsg(){
        return driver.findElement(newPasswordErr).isDisplayed();
    }

    public boolean assertConfirmPasswordErrorMsg(){
        return driver.findElement(confirmPasswordErr).isDisplayed();
    }

    public boolean assertEmailErrorMsg(){
        return driver.findElement(emailErr).isDisplayed();
    }

    public boolean assertWrongPasswordErrorMsg(){
        return driver.findElement(wrongPasswordErr).isDisplayed();
    }
}
