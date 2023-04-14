package tests;

import enums.*;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class DemoQaTest extends TestBase {

    private RegistrationPage registrationPage = new RegistrationPage();
    private ModalDialogFields key = new ModalDialogFields();

    @Test
    public void fillFormTest() {
        registrationPage.openPage()
                .fillFirstNameField("Ivan")
                .fillLastNameField("Ivanov")
                .fillEmailField("IvIvan@test.ru")
                .fillPhoneNumberField("8800555353")
                .setGender(Gender.Male)
                .chooseSubject(Subject.Commerce)
                .chooseState(State.Haryana)
                .chooseCity("Karnal")
                .fillTextArea("some text for test")
                .chooseHobby(Hobby.Music)
                .uploadImage("img/test.png")
                .setBirthDate("3", Months.October, "1990")
                .clickSubmitButton();
        registrationPage
                .verifyModalDialogApper()
                .verifyModalDialogsElements(key.getStudenName(), "Ivan Ivanov")
                .verifyModalDialogsElements(key.getStudentEmail(), "IvIvan@test.ru")
                .verifyModalDialogsElements(key.getMobile(), "8800555353")
                .verifyModalDialogsElements(key.getDateOfBirth(), String.format( "3 %s,1990", Months.October.toString()))
                .verifyModalDialogsElements(key.getGender(), Gender.Male.toString())
                .verifyModalDialogsElements(key.getSubjects(), Subject.Commerce.toString())
                .verifyModalDialogsElements(key.getStateAndCity(), String.format("%s %s",State.Haryana.toString(), "Karnal"  ))
                .verifyModalDialogsElements(key.getHobbies(), Hobby.Music.toString())
                .verifyModalDialogsElements(key.getPicture(), "test.png")
                .verifyModalDialogsElements(key.getAddress(),"some text for test");


    }


}
