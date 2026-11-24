package udemy.micro.sinistro.port.output;

import udemy.micro.sinistro.adapters.output.entity.Sinistro;

public interface SinistroOutputPort {
    Sinistro save(Sinistro sinistro);
}
