package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;
import org.example.constants.SearchCategory;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.example.utils.DriverUtils.waitForPageLoad;

public class BasePage {

    @Step("Open My Account page")
    public void openMyAccountPage() {
        loginSignUpLabel.click();
    }

    @Step("Search {text} in {category}")
    public void search(SearchCategory category, String text) {
        selectSearchCategory(category);
        enterSearchTextBox(text);
        submitSearch();
        waitForPageLoad();
    }

    /**
     * Search a product in all categories
     *
     * @param text
     */
    public void search(String text) {
        search(SearchCategory.ALL, text);
    }

    public void openWishlist() {

    }

    @Step("Open Cart page")
    public void openCart() {
        cartButton.click();
    }

    public void closePromotionPopup() {
        if (closePromotionButton.exists()) {
            closePromotionButton.click();
            closePromotionButton.shouldBe(Condition.disappear);
        }
    }

    public void openAboutUsPage() {
        openNavBarPage("About Us");
    }

    public void openShopPage() {
        openNavBarPage("Shop");
    }

    public void openOffersPage() {
        openNavBarPage("Offers");
    }

    public void openBlogPage() {
        openNavBarPage("Blog");
    }

    public void openContactUsPage() {
        openNavBarPage("Contact Us");
    }

    @Step("Open {label} page from navigation bar")
    protected void openNavBarPage(@Param(mode = Parameter.Mode.HIDDEN) String label) {
        $(By.linkText(label)).click();
    }

    private void selectSearchCategory(SearchCategory category) {
        searchCategorySelect.selectOption(category.getText());
    }

    private void enterSearchTextBox(String value) {
        searchTextbox.setValue(value);
    }

    private void submitSearch() {
        searchTextbox.pressEnter();
    }

    private final SelenideElement loginSignUpLabel = $(By.xpath("//a[span[normalize-space()='Log in / Sign up']]"));
    private final SelenideElement searchCategorySelect = $(By.name("product_cat"));
    private final SelenideElement searchTextbox = $(By.name("s"));
    private final SelenideElement closePromotionButton = $(".pum-close.popmake-close");
    private final SelenideElement cartButton = $(".et_b_header-cart");

}
