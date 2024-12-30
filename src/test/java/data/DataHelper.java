package data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    public static final Faker FAKER = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static AuthInfo getAuthInfowithTestData() {

        return new AuthInfo("vasya", "qwerty123");
    }

    public static String generateRandomLogin() {
        return FAKER.name().username();
    }

    public static String generateRandomPassword() {
        return FAKER.internet().password();
    }

    public static AuthInfo generateRandonUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }

    public static VerificationCode generateRandonVerificationCode() {
        return new VerificationCode(FAKER.numerify("######"));
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VerificationCode{
        String code;
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
}