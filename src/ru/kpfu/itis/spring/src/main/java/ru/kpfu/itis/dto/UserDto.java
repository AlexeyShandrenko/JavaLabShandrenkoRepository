package ru.kpfu.itis.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import ru.kpfu.itis.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String firstname;
    private String lastname;

    public static UserDto from(User user) {
        return UserDto.builder()
                .firstname(user.getFirstName())
                .lastname(user.getLastName())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
