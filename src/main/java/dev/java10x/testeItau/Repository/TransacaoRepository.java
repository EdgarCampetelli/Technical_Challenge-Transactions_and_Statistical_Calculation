package dev.java10x.testeItau.Repository;

import dev.java10x.testeItau.DTO.EstatisticasDTO;
import dev.java10x.testeItau.DTO.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;

@Repository
public class TransacaoRepository<T>{

    public ArrayList<TransacaoDTO> list = new ArrayList<>();

    public ArrayList<TransacaoDTO> listar(){
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
        EstatisticasDTO estatisticasDTO = new EstatisticasDTO();

        Long count = list.stream().count();
        estatisticasDTO.setCount(count);

        BigDecimal sum = list.stream()
                .map(TransacaoDTO::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        estatisticasDTO.setSum(sum);

        //avg
        BigDecimal avg = list.stream()
                .map(TransacaoDTO::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(list.size()));
        estatisticasDTO.setAvg(avg);

        BigDecimal min = list.stream()
                .map(TransacaoDTO::getValor)
                .min((n1,n2)-> n1.compareTo(n2)).orElse(BigDecimal.ZERO);
        estatisticasDTO.setMin(min);

        BigDecimal max = list.stream()
                .map(TransacaoDTO::getValor)
                .max((n1,n2)-> n1.compareTo(n2)).orElse(BigDecimal.ZERO);
        estatisticasDTO.setMax(max);

        return estatisticasDTO;
    }
}
