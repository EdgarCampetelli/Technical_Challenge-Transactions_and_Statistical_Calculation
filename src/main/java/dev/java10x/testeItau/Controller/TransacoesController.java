package dev.java10x.testeItau.Controller;

import dev.java10x.testeItau.DTO.TransacaoDTO;
import dev.java10x.testeItau.Repository.TransacaoRepository;
import dev.java10x.testeItau.Service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping("/transacao")
public class TransacoesController {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;

    @GetMapping("/listar")
    public ArrayList<TransacaoDTO> listar(){
        return transacaoRepository.listar();
    }

    @PostMapping("/criar")
    public ResponseEntity<?> adicionar(@RequestBody TransacaoDTO body){
        try {
            transacaoService.validar(body);
            transacaoRepository.salvar(body);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletar(){
        try{
            transacaoRepository.deletar();
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    };


}
