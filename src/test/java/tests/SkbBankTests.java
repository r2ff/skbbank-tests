package tests;

import com.codeborne.selenide.Condition;
import helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class SkbBankTests extends TestBase {
    @Test
    @DisplayName("Переход на \"Вклады\" с главной страницы")
    void openDepositTabFromMainPageTest() {
        step("Открыть https://skbbank.ru/", () -> {
            open("https://skbbank.ru/");
        });

        step("Перейти на вкладку \"Вклады\"", () -> {
            $(".top-menu-block").find(byText("Вклады")).click();
            $(".detail").shouldHave(text("Вклады"));
        });
    }

    @Test
    @DisplayName("Проверка заголовка страницы")
    void checkTitleTest() {
        step("Open url 'https://skbbank.ru/'", () ->
            open("https://skbbank.ru/"));

        step("Page title should have text 'Частным клиентам: кредит наличными, интернет банк, вклады, кредитные карты с cash-back, переводы с карты на карту | СКБ-Банк'", () -> {
            String expectedTitle = "Частным клиентам: кредит наличными, интернет банк, вклады, кредитные карты с cash-back, переводы с карты на карту | СКБ-Банк";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Проверяем консоль браузера на наличие ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://skbbank.ru/'", () ->
            open("https://skbbank.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}