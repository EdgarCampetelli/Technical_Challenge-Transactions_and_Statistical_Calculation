package dev.java10x.testeItau;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasProperties(@DefaultValue("60") Integer sec){
}
