package page_object;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public static void openMainPage() {
        Selenide.open("https://ifellow.ru/");
        $(By.xpath("//button[@class='app-close']")).click();
    }

    public static AboutUsPage goAboutUsPage() {
        $(By.xpath("//a[@href='/about-us']")).click();
        return new AboutUsPage();
    }

}
