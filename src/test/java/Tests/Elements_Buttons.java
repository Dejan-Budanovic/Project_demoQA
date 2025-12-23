package Tests;

import Base.BaseTest;
import Pages.ButtonsPage;
import Pages.HomePage;
import Pages.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Elements_Buttons extends BaseTest {

    String cardName = "Elements";
    String sideBarItem = "Buttons";
    String homePageExpectedURL = "https://demoqa.com/elements";
    String checkBoxExpectedURL = "https://demoqa.com/buttons";

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        homePage = new HomePage();
        sideBar = new SideBar();
        buttonsPage = new ButtonsPage();
        scrollToElement(homePage.getCard(cardName));
        homePage.clickOnCard(cardName);
        Assert.assertEquals(driver.getCurrentUrl(), homePageExpectedURL);
        sideBar.clickOnSideBarItem(sideBarItem);
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxExpectedURL);
    }

    @Test
    public void UserCanClickOnDoubleClickButton() {
        buttonsPage.clickDoubleClickButton();
        System.out.println(buttonsPage.doubleClickButton.getText().substring(0, 6));
        System.out.println(buttonsPage.doubleClickButtonMessage.getText());
        Assert.assertTrue(buttonsPage.doubleClickButtonMessage.getText().contains(buttonsPage.doubleClickButton.getText().substring(0, 6).toLowerCase()));
    }

    @Test
    public void UserCanRightClickOnRightClickButton() {
        buttonsPage.clickRightClickButton();
        System.out.println(buttonsPage.rightClickButton.getText().substring(0, 5));
        System.out.println(buttonsPage.rightClickButtonMessage.getText());
        Assert.assertTrue(buttonsPage.rightClickButtonMessage.getText().contains(buttonsPage.rightClickButton.getText().substring(0, 5).toLowerCase()));
    }

    @Test
    public void userCanClickOnDynamicButton() {
        buttonsPage.clickDynamicClickButton();
        Assert.assertTrue(buttonsPage.dynamicClickButtonMessage.getText().contains(buttonsPage.dynamicClickButton.getText().substring(0, 5).toLowerCase()));
    }

    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
