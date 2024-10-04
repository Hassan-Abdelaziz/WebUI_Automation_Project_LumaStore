package com.softwaretestingboard.magento.testcases;

import com.softwaretestingboard.magento.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test (description = "Verify that homepage sliders are clickable")
    public void verifyThatHomePageSlidersClickable(){
    HomePage homePage = new HomePage(driver);
    homePage.clickMainSlider();
    Assert.assertTrue(homePage.verifyMainSliderPageTitle());
    homePage.navToHomePage();
    homePage.clickSlider1();
    Assert.assertTrue(homePage.verifyHomeSlider1PageTitle());
    homePage.navToHomePage();
    homePage.clickSlider2();
    Assert.assertTrue(homePage.verifyHomeSlider2PageTitle());
    }

    @Test (description = "Verify that user can navigate through categories")
    public void  verifyThatHoverCategoriesWork(){
        HomePage homePage = new HomePage(driver);
        homePage.hoverToMenCategory();
        Assert.assertTrue(homePage.verifyMenPageTitle());
        homePage.hoverToMenTopsCategory();
        Assert.assertTrue(homePage.verifyMenTopsPageTitle());
        homePage.hoverToMenTopsJacketsCategory();
        Assert.assertTrue(homePage.verifyJacketsPageTitle());
    }
}
