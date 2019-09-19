package user;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class User {

    private Faker faker = new Faker();

    private Gender gender;
    private String firstName;
    private String surname;
    private String DOB;
    private String phone;
    private String email;

    public User(){
        this.gender = Gender.Male;
        this.firstName = faker.name().firstName();
        this.surname = faker.name().lastName();
        this.DOB = new SimpleDateFormat("dd/MM/yyyy").format(faker.date().birthday());
        this.phone = "0" + faker.phoneNumber().cellPhone();
        this.email = faker.internet().emailAddress();
    }

    public enum Gender { Male, Female }
}
