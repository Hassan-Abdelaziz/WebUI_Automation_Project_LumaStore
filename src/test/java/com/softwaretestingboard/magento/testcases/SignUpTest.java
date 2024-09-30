package com.softwaretestingboard.magento.testcases;

import com.softwaretestingboard.magento.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpWithValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","testpassword@gmail.com","Hassan99","Hassan99");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.assertSuccessSignUpMsg());
    }

    @Test
    public void signUpWithEmptyFirstNameAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("","Abdelaziz","tsunaimy333@gmail.com","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertFirstNameErrorMsg());
    }

    @Test
    public void signUpWithSpecialCharacterInFirstName(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("@h","Abdelaziz","tsunaimy333@gmail.com","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertFirstNameNotValidErrorMsg());
    }

    @Test
    public void signUpWithEmptyLastNameAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","","tsunaimy333@gmail.com","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertLastNameErrorMsg());
    }

    @Test
    public void signUpWithSpecialCharacterInLastName(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","@h","tsunaimy333@gmail.com","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertLastNameNotValidErrorMsg());
    }

    @Test
    public void signUpWithEmptyEmailAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertEmailErrorMsg());
    }

    @Test
    public void signUpWithInvalidEmailFormatAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy333@gmail","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertEmailErrorMsg());
    }

    @Test
    public void signUpWithEmptyPasswordAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy333@gmail.com","","Hassan99");
        Assert.assertTrue(signUpPage.assertPasswordErrorMsg());
    }

    @Test
    public void signUpWithEmptyConfirmPasswordAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy333@gmail.com","Hassan99","");
        Assert.assertTrue(signUpPage.assertConfirmPasswordErrorMsg());
    }

    @Test
    public void signUpWithEmptyData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("","","","","");
        Assert.assertTrue(signUpPage.assertFirstNameErrorMsg());
        Assert.assertTrue(signUpPage.assertLastNameErrorMsg());
        Assert.assertTrue(signUpPage.assertEmailErrorMsg());
        Assert.assertTrue(signUpPage.assertPasswordErrorMsg());
        Assert.assertTrue(signUpPage.assertConfirmPasswordErrorMsg());
    }

    @Test
    public void signUpWithRegisteredEmail(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy111@gmail.com","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertEmailDuplicatedErrorMsg());
    }

    @Test
    public void signUpWithUnMatchedPasswords(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy333@gmail.com","Hassan99","Hassan9");
        Assert.assertTrue(signUpPage.assertConfirmPasswordErrorMsg());
    }

    @Test
    public void signUpWithWeakPassword(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy333@gmail.com","12345678h","12345678h");
        Assert.assertTrue(signUpPage.assertPasswordErrorMsg());
    }


}
