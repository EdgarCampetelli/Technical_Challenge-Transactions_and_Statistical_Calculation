package dev.java10x.testeItau.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstatisticasDTO {
    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

}
