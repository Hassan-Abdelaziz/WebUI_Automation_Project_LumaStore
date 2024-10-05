package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckOutPage {

    WebDriver driver;
    public CheckOutPage(WebDriver driver){
        this.driver=driver;
    }

    By navToCheckOutSuccess = By.xpath("//div[.='Shipping Address']");
    By orderSummaryClosed = By.cssSelector(".title[data-role='title' ]");
    By orderDetailsClosed = By.cssSelector(".toggle[data-role='title'][ aria-selected='false']");
    By firstItemNameInCheckOutPage = By.cssSelector("[class=\"product-item-name\"]");
    By firstItemPriceInCheckOutPage = By.cssSelector("[class=\"cart-price\"]");
    By firstItemSizeInCheckOutPage = By.cssSelector("dd:nth-of-type(1)");
    By firstItemColorInCheckOutPage = By.cssSelector("dd:nth-of-type(2)");
    By savedShippingAddress = By.cssSelector(".shipping-address-item");
    By customerEmail = By.xpath("//div[@class='field required']//input[@id='customer-email']");
    By firstName = By.cssSelector("[name=\"firstname\"]");
    By lastName = By.cssSelector("[name=\"lastname\"]");
    By street = By.cssSelector("[name=\"street[0]\"]");
    By city = By.cssSelector("[name=\"city\"]");
    By dropDownState = By.cssSelector("[name=\"region_id\"]");
    By postCode = By.cssSelector("[name=\"postcode\"]");
    By dropDownCountry = By.cssSelector("[name=\"country_id\"]");
    By phoneNum = By.cssSelector("[name=\"telephone\"]");
    By flatShippingMethod = By.cssSelector("[value=\"flatrate_flatrate\"]");
    By bestShippingMethod = By.cssSelector("[value=\"tablerate_bestway\"]");
    By emptyShippingMethodErr = By.xpath("//span[.='The shipping method is missing. Select the shipping method and try again.']");
    By nextButton = By.cssSelector("[class=\"button action continue primary\"]");
    By shippingOK = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[1]");
    By placeOrderButton = By.cssSelector(".action.primary.checkout");
    By successOrder = By.cssSelector(".checkout-success");
    By customerEmailErr = By.cssSelector("#customer-email-error");
    By firstNameErr = By.xpath("//div[@name='shippingAddress.firstname']//span[.='This is a required field.']");
    By lastNameErr = By.xpath("//div[@name='shippingAddress.lastname']//span[.='This is a required field.']");
    By streetErr = By.xpath("//fieldset[@class='field street admin__control-fields required']//span[.='This is a required field.']");
    By cityErr = By.xpath("//div[@name='shippingAddress.city']//span[.='This is a required field.']");
    By dropDownStateErr = By.xpath("//div[@name='shippingAddress.region_id']//span[.='This is a required field.']");
    By postCodeErr = By.xpath("//div[@name='shippingAddress.postcode']//span[.='This is a required field.']");
    By phoneNumErr = By.xpath("//div[@name='shippingAddress.telephone']//span[.='This is a required field.']");



    public boolean verifyShippingAddressPage(){
        return driver.findElement(navToCheckOutSuccess).getText().matches("Shipping Address");
    }

    public void expandOrderSummary(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));
        if (!driver.findElement(orderSummaryClosed).isSelected()){
            driver.findElement(orderSummaryClosed).click();
        }

    }
    public void expandOrderDetails(){
        if (!driver.findElement(orderDetailsClosed).isSelected()){
            driver.findElement(orderDetailsClosed).click();
        }
    }

    public String firstItemInCheckOutName(){
        return driver.findElement(firstItemNameInCheckOutPage).getText();
    }
/*
    public String firstItemInCheckOutPrice(){
        return driver.findElement(firstItemPriceInCheckOutPage).getText();
    }
*/
    public String firstItemInCheckOutSize(){
        return driver.findElement(firstItemSizeInCheckOutPage).getText();
    }

    public String firstItemInCheckOutColor(){
        return driver.findElement(firstItemColorInCheckOutPage).getText();
    }

    public boolean isShippingAddressSaved(){
        List<WebElement> savedAddress = driver.findElements(savedShippingAddress);
        if(savedAddress.isEmpty())
        {
            return false;
        }
        else return true;
    }

    public void addCustomerMail(String customerMail){
        driver.findElement(customerEmail).sendKeys(customerMail);
    }

    public void addNewAddress(String name1, String name2, String st, String ct, String post, String phone){
        driver.findElement(firstName).sendKeys(name1);
        driver.findElement(lastName).sendKeys(name2);
        driver.findElement(street).sendKeys(st);
        driver.findElement(city).sendKeys(ct);
        driver.findElement(postCode).sendKeys(post);
        driver.findElement(phoneNum).sendKeys(phone);
    }

    public void chooseState(String state){
        WebElement dropDownStateWeb = driver.findElement(dropDownState);
        Select st = new Select(dropDownStateWeb);
        st.selectByVisibleText(state);
    }

    public void chooseCountry(String country){
        WebElement dropDownCountryWeb = driver.findElement(dropDownCountry);
        Select ctry = new Select(dropDownCountryWeb);
        ctry.selectByVisibleText(country);
    }

    public void chooseShippingMethod(String ship){
    switch (ship){
        case "flat":
            driver.findElement(flatShippingMethod).click();
            break;

        case "table":
            driver.findElement(bestShippingMethod).click();
            break;
                }
    }

    public boolean verifyEmptyShippingMethodErr(){
        return driver.findElement(emptyShippingMethodErr).isDisplayed();
    }
    public boolean verifyEmptyCustomerEmailErr(){
        return driver.findElement(customerEmailErr).isDisplayed();
    }
    public boolean verifyEmptyFirstNameErr(){
        return driver.findElement(firstNameErr).isDisplayed();
    }
    public boolean verifyEmptyLastNameErr(){
        return driver.findElement(lastNameErr).isDisplayed();
    }
    public boolean verifyEmptyStreetAddressErr(){
        return driver.findElement(streetErr).isDisplayed();
    }
    public boolean verifyEmptyCityErr(){
        return driver.findElement(cityErr).isDisplayed();
    }
    public boolean verifyEmptyStateErr(){
        return driver.findElement(dropDownStateErr).isDisplayed();
    }
    public boolean verifyEmptyPostalErr(){
        return driver.findElement(postCodeErr).isDisplayed();
    }
    public boolean verifyEmptyPhoneErr(){
        return driver.findElement(phoneNumErr).isDisplayed();
    }

    public void toReviewAndPayment(){
        driver.findElement(nextButton).click();
    }

    public boolean verifyPaymentPage(){
        return driver.findElement(shippingOK).isDisplayed();
    }

    public void placeOrder(){
        WebElement element = driver.findElement(placeOrderButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }

    public boolean verifySuccessOrder(){
        return driver.findElement(successOrder).isDisplayed();
    }



}
