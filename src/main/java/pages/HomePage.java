package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    By welcomeUserMsg = By.xpath("//*[contains(text(), 'Welcome')]");
    By toHomePage = By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/static/version1695896754/frontend/Magento/luma/en_US/images/logo.svg']");
    By userActionsMenu = By.cssSelector(".header.panel > .header .action");
    By myAccountButton = By.linkText("My Account");
    By myWishListButton = By.linkText("My Wish List ");
    By signOutButton = By.linkText("Sign Out");
    By menCategory = By.cssSelector("[id=\"ui-id-5\"]");
    By menTopsCategory = By.cssSelector("[id=\"ui-id-17\"]");
    By menTopsJacketsCategory = By.cssSelector("[id=\"ui-id-19\"]");
    By itemName = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong");
    By itemPrice = By.cssSelector("[id=\"product-price-430\"]");
    By itemSize = By.cssSelector("[id=\"option-label-size-143-item-166\"]");
    By itemColor = By.cssSelector("[id=\"option-label-color-93-item-49\"]");
    By addToCart = By.cssSelector("[title=\"Add to Cart\"]");
    By addToCartSuccess = By.cssSelector("[data-ui-id=\"message-success\"]");
    By cartIcon = By.cssSelector("[class=\"action showcart\"]");
    By seeDetailsClosed = By.cssSelector(".toggle[data-role='title'][ aria-selected='false']");
    By firstItemNameInMiniCart = By.cssSelector("[class=\"product-item-name\"]");
    By firstItemPriceInMiniCart = By.cssSelector(".minicart-price");
    By firstItemSizeInCMiniCart = By.cssSelector("dd:nth-of-type(1)");
    By firstItemColorInMiniCart = By.cssSelector("dd:nth-of-type(2)");
    By proceedToCheckOutButton = By.cssSelector("[id=\"top-cart-btn-checkout\"]");
    By homeMainSlider = By.cssSelector(".home-main");
    By homeSlider1 = By.cssSelector(".home-pants") ;
    By homeSlider2 = By.cssSelector(".home-erin");
    By emptyCartMsg = By.cssSelector(".subtitle");


    public boolean assertWelcomeMsg(){
        return driver.findElement(welcomeUserMsg).isDisplayed();
    }

    public void navToHomePage(){
        driver.findElement(toHomePage).click();
    }

    public void navToMyAccount(){
        driver.findElement(userActionsMenu).click();
        driver.findElement(myAccountButton).click();
    }

    public void navToMyWishList(){
        driver.findElement(userActionsMenu).click();
        driver.findElement(myWishListButton).click();
    }

    public void signOut(){
        driver.findElement(userActionsMenu).click();
        driver.findElement(signOutButton).click();
    }

    public void hoverToMenTopsJacketsCategory(){
        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(menCategory));
        action.moveToElement(driver.findElement(menTopsCategory));
        action.click(driver.findElement(menTopsJacketsCategory));
        action.build().perform();
    }

    public boolean verifyJacketsPageTitle(){
        return driver.getCurrentUrl().matches("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
    }

    public void hoverToMenCategory(){
      driver.findElement(menCategory).click();
    }

    public boolean verifyMenPageTitle(){
        return driver.getCurrentUrl().matches("https://magento.softwaretestingboard.com/men.html");
    }

    public void hoverToMenTopsCategory(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(menCategory));
        action.click(driver.findElement(menTopsCategory));
        action.build().perform();
    }

    public boolean verifyMenTopsPageTitle(){
        return driver.getCurrentUrl().matches("https://magento.softwaretestingboard.com/men/tops-men.html");
    }

    public void clickMainSlider(){
    driver.findElement(homeMainSlider).click();
    }

    public boolean verifyMainSliderPageTitle(){
        return driver.getTitle().matches("New Luma Yoga Collection");
    }

    public void clickSlider1(){
        driver.findElement(homeSlider1).click();
    }

    public boolean verifyHomeSlider1PageTitle(){
        return driver.getTitle().matches("Pants");
    }

    public void clickSlider2(){
        driver.findElement(homeSlider2).click();
    }

    public boolean verifyHomeSlider2PageTitle(){
        return driver.getTitle().matches("Erin Recommends");
    }

    public String itemName(){
       return driver.findElement(itemName).getText();
    }

    public String itemPrice(){
        return driver.findElement(itemPrice).getText();
    }

    public String itemSize(){
        return driver.findElement(itemSize).getText();
    }

    public void chooseSize(){
        driver.findElement(itemSize).click();
    }

    public String itemColor(){
        return driver.findElement(itemColor).getAttribute("option-label");
    }

    public void chooseColor(){
        driver.findElement(itemColor).click();
    }

    public void addToCart(){
        driver.findElement(addToCart).submit();
    }

    public boolean verifyAddedToCart(){
        return driver.findElement(addToCartSuccess).isDisplayed();
    }

    public boolean verifyEmptyCartMsg(){
        return driver.findElement(emptyCartMsg).isDisplayed();
    }

    public void viewCart(){
        driver.findElement(cartIcon).click();
    }

    public void expandOrderDetails(){
        if (driver.findElement(seeDetailsClosed).isEnabled()){
            driver.findElement(seeDetailsClosed).click();
        }
    }

    public String firstItemInMiniCartName(){
        return driver.findElement(firstItemNameInMiniCart).getText();
    }

    public String firstItemInMiniCartPrice(){
        return driver.findElement(firstItemPriceInMiniCart).getText();
    }

    public String firstItemInMiniCartSize(){
        return driver.findElement(firstItemSizeInCMiniCart).getText();
    }

    public String firstItemInMiniCartColor(){
        return driver.findElement(firstItemColorInMiniCart).getText();
    }

    public void proceedToCheckOut(){
        driver.findElement(proceedToCheckOutButton).click();
    }

}
