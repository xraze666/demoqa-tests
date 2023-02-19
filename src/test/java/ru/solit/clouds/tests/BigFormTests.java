package ru.solit.clouds.tests;

import org.junit.jupiter.api.Test;
import ru.solit.clouds.pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BigFormTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest(){

        //Fill the form
        registrationPage.openPage();

        //Fill user base info
        registrationPage.typeFirstName("Alex")
                        .typeLastName("Sidorov")
                        .typeUserEmail("alex@yandex.ru")
                        .typePhoneNumber("+712938475029")
                        .typeSubject("Maths")
                        .typeGender("Male");

        //Select date from Calendar
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__month").$(byText("13")).click();

        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/image.png"));
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
