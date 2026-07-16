package dev.java10x.testeItau.Controller;
import dev.java10x.testeItau.EstatisticasProperties;
import dev.java10x.testeItau.Repository.TransacaoRepository;
import dev.java10x.testeItau.Service.EstatisticasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final EstatisticasProperties properties;
    private final TransacaoRepository transacaoRepository;

    @GetMapping("/ultimaEstatistica")
    public ResponseEntity<?> view(){
        properties.setSec(60);
        final var horaAtual = OffsetDateTime.now().minusSeconds(properties.getSec());
        try {
            return ResponseEntity.ok(transacaoRepository.estatistica(horaAtual));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

}
