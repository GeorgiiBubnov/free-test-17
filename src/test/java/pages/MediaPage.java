package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MediaPage {
    private SelenideElement firstLink =  $("#post-3589");

    @Step("Проверка первого заголовка")
    public MediaPage checkFirstTitle (String text) {
        firstLink.shouldHave(text(text));

        return this;
    }
}
