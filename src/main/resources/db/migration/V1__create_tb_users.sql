-- Tabela tb_users
CREATE TABLE tb_users (
                          id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                          username VARCHAR(255) NOT NULL UNIQUE,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL
) ENGINE=InnoDB;
