package example.tests;

import org.example.pages.HomePage;
import org.example.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_VerifyUsersCanSearchProductByName extends TestBase {

    @Test
    public void tc03() {
        homePage.search(text);

        shopPage.closePromotionPopup();

        Assert.assertTrue(shopPage.allProductNameContains(text));
    }

    String text = "camera";
    HomePage homePage = new HomePage();
    ShopPage shopPage = new ShopPage();
}
