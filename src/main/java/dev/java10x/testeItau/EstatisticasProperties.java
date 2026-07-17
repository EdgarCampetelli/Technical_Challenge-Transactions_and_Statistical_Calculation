package dev.java10x.testeItau;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasProperties(
        @NotNull(message = "O campo 'sec' não pode ser nulo.")
        @Positive(message = "O campo 'sec' deve ser um número inteiro maior que zero.")
        Integer sec){
}
