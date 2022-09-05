package ru.solit.clouds;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;


import java.io.File;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BigFormTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized=true;
    }

    @Test
    void fillFormTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Sidorov");
        $("#userEmail").setValue("alex@yandex.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").selectOption(3);
        $(".react-datepicker__month-select").selectOption(2);
        $(".react-datepicker__month").$(byText("13")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/ru/solit/clouds/image.png"));
        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();
    }
}
