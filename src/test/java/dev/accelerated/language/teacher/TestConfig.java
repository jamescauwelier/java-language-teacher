package dev.accelerated.language.teacher;

import dev.accelerated.language.teacher.domain.id.HardcodedIdGeneratorAdapter;
import dev.accelerated.language.teacher.domain.id.IdGeneratorPort;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class TestConfig {
    @Primary
    @Bean
    public IdGeneratorPort idGeneratorPort() {
        return new HardcodedIdGeneratorAdapter();
    }
}
