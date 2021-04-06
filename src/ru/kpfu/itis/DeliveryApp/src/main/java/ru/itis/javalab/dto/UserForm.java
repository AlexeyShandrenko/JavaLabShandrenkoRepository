package ru.itis.javalab.dto;

import lombok.Data;

@Data
public class UserForm {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String age;
    private String phone;

}
