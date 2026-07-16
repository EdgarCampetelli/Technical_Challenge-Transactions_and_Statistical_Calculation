package dev.java10x.testeItau.Controller;
import dev.java10x.testeItau.DTO.EstatisticasDTO;
import dev.java10x.testeItau.EstatisticasProperties;
import dev.java10x.testeItau.Repository.TransacaoRepository;
import dev.java10x.testeItau.Service.EstatisticasService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final EstatisticasProperties properties;
    private final TransacaoRepository transacaoRepository;

    @GetMapping("/ultimaEstatistica")
    public ResponseEntity<?> view(){
        //log de requisicao via lombok
        log.info("Calculando estatisticas de transacoes nos ultimos "+properties.sec()+" segundos");

        final var horaAtual = OffsetDateTime
                .now()
                .minusSeconds(properties.sec());
        try {
            if (transacaoRepository.estatistica(horaAtual).equals(new EstatisticasDTO(0,0.0,0.0,0.0,0.0))){
                log.error("Nao foi identificado transacoes realizadas nos "+properties.sec()+" segundos");
                return ResponseEntity.ok(transacaoRepository.estatistica(horaAtual));
            }
            log.info("Sucesso ao calcular a estatistica das transacoes realizadas no tempo de "+properties.sec()+" segundos ");
            return ResponseEntity.ok(transacaoRepository.estatistica(horaAtual));
        }catch (Exception e){
            log.error("Erro ao calcular estatistica das transacoes realizadas no tempo de "+properties.sec()+" segundos ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

}
