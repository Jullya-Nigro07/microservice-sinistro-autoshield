package udemy.micro.sinistro.infrastructure.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import udemy.micro.sinistro.domain.model.DadosVeiculo;

@FeignClient(value = "veiculo", path = "/veiculos")
public interface Veiculo {

    @GetMapping("/search/{chassi}")
    DadosVeiculo dadosVeiculo (@PathVariable String chassi);

}