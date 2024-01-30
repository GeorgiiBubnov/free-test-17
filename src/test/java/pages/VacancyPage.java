package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VacancyPage {
    private SelenideElement vacancyDescription = $(".elementor-element-f518fc9");


@Step("Проверить соответствие текста вакансии {0}")
public VacancyPage checkVacancyDescription(String vacancy) {

    vacancyDescription.shouldHave(text(vacancy));
    return this;
}

}