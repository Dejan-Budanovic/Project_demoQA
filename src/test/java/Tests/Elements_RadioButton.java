package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.RadioButtonPage;
import Pages.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Elements_RadioButton extends BaseTest {

    String cardName = "Elements";
    String sideBarItem = "Radio Button";
    String homePageExpectedURL = "https://demoqa.com/elements";
    String radioButtonExpectedURL = "https://demoqa.com/radio-button";

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        homePage = new HomePage();
        sideBar = new SideBar();
        radioButtonPage = new RadioButtonPage();
        scrollToElement(homePage.getCard(cardName));
        homePage.clickOnCard(cardName);
        Assert.assertEquals(driver.getCurrentUrl(), homePageExpectedURL);
        sideBar.clickOnSideBarItem(sideBarItem);
        Assert.assertEquals(driver.getCurrentUrl(), radioButtonExpectedURL);
    }

    @Test
    public void userCanClickOnYesRadioButton() {
        radioButtonPage.clickOnYesRadioButton();
        Assert.assertEquals(radioButtonPage.yesRadioButton.getText(), radioButtonPage.getSuccessMessage());
    }

    @Test
    public void userCanClickOnImpressiveRadioButton() {
        radioButtonPage.clickOnImpressiveRadioButton();
        Assert.assertEquals(radioButtonPage.impressiveRadioButton.getText(), radioButtonPage.getSuccessMessage());
    }

    @Test
    public void userCannotClickOnNoRadioButton() {
        radioButtonPage.clickOnNoRadioButton();
        Assert.assertTrue(radioButtonPage.successMessageList.isEmpty());
    }

    @Test
    public void userCannotSelectMultipleRadioButtons() {
        radioButtonPage.clickOnYesRadioButton();
        radioButtonPage.clickOnImpressiveRadioButton();
        radioButtonPage.clickOnNoRadioButton();
        Assert.assertEquals(radioButtonPage.impressiveRadioButton.getText(), radioButtonPage.getSuccessMessage());
        Assert.assertEquals(radioButtonPage.successMessageList.size(), 1);
    }

    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
