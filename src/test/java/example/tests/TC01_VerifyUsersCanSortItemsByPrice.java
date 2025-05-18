package example.tests;

import org.example.models.Product;
import org.example.pages.HomePage;
import org.example.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC01_VerifyUsersCanSortItemsByPrice extends TestBase {

    @Test(
            description = "Verify users can sort items by price"
    )
    public void verifyUsersCanSortItemsByPrice() {
        homePage.openShopPage();

        shopPage.closePromotionPopup();

        shopPage.switchToListView();

        shopPage.sortByPriceAsc();

        Assert.assertTrue(shopPage.isProductSortedByPriceAsc());

        shopPage.sortByPriceDesc();

        products = shopPage.getAllProducts();

        Assert.assertTrue(shopPage.isProductSortedByPriceDesc());
    }

    HomePage homePage = new HomePage();
    ShopPage shopPage = new ShopPage();
    List<Product> products;
}
