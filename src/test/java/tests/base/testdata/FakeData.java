package tests.base.testdata;

import com.github.javafaker.Faker;

public class FakeData {
    public static String getFakeName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getFakePassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

    public static String getFakeEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getWrongPass() {
        Faker faker = new Faker();
        return faker.number().digits(5);
    }
}
