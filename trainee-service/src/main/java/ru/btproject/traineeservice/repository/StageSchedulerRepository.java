package ru.btproject.traineeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.btproject.traineeservice.entity.StageScheduler;

import java.time.LocalDate;
import java.util.Optional;

public interface StageSchedulerRepository extends JpaRepository<StageScheduler, Long> {
    Optional<StageScheduler> findStageSchedulerByActive(boolean isActive);

    @Query("SELECT s from StageScheduler s where s.startDate <= :date and s.endDate >= :date")
    Optional<StageScheduler> findStageSchedulerByStartDateBeforeAndEndDateAfter(@Param("date") LocalDate date);
}
