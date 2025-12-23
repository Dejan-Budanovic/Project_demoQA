package Tests;

import Base.BaseTest;
import Pages.CheckBoxPage;
import Pages.HomePage;
import Pages.LinksPage;
import Pages.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Elements_Links extends BaseTest {
    String cardName = "Elements";
    String sideBarItem = "Links";
    String homePageExpectedURL = "https://demoqa.com/elements";
    String linksExpectedURL = "https://demoqa.com/links";

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        homePage = new HomePage();
        sideBar = new SideBar();
        linksPage = new LinksPage();
        scrollToElement(homePage.getCard(cardName));
        homePage.clickOnCard(cardName);
        Assert.assertEquals(driver.getCurrentUrl(), homePageExpectedURL);
        sideBar.clickOnSideBarItem(sideBarItem);
        Assert.assertEquals(driver.getCurrentUrl(), linksExpectedURL);
    }

    @Test
    public void userCanOpenLinkInNewWindow() throws InterruptedException {
        linksPage.clickOnHomePageNewTabLink();
        //Thread.sleep(5000);
        driver.switchTo().window(linksPage.openTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test
    public void userCanOpenDynamicLinkInNewWindow() throws InterruptedException {
        linksPage.clickOnHomePageNewTabDynamicLink();
        //Thread.sleep(5000);
        driver.switchTo().window(linksPage.openTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    public static int getStatusCode(String url) {
        return given()
                .redirects().follow(false)
                .when()
                .get(url)
                .then()
                .extract()
                .statusCode();
    }

    @Test
    public void verifyCreatedLinkResponse() throws InterruptedException {

        linksPage.clickOnCreatedAPILink();
        Thread.sleep(1000);
        scrollToElement(linksPage.responseMessage);
        String response = linksPage.responseMessage.getText();

        String id = linksPage.createdAPILink.getAttribute("id");
        System.out.println(id);
        int statusCode = getStatusCode("https://demoqa.com/" + id);

        Assert.assertEquals(statusCode, 201);
        Assert.assertTrue(response.contains("201"));
        Assert.assertTrue(response.contains("Created"));
    }

    @Test
    public void verifyNoContentLinkResponse() throws InterruptedException {

        linksPage.clickOnNoContentAPILink();
        Thread.sleep(1000);
        scrollToElement(linksPage.responseMessage);
        String response = linksPage.responseMessage.getText();

        String id = linksPage.noContentAPILink.getAttribute("id");
        System.out.println(id);
        int statusCode = getStatusCode("https://demoqa.com/" + id);

        Assert.assertEquals(statusCode, 204);
        Assert.assertTrue(response.contains("204"));
        Assert.assertTrue(response.contains("No Content"));
    }

    @Test
    public void verifyMovedLinkResponse() throws InterruptedException {

        linksPage.clickOnMovedAPILink();
        Thread.sleep(1000);
        scrollToElement(linksPage.responseMessage);
        String response = linksPage.responseMessage.getText();

        String id = linksPage.movedAPILink.getAttribute("id");
        System.out.println(id);
        int statusCode = getStatusCode("https://demoqa.com/" + id);

        Assert.assertEquals(statusCode, 301);
        Assert.assertTrue(response.contains("301"));
        Assert.assertTrue(response.contains("Moved Permanently"));
    }

    @Test
    public void verifyBadRequestLinkResponse() throws InterruptedException {

        linksPage.clickBadRequestAPILink();
        Thread.sleep(1000);
        scrollToElement(linksPage.responseMessage);
        String response = linksPage.responseMessage.getText();

        String id = linksPage.badRequestAPILink.getAttribute("id");
        System.out.println(id);
        int statusCode = getStatusCode("https://demoqa.com/" + id);

        Assert.assertEquals(statusCode, 400);
        Assert.assertTrue(response.contains("400"));
        Assert.assertTrue(response.contains("Bad Request"));
    }

    @Test
    public void verifyUnauthorizedLinkResponse() throws InterruptedException {

        linksPage.clickOnUnauthorizedAPILink();
        Thread.sleep(1000);
        scrollToElement(linksPage.responseMessage);
        String response = linksPage.responseMessage.getText();

        String id = linksPage.unauthorizedAPILink.getAttribute("id");
        System.out.println(id);
        int statusCode = getStatusCode("https://demoqa.com/" + id);

        Assert.assertEquals(statusCode, 401);
        Assert.assertTrue(response.contains("401"));
        Assert.assertTrue(response.contains("Unauthorized"));
    }

    @Test
    public void verifyForbiddenLinkResponse() throws InterruptedException {

        linksPage.clickOnfForbiddenAPILink();
        Thread.sleep(1000);
        scrollToElement(linksPage.responseMessage);
        String response = linksPage.responseMessage.getText();

        String id = linksPage.forbiddenAPILink.getAttribute("id");
        System.out.println(id);
        int statusCode = getStatusCode("https://demoqa.com/" + id);

        Assert.assertEquals(statusCode, 403);
        Assert.assertTrue(response.contains("403"));
        Assert.assertTrue(response.contains("Forbidden"));
    }

    @Test
    public void verifyNotFoundLinkResponse() throws InterruptedException {

        linksPage.clickOnNotFoundAPILink();
        Thread.sleep(1000);
        scrollToElement(linksPage.responseMessage);
        String response = linksPage.responseMessage.getText();

        String id = linksPage.notFoundAPILink.getAttribute("id");
        System.out.println(id);
        int statusCode = getStatusCode("https://demoqa.com/" + id);

        Assert.assertEquals(statusCode, 404);
        Assert.assertTrue(response.contains("404"));
        Assert.assertTrue(response.contains("Not Found"));
    }

    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}


