package example.tests;

import org.example.dao.UserDAO;
import org.example.models.User;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.MyAccountPage;
import org.testng.annotations.Test;

public class TC02_VerifyUsersCanLoginTheirAccount extends TestBase {

    @Test
    public void t() {
        homePage.openMyAccountPage();

        loginPage.login(user);

        myAccountPage.logOut();
    }

    User user = UserDAO.getUser();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();
}
