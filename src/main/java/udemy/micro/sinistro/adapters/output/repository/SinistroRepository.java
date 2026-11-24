package udemy.micro.sinistro.adapters.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udemy.micro.sinistro.adapters.output.entity.Sinistro;
import udemy.micro.sinistro.port.output.SinistroOutputPort;

public interface SinistroRepository extends SinistroOutputPort, JpaRepository<Sinistro, Long> {
    Sinistro save(Sinistro sinistro);
}
