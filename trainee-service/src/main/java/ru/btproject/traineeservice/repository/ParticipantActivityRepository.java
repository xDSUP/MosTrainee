package ru.btproject.traineeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.btproject.traineeservice.entity.ParticActivityHist;
import ru.btproject.traineeservice.entity.Participant;

import java.util.List;

public interface ParticipantActivityRepository extends JpaRepository<ParticActivityHist, Long> {

    @Query("select a from ParticActivityHist a join fetch a.stageActivity where a.participant = :partic")
    List<ParticActivityHist> findByParticipant(@Param("partic") Participant participant);
}
