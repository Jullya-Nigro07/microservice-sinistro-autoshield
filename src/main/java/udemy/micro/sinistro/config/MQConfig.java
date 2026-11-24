package udemy.micro.sinistro.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfig {

    @Value("${mq.queues.enviar-status-cliente}")
    private String queueEnviarStatusClienteFila;

    @Bean
    public Queue filaEnviarStatusCliente() {
        return new Queue(queueEnviarStatusClienteFila, true);
    }

    @Bean
    public DirectExchange exchangeAutoShield() {
        return new DirectExchange("autoshield");
    }
}
