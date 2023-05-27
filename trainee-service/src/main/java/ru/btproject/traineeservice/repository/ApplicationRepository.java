package ru.btproject.traineeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.btproject.traineeservice.entity.Application;
import ru.btproject.traineeservice.entity.Mentor;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT a FROM Application a JOIN FETCH a.createdBy m JOIN FETCH m.organization JOIN FETCH a.internshipType it JOIN FETCH a.branch")
    List<Application> findAllWithAllData();

    @Query("SELECT a FROM Application a JOIN FETCH a.createdBy m JOIN FETCH m.organization JOIN FETCH a.internshipType it JOIN FETCH a.branch where a.isActive = :isActive")
    List<Application> findAllByIsActive(@Param("isActive") boolean isActive);

    Application findByCreatedByEquals(Mentor mentor);
}
