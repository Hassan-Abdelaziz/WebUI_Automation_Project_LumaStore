package com.softwaretestingboard.magento.testcases;

import com.softwaretestingboard.magento.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccountTest extends BaseTest {

    @Test (description = "Verify that user can change password using valid data")
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

    @Test (description = "Verify that user can change email using valid data")
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

    @Test (description = "Verify that user cannot change password using empty current password")
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

    @Test (description = "Verify that user cannot change password using empty new password")
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

    @Test (description = "Verify that user cannot change password using empty confirm password")
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

    @Test (description = "Verify that user cannot change password using un-matched passwords")
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

    @Test (description = "Verify that user cannot change email using empty email")
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

    @Test (description = "Verify that user cannot change email using empty current password")
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

    @Test (description = "Verify that user cannot change email using wrong current password")
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
