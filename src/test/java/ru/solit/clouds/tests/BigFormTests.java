package ru.solit.clouds.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.solit.clouds.pages.RegistrationPage;


public class BigFormTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    private String firstName=faker.name().firstName(),
                    lastName=faker.name().lastName(),
                    emailAddress=faker.internet().emailAddress(),
                    phoneNumber=faker.numerify("##########"),
                    subjects="Maths",
                    hobbies="Music",
                    userGender="Male",
                    imagePath="src/test/resources/img/image.png",
                    userAddress=faker.address().secondaryAddress(),
                    userState="Rajasthan",
                    userCity="Jaipur";
    @Test
    void fillFormTest(){

        //Fill the form
        registrationPage.openPage();

        //Fill user base info
        registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeUserEmail(emailAddress)
                        .typePhoneNumber(phoneNumber)
                        .typeSubject(subjects)
                        .typeHobbies(hobbies)
                        .typeUserAddress(userAddress)
                        .loagImages(imagePath)
                        .typeGender(userGender);

        //Select date from Calendar
        registrationPage.calendar.setDate("19", "March", "2023");

        //Select State and City from component
        registrationPage.stateAndCity.setStateAndCity(userState, userCity);

        //Submit
        registrationPage.submitForm();

        //Check submit form
        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName);
        registrationPage.checkResultsValue("Student Email", emailAddress);
        registrationPage.checkResultsValue("Gender", userGender);
        registrationPage.checkResultsValue("Mobile", phoneNumber);
        registrationPage.checkResultsValue("Date of Birth", "19"+" March"+","+"2023");
        registrationPage.checkResultsValue("Subjects", subjects);
        registrationPage.checkResultsValue("Hobbies", hobbies);
        registrationPage.checkResultsValue("Picture", imagePath.split("/")[imagePath.split("/").length-1]);
        registrationPage.checkResultsValue("Address", userAddress);
        registrationPage.checkResultsValue("State and City", userState + " " + userCity);
    }
}
