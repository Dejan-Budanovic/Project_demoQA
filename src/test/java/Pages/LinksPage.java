package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class LinksPage extends BaseTest {

    public LinksPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "simpleLink")
    public WebElement homePageNewTabLink;

    @FindBy(id = "dynamicLink")
    public WebElement homePageNewTabDynamicLink;

    @FindBy(id = "created")
    public WebElement createdAPILink;

    @FindBy(id = "no-content")
    public WebElement noContentAPILink;

    @FindBy(id = "moved")
    public WebElement movedAPILink;

    @FindBy(id = "bad-request")
    public WebElement badRequestAPILink;

    @FindBy(id = "unauthorized")
    public WebElement unauthorizedAPILink;

    @FindBy(id = "forbidden")
    public WebElement forbiddenAPILink;

    @FindBy(id = "invalid-url")
    public WebElement notFoundAPILink;

    @FindBy(id = "linkResponse")
    public WebElement responseMessage;

    public ArrayList<String> openTabs;

    //--------------------------------------------

    public void clickOnHomePageNewTabLink() {
        scrollToElement(homePageNewTabLink);
        homePageNewTabLink.click();
        openTabs = new ArrayList<>(driver.getWindowHandles());
    }

    public void clickOnHomePageNewTabDynamicLink() {
        scrollToElement(homePageNewTabDynamicLink);
        homePageNewTabDynamicLink.click();
        openTabs = new ArrayList<>(driver.getWindowHandles());
    }

    public void clickOnCreatedAPILink() {
        scrollToElement(createdAPILink);
        createdAPILink.click();
    }

    public void clickOnNoContentAPILink() {
        scrollToElement(noContentAPILink);
        noContentAPILink.click();
    }

    public void clickOnMovedAPILink() {
        scrollToElement(movedAPILink);
        movedAPILink.click();
    }

    public void clickBadRequestAPILink() {
        scrollToElement(badRequestAPILink);
        badRequestAPILink.click();
    }

    public void clickOnUnauthorizedAPILink() {
        scrollToElement(unauthorizedAPILink);
        unauthorizedAPILink.click();
    }

    public void clickOnfForbiddenAPILink() {
        scrollToElement(forbiddenAPILink);
        forbiddenAPILink.click();
    }

    public void clickOnNotFoundAPILink() {
        scrollToElement(notFoundAPILink);
        notFoundAPILink.click();
    }

}
