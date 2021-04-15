package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.validation.ValidAge;
import ru.itis.javalab.validation.ValidMatchPassword;
import ru.itis.javalab.validation.ValidNames;
import ru.itis.javalab.validation.ValidPassword;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ValidNames(message = "{errors.invalid.names}", name = "firstname", surname = "lastname")
@ValidMatchPassword(message = "{errors.incorrect.unmatched_password}", password = "password", password_repeat = "password_repeat")
public class UserForm {

    private String firstname;
    private String lastname;
    @Email(message = "{errors.incorrect.email}")
    private String email;
    @ValidPassword(message = "{errors.incorrect.password}")
    private String password;
    private String password_repeat;
    @ValidAge(message = "{errors.invalid.age}")
    private Integer age;
    private String phone;

}
