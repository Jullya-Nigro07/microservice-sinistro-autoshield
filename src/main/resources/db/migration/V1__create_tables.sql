CREATE TABLE sinistro(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    descricao TEXT NOT NULL,
    data_ocorrencia TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    tipo_sinistro varchar (255) NOT NULL,
    status varchar(255) NOT NULL,
    valor_prejuizo NUMERIC(15,2) NOT NULL,
    veiculo_id BIGINT NOT NULL
);

