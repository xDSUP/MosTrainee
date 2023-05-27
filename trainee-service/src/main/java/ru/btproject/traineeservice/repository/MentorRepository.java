package ru.btproject.traineeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.btproject.traineeservice.entity.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long> {

}
