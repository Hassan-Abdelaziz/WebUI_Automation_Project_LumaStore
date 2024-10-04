package com.softwaretestingboard.magento.testcases;

import com.github.javafaker.Faker;
import com.softwaretestingboard.magento.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test (description = "Verify that user can sign up using all valid data")
    public void signUpWithValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        String mail = new Faker().internet().emailAddress();
        signUpPage.signUp("Hassan","Abdelaziz","testpassword@gmail.com","Hassan99","Hassan99");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.assertSuccessSignUpMsg());
    }

    @Test (description = "Verify that user cannot sign up using empty firstname")
    public void signUpWithEmptyFirstNameAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("","Abdelaziz","tsunaimy333@gmail.com","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertFirstNameErrorMsg());
    }

    @Test (description = "Verify that user cannot sign up using special characters in firstname")
    public void signUpWithSpecialCharacterInFirstName(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("@h","Abdelaziz","tsunaimy333@gmail.com","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertFirstNameNotValidErrorMsg());
    }

    @Test (description = "Verify that user cannot sign up using empty lastname")
    public void signUpWithEmptyLastNameAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","","tsunaimy333@gmail.com","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertLastNameErrorMsg());
    }

    @Test (description = "Verify that user cannot sign up using special characters in lastname")
    public void signUpWithSpecialCharacterInLastName(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","@h","tsunaimy333@gmail.com","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertLastNameNotValidErrorMsg());
    }

    @Test (description = "Verify that user cannot sign up using empty Email")
    public void signUpWithEmptyEmailAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertEmailErrorMsg());
    }

    @Test (description = "Verify that user cannot sign up using wrong Email format")
    public void signUpWithInvalidEmailFormatAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy333@gmail","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertEmailErrorMsg());
    }

    @Test (description = "Verify that user cannot sign up using empty password")
    public void signUpWithEmptyPasswordAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy333@gmail.com","","Hassan99");
        Assert.assertTrue(signUpPage.assertPasswordErrorMsg());
    }

    @Test (description = "Verify that user cannot sign up using empty confirm password")
    public void signUpWithEmptyConfirmPasswordAndValidData(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy333@gmail.com","Hassan99","");
        Assert.assertTrue(signUpPage.assertConfirmPasswordErrorMsg());
    }

    @Test (description = "Verify that user cannot sign up with empty data")
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

    @Test (description = "Verify that user cannot sign up using already registered Email")
    public void signUpWithRegisteredEmail(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy111@gmail.com","Hassan99","Hassan99");
        Assert.assertTrue(signUpPage.assertEmailDuplicatedErrorMsg());
    }

    @Test (description = "Verify that user cannot sign up using un-matched passwords")
    public void signUpWithUnMatchedPasswords(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy333@gmail.com","Hassan99","Hassan9");
        Assert.assertTrue(signUpPage.assertConfirmPasswordErrorMsg());
    }

    @Test (description = "Verify that user cannot sign up using weak password")
    public void signUpWithWeakPassword(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.load();
        Assert.assertTrue(signUpPage.verifySignUpPageTitle());
        signUpPage.signUp("Hassan","Abdelaziz","tsunaimy333@gmail.com","12345678h","12345678h");
        Assert.assertTrue(signUpPage.assertPasswordErrorMsg());
    }


}
