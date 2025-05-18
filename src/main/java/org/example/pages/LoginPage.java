package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;
import org.example.models.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    /**
     * Login with specific account without remember
     *
     * @param user
     */
    public void login(User user) {
        login(user, false);
    }

    @Step("Login as {user.email}")
    public void login(User user, boolean rememberMe) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        if (rememberMe) {
            rememberAccount();
        }
        clickLoginButton();
    }

    @Step("Enter email: {email}")
    private void enterEmail(@Param(mode = Parameter.Mode.HIDDEN) String email) {
        emailTextbox.press(email);
    }

    @Step("Enter password: {password}")
    private void enterPassword(@Param(mode = Parameter.Mode.MASKED) String password) {
        passwordTextbox.press(password);
    }

    @Step("Click LOGIN button")
    private void clickLoginButton() {
        loginButton.click();
    }

    private void rememberAccount() {
        rememberMeCheckBox.setSelected(true);
    }

    private final SelenideElement emailTextbox = $("#username");
    private final SelenideElement passwordTextbox = $("#password");
    private final SelenideElement loginButton = $(By.name("login"));
    private final SelenideElement rememberMeCheckBox = $("#rememberme");
}
