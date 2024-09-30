package com.softwaretestingboard.magento.testcases;

import com.softwaretestingboard.magento.base.BaseTest;
import pages.CheckOutPage;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CheckOutTest extends BaseTest {

    @Test
    public void checkOutItemAsUser(){
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

        //  Navigate to Checkout Page
        homePage.proceedToCheckOut();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        Assert.assertTrue(checkOutPage.verifyShippingAddressPage());

        //  Open Order Summary and Details
            checkOutPage.expandOrderSummary();
            checkOutPage.expandOrderDetails();

        //  Check added item appears in checkout page
        Assert.assertEquals(checkOutPage.firstItemInCheckOutName(),homePage.firstItemInMiniCartName());
        Assert.assertEquals(checkOutPage.firstItemInCheckOutSize(),homePage.firstItemInMiniCartSize());
        Assert.assertEquals(checkOutPage.firstItemInCheckOutColor(),homePage.firstItemInMiniCartColor());

        // Fill shipping address
        if (!checkOutPage.isShippingAddressSaved()){
            checkOutPage.addNewAddress("Hassan","Abdelaziz","Main st.","Chicago","12345","123456789");
            checkOutPage.chooseCountry("United States");
            checkOutPage.chooseState("Illinois");
        }

        //  choose shipping method
        checkOutPage.chooseShippingMethod("table");   // choose "flat" or "table" method
        //  to review and payment page
        checkOutPage.toReviewAndPayment();
        Assert.assertTrue(checkOutPage.verifyPaymentPage());

        //  place order
        checkOutPage.placeOrder();
        checkOutPage.verifySuccessOrder();
        Assert.assertTrue(checkOutPage.verifySuccessOrder());
    }

    @Test
    public void checkOutItemAsGuest(){
        HomePage homePage = new HomePage(driver);

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

        //  Navigate to Checkout Page
        homePage.proceedToCheckOut();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        Assert.assertTrue(checkOutPage.verifyShippingAddressPage());

        //  Open Order Summary and Details
        checkOutPage.expandOrderSummary();
        checkOutPage.expandOrderDetails();

        //  Check added item appears in checkout page
        Assert.assertEquals(checkOutPage.firstItemInCheckOutName(),homePage.firstItemInMiniCartName());
        Assert.assertEquals(checkOutPage.firstItemInCheckOutSize(),homePage.firstItemInMiniCartSize());
        Assert.assertEquals(checkOutPage.firstItemInCheckOutColor(),homePage.firstItemInMiniCartColor());

        // Fill shipping address
            checkOutPage.addCustomerMail("testcheckout@gmail.com");
            checkOutPage.addNewAddress("Hassan","Abdelaziz","Main st.","Chicago","12345","123456789");
            checkOutPage.chooseCountry("United States");
            checkOutPage.chooseState("Illinois");

        //  choose shipping method
        checkOutPage.chooseShippingMethod("table");   // choose "flat" or "table" method
        //  to review and payment page
        checkOutPage.toReviewAndPayment();
        Assert.assertTrue(checkOutPage.verifyPaymentPage());

        //  place order
        checkOutPage.placeOrder();
        checkOutPage.verifySuccessOrder();
        Assert.assertTrue(checkOutPage.verifySuccessOrder());
    }

    @Test
    public void verifyGuestCantCheckOutWithEmptyShippingMethod(){
        HomePage homePage = new HomePage(driver);

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

        //  Navigate to Checkout Page
        homePage.proceedToCheckOut();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        Assert.assertTrue(checkOutPage.verifyShippingAddressPage());

        //  Open Order Summary and Details
        checkOutPage.expandOrderSummary();
        checkOutPage.expandOrderDetails();

        //  Check added item appears in checkout page
        Assert.assertEquals(checkOutPage.firstItemInCheckOutName(),homePage.firstItemInMiniCartName());
        Assert.assertEquals(checkOutPage.firstItemInCheckOutSize(),homePage.firstItemInMiniCartSize());
        Assert.assertEquals(checkOutPage.firstItemInCheckOutColor(),homePage.firstItemInMiniCartColor());

        // Fill shipping address
            checkOutPage.addCustomerMail("testcheckout@gmail.com");
            checkOutPage.addNewAddress("Hassan","Abdelaziz","Main st.","Chicago","12345","123456789");
            checkOutPage.chooseCountry("United States");
            checkOutPage.chooseState("Illinois");

        //  choose shipping method
        checkOutPage.toReviewAndPayment();
        Assert.assertTrue(checkOutPage.verifyEmptyShippingMethodErr());
    }

    @Test
    public void verifyGuestCantCheckOutWithEmptyData(){
        HomePage homePage = new HomePage(driver);

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

        //  Navigate to Checkout Page
        homePage.proceedToCheckOut();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        Assert.assertTrue(checkOutPage.verifyShippingAddressPage());

        //  Open Order Summary and Details
        checkOutPage.expandOrderSummary();
        checkOutPage.expandOrderDetails();

        //  Check added item appears in checkout page
        Assert.assertEquals(checkOutPage.firstItemInCheckOutName(),homePage.firstItemInMiniCartName());
        Assert.assertEquals(checkOutPage.firstItemInCheckOutSize(),homePage.firstItemInMiniCartSize());
        Assert.assertEquals(checkOutPage.firstItemInCheckOutColor(),homePage.firstItemInMiniCartColor());

        // Fill shipping address
            checkOutPage.addCustomerMail("");
            checkOutPage.addNewAddress("","","","","","");



        //  choose shipping method
        checkOutPage.chooseShippingMethod("table");   // choose "flat" or "table" method

        //  to review and payment page
        checkOutPage.toReviewAndPayment();
        Assert.assertTrue(checkOutPage.verifyEmptyCustomerEmailErr());
        Assert.assertTrue(checkOutPage.verifyEmptyFirstNameErr());
        Assert.assertTrue(checkOutPage.verifyEmptyLastNameErr());
        Assert.assertTrue(checkOutPage.verifyEmptyStreetAddressErr());
        Assert.assertTrue(checkOutPage.verifyEmptyCityErr());
        Assert.assertTrue(checkOutPage.verifyEmptyStateErr());
        Assert.assertTrue(checkOutPage.verifyEmptyPostalErr());
        Assert.assertTrue(checkOutPage.verifyEmptyPhoneErr());

    }

}
