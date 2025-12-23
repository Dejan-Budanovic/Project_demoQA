package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(id = "firstName")
    public WebElement firstNameFieldWT;

    @FindBy(id = "lastName")
    public WebElement lastNameFieldWT;

    @FindBy(id = "userEmail")
    public WebElement emailFieldWT;

    @FindBy(id = "age")
    public WebElement ageFieldWT;

    @FindBy(id = "salary")
    public WebElement salaryFieldWT;

    @FindBy(id = "department")
    public WebElement departmentFieldWT;

    @FindBy(id = "submit")
    public WebElement submitButtonWT;

    @FindBy(css = "span[id^='delete-record']")
    public List<WebElement> deleteButtons;

    @FindBy(className = "rt-tr-group")
    public List<WebElement> rowContent;

    @FindBy(className = "rt-td")
    public List<WebElement> cell;

    //--------------------------------------------

    public void clickOnAddButton() {
        addButton.click();
    }

    public void inputFirstName(String firstName) {
        firstNameFieldWT.clear();
        firstNameFieldWT.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameFieldWT.clear();
        lastNameFieldWT.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        emailFieldWT.sendKeys(email);
    }

    public void inputAge(String age) {
        ageFieldWT.clear();
        ageFieldWT.sendKeys(age);
    }

    public void inputSalary(String salary) {
        salaryFieldWT.clear();
        salaryFieldWT.sendKeys(salary);
    }

    public void inputDepartment(String department) {
        departmentFieldWT.clear();
        departmentFieldWT.sendKeys(department);
    }

    public void clickOnSubmitButton() {
        submitButtonWT.click();
    }

    public void clickOnDeleteButton() {
        deleteButtons.get(0).click();
    }
}
