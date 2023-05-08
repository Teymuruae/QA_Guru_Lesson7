package tests;

import com.github.javafaker.Faker;
import enums.ModalDialogFields;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.TestData;

import static io.qameta.allure.Allure.step;


public class DemoQaTest extends TestBase {

    private Faker faker = new Faker();

    private String imageToUploadPath = "img/test.png";
    private String expectedUploadFileName = "test.png";
    private RegistrationPage registrationPage = new RegistrationPage();
    private ModalDialogFields key = new ModalDialogFields();

    private String city = TestData.city();

    @Tag("remote")
    @Test
    public void fillFormTest() {

        step("open registration page", () -> {
            registrationPage
                    .openPage()
                    .removeDomElements();
        });
        step("fill registration form", () -> {
            registrationPage
                    .fillFirstNameField(TestData.firstName)
                    .fillLastNameField(TestData.lastName)
                    .fillEmailField(TestData.email)
                    .fillPhoneNumberField(TestData.phoneNumber)
                    .setGender(TestData.gender)
                    .chooseSubject(TestData.subject)
                    .chooseState(TestData.state)
                    .chooseCity(city)
                    .fillTextArea(TestData.textAreaText)
                    .chooseHobby(TestData.hobby)
                    .uploadImage(imageToUploadPath)
                    .setBirthDate(TestData.birthDay, TestData.month, TestData.birthYear)
                    .clickSubmitButton();
        });
        step("verify form", () -> {
            registrationPage
                    .verifyModalDialogAppear()
                    .verifyModalDialogsElements(key.getStudenName(), TestData.firstName + " " + TestData.lastName)
                    .verifyModalDialogsElements(key.getStudentEmail(), TestData.email)
                    .verifyModalDialogsElements(key.getMobile(), TestData.phoneNumber)
                    .verifyModalDialogsElements(key.getDateOfBirth(), String
                            .format("%s %s,%s", TestData.birthDay, TestData.month, TestData.birthYear))
                    .verifyModalDialogsElements(key.getGender(), TestData.gender)
                    .verifyModalDialogsElements(key.getSubjects(), TestData.subject)
                    .verifyModalDialogsElements(key.getStateAndCity(), String
                            .format("%s %s", TestData.state, city))
                    .verifyModalDialogsElements(key.getHobbies(), TestData.hobby)
                    .verifyModalDialogsElements(key.getPicture(), expectedUploadFileName)
                    .verifyModalDialogsElements(key.getAddress(), TestData.textAreaText);
        });


    }
}
