package udemy.micro.sinistro.domain.services;

import org.springframework.stereotype.Service;
import udemy.micro.sinistro.domain.model.DadosEnvioSinistro;
import udemy.micro.sinistro.domain.model.ProtocoloEnviarStatusSinistro;
import udemy.micro.sinistro.infrastructure.mqueue.EnviarStatusSinistroClientePublisher;

import java.util.UUID;

@Service
public class MQService {
    private EnviarStatusSinistroClientePublisher enviarStatusSinistroClientePublisher;

    public MQService(EnviarStatusSinistroClientePublisher enviarStatusSinistroClientePublisher) {
        this.enviarStatusSinistroClientePublisher = enviarStatusSinistroClientePublisher;
    }

    public ProtocoloEnviarStatusSinistro protocoloEnviarStatusSinistro(DadosEnvioSinistro dadosEnvioSinistro){
        try{
            enviarStatusSinistroClientePublisher.enviarStatus(dadosEnvioSinistro);
            var protocolo = UUID.randomUUID().toString();
            return new ProtocoloEnviarStatusSinistro(protocolo);

        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
