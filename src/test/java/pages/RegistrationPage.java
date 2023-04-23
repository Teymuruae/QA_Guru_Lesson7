package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.*;
import pages.components.CalendarComponent;
import pages.components.ModalDialog;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    private final static String registrationPageUri = "/automation-practice-form";
    private ModalDialog modalDialog = new ModalDialog();

    private CalendarComponent calendar = new CalendarComponent();
    private String textOnRegistrationForm = "Student Registration Form";
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


    private SelenideElement getStateLocator(String value) {
        return $(Selectors.byTagAndText("div", value));
    }

    private SelenideElement getCityLocator(String cityName) {
        return $(Selectors.byTagAndText("div", cityName));
    }

    private SelenideElement getHobbyCheckBoxLocator(String hobby) {
        return $x(String.format("//label[text() = '%s']", hobby));
    }

// act methods

    public RegistrationPage openPage() {
        Selenide.open(registrationPageUri);
        textToWaitForOnPage.shouldHave(Condition.text(textOnRegistrationForm));
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

    public RegistrationPage setGender(String value) {
        genderRadio.$(Selectors.byText(value)).click();
        return this;
    }

    public RegistrationPage fillPhoneNumberField(String phoneNumber) {
        phoneNumberField.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage chooseSubject(String subjectValue) {
        subject.setValue(subjectValue).pressEnter();
        return this;
    }

    public RegistrationPage fillTextArea(String text) {
        textArea.setValue(text);
        return this;
    }

    public RegistrationPage chooseState(String stateValue) {
        stateButton.click();
        getStateLocator(stateValue).click();
        return this;
    }


    public RegistrationPage chooseCity(String cityName) {
        cityButton.click();
        getCityLocator(cityName).click();
        return this;
    }

    public RegistrationPage chooseHobby(String hobby) {
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

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateField.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyModalDialogAppear() {
        modalDialog.verifyModalAppear();
        return this;
    }

    public RegistrationPage verifyModalDialogsElements(String key, String value) {
        modalDialog.verifyElements(key, value);
        return this;
    }
    public RegistrationPage removeDomElements(){
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        return this;
    }


}
