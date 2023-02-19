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
                        .typeHobbies("Music")
                        .typeUserAddress("Some address")
                        .typeGender("Male")
                        ;

        //Select date from Calendar
        registrationPage.calendar.setDate("19", "March", "2023");

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/image.png"));

        registrationPage.stateAndCity.setStateAndCity("Rajasthan", "Jaipur");

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
