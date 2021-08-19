package tests;

import annotations.Layer;
import com.codeborne.selenide.Condition;
import helpers.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Alexey")
@Layer("web")
@Feature("Вклады")
public class SkbBankTests extends TestBase {
    @Test
    @Tag("web")
    @DisplayName("Проверка перехода страницу на \"Вклады\" с главной страницы")
    void openDepositTabFromMainPageTest() {
        step("Открываем https://skbbank.ru/", () -> {
            open("https://skbbank.ru/");
        });

        step("Перейти на страницу \"Вклады\"", () -> {
            $(".top-menu-block").find(byText("Вклады")).click();
            $(".detail").shouldHave(text("Вклады"));
        });
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка заголовка страницы")
    void checkTitleTextTest() {
        step("Открыть 'https://skbbank.ru/'", () ->
                open("https://skbbank.ru/"));

        step("Заголовок должен содержать текст 'Частным клиентам: кредит наличными, интернет банк, вклады, кредитные карты с cash-back, переводы с карты на карту | СКБ-Банк'", () -> {
            String expectedTitle = "Частным клиентам: кредит наличными, интернет банк, вклады, кредитные карты с cash-back, переводы с карты на карту | СКБ-Банк";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Tag("web")
    @DisplayName("Проверить консоль браузера на наличие ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открыть 'https://skbbank.ru/'", () ->
                open("https://skbbank.ru/"));

        step("В логах консоли не должно быть слова 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Tag("web")
    @DisplayName("Открыть страницу вклада \"Обыкновенное чудо\"")
    void openDepositAnOrdinaryMiracleTest() {
        step("Открыть страницу вкладов 'https://skbbank.ru/'", () -> {
            open("https://skbbank.ru/chastnym-licam/vklady");
        });

        step("Открыть вклад \"Обыкновенное чудо\"", () -> {
            $(".obyknovennoe-chudo .ui-btn").click();
            $(".promo-static-info").shouldHave(text("Обыкновенное чудо"));
        });
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка чекбокса при открытии вклада \"Обыкновенное чудо\" онлайн")
    void checkInterestRateWithOnlineOpeningDepositTest() {
        step("Открыть страницу вклада \"Обыкновенное чудо\"", () -> {
            open("https://skbbank.ru/chastnym-licam/vklady/obyknovennoe-chudo");
        });

        step("Проверить процентную ставку при онлайн открытии вклада", () -> {
            $(byText("Рассчитать доход по вкладу")).scrollTo();
            $(byText("Открыть онлайн")).click();
            $(".perc").shouldHave(text("6,7"));
        });
    }


    @Test
    @Tag("web")
    @DisplayName("Проверка чекбокса при открытии вклада \"Обыкновенное чудо\" в офисе")
    void checkInterestRateWithOpeningDepositInOfficeTest() {
        step("Открыть страницу вклада \"Обыкновенное чудо\"", ()
                -> {
            open("https://skbbank.ru/chastnym-licam/vklady/obyknovennoe-chudo");
        });

        step("Проверить процентную ставку открытия вклада в офисе", () -> {
            $(byText("Рассчитать доход по вкладу")).scrollTo();
            $("#open_in_office").parent().click();
            $(".perc").shouldHave(text("6,5"));
        });
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка чекбокса капитализация процентов")
    void checkCheckBoxCapitalizationOfInterestWithDefaultSettingsTest() {
        step("Открыть страницу вклада \"Обыкновенное чудо\"", ()
                -> {
            open("https://skbbank.ru/chastnym-licam/vklady/obyknovennoe-chudo");
        });

        step("Проверить работу чекбокса \"Капитализация процентов\"", () -> {
            $(byText("Рассчитать доход по вкладу")).scrollTo();
            $("#result").shouldHave(text("977"));
            $("#cpital").parent().click();
            $("#result").shouldHave(text("999"));

        });
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка ввода суммы с клавиатуры")
    void checkEnteringAmountOfMoneyWithKeyboard() {
        step("Открыть страницу вклада \"Обыкновенное чудо\"", ()
                -> {
            open("https://skbbank.ru/chastnym-licam/vklady/obyknovennoe-chudo");
        });

        step("Ввод суммы 20000", () -> {
            $(byText("Рассчитать доход по вкладу")).scrollTo();
            $(byName("summ")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            $(byName("summ")).setValue("20 000").pressEnter();
            $("#result").shouldHave(text("21 954"));

        });
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка ввода суммы с помощью слайдера")
    void checkEnteringAmountOfMoneyWithKeyboard2() {
        step("Открыть страницу вклада \"Обыкновенное чудо\"", ()
                -> {
            open("https://skbbank.ru/chastnym-licam/vklady/obyknovennoe-chudo");
        });

        step("Ввод суммы с помощью слайдера", () -> {
            $(byText("Рассчитать доход по вкладу")).scrollTo();
            $(byName("summ")).shouldHave(value("10 000"));
            actions().clickAndHold($(".ui-slider-handle")).moveByOffset(1, 0).release().perform();
            $(byName("summ")).shouldHave(value("2 647 000"));
            sleep(5000);
        });
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка периода вклада")
    void checkTimeOfDepositTest() {
        step("Открыть страницу вклада \"Обыкновенное чудо\"", ()
                -> {
            open("https://skbbank.ru/chastnym-licam/vklady/obyknovennoe-chudo");
        });

        step("Проверить срок вклада \"Обыкновенное чудо\"", () -> {
            $(byText("Рассчитать доход по вкладу")).scrollTo();
            $("#result").shouldHave(text("1080 дней"));
        });
    }

    @Test
    @Tag("web")
    @DisplayName("Проверить информацию о разделе \"Благотворительность\"")
    void checkCharityTextTest() {
        step("Открыть страницу вклада \"Обыкновенное чудо\"", ()
                -> {
            open("https://skbbank.ru/chastnym-licam/vklady/obyknovennoe-chudo");
        });

        step("Проверить информацию о разделе \"Благотворительность\"", () -> {
            $(byText("Рассчитать доход по вкладу")).scrollTo();
            $(".deposits-advantages-block-item-content-title").scrollTo().shouldHave(text("Благотворительность"));
            $(".deposits-advantages-block-item-content-txt").shouldHave(text("Синара"));
        });
    }
}