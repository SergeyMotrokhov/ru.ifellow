package page_object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static helper.Helper.SLEEP;

public class AboutUsPage {

    public static void goLinksAboutUs() {
        SoftAssertions softy = new SoftAssertions();
        ElementsCollection linksAboutUsElements = getLinksAboutUsElements();
        int size = linksAboutUsElements.size();
        for (int i = 0; i < size; i++) {
            try {
                linksAboutUsElements.get(i).shouldBe(visible).click();
                sleep(SLEEP);
                String linkAboutUs = linksAboutUsElements.get(i).getText();
                assertionHeaders(softy, linkAboutUs);
            } catch (StaleElementReferenceException e) {
                e.getCause();
            }
        }
        softy.assertAll();
    }

    private static void assertionHeaders(SoftAssertions softy, String link) {
        List<String> listHeaders = getListTextFromElementsCollection(getHeaderAboutUsElements());
        String header = listHeaders.get(0);
        softy.assertThat(header).as("Header <%s> должен содержать текст <%s>", header, link).contains(link);
    }

    private static List<String> getListTextFromElementsCollection(ElementsCollection elements) {
        List<String> list = new ArrayList<>();
        for (SelenideElement e : elements) {
            list.add(e.shouldBe(visible).getText());
        }
        return list;
    }

    private static ElementsCollection getLinksAboutUsElements() {
        return $$(By.xpath("//*[@class='page-bottom-nav']//a"));
    }

    private static ElementsCollection getHeaderAboutUsElements() {
        return $$(By.xpath("//*[contains(@href, 'about-us')]/following-sibling::div/h1"));
    }

}
