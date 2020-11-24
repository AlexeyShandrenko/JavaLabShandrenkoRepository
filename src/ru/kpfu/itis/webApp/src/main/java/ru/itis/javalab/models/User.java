package ru.itis.javalab.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
