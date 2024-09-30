package com.softwaretestingboard.magento.testcases;

import com.softwaretestingboard.magento.base.BaseTest;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("tsunaimy111@gmail.com","Hassan99");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
    }

    @Test
    public void loginWithValidCredentialsFullCycle(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("tsunaimy111@gmail.com","Hassan99");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
        // LogOut
        homePage.signOut();
        // sign in again
        loginPage.load();
        loginPage.login("tsunaimy111@gmail.com","Hassan99");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
    }

    @Test
    public void loginWithIncorrectPassword(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("tsunaimy111@gmail.com","Hassan");
        Assert.assertTrue(loginPage.assertSignInErrorMsg());
    }

    @Test
    public void loginWithNonRegisteredEmail(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("tsunaimy753@gmail.com","Hassan99");
        Assert.assertTrue(loginPage.assertSignInErrorMsg());
    }

    @Test
    public void loginWithEmptyEmail(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("","Hassan99");
        Assert.assertTrue(loginPage.assertEmptyMailErrorMsg());
    }

    @Test
    public void loginWithEmptyPassword(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("tsunaimy111@gmail.com","");
        Assert.assertTrue(loginPage.assertEmptyPassErrorMsg());
    }

    @Test
    public void loginWithEmptyEmailAndPassword(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("","");
        Assert.assertTrue(loginPage.assertEmptyMailErrorMsg());
        Assert.assertTrue(loginPage.assertEmptyPassErrorMsg());
    }

    @Test
    public void loginWithOldPassword(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("tsunaimy111@gmail.com","Hassan123");
        Assert.assertTrue(loginPage.assertSignInErrorMsg());
    }

    @Test
    public void loginWithOldEmail(){
        //  sign in
        LoginPage loginPage= new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("tsunaimy111old@gmail.com","Hassan99");
        Assert.assertTrue(loginPage.assertSignInErrorMsg());
    }


}
