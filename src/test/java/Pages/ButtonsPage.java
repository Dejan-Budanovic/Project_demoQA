package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage extends BaseTest {

    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/button")
    public WebElement dynamicClickButton;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickButtonMessage;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickButtonMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickButtonMessage;

    //--------------------------------------------

    public void clickDoubleClickButton() {
        scrollToElement(doubleClickButton);
        Actions act = new Actions(driver);
        act.doubleClick(doubleClickButton).perform();
    }

    public void clickRightClickButton() {
        scrollToElement(rightClickButton);
        Actions act = new Actions(driver);
        act.contextClick(rightClickButton).perform();
    }

    public void clickDynamicClickButton() {
        scrollToElement(dynamicClickButton);
        dynamicClickButton.click();
    }
}

