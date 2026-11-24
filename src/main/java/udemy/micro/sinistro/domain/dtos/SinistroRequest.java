package udemy.micro.sinistro.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import udemy.micro.sinistro.domain.enums.StatusSinistro;
import udemy.micro.sinistro.domain.enums.TipoSinistro;

import java.math.BigDecimal;

public record SinistroRequest(@NotEmpty String descricao,
                              @NotNull(message = "O tipo do sinistro é obrigatório") TipoSinistro tipoSinistro,
                              @NotNull(message = "O status do sinistro é obrigatório") StatusSinistro status,
                              @Positive BigDecimal valorPrejuizo,
                              @NotNull Long veiculo_id) {
}
