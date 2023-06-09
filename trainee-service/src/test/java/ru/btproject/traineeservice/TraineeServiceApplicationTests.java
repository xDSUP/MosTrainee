package ru.btproject.traineeservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "app.stage_sync.enable=false",
        "spring.flyway.enabled=false", // тест миграций в соседнем тесте
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_ON_EXIT=FALSE",
        "spring.jpa.hibernate.ddl-auto=none",
        "spring.datasource.username=sa",
        "spring.datasource.password=''"
})
class TraineeServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
