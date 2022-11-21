package org.selenium.pom.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.selenium.pom.api.actions.CartApi;
import org.selenium.pom.api.actions.SignUpApi;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.utils.FakerUtils;



public class LoginTest extends BaseTest {

    @Test
    public void loginDuringCheckout() throws InterruptedException {
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demopwd").
                setEmail(username + "@askomdch.com");

        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
        CartApi cartApi = new CartApi();
        cartApi.addToCart(1215, 1);

        CheckoutPage checkoutPage = new CheckoutPage(driver).load();
        Thread.sleep(5000);
        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();
        Thread.sleep(5000);
        checkoutPage.
                clickHereToLoginLink().
                login(user);
        Thread.sleep(5000);
        Assertions.assertEquals("Blue Shoes  × 1",  checkoutPage.getProductName());

    }

}
