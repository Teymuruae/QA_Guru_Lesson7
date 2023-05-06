package testdata;

import com.github.javafaker.Faker;
import enums.*;
import org.junit.jupiter.api.Test;

public class TestData {
    private static Faker faker = new Faker();


    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String phoneNumber = Long.toString(faker.number().randomNumber(10, true));
    public static String textAreaText = faker.address().toString();
    public static String birthDay = Integer.toString(faker.number().numberBetween(1, 28));
    public static String birthYear = Integer.toString(faker.number().numberBetween(1990, 2005));
    public static String gender = faker.options().option(Gender.MALE.toString(), Gender.FEMALE.toString(),
            Gender.OTHER.toString());
    public static String hobby = faker.options().option(Hobby.MUSIC.toString(), Hobby.READING.toString(),
            Hobby.SPORTS.toString());
    public static String month = faker.options().option(Months.JANUARY.toString(), Months.FEBRUARY.toString(),
            Months.MARCH.toString(), Months.APRIL.toString(), Months.MAY.toString(), Months.JUNE.toString(),
            Months.JULY.toString(), Months.AUGUST.toString(), Months.SEPTEMBER.toString(), Months.OCTOBER.toString(),
            Months.NOVEMBER.toString(), Months.DECEMBER.toString());
    public static String subject = faker.options().option(Subject.ENGLISH.toString(),Subject.CHEMISTRY.toString(),
            Subject.COMMERCE.toString() );

    public static String state = faker.options().option(State.NCR.toString().toUpperCase(),
            "Uttar Pradesh", State.HARYANA.toString(), State.RAJASTHAN.toString());



    public static String city(){
        String cityName;
        switch(state){
            case "NCR": cityName= faker.options().option("Delhi", "Gurgaon", "Noida");
            return cityName;

            case "Uttar Pradesh": cityName = faker.options().option("Agra", "Lucknow", "Merrut");
            return cityName;

            case "Haryana": cityName = faker.options().option("Karnal", "Panipat");
            return cityName;

            case "Rajasthan": cityName = faker.options().option("Jaipur", "Jaiselmer");
            return cityName;

            default: return "";

        }
    }

}

