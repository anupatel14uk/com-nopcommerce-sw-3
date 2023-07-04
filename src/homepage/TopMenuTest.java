package homepage;

import org.junit.*;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu)
    {
        String xpath = "//a[text()='"+menu+"']";
        //Find element
        By element = By.xpath(xpath);
        //Click element
        clickOnElement(element);
    }

    @Test
    public void verifyPageNavigation()
    {
        selectMenu("Computers ");

        //Find expected element
        String actualResult=getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        String expectedText="Computers";

        //Verify expected and actual text
        Assert.assertEquals("Text Matched",expectedText,actualResult);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}


