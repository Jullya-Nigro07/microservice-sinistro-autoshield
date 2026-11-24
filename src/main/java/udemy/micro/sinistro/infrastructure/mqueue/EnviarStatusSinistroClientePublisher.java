package udemy.micro.sinistro.infrastructure.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import udemy.micro.sinistro.domain.model.DadosEnvioSinistro;


@Component
public class EnviarStatusSinistroClientePublisher {
    private final RabbitTemplate rabbitTemplate;

    public EnviarStatusSinistroClientePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarStatus(DadosEnvioSinistro dados) throws JsonProcessingException {
        var json = converterJson(dados);
        rabbitTemplate.convertAndSend("autoshield", "status", json);
    }

    private String converterJson(DadosEnvioSinistro dados) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(dados);
        return json;
    }
}
