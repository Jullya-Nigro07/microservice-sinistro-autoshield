package udemy.micro.sinistro.domain.services;

import feign.FeignException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import udemy.micro.sinistro.adapters.output.entity.Sinistro;
import udemy.micro.sinistro.domain.dtos.SinistroRequest;
import udemy.micro.sinistro.domain.dtos.SinistroResponse;
import udemy.micro.sinistro.domain.model.DadosVeiculo;
import udemy.micro.sinistro.domain.model.SinistroSeguro;
import udemy.micro.sinistro.exceptions.DataNotFound;
import udemy.micro.sinistro.infrastructure.feign.Veiculo;
import udemy.micro.sinistro.port.input.SinistroInputPort;
import udemy.micro.sinistro.port.output.SinistroOutputPort;

@Service
public class SinistroService implements SinistroInputPort {
    private final SinistroOutputPort sinistroOutputPort;
    private final Veiculo veiculo;
    public SinistroService(SinistroOutputPort sinistroOutputPort, Veiculo veiculo) {
        this.sinistroOutputPort = sinistroOutputPort;
        this.veiculo = veiculo;
    }

    @Override
    @Transactional
    public SinistroResponse registerSinistro(SinistroRequest sinistroRequest) {
        Sinistro sinistro = new Sinistro(sinistroRequest.descricao(),
                sinistroRequest.tipoSinistro(),
                sinistroRequest.status(),
                sinistroRequest.valorPrejuizo(),
                sinistroRequest.veiculo_id()
                );

        Sinistro sinistroSave = sinistroOutputPort.save(sinistro);

        return SinistroResponse.builder()
                .id(sinistroSave.getId())
                .tipoSinistro(sinistroSave.getTipoSinistro())
                .status(sinistroSave.getStatus())
                .valorPrejuizo(sinistroSave.getValorPrejuizo())
                .dataOcorrencia(sinistroSave.getDataOcorrencia())
                .build();
    }

    @Override
    public SinistroSeguro dadosVeiculoCliente(String chassi) throws DataNotFound {
        try{
            DadosVeiculo veiculoCleinte = veiculo.dadosVeiculo(chassi);
            return SinistroSeguro.builder().veiculo(veiculoCleinte).build();
        }catch (FeignException exception){
            throw new DataNotFound("Não foi possível encontrar o veículo informado.");
        }
    }

}
