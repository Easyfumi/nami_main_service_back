package ru.marinin.namiBackService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.marinin.namiBackService.model.Request;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {


    @Query(nativeQuery = true, value = "SELECT a.* FROM request a where a.user_id = ?1")
    List<Request> findAllByUser_id(long id);
}
