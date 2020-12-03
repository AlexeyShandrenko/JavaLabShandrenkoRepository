package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
    List<User> findAllByAge(Integer age);
}
