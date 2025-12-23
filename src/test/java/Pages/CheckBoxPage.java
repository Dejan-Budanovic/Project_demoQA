package Pages;

import Base.BaseTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage extends BaseTest {

    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "rct-option-collapse-all")
    public WebElement collapseAllButton;

    @FindBy(css = "button[title='Expand all']")
    public WebElement expandAllButton;

    @FindBy(id = "tree-node")
    public WebElement checkBoxesListParent;

    @FindBy(className = "text-success")
    public List<WebElement> successMessageList;

    public List<WebElement> selectedBoxesList;

    public List<WebElement> checkBoxesList;

    //--------------------------------------------

    public void clickOnExpandAllButton() {
        this.expandAllButton.click();
        this.checkBoxesList = checkBoxesListParent.findElements(By.cssSelector(".rct-title"));
    }

    public void clickOnCollapseAllButton() {
        collapseAllButton.click();
        checkBoxesList = checkBoxesListParent.findElements(By.cssSelector(".rct-title"));
    }

    public void clickOnCheckBox(String checkBoxTitle) {
        for (int i = 0; i < this.checkBoxesList.size(); ++i) {
            if (checkBoxesList.get(i).getText().equals(checkBoxTitle)) {
                checkBoxesList.get(i).click();
                selectedBoxesList = driver.findElements(By.className("text-success"));
                break;
            }
        }

    }

    public void clickOnRandomCheckBoxes() {
        clickOnExpandAllButton();
        int max = checkBoxesList.size();
        int rand = (int) (Math.random() * max + 1);
        for (int i = 0; i < rand; ++i) {
            int randr = (int) (Math.random() * max);
            scrollToElement(checkBoxesList.get(randr));
            checkBoxesList.get(randr).click();
            selectedBoxesList = driver.findElements(By.className("rct-icon-check"));
        }
    }
}
