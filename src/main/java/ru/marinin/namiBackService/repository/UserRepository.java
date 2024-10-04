package ru.marinin.namiBackService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.marinin.namiBackService.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
