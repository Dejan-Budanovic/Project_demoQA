package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;
    public ExcelReader excelReader;
    public HomePage homePage;
    public SideBar sideBar;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        this.excelReader = new ExcelReader("webtablesdata.xlsx");
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown() {
//        driver.close();
//        driver.quit();
    }
}
