package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonePageSucessFully() {
        //1.1 Mouse Hover on “Electronics” Tab
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"))).perform();
        //1.2 Mouse Hover on “Cell phones” and click
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")).click();
        //1.3 Verify the text “Cell phones”
        String expectedCellPhone = "Cell phones";
        String actualCellPhone = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Text Matched", expectedCellPhone, actualCellPhone);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        String email="yogesh8a@gmail.com";
        // 2.1 Mouse Hover on “Electronics”
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"))).perform();

        // 2.2 Mouse Hover on “Cell phones” and click
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")).click();

        // 2.3 Verify the text “Cell phones”
        String expectedcellphone = "Cell phones";
        String actualcellphone = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Text Matched", expectedcellphone, actualcellphone);

        //2.4 Click on List View Tab
        driver.findElement(By.xpath("//a[contains(text(),'List')]")).click();

        Thread.sleep(2000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        WebElement nokiaLink = driver.findElement(By.linkText("Nokia Lumia 1020"));
        nokiaLink.click();

        //2.6 Verify the text “Nokia Lumia 1020”
        String expectednokialumia = "Nokia Lumia 1020";
        String actualnokialumia = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Text Matched", expectednokialumia, actualnokialumia);

        //2.7 Verify the price “$349.00”
        String expectednokialumiaprice = "$349.00";
        String actualnokialumiaprice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("Text Matched", expectednokialumiaprice, actualnokialumiaprice);

        // 2.8 Change quantity to 2
        clearTextToElement(By.name("addtocart_20.EnteredQuantity"));
        sendTextToElement(By.name("addtocart_20.EnteredQuantity"), "2");

        //2.9 Click on “ADD TO CART” tab
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-20\"]")).click();

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedProAdded = "The product has been added to your shopping cart";
        String actualProAdded = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Text Matched", expectedProAdded, actualProAdded);

        //After that close the bar clicking on the cross button.
        driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]")).click();

        //2.11 hen MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions builder2 = new Actions(driver);
        builder2.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"flyout-cart\"]/div/div[4]/button")).click();

        //2.12 Verify the message "Shopping cart"
        String expectedShoppingCart = "Shopping cart";
        String actualShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text Matched", expectedShoppingCart, actualShoppingCart);

        //2.13 Verify the quantity is 2
        clearTextToElement(By.id("product_enteredQuantity_20"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        Thread.sleep(2500);
        //2.14 Verify the Total $698.00
        String expectedTotalPrice = "$698.00";
        String actualTotalPrice = getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[6]/span"));
        Assert.assertEquals("Text Matched", expectedTotalPrice, actualTotalPrice);

        //2.15 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[3]/label")).click();

        //2.16 Click on “CHECKOUT”
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedSignInMessage1 = "Welcome, Please Sign In!";
        String actualSignInMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Text Matched", expectedSignInMessage1, actualSignInMessage1);

        //2.18 Click on “REGISTER” tab
        driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();

        //2.19 Verify the text “Register”
        String expectedRegister = "Register";
        String actualRegister = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Text Matched", expectedRegister, actualRegister);

        // 2.20 Fill the mandatory fields
        //Add first name
        sendTextToElement(By.id("FirstName"), "Yogesh");
        //Add Last name
        sendTextToElement(By.id("LastName"), "Patel");
        //Add email address Password
        sendTextToElement(By.id("Email"), email);
        //Add Password
        sendTextToElement(By.id("Password"), "Anu123");
        // Conform Password
        sendTextToElement(By.id("ConfirmPassword"), "Anu123");

        // 2.21 Click on “REGISTER” Button
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();

        //2.22 Verify the message “Your registration completed”
        String expectedRegisterText = "Your registration completed";
        String actualRegisterText = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals("Text Matched", expectedRegisterText, actualRegisterText);

        //2.23 Click on “CONTINUE” tab
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();

        //2.24 Verify the text “Shopping card”
        String expectedShoppingCard = "Shopping cart";
        String actualShoppingCard = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text Matched", expectedShoppingCard, actualShoppingCard);

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        driver.findElement(By.id("Email")).sendKeys(email);
        //  Enter valid password
        driver.findElement(By.id("Password")).sendKeys("Anu123");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        // 2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //  2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        // 2.27 Fill the Mandatory fields
        WebElement country = driver.findElement(By.name("BillingNewAddress.CountryId"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("United Kingdom"); //Select by visible text
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "11 home Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "NH1 1PD");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "01234567890");

        // 2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //  2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//label[contains(text(),'2nd Day Air ($0.00)')]"));

        //  2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //  2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //  2.32 Select “Visa” From Select credit card dropdown
        WebElement card = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
        Select credit = new Select(card);
        credit.selectByVisibleText("Visa"); //Select by visible text

        //   2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "y patel");
        sendTextToElement(By.id("CardNumber"), "5368392055488809");
        WebElement expiryDate = driver.findElement(By.id("ExpireMonth"));
        Select date = new Select(expiryDate);
        date.selectByVisibleText("03"); //Select by visible text
        WebElement expiryYear = driver.findElement(By.id("ExpireYear"));
        Select year = new Select(expiryYear);
        year.selectByVisibleText("2024"); //Select by visible text
        sendTextToElement(By.id("CardCode"), "365");

        //   2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        // 2.35 Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[2]/ul/li/span[2]"));
        Assert.assertEquals("Text Matched", expectedPaymentMethod, actualPaymentMethod);

        //  2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedShippingMethod = "2nd Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[2]/ul/li/span[2]"));
        Assert.assertEquals("Text Matched", expectedShippingMethod, actualShippingMethod);
        //2.37 Verify Total is “$698.00”

        String expectedPayment1 = "$698.00";
        String actualPayment1 = getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div/div/table/tbody/tr[4]/td[2]/span/strong"));
        Assert.assertEquals(expectedPayment1, actualPayment1);

        // 2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”
        String expectedThankYou = "Thank you";
        String actualThankYou = driver.findElement(By.xpath("//h1[contains(text(),'Thank you')]")).getText();
        Assert.assertEquals(expectedThankYou, actualThankYou);

        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMessage1 = "Your order has been successfully processed!";
        String actualMessage1 = driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")).getText();
        Assert.assertEquals(expectedMessage1, actualMessage1);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        String expectedWelcomeText1 = "Welcome to our store";
        String actualWelcomeText1 = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")).getText();
        Assert.assertEquals(expectedWelcomeText1, actualWelcomeText1);

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}









