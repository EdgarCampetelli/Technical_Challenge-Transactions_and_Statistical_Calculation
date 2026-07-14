package dev.java10x.testeItau.Service;

import dev.java10x.testeItau.DTO.TransacaoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validar(TransacaoDTO transacaoDTO){
        if (transacaoDTO.getValor() != null && transacaoDTO.getDataeHora() != null){
            if (transacaoDTO.getValor().compareTo(BigDecimal.ZERO) < 0){
                throw new IllegalArgumentException("Error: Transacoes devem ser maior ou igual a 0");
            }
            if (transacaoDTO.getDataeHora().isAfter(OffsetDateTime.now())){
                throw new IllegalArgumentException("Error: Data de transacao errada");
            }
        }else {
            throw new IllegalArgumentException("Error: Valores nulos");

        }
    }

}
