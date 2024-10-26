package ru.marinin.namiBackService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.namiBackService.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
