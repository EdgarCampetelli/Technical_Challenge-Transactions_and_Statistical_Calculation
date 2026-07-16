package dev.java10x.testeItau;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "estatistica")
public class EstatisticasProperties {
    private Integer sec;
}
