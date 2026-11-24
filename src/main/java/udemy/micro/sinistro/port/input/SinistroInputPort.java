package udemy.micro.sinistro.port.input;

import udemy.micro.sinistro.domain.dtos.SinistroRequest;
import udemy.micro.sinistro.domain.dtos.SinistroResponse;
import udemy.micro.sinistro.domain.model.SinistroSeguro;

public interface SinistroInputPort {
    SinistroResponse registerSinistro(SinistroRequest sinistroRequest);
    SinistroSeguro dadosVeiculoCliente(String chassi);
}
