package Tests;

import Base.BaseTest;
import Pages.CheckBoxPage;
import Pages.HomePage;
import Pages.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Elements_CheckBox extends BaseTest {
    String cardName = "Elements";
    String sideBarItem = "Check Box";
    String homePageExpectedURL = "https://demoqa.com/elements";
    String checkBoxExpectedURL = "https://demoqa.com/checkbox";

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        homePage = new HomePage();
        sideBar = new SideBar();
        checkBoxPage = new CheckBoxPage();
        scrollToElement(homePage.getCard(cardName));
        homePage.clickOnCard(cardName);
        Assert.assertEquals(driver.getCurrentUrl(), homePageExpectedURL);
        sideBar.clickOnSideBarItem(sideBarItem);
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxExpectedURL);
    }

    @Test
    public void userCanExpandTreeStructure() {
        checkBoxPage.clickOnExpandAllButton();
        Assert.assertEquals(checkBoxPage.checkBoxesList.size(), 17);
    }

    @Test
    public void userCanCollapseTreeStructure() throws InterruptedException {
        checkBoxPage.clickOnExpandAllButton();
        Assert.assertEquals(checkBoxPage.checkBoxesList.size(), 17);
        checkBoxPage.clickOnCollapseAllButton();
        Assert.assertEquals(checkBoxPage.checkBoxesList.size(), 1);
    }

    @Test
    public void userCanSelectAllCheckBoxesAtOnce() {
        checkBoxPage.clickOnExpandAllButton();
        checkBoxPage.clickOnCheckBox("Home");
        Assert.assertEquals(checkBoxPage.checkBoxesList.size(), 17);
    }

    @Test
    public void userCanSelectAnyCheckbox() throws InterruptedException {
        checkBoxPage.clickOnExpandAllButton();
        System.out.println(checkBoxPage.checkBoxesList.size());
        Thread.sleep(1000L);
        boolean exists = false;

        for (int i = 0; i < checkBoxPage.checkBoxesList.size(); ++i) {
            scrollToElement(checkBoxPage.checkBoxesList.get(i));
            checkBoxPage.clickOnCheckBox(checkBoxPage.checkBoxesList.get(i).getText());
            Thread.sleep(1000L);

            for (int j = 0; j < checkBoxPage.selectedBoxesList.size(); ++j) {
                if (checkBoxPage.checkBoxesList.get(i).getText().equalsIgnoreCase(checkBoxPage.selectedBoxesList.get(j).getText())) {
                    exists = true;
                    break;
                }
                Assert.assertTrue(exists);
            }
        }
    }

    @Test
    public void userCanSelectMultipleRandomCheckboxes() {
        checkBoxPage.clickOnRandomCheckBoxes();
        Assert.assertEquals(checkBoxPage.selectedBoxesList.size(), checkBoxPage.successMessageList.size());
    }

    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}


