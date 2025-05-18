package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.example.constants.SortOption;
import org.example.models.Product;
import org.example.utils.DriverUtils;
import org.openqa.selenium.By;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Float.parseFloat;

@Slf4j
public class ShopPage extends BasePage {

    @Step("Select {size} items per page")
    public void changePageSize(int size) {
        pageSizeSelect.selectOption(String.valueOf(size));
    }

    public void toggleFilterPanel() {
        filterToggleButton.click();
    }

    @Step("Switch to List view mode")
    public void switchToListView() {
        switchListViewButton.click();
        waitForProductUpdating();
    }

    @Step("Switch to Grid view mode")
    public void switchToGridView() {
        switchGridViewButton.click();
    }

    public List<Product> getAllProducts() {
        int total = getTotalProducts();
        return IntStream.rangeClosed(1, total)
                .mapToObj(this::getProductByIndex)
                .collect(Collectors.toList());
    }

    public Product getProductByIndex(int index) {
        Product product = new Product();
        product.setName(getProductNameByIndex(index - 1));
        product.setPrice(getProductPriceByIndex(index - 1));
        return product;
    }

    public void openProductDetailByIndex(int index) {

    }

    public void addToCart(Product product) {

    }

    public void sortByPriceAsc() {
        sort(SortOption.PRICE_ASC);
    }

    public void sortByPriceDesc() {
        sort(SortOption.PRICE_DESC);
    }

    public boolean isProductSortedByPriceAsc() {
        return isProductSortedBy((a, b) -> a.getPrice() <= b.getPrice());
    }

    public boolean isProductSortedByPriceDesc() {
        return isProductSortedBy((a, b) -> a.getPrice() >= b.getPrice());
    }

    private boolean isProductSortedBy(BiFunction<Product, Product, Boolean> condition) {
        int total = getTotalProducts();
        for (int i = 1; i < total; i++) {
            if (!condition.apply(getProductByIndex(i), getProductByIndex(i + 1))) {
                log.info("Wrong");
                return false;
            }
        }
        return true;
    }

    public boolean allProductNameContains(String text) {
        return $$(productNameLabelLocator)
                .stream().allMatch(p -> {
                    String productName = p.text();
                    if (productName.toLowerCase().contains(text)) {
                        return true;
                    }
                    log.info("{} does not contains {}", productName, text);
                    return false;
                });
    }

    protected String getProductNameByIndex(int index) {
        return $$(productNameLabelLocator).get(index).text();
    }

    protected float getProductPriceByIndex(int index) {
        String rawValue = $$(productPriceLabelLocator).get(index).text().replace(",", ""); // remove comma
        if (rawValue.contains(" ")) {
            // Original price + Discount price
            return parseFloat(rawValue.split(" ")[1].substring(1));
        }
        return parseFloat(rawValue.substring(1));
    }

    protected void sort(SortOption option) {
        sortSelect.selectOption(option.getValue());
        waitForProductUpdating();
    }

    private void waitForProductUpdating() {
        DriverUtils.waitForAjax();
    }

    private int getTotalProducts() {
        return productContainer.size();
    }

    private final SelenideElement filterToggleButton = $(".open-filters-btn");
    private final SelenideElement pageSizeSelect = $(By.name("et_per_page"));
    private final SelenideElement sortSelect = $(By.name("orderby"));
    private final SelenideElement switchListViewButton = $(".switch-list");
    private final SelenideElement switchGridViewButton = $(".switch-grid");
    private final ElementsCollection productContainer = $$(".content-product");
    private final By productNameLabelLocator = By.cssSelector("h2.product-title a");
    private final By productPriceLabelLocator = By.cssSelector("span.price");
}
