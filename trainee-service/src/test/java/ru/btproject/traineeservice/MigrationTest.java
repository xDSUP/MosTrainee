package ru.btproject.traineeservice;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;

@Testcontainers
public class MigrationTest {
    @Container
    public static GenericContainer postgres = new GenericContainer("postgres:13")
            .withExposedPorts(5432)
            .withEnv("POSTGRES_DB", "mydb")
            .withEnv("POSTGRES_USER", "test")
            .withEnv("POSTGRES_PASSWORD", "test")
            .withStartupTimeout(Duration.ofSeconds(30));
    private static Flyway flyway;

    @BeforeAll
    public static void setup() {
        // Set up the Flyway instance
        flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://" + postgres.getHost() + ":" + postgres.getMappedPort(5432) + "/mydb", "test", "test")
                .locations("classpath:db/migration")
                .load();

        // Perform the migration
        flyway.migrate();
    }

    @AfterAll
    public static void cleanup() {
        // Additional cleanup code here
    }

    @Test
    public void testMigration() {
        // Your test code here
    }
}