package steps.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static page_object.AboutUsPage.goLinksAboutUs;
import static page_object.MainPage.goAboutUsPage;
import static page_object.MainPage.openMainPage;

public class UISteps {
    private static SelenideElement title = $(By.xpath("//*[text()='iFellow - Quality. Clarity. Performance. Reality.']"));

    @Step("Переход на главную страницу и проверка, что Title содержит значение iFellow")
    public static void goMainPageStep() {
        openMainPage();
        assertTrue(title.innerText().contains("iFellow"));
    }


    @Step("Переход в меню 'О нас'")
    public static void goAboutUsPageStep() {
        goAboutUsPage();
    }


    @Step("Проверка переходов по ссылкам в меню 'О нас'")
    public static void goLinksAboutUsPageStep() {
        goLinksAboutUs();
    }
}
