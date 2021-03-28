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
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String age;
    private State state;
    private String confirm_code;
    public enum State {
        CONFIRMED, NOT_CONFIRMED
    }
}
