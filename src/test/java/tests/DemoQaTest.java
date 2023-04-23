package tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import enums.*;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.TestData;

import java.util.Locale;


public class DemoQaTest extends TestBase {

    private Faker faker = new Faker();

    private String imageToUploadPath = "img/test.png";
    private String expectedUploadFileName = "test.png";
    private RegistrationPage registrationPage = new RegistrationPage();
    private ModalDialogFields key = new ModalDialogFields();


    @Test
    public void fillFormTest() {

        registrationPage
                .openPage()
                .removeDomElements()
                .fillFirstNameField(TestData.firstName)
                .fillLastNameField(TestData.lastName)
                .fillEmailField(TestData.email)
                .fillPhoneNumberField(TestData.phoneNumber)
                .setGender(TestData.gender)
                .chooseSubject(TestData.subject)
                .chooseState(TestData.state)
                .chooseCity(TestData.city())
                .fillTextArea(TestData.textAreaText)
                .chooseHobby(TestData.hobby)
                .uploadImage(imageToUploadPath)
                .setBirthDate(TestData.birthDay, TestData.month, TestData.birthYear)
                .clickSubmitButton();
        registrationPage
                .verifyModalDialogAppear()
                .verifyModalDialogsElements(key.getStudenName(), TestData.firstName + " " + TestData.lastName)
                .verifyModalDialogsElements(key.getStudentEmail(), TestData.email)
                .verifyModalDialogsElements(key.getMobile(), TestData.phoneNumber)
                .verifyModalDialogsElements(key.getDateOfBirth(), String
                        .format( "%s %s,%s", TestData.birthDay, TestData.month, TestData.birthYear))
                .verifyModalDialogsElements(key.getGender(), TestData.gender)
                .verifyModalDialogsElements(key.getSubjects(), TestData.subject)
                .verifyModalDialogsElements(key.getStateAndCity(), String
                        .format("%s %s",TestData.state, TestData.city()  ))
                .verifyModalDialogsElements(key.getHobbies(), TestData.hobby)
                .verifyModalDialogsElements(key.getPicture(), expectedUploadFileName)
                .verifyModalDialogsElements(key.getAddress(), TestData.textAreaText);


    }


}
