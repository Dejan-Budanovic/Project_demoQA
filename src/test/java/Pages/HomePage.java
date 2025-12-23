package Pages;

import Base.BaseTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "card-body")
    public List<WebElement> cardsList;

    //--------------------------------------------

    public void clickOnCard(String cardName) {
        for (int i = 0; i < cardsList.size(); i++) {
            if (cardsList.get(i).getText().equals(cardName)) {
                cardsList.get(i).click();
                break;

            }
        }
    }

    public WebElement getCard(String cardName) {
        WebElement card = null;
        for (int i = 0; i < this.cardsList.size(); ++i) {
            if (this.cardsList.get(i).getText().equals(cardName)) {
                card = cardsList.get(i);

            }
        }
        return card;
    }
}