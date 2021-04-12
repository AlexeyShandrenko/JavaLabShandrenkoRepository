package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String email;
    private String password;
    private String phone;
    private String city;
    private String confirm_code;
    private State state;
    public enum State {
        CONFIRMED, NOT_CONFIRNED
    }
    @OneToMany(mappedBy = "owner")
    private List<Orders> ordersList;
}
