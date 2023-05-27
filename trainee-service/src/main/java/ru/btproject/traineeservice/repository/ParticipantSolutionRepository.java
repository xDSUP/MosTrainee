package ru.btproject.traineeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.btproject.traineeservice.entity.Application;
import ru.btproject.traineeservice.entity.Participant;
import ru.btproject.traineeservice.entity.ParticipantSolution;

import java.util.List;

public interface ParticipantSolutionRepository extends JpaRepository<ParticipantSolution, Long> {

    @Query("select p from ParticipantSolution p join fetch p.application a join fetch a.createdBy m join fetch m.organization where p.participant = :partic")
    List<ParticipantSolution> findByPartic(@Param("partic") Participant participant);

    @Query("select p from ParticipantSolution p join fetch p.participant a where p.application = :application")
    List<ParticipantSolution> findByApplication(@Param("application") Application application);
}
