package aafanasyevaa;

import aafanasyevaa.testData.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class DemoQaTest extends TestData {
    @Test
    @DisplayName("Заполнение формы Demo QA и проверка после заполнения")
    @Tag("owner")
    @Owner("aafanasyevaa")
    @Feature("UI Test")
    @Story("Demo QA UI")
    @Severity(SeverityLevel.BLOCKER)

    public void demoQaTest() {

        step("Открыть главную страницу формы", () -> {
            open("https://demoqa.com/automation-practice-form");
        });

        step("Ввести имя в поле ввода", () -> {
            $("#firstName").setValue(firstName);
            ;
        });

        step("Ввести фамилию в поле ввода", () -> {
            $("#lastName").setValue(lastName);
            ;
        });

        step("Ввести e-mail в поле ввода", () -> {
            $("#userEmail").setValue(email);
            ;
        });

        step("Выбрать женский пол", () -> {
            $("#genterWrapper").find(byText("Female")).click();
            ;
        });

        step("Ввести номер телефона в поле ввода", () -> {
            $("#userNumber").setValue(phone);
        });

        step("Выбрать предмет в дропдаун меню", () -> {
            $("#subjectsInput").setValue("C").pressEnter();
        });

        step("Выбрать хобби", () -> {
            $("#hobbiesWrapper").find(byText("Reading")).click();
        });

        step("Загрузить картинку", () -> {
            $("#uploadPicture").uploadFromClasspath("png.jpg");
        });

        step("Ввести адрес", () -> {
            $("#currentAddress").setValue(address);
        });

        step("Выбрать штат", () -> {
            $("#state").click();
            $("#state").find(byText("NCR")).click();
        });

        step("Выбрать город", () -> {
            $("#city").click();
            $("#city").find(byText("Delhi")).click();
        });

        step("Нажать на кнопку Submit", () -> {
            $("#submit").click();
        });

        step("Проверить правильность отображения данных", () -> {
            $(".table-responsive").shouldHave(text(firstName), text(lastName), text(email), text("Female"),
                    text(phone), text("Physics"), text("Reading"), text("png.jpg"), text(address), text("NCR"), text("Delhi"));
        });
    }
}