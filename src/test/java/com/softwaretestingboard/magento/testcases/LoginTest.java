package com.softwaretestingboard.magento.testcases;

import com.softwaretestingboard.magento.base.BaseTest;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginTest extends BaseTest {

    //  hassan1@gmail.com    for login trials
    //  hassanoldmail@gmail.com     for old email trial

    @Test (description = "Verify that user can sign in using valid email and password")
    public void loginWithValidCredentials(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("hassan1@gmail.com","Hassan99");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
    }

    @Test (description = "Verify that user can sign in using valid email and password in full Cycle")
    public void loginWithValidCredentialsFullCycle(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("hassan1@gmail.com","Hassan99");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
        // LogOut
        homePage.signOut();
        // sign in again
        loginPage.load();
        loginPage.login("hassan1@gmail.com","Hassan99");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
    }

    @Test (description = "Verify that user cannot sign in using Incorrect password")
    public void loginWithIncorrectPassword(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("hassan1@gmail.com","Hassan");
        Assert.assertTrue(loginPage.assertSignInErrorMsg());
    }

    @Test (description = "Verify that user cannot sign in using a non-registered Email")
    public void loginWithNonRegisteredEmail(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("hassan753@gmail.com","Hassan99");
        Assert.assertTrue(loginPage.assertSignInErrorMsg());
    }

    @Test (description = "Verify that user cannot sign in using empty email")
    public void loginWithEmptyEmail(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("","Hassan99");
        Assert.assertTrue(loginPage.assertEmptyMailErrorMsg());
    }

    @Test (description = "Verify that user cannot sign in using empty password")
    public void loginWithEmptyPassword(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("hassan1@gmail.com","");
        Assert.assertTrue(loginPage.assertEmptyPassErrorMsg());
    }

    @Test (description = "Verify that user cannot sign in using empty email and password")
    public void loginWithEmptyEmailAndPassword(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("","");
        Assert.assertTrue(loginPage.assertEmptyMailErrorMsg());
        Assert.assertTrue(loginPage.assertEmptyPassErrorMsg());
    }

    @Test (description = "Verify that user cannot sign in using old (changed) Password")
    public void loginWithOldPassword(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("hassan1@gmail.com","Hassan123");
        Assert.assertTrue(loginPage.assertSignInErrorMsg());
    }

    @Test (description = "Verify that user cannot sign in using old (changed) Email")
    public void loginWithOldEmail(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("hassanoldmail@gmail.com","Hassan99");
        Assert.assertTrue(loginPage.assertSignInErrorMsg());
    }


}
