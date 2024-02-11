package tests;

import data.Language;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ContactPage;
import pages.MainPage;
import pages.MediaPage;
import pages.VacancyPage;

import java.util.List;
import java.util.stream.Stream;


import static com.codeborne.selenide.Configuration.baseUrl;


public class CyntekaTest extends TestBase {

    MainPage mainPage = new MainPage();
    VacancyPage vacancyPage = new VacancyPage();
    MediaPage mediaPage = new MediaPage();
    ContactPage contactPage = new ContactPage();

    @Test
    @Tag("smoke")
    @DisplayName("Проверка наличия вакансии в разделе 'Вакансии'")
    void verifyVacancy() {
        mainPage.openPage(baseUrl)
                .clickButtonAboutUs()
                .clickButtonVacancy();
        vacancyPage.checkVacancyDescription("Координатор отдела обработки данных");
    }


    @EnumSource(Language.class)
    @Tag("title")
    @ParameterizedTest(name = "Заголовок страницы должен выводиться на соответствующем языке {0}")
    @DisplayName("Проверка заголовка на соответствующем языке")
    void checkMainMenu(Language language) {
        mainPage.openPage(baseUrl)
                .chooseLanguage(language)
                .checkTitle(language);
    }

    static Stream<Arguments> checkDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(Language.RU,
                        List.of("Главная", "Возможности", "Кейсы", "О нас",
                                "Контакты"))
        );
    }

    @MethodSource
    @Tag("smoke")
    @ParameterizedTest(name = "Кнопки меню должны выводиться на соответствующем языке {0}")
    @DisplayName("Проверка кнопок меню страницы для каждого языка")
    void checkDisplayCorrectButtons(Language language, List<String> expectedButtons) {
        mainPage.openPage(baseUrl)
                .chooseLanguage(language)
                .checkMenuOfLanguage(expectedButtons);
    }


    @Test
    @Tag("title")
    @DisplayName("Проверка первого заголовка в Разделе о СМИ")
    void checkFirstTitleInMedia() {
        mainPage.openPage(baseUrl)
                .clickButtonMedia("СМИ о \"Синтека\"");
        mediaPage.checkFirstTitle("Разбираемся, зачем строительные компании внедряют цифровые решения и каких " +
                "результатов достигают с помощью инструментов нового поколения");

    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка наличия электронной почты в Разделе 'Контакты'")
    void checkEmail() {
        mainPage.openPage(baseUrl)
                .clickButtonContacts("Контакты");
        contactPage.checkEmail("info@cynteka.ru");

    }

}
