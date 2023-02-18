package ru.solit.clouds.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BigFormTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized=true;
    }

    @Test
    void fillFormTest(){

        //Fill the form
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Sidorov");
        $("#userEmail").setValue("alex@yandex.ru");

        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#subjectsInput").setValue("Maths").pressEnter();

        //Select date from Calendar
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__month").$(byText("13")).click();

        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/resources/img/image.png"));
        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        //Check submit form
        //$(".table tbody tr[0]").shouldHave(text("Alex"));
        $(".table-responsive").shouldHave(
                text("Alex Sidorov"),
                text("13 March,2002"),
                text("alex@yandex.ru"),
                text("Some address"),
                text("NCR Delhi"),
                text("Maths"),
                text("1234567890"),
                text("Male"),
                text("image.png"),
                text("Music"),
                text("alex@yandex.ru"));
    }
}
