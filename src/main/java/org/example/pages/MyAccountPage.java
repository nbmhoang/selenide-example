package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage extends BasePage {

    public void logOut() {
        clickMyAccountTab("Logout");
    }

    private void clickMyAccountTab(String label) {
        $(By.linkText(label)).click();
    }
}
