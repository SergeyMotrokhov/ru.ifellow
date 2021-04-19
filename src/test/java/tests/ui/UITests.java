package tests.ui;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static helper.Helper.URL;
import static steps.ui.UISteps.*;

public class UITests extends BaseTest {

    @Test
    @Description(value = "Проверка переходов по ссылкам 'О нас' и соответствия заголовков на сайте " + URL)
    public void aboutUsTest() {
        goMainPageStep();
        goAboutUsPageStep();
        assetionHeadersAboutUsPageStep();
    }
}
