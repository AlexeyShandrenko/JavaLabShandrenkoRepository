package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long user_id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String email;
    private String password;
    private String address;
    private String phone;
}
