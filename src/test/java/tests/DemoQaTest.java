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
                .setGender(Gender.MALE)
                .chooseSubject(Subject.COMMERCE)
                .chooseState(State.HARYANA)
                .chooseCity("Karnal")
                .fillTextArea("some text for test")
                .chooseHobby(Hobby.MUSIC)
                .uploadImage("img/test.png")
                .setBirthDate("3", Months.OCTOBER, "1990")
                .clickSubmitButton();
        registrationPage
                .verifyModalDialogApper()
                .verifyModalDialogsElements(key.getStudenName(), "Ivan Ivanov")
                .verifyModalDialogsElements(key.getStudentEmail(), "IvIvan@test.ru")
                .verifyModalDialogsElements(key.getMobile(), "8800555353")
                .verifyModalDialogsElements(key.getDateOfBirth(), String.format( "3 %s,1990", Months.OCTOBER.toString()))
                .verifyModalDialogsElements(key.getGender(), Gender.MALE.toString())
                .verifyModalDialogsElements(key.getSubjects(), Subject.COMMERCE.toString())
                .verifyModalDialogsElements(key.getStateAndCity(), String.format("%s %s",State.HARYANA.toString(), "Karnal"  ))
                .verifyModalDialogsElements(key.getHobbies(), Hobby.MUSIC.toString())
                .verifyModalDialogsElements(key.getPicture(), "test.png")
                .verifyModalDialogsElements(key.getAddress(),"some text for test");


    }


}
