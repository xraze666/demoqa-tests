package ru.solit.clouds.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final String FORM_TITLE = "Student Registration Form";

    private SelenideElement
                    formTitle = $(".practice-form-wrapper"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput =  $("#userEmail"),
                    genderInput = $("#genterWrapper"),
                    phoneNumber = $("#userNumber"),
                    subjectsInput = $("#subjectsInput");

    public void openPage(){
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        //return this for create chains
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        //return this for create chains
        return this;
    }

    public RegistrationPage typeUserEmail(String email){
        userEmailInput.setValue(email);
        //return this for create chains
        return this;
    }


    public RegistrationPage typePhoneNumber(String number){
        phoneNumber.setValue(number);
        //return this for create chains
        return this;
    }

    public RegistrationPage typeSubject(String subject){
        subjectsInput.setValue(subject).pressEnter();
        //return this for create chains
        return this;
    }

    public void typeGender(String gender){
        genderInput.$(byText(gender)).click();
    }
}