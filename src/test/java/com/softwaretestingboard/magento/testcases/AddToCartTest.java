package com.softwaretestingboard.magento.testcases;

import com.softwaretestingboard.magento.base.BaseTest;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void addItemWithSizeAndColorToCartWhileSignedIn(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        loginPage.login("tsunaimy111@gmail.com","Hassan99");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());

        // navigate to homepage
        homePage.navToHomePage();

        // navigate to jackets page
        homePage.hoverToMenTopsJacketsCategory();
        Assert.assertTrue(homePage.verifyJacketsPageTitle());

        // add item to cart
        homePage.chooseSize();
        homePage.chooseColor();
        homePage.addToCart();
        Assert.assertTrue(homePage.verifyAddedToCart());

        // check in cart
        homePage.viewCart();
        homePage.expandOrderDetails();
        Assert.assertEquals(homePage.firstItemInMiniCartName(),homePage.itemName());
        Assert.assertEquals(homePage.firstItemInMiniCartPrice(),homePage.itemPrice());
        Assert.assertEquals(homePage.firstItemInMiniCartSize(),homePage.itemSize());
        Assert.assertEquals(homePage.firstItemInMiniCartColor(),homePage.itemColor());
    }

    @Test
    public void addItemWithSizeAndColorToCartAsGuest(){
        // navigate to homepage
        HomePage homePage = new HomePage(driver);
        homePage.navToHomePage();

        // navigate to jackets page
        homePage.hoverToMenTopsJacketsCategory();
        Assert.assertTrue(homePage.verifyJacketsPageTitle());

        // add item to cart
        homePage.chooseSize();
        homePage.chooseColor();
        homePage.addToCart();
        Assert.assertTrue(homePage.verifyAddedToCart());

        // check in cart
        homePage.viewCart();
        homePage.expandOrderDetails();
        Assert.assertEquals(homePage.firstItemInMiniCartName(),homePage.itemName());
        Assert.assertEquals(homePage.firstItemInMiniCartPrice(),homePage.itemPrice());
        Assert.assertEquals(homePage.firstItemInMiniCartSize(),homePage.itemSize());
        Assert.assertEquals(homePage.firstItemInMiniCartColor(),homePage.itemColor());
    }

    @Test
    public void verifyThatEmptyMsgAppearsWhenMiniCartIsEmpty(){
        HomePage homePage = new HomePage(driver);
        homePage.viewCart();
        homePage.verifyEmptyCartMsg();
    }
}
