package ru.btproject.traineeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.btproject.traineeservice.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
