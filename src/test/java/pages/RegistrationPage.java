package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.*;
import org.junit.jupiter.api.Test;
import pages.components.CalendarComponent;
import pages.components.ModalDialog;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    private final static String registrationPageUri = "/automation-practice-form";
    private ModalDialog modalDialog = new ModalDialog();

    private CalendarComponent calendar = new CalendarComponent();
    private SelenideElement firstNameField = $("#firstName"),
            lastNameField = $("#lastName"),
            emailField = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            phoneNumberField = $("#userNumber"),
            birthDateField = $("#dateOfBirthInput"),

    subject = $("#subjectsInput"),
            textArea = $("#currentAddress"),
            stateButton = $("#state"),
            cityButton = $("#city"),
            submitButton = $("#submit"),
            uploadPictureButton = $("#uploadPicture"),
            textToWaitForOnPage = $("h5");


    private SelenideElement getStateLocator(State value) {
        return $(Selectors.byTagAndText("div", value.toString()));
    }

    private SelenideElement getCityLocator(String cityName) {
        return $(Selectors.byTagAndText("div", cityName));
    }

    private SelenideElement getHobbyCheckBoxLocator(Hobby hobby) {
        return $x(String.format("//label[text() = '%s']", hobby.toString()));
    }

// act methods

    public RegistrationPage openPage() {
        Selenide.open(registrationPageUri);
        textToWaitForOnPage.shouldHave(Condition.text("Student Registration Form"));
        Selenide.executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage fillFirstNameField(String name) {
        firstNameField.setValue(name);
        return this;
    }

    public RegistrationPage fillLastNameField(String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }

    public RegistrationPage fillEmailField(String email) {
        emailField.setValue(email);
        return this;
    }

    public RegistrationPage setGender(Gender value) {
        genderRadio.$(Selectors.byText(value.toString())).click();
        return this;
    }

    public RegistrationPage fillPhoneNumberField(String phoneNumber) {
        phoneNumberField.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage chooseSubject(Subject subjectValue) {
        subject.setValue(subjectValue.toString()).pressEnter();
        return this;
    }

    public RegistrationPage fillTextArea(String text) {
        textArea.setValue(text);
        return this;
    }

    public RegistrationPage chooseState(State stateValue) {
        stateButton.click();
        getStateLocator(stateValue).click();
        return this;
    }


    @Test
    void t() {
        System.out.println("==========================");
        System.out.println(State.Rajasthan.toString());
        System.out.println(State.valueOf("Rajasthan"));
        System.out.println("============================");
    }

    public RegistrationPage chooseCity(String cityName) {
        cityButton.click();
        getCityLocator(cityName).click();
        return this;
    }

    public RegistrationPage chooseHobby(Hobby hobby) {
        getHobbyCheckBoxLocator(hobby).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage uploadImage(String classPath) {
        uploadPictureButton.uploadFromClasspath(classPath);
        return this;

    }

    public RegistrationPage setBirthDate(String day, Months month, String year) {
        birthDateField.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyModalDialogApper() {
        modalDialog.verifyModalAppear();
        return this;
    }

    public RegistrationPage verifyModalDialogsElements(String key, String value) {
        modalDialog.verifyElements(key, value);
        return this;
    }


}
