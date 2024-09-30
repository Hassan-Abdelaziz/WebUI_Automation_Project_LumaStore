package com.softwaretestingboard.magento.testcases;

import com.softwaretestingboard.magento.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccountTest extends BaseTest {

    @Test
public void verifyChangePasswordWithVaildData(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.load();
    Assert.assertTrue(loginPage.verifyLoginPageTitle());
    loginPage.login("testpassword@gmail.com","Hassan99");
    HomePage homePage = new HomePage(driver);
    Assert.assertTrue(homePage.assertWelcomeMsg());
    homePage.navToMyAccount();
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
    myAccountPage.navToAccInfoPage();
    Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
    myAccountPage.changePassword("Hassan99","Hassan999","Hassan999");
    Assert.assertTrue(myAccountPage.assertSuccessChangeMsg());
}

    @Test
    public void verifyChangeEmaildWithVaildData(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("testpassword@gmail.com","Hassan999");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
        homePage.navToMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
        myAccountPage.navToAccInfoPage();
        Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
        myAccountPage.changeMail("testemail@gmail.com","Hassan999");
        Assert.assertTrue(myAccountPage.assertSuccessChangeMsg());
    }

    @Test
    public void verifyUserCantChangePasswordWithEmptyCurrentPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("testemail@gmail.com","Hassan999");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
        homePage.navToMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
        myAccountPage.navToAccInfoPage();
        Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
        myAccountPage.changePassword("","Hassan123","Hassan123");
        Assert.assertTrue(myAccountPage.assertCurrentPasswordErrorMsg());
    }

    @Test
    public void verifyUserCantChangePasswordWithEmptyNewPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("testemail@gmail.com","Hassan999");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
        homePage.navToMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
        myAccountPage.navToAccInfoPage();
        Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
        myAccountPage.changePassword("Hassan999","","Hassan123");
        Assert.assertTrue(myAccountPage.assertNewPasswordErrorMsg());
    }

    @Test
    public void verifyUserCantChangePasswordWithEmptyConfirmsPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("testemail@gmail.com","Hassan999");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
        homePage.navToMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
        myAccountPage.navToAccInfoPage();
        Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
        myAccountPage.changePassword("Hassan999","Hassan123","");
        Assert.assertTrue(myAccountPage.assertNewPasswordErrorMsg());
    }

    @Test
    public void verifyUserCantChangePasswordWithUnmatchedConfirmsPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("testemail@gmail.com","Hassan999");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
        homePage.navToMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
        myAccountPage.navToAccInfoPage();
        Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
        myAccountPage.changePassword("Hassan999","Hassan123","Hassan12345");
        Assert.assertTrue(myAccountPage.assertConfirmPasswordErrorMsg());
    }

    @Test
    public void verifyUserCantChangeEmailWithEmptyEmail(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("testemail@gmail.com","Hassan999");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
        homePage.navToMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
        myAccountPage.navToAccInfoPage();
        Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
        myAccountPage.changeMail("","Hassan999");
        Assert.assertTrue(myAccountPage.assertEmailErrorMsg());
    }

    @Test
    public void verifyUserCantChangeEmailWithEmptyCurrentPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("testemail@gmail.com","Hassan999");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
        homePage.navToMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
        myAccountPage.navToAccInfoPage();
        Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
        myAccountPage.changeMail("testemail22@gmail.com","");
        Assert.assertTrue(myAccountPage.assertCurrentPasswordErrorMsg());
    }

    @Test
    public void verifyUserCantChangeEmailWithWrongCurrentPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        Assert.assertTrue(loginPage.verifyLoginPageTitle());
        loginPage.login("testemail@gmail.com","Hassan999");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.assertWelcomeMsg());
        homePage.navToMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.verifyMyAccountPageTitle());
        myAccountPage.navToAccInfoPage();
        Assert.assertTrue(myAccountPage.verifyAccountInformationPageTitle());
        myAccountPage.changeMail("testemail22@gmail.com","Hassan789");
        Assert.assertTrue(myAccountPage.assertWrongPasswordErrorMsg());
    }



}
