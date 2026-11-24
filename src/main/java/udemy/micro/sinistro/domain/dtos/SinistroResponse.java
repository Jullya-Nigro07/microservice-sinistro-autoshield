package udemy.micro.sinistro.domain.dtos;

import lombok.Builder;
import udemy.micro.sinistro.domain.enums.StatusSinistro;
import udemy.micro.sinistro.domain.enums.TipoSinistro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record SinistroResponse (Long id,
                                LocalDateTime dataOcorrencia,
                                TipoSinistro tipoSinistro,
                                StatusSinistro status,
                                BigDecimal valorPrejuizo){
}
