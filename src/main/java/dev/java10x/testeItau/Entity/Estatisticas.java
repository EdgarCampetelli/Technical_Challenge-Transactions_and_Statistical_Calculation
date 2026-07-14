package dev.java10x.testeItau.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estatisticas {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

}
