package udemy.micro.sinistro.adapters.output.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import udemy.micro.sinistro.domain.enums.StatusSinistro;
import udemy.micro.sinistro.domain.enums.TipoSinistro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Sinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private LocalDateTime dataOcorrencia;

    @Enumerated(EnumType.STRING)
    private TipoSinistro tipoSinistro;

    @Enumerated(EnumType.STRING)
    private StatusSinistro status;

    private BigDecimal valorPrejuizo;

    private Long veiculo_id;

    @PrePersist
    public void prePersist() {
        this.dataOcorrencia = LocalDateTime.now();
    }

    public Sinistro(String descricao, TipoSinistro tipoSinistro, StatusSinistro status, BigDecimal valorPrejuizo, Long veiculo_id) {
        this.descricao = descricao;
        this.tipoSinistro = tipoSinistro;
        this.status = status;
        this.valorPrejuizo = valorPrejuizo;
        this.veiculo_id = veiculo_id;
    }
}
