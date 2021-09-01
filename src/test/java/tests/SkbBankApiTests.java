package tests;

import annotations.Layer;
import helpers.AllureRestAssuredFilter;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Owner("Alexey")
@Layer("api")
@Feature("Вклады")
public class SkbBankApiTests{

    @Test
    @Tag("api")
    @DisplayName("Проверка расчета калькулятора при минимальной сумме")
    void checkCalculationWithMinAmount() {
        step("Проверяем расчет калькулятора", () -> {

            given()
                    .filter(AllureRestAssuredFilter.withCustomTemplates())
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .header("x-requested-with", "XMLHttpRequest")
                    .body("online=1&" +
                            "id=37&" +
                            "code=&" +
                            "iblock_id=8&" +
                            "period=1080&" +
                            "summ=10000")
                    .when()
                    .post("https://skbbank.ru/local/templates/main/include/pages/chastnym-licam/vklady/ajax/calc_vklady.php")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .body("summ", is("1 057"));
        });
    }

    @Test
    @Tag("api")
    @DisplayName("Проверка расчета калькулятора при сумме меньше минимальной")
    void checkCalculationWithAmountLessThenMinimum() {
        step("Проверяем расчет калькулятора", () -> {

            given()
                    .filter(AllureRestAssuredFilter.withCustomTemplates())
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .header("x-requested-with", "XMLHttpRequest")
                    .body("online=1&" +
                            "id=37&" +
                            "code=&" +
                            "iblock_id=8&" +
                            "period=1080&" +
                            "summ=9999")
                    .when()
                    .post("https://skbbank.ru/local/templates/main/include/pages/chastnym-licam/vklady/ajax/calc_vklady.php")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .body("summ", is("0"));
        });
    }

    @Test
    @Tag("api")
    @DisplayName("Проверка расчета калькулятора при максимальной сумме")
    void checkCalculationWithMaxAmount() {
        step("Проверяем расчет калькулятора", () -> {

            given()
                    .filter(AllureRestAssuredFilter.withCustomTemplates())
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .header("x-requested-with", "XMLHttpRequest")
                    .body("online=1&" +
                            "id=37&" +
                            "code=&" +
                            "iblock_id=8&" +
                            "period=1080&" +
                            "summ=100000000")
                    .when()
                    .post("https://skbbank.ru/local/templates/main/include/pages/chastnym-licam/vklady/ajax/calc_vklady.php")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .body("summ", is("11 069 863"));
        });
    }

    @Test
    @Tag("api")
    @DisplayName("Проверка расчета калькулятора при сумме больше максимальной")
    void checkCalculationWithAmountMoreThenMax() {
        step("Проверяем расчет калькулятора", () -> {

            given()
                    .filter(AllureRestAssuredFilter.withCustomTemplates())
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .header("x-requested-with", "XMLHttpRequest")
                    .body("online=1&" +
                            "id=37&" +
                            "code=&" +
                            "iblock_id=8&" +
                            "period=1080&" +
                            "summ=100000001")
                    .when()
                    .post("https://skbbank.ru/local/templates/main/include/pages/chastnym-licam/vklady/ajax/calc_vklady.php")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .body("summ", is("0"));
        });
    }

    @Test
    @Tag("api")
    @DisplayName("Проверка расчета калькулятора при минимальной сумме, при открытии вклада в офисе")
    void checkCalculationWithoutOnlineOpening() {
        step("Проверяем расчет калькулятора", () -> {

            given()
                    .filter(AllureRestAssuredFilter.withCustomTemplates())
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .header("x-requested-with", "XMLHttpRequest")
                    .body("online=&" +
                            "id=37&" +
                            "code=&" +
                            "iblock_id=8&" +
                            "period=1080&" +
                            "summ=10000")
                    .when()
                    .post("https://skbbank.ru/local/templates/main/include/pages/chastnym-licam/vklady/ajax/calc_vklady.php")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .body("summ", is("978"));
        });
    }

    @Test
    @Tag("api")
    @DisplayName("Проверка расчета калькулятора с пустыми данными")
    void checkCalculationWithout() {
        step("Проверяем расчет калькулятора", () -> {

            given()
                    .filter(AllureRestAssuredFilter.withCustomTemplates())
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .header("x-requested-with", "XMLHttpRequest")
                    .body("")
                    .when()
                    .post("https://skbbank.ru/local/templates/main/include/pages/chastnym-licam/vklady/ajax/calc_vklady.php")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .body("summ", is("0"))
                    .body("period", is(" дней"))
                    .body("final_date_summ", is("0"));
        });
    }

}