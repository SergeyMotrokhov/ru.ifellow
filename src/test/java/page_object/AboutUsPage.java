package page_object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class AboutUsPage {
    static ElementsCollection linksAboutUsElements = $$(By.xpath("//*[@class='page-bottom-nav']//a"));

    public static void goLinksAboutUs() {
        List<String> list = getLinksAboutUsList(linksAboutUsElements);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                linksAboutUsElements.get(i).shouldBe(visible).click();
                sleep(10000);
            } catch (StaleElementReferenceException e) {
                e.getCause();
            }
        }
    }

    private static List<String> getLinksAboutUsList(ElementsCollection elements) {
        List<String> list = new ArrayList<>();
        for (SelenideElement e : elements) {
            list.add(e.shouldBe(visible).getText());
        }
        return list;
    }
}
