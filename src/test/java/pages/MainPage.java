package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.Language;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement buttonAboutUs = $(".menu-item-1173"),
            buttonVacancy = $(byText("Вакансии")),
            languageElement = $(".elementor-element-d4bf4a6"),
            title = $(".elementor-headline-text-wrapper"),
            media = $(".elementor-element-bcec537"),
            buttonOfContacts = $("#menu-1-891ce5f").$(".menu-item-2419");

    private ElementsCollection buttonsAllMenu =
            $$("#menu-1-891ce5f li.menu-item:not(.sub-menu):not(.menu-item-object-page)");

    @Step("Открыть главную страницу")
    public MainPage openPage(String url) {
        open(url);

        return this;
    }

    @Step("Нажать на кнопку 'О нас'")
    public MainPage clickButtonAboutUs() {
        buttonAboutUs.click();

        return this;

    }

    @Step("Нажать на кнопку 'Вакансия'")
    public MainPage clickButtonVacancy() {

        buttonVacancy.click();

        return this;
    }

    @Step("Выбор соответствующего языка {0}")
    public MainPage chooseLanguage(Language language) {
        languageElement.$(byText(language.getName())).click();

        return this;

    }

    @Step("Проверка заголовка на соответствующем языке {0}")
    public MainPage checkTitle(Language language) {
        title.shouldHave(text(language.getDescription()));

        return this;
    }

    @Step("Проверка названия меню на соответствующем языке {0}")
    public MainPage checkMenuOfLanguage(List<String> text) {

        buttonsAllMenu.shouldHave(texts(text));
        return this;
    }

    @Step("Нажать на кнопку 'Синтека о СМИ'")
    public MainPage clickButtonMedia(String text) {

        media.$(byText(text)).click();
        return this;

    }

    @Step("Нажать на кнопку 'Контакты'")
    public MainPage clickButtonContacts (String text) {
        buttonOfContacts.$(byText(text)).click();

        return this;
    }
}
