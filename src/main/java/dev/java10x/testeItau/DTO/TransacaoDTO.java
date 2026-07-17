package dev.java10x.testeItau.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoDTO {
    @NotNull(message = "O valor da transacao nao pode ser vazio")
    @Positive(message = "O valor da transacao nao pode ser negativo")
    private BigDecimal valor;
    private OffsetDateTime dataHora;

    @Override
    public String toString(){
        return "Valor: "+valor+"\nData e Hora: "+dataHora;
    }
}
