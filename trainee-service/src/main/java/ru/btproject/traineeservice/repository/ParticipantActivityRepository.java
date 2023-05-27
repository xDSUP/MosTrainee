package ru.btproject.traineeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.btproject.traineeservice.entity.ParticActivityHist;
import ru.btproject.traineeservice.entity.Participant;

import java.util.List;

public interface ParticipantActivityRepository extends JpaRepository<ParticActivityHist, Long> {

    List<ParticActivityHist> findByParticipant(Participant participant);
}
