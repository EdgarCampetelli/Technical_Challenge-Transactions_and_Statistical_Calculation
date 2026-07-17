package dev.java10x.testeItau.Controller;

import dev.java10x.testeItau.Config.Docs.TransacaoControllerDoc;
import dev.java10x.testeItau.DTO.TransacaoDTO;
import dev.java10x.testeItau.Repository.TransacaoRepository;
import dev.java10x.testeItau.Service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/transacao")
public class TransacoesController implements TransacaoControllerDoc {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        try {
            log.info("Transacoes listadas");
            return ResponseEntity.ok(transacaoRepository.listar());
        }catch (Exception e){
            log.error("Nao ha transacoes para serem listadas");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }

    @PostMapping("/criar")
    public ResponseEntity<?> adicionar(@RequestBody TransacaoDTO body){
        try {
            transacaoService.validar(body);
            transacaoRepository.salvar(body);
            log.info("Transacao realizada");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (IllegalArgumentException e){
            log.error("Erro no corpo da requisicao");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }catch (Exception e){
            log.error("Erro no servico");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletar(){
        try{
            transacaoRepository.deletar();
            log.info("Transacoes deletadas");
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            log.error("Erro ao deletar Transacoes");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };


}
