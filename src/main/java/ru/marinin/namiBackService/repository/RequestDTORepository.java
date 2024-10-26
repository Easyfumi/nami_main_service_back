package ru.marinin.namiBackService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.namiBackService.model.RequestDTO;

public interface RequestDTORepository extends JpaRepository<RequestDTO, Long> {
}
