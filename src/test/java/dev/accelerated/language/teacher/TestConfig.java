package dev.accelerated.language.teacher;

import dev.accelerated.language.teacher.domain.uuid.HardcodedUUIDGeneratorAdapter;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class TestConfig {

    HardcodedUUIDGeneratorAdapter uuidGeneratorAdapter = new HardcodedUUIDGeneratorAdapter();

    @Primary
    @Bean
    public UUIDGeneratorPort idGeneratorPort() {
        return uuidGeneratorAdapter;
    }

    @Bean
    public HardcodedUUIDGeneratorAdapter uuidGeneratorAdapter() {
        return this.uuidGeneratorAdapter;
    }
}
