package dev.java10x.testeItau.Service;

import dev.java10x.testeItau.DTO.EstatisticasDTO;
import dev.java10x.testeItau.DTO.TransacaoDTO;
import dev.java10x.testeItau.Repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class EstatisticasService{

    public String contar(){
        return "Foram realizadas ";
    }

}
