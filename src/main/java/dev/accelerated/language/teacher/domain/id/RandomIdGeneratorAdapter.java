package dev.accelerated.language.teacher.domain.id;

import com.github.f4b6a3.uuid.UuidCreator;
import org.springframework.stereotype.Component;

@Component
public class RandomIdGeneratorAdapter implements IdGeneratorPort {
    @Override
    public Id generate() {
        return new Id(UuidCreator.getTimeOrderedEpoch());
    }
}
