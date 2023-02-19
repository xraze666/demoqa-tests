package ru.solit.clouds.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.solit.clouds.pages.RegistrationPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BigFormTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Test
    void fillFormTest(){

        //Fill the form
        registrationPage.openPage();

        //Fill user base info
        registrationPage.typeFirstName(faker.name().firstName())
                        .typeLastName(faker.name().lastName())
                        .typeUserEmail("alex@yandex.ru")
                        .typePhoneNumber("+712938475029")
                        .typeSubject("Maths")
                        .typeHobbies("Music")
                        .typeUserAddress("Some address")
                        .loagImages("src/test/resources/img/image.png")
                        .typeGender("Male");

        //Select date from Calendar
        registrationPage.calendar.setDate("19", "March", "2023");

        //Select State and City from component
        registrationPage.stateAndCity.setStateAndCity("Rajasthan", "Jaipur");

        //Submit
        registrationPage.submitForm();

        //Check submit form
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
