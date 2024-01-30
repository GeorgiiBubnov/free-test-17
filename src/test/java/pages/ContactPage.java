package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ContactPage {
    private SelenideElement email =  $(".elementor-element-f838116");

    @Step ("Проверка наличия электронной почты")
    public ContactPage checkEmail(String text) {

        email.shouldHave(text(text));
        return this;
    }
}
