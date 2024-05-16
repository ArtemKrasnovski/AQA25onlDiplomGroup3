package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "name")
    public WebElement emailInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "button_primary")
    public WebElement loginButton;

    public LoginPage(WebDriver driver, boolean isOpenedByUrl) {
        super(driver, isOpenedByUrl);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return emailInput;
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    public LoginPage enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public DashboardPage successfulLogIn(User user) {
        this.enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .clickLoginButton();
        return new DashboardPage(driver, true);
    }
}