package com.softwaretestingboard.magento.testcases;

import com.github.javafaker.Faker;
import com.softwaretestingboard.magento.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EndToEndTest extends BaseTest {

    @Test (description = "Verify that user can make an order as guest user using valid shipping data ")
    public void endToEndPurchaseCycleAsGuestUser(){

        HomePage homePage = new HomePage(driver);

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
        String email = new Faker().internet().emailAddress();
        checkOutPage.addCustomerMail(email);
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


    @Test(description = "Verify that user can make an order as registered user using all valid data")
    public void endToEndPurchaseCycleAsRegisteredUser(){
        //  sign up
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        String email = new Faker().internet().emailAddress();
        signUpPage.signUp("Hassan","Abdelaziz",email,"Hassan99","Hassan99");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.assertSuccessSignUpMsg());

        //  sign out
        HomePage homePage = new HomePage(driver);
        homePage.signOut();

        // sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login(email,"Hassan99");
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());

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

    @Test(description = "e2e verify that user can sign up - logout - sign in - change password - sign in with new password")
    public void endToEndChangePasswordCycle(){
        //  sign up
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        String email = new Faker().internet().emailAddress();
        signUpPage.signUp("Hassan","Abdelaziz",email,"Hassan99","Hassan99");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.assertSuccessSignUpMsg());

        //  sign out
        HomePage homePage = new HomePage(driver);
        homePage.signOut();

        // sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login(email,"Hassan99");
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());

        //  Change Password
        myAccountPage.navToAccInfoPage();
        Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
        myAccountPage.changePassword("Hassan99","Hassan999","Hassan999");
        Assert.assertTrue(myAccountPage.assertSuccessChangeMsg());

        // sign in with new password
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login(email,"Hassan999");
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());

    }

    @Test(description = "e2e verify that user can sign up - logout - sign in - change Email - sign in with new Email")
    public void endToEndChangeEmailCycle(){
        //  sign up
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        String email = new Faker().internet().emailAddress();
        signUpPage.signUp("Hassan","Abdelaziz",email,"Hassan99","Hassan99");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.assertSuccessSignUpMsg());

        //  sign out
        HomePage homePage = new HomePage(driver);
        homePage.signOut();

        // sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login(email,"Hassan99");
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());

        //  Change Password
        myAccountPage.navToAccInfoPage();
        Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
        String newMail = new Faker().internet().emailAddress();
        myAccountPage.changeMail(newMail,"Hassan99");
        Assert.assertTrue(myAccountPage.assertSuccessChangeMsg());

        // sign in with new email
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login(newMail,"Hassan99");
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());

    }
}
