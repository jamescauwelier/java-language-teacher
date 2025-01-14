package dev.accelerated.language.teacher.domain.uuid;

import com.github.f4b6a3.uuid.UuidCreator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomUUIDGeneratorAdapter implements UUIDGeneratorPort {
    @Override
    public UUID generate() {
        return UuidCreator.getTimeOrderedEpoch();
    }
}
