package org.selenium.pom.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.selenium.pom.base.BasePage;

import org.selenium.pom.objects.User;



public class CheckoutPage extends BasePage {


    private final By clickHereToLoginLink = By.cssSelector(".showlogin");
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[value='Login']");


    private final By productName = By.cssSelector("td[class='product-name']");
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage load(){
        load("/checkout/");
        return this;
    }

    public CheckoutPage clickHereToLoginLink(){
        wait.until(ExpectedConditions.elementToBeClickable(clickHereToLoginLink)).click();
        return this;
    }

    public CheckoutPage enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);

        return this;
    }

    public CheckoutPage enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        return this;
    }

    public CheckoutPage clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return this;
    }

    public CheckoutPage login(User user){
        return  enterUsername(user.getUsername()).enterPassword(user.getPassword()).clickLoginButton();
    }


    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

}
