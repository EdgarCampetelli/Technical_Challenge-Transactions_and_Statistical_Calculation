package dev.java10x.testeItau.Repository;

import dev.java10x.testeItau.DTO.EstatisticasDTO;
import dev.java10x.testeItau.DTO.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository<T>{

    public ArrayList<TransacaoDTO> list = new ArrayList<>();

    public ArrayList<TransacaoDTO> listar(){
        System.out.println(OffsetDateTime.now());
        return list;
    }

    public void salvar(TransacaoDTO item){
        list.add(item);
    }

    public void limparDados(TransacaoDTO item){

    }

    public void deletar(){
        list.clear();
    }

    public EstatisticasDTO estatistica(OffsetDateTime horaAtual) {

        if ( list.stream()
                .filter(i-> i.getDataHora().isAfter(horaAtual) || i.getDataHora().isEqual(horaAtual))
                .toList()
                .isEmpty()){

            return new EstatisticasDTO(0,0.0,0.0,0.0,0.0);
        }

       final var listUmMin =  list.stream()
               .filter(i-> i.getDataHora().isAfter(horaAtual) || i.getDataHora().isEqual(horaAtual))
               .mapToDouble(i-> i.getValor().doubleValue())
               .summaryStatistics();

        return new EstatisticasDTO(listUmMin.getCount(),listUmMin.getSum(),listUmMin.getAverage(),listUmMin.getMin(),listUmMin.getMax());
    }
}
