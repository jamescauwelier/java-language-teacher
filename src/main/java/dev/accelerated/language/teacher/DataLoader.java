package dev.accelerated.language.teacher;

import dev.accelerated.language.teacher.application.person.PersonService;
import dev.accelerated.language.teacher.application.person.commands.RegisterPersonCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Bean
    CommandLineRunner initDatabase(PersonService personService) {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                logger.info("Preloading " + personService.createPerson(new RegisterPersonCommand("John " + i, "Wick " + i)));
            }
        };
    }
}