package ru.marinin.namiBackService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.namiBackService.model.RequestDTO;

public interface RequestRepository extends JpaRepository<RequestDTO, Long> {
}
