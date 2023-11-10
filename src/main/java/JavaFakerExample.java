import com.github.javafaker.Faker;

import java.util.Date;

public class JavaFakerExample {
    public static void main(String[] args) {
        // Создаем объект Faker
        Faker faker = new Faker();

        // Генерация различных типов данных
        String fakeName = faker.name().fullName();
        String fakeAddress = faker.address().fullAddress();
        String fakePhoneNumber = faker.phoneNumber().phoneNumber();
        String fakeEmail = faker.internet().emailAddress();
        String fakeCompany = faker.company().name();
        String fakeLoremText = faker.lorem().paragraph();

        int fakeNumber = faker.number().randomDigit();
        Double fakeDouble = faker.number().randomDouble(10, 10, 50);
        Date fakeBirthday = faker.date().birthday();

        boolean fakeBoolean = faker.bool().bool();

        // Вывод результатов
        System.out.println("Fake Name: " + fakeName);
        System.out.println("Fake Address: " + fakeAddress);
        System.out.println("Fake Phone Number: " + fakePhoneNumber);
        System.out.println("Fake Email: " + fakeEmail);
        System.out.println("Fake Company: " + fakeCompany);
        System.out.println("Fake Lorem Text: " + fakeLoremText);
        System.out.println("Fake Number int: " + fakeNumber);
        System.out.println("Fake Double: " + fakeDouble);
        System.out.println("Fake Birthday: " + fakeBirthday);
        System.out.println("Fake Boolean: " + fakeBoolean);
    }
}