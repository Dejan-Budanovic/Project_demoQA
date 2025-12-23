package Tests;

import Pages.HomePage;
import Pages.SideBar;
import Pages.TextBoxPage;

import Base.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Elements_TextBox extends BaseTest {

    String cardName = "Elements";
    String sideBarItem = "Text Box";
    String homePageExpectedURL = "https://demoqa.com/elements";
    String textBoxExpectedURL = "https://demoqa.com/text-box";

    String userName = "Petar Petrovic";
    String userEmail = "petar@petrovic.com";
    String userCurrentAddress = "Petra Petrovica 1";
    String userPermanentAddress = "Petrovica Petra 2";
    String invalidUserEmail = "petar petrovic";

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        this.homePage = new HomePage();
        this.sideBar = new SideBar();
        this.textBoxPage = new TextBoxPage();
        scrollToElement(homePage.getCard(cardName));
        this.homePage.clickOnCard(this.cardName);
        Assert.assertEquals(driver.getCurrentUrl(), this.homePageExpectedURL);
        this.sideBar.clickOnSideBarItem(this.sideBarItem);
        Assert.assertEquals(driver.getCurrentUrl(), this.textBoxExpectedURL);
    }

    public void inputUserData(String userName, String userEmail, String userCurrentAddress, String userPermanentAddress) {
        this.textBoxPage.inputUserName(userName);
        this.textBoxPage.inputUserEmail(userEmail);
        this.textBoxPage.inputUserCurrentAddress(userCurrentAddress);
        this.textBoxPage.inputUserPermanentAddress(userPermanentAddress);
    }

    @Test
    public void userCanSubmitData() throws InterruptedException {
        this.inputUserData(this.userName, this.userEmail, this.userCurrentAddress, this.userPermanentAddress);
        this.scrollToElement(this.textBoxPage.submitButton);
        this.textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(this.textBoxPage.userNameOutput.getText().contains(this.userName));
        Assert.assertTrue(this.textBoxPage.userEmailOutput.getText().contains(this.userEmail));
        Assert.assertTrue(this.textBoxPage.userCurrentAddressOutput.getText().contains(this.userCurrentAddress));
        Assert.assertTrue(this.textBoxPage.userPermanentAddressOutput.getText().contains(this.userPermanentAddress));
    }

    @Test
    public void userCannotSubmitDataWithInvalidEmail() {
        this.inputUserData(this.userName, this.invalidUserEmail, this.userCurrentAddress, this.userPermanentAddress);
        this.scrollToElement(this.textBoxPage.submitButton);
        this.textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(this.textBoxPage.userEmailInputError.isDisplayed());
        Assert.assertEquals(this.textBoxPage.outputPlaceHolder.getText(), "");
    }

    @Test
    public void userCanSubmitPartialDataWithoutName() throws InterruptedException {
        this.inputUserData(this.userName, this.userEmail, this.userCurrentAddress, this.userPermanentAddress);
        this.textBoxPage.userNameInput.clear();
        this.scrollToElement(this.textBoxPage.submitButton);
        this.textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(this.textBoxPage.userEmailOutput.getText().contains(this.userEmail));
        Assert.assertTrue(this.textBoxPage.userCurrentAddressOutput.getText().contains(this.userCurrentAddress));
        Assert.assertTrue(this.textBoxPage.userPermanentAddressOutput.getText().contains(this.userPermanentAddress));
    }

    @Test
    public void userCanSubmitPartialDataWithoutEmail() throws InterruptedException {
        this.inputUserData(this.userName, this.userEmail, this.userCurrentAddress, this.userPermanentAddress);
        this.textBoxPage.userEmailInput.clear();
        this.scrollToElement(this.textBoxPage.submitButton);
        this.textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(this.textBoxPage.userNameOutput.getText().contains(this.userName));
        Assert.assertTrue(this.textBoxPage.userCurrentAddressOutput.getText().contains(this.userCurrentAddress));
        Assert.assertTrue(this.textBoxPage.userPermanentAddressOutput.getText().contains(this.userPermanentAddress));
    }

    @Test
    public void userCanSubmitPartialDataWithoutCurrentAddress() throws InterruptedException {
        this.inputUserData(this.userName, this.userEmail, this.userCurrentAddress, this.userPermanentAddress);
        this.textBoxPage.userCurrentAddressInput.clear();
        this.scrollToElement(this.textBoxPage.submitButton);
        this.textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(this.textBoxPage.userNameOutput.getText().contains(this.userName));
        Assert.assertTrue(this.textBoxPage.userEmailOutput.getText().contains(this.userEmail));
        Assert.assertTrue(this.textBoxPage.userPermanentAddressOutput.getText().contains(this.userPermanentAddress));
    }

    @Test
    public void userCanSubmitPartialDataWithoutPermanentAddress() throws InterruptedException {
        this.inputUserData(this.userName, this.userEmail, this.userCurrentAddress, this.userPermanentAddress);
        this.textBoxPage.userPermanentAddressInput.clear();
        this.scrollToElement(this.textBoxPage.submitButton);
        this.textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(this.textBoxPage.userNameOutput.getText().contains(this.userName));
        Assert.assertTrue(this.textBoxPage.userEmailOutput.getText().contains(this.userEmail));
        Assert.assertTrue(this.textBoxPage.userCurrentAddressOutput.getText().contains(this.userCurrentAddress));
    }

    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

