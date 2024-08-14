package ru.job4j.repository;

import ru.job4j.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> save(User user);

    Optional<User> findByEmailAndPassword(String email, String password);
}
