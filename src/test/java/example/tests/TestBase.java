package example.tests;

import org.example.utils.ConfigReader;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeClass
    public void setUp() {
        open(ConfigReader.getUrl());
    }

}
