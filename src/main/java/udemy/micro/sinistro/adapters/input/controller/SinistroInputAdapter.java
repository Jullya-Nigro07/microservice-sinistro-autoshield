package udemy.micro.sinistro.adapters.input.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import udemy.micro.sinistro.domain.dtos.SinistroRequest;
import udemy.micro.sinistro.domain.dtos.SinistroResponse;
import udemy.micro.sinistro.domain.model.SinistroSeguro;
import udemy.micro.sinistro.exceptions.DataNotFound;
import udemy.micro.sinistro.port.input.SinistroInputPort;

@RestController
@RequestMapping("/sinistro")
public class SinistroInputAdapter {
    private final SinistroInputPort sinistroInputPort;
    public SinistroInputAdapter(SinistroInputPort sinistroInputPort){
        this.sinistroInputPort = sinistroInputPort;
    }

    @PostMapping("/register")
    public SinistroResponse registerSinistro(@Valid @RequestBody SinistroRequest sinistroRequest){
        return sinistroInputPort.registerSinistro(sinistroRequest);
    }

    @GetMapping("/search/veiculo/{chassi}")
    public SinistroSeguro dadosVeiculo(@PathVariable String chassi) throws DataNotFound {
        return sinistroInputPort.dadosVeiculoCliente(chassi);
    }
}
