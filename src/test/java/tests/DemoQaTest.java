package tests;

import com.github.javafaker.Faker;
import enums.*;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;


public class DemoQaTest extends TestBase {

    private Faker faker = new Faker();

    private String city = "Karnal";
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String email = faker.internet().emailAddress();
    private String phoneNumber =    Long.toString(faker.number().randomNumber(10,true));
    private String textAreaText = faker.address().toString();
    private String imageToUploadPath = "img/test.png";
    private String birthDay = Integer.toString(faker.number().numberBetween(1, 28));
    private String birthYear = Integer.toString(faker.number().numberBetween(1990,2005));
    private String expectedUploadFileName = "test.png";
    private RegistrationPage registrationPage = new RegistrationPage();
    private ModalDialogFields key = new ModalDialogFields();


    @Test
    public void fillFormTest() {
        registrationPage
                .openPage()
                .fillFirstNameField(firstName)
                .fillLastNameField(lastName)
                .fillEmailField(email)
                .fillPhoneNumberField(phoneNumber)
                .setGender(Gender.MALE)
                .chooseSubject(Subject.COMMERCE)
                .chooseState(State.HARYANA)
                .chooseCity(city)
                .fillTextArea(textAreaText)
                .chooseHobby(Hobby.MUSIC)
                .uploadImage(imageToUploadPath)
                .setBirthDate(birthDay, Months.OCTOBER, birthYear)
                .clickSubmitButton();
        registrationPage
                .verifyModalDialogAppear()
                .verifyModalDialogsElements(key.getStudenName(), firstName + " " + lastName)
                .verifyModalDialogsElements(key.getStudentEmail(), email)
                .verifyModalDialogsElements(key.getMobile(), phoneNumber)
                .verifyModalDialogsElements(key.getDateOfBirth(), String
                        .format( "%s %s,%s", birthDay, Months.OCTOBER.toString(), birthYear))
                .verifyModalDialogsElements(key.getGender(), Gender.MALE.toString())
                .verifyModalDialogsElements(key.getSubjects(), Subject.COMMERCE.toString())
                .verifyModalDialogsElements(key.getStateAndCity(), String
                        .format("%s %s",State.HARYANA.toString(), city  ))
                .verifyModalDialogsElements(key.getHobbies(), Hobby.MUSIC.toString())
                .verifyModalDialogsElements(key.getPicture(), expectedUploadFileName)
                .verifyModalDialogsElements(key.getAddress(), textAreaText);


    }


}
