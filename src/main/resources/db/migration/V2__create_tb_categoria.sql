-- Tabela tb_categoria
CREATE TABLE tb_categoria (
                              id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                              nome VARCHAR(255) NOT NULL UNIQUE
) ENGINE=InnoDB;
