package tests.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.timeout = 50000;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = false;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
    }

}
