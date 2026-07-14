package dev.java10x.testeItau.Controller;

import dev.java10x.testeItau.DTO.TransacaoDTO;
import dev.java10x.testeItau.Entity.Transacao;
import dev.java10x.testeItau.Service.TransacaoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/transacao")
public class TransacoesController {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody TransacaoDTO body){
        try {
            transacaoService.validar(body);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

    }

}
