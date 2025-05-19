
-- Tabela tb_produto
CREATE TABLE tb_produto (
                            id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                            codigo_de_barras VARCHAR(255) NOT NULL UNIQUE,
                            nome VARCHAR(255) NOT NULL,
                            categoria_id BINARY(16) NOT NULL,
                            descricao TEXT,
                            preco_custo DECIMAL(19, 2),
                            preco_venda DECIMAL(19, 2),
                            CONSTRAINT fk_produto_categoria
                                FOREIGN KEY (categoria_id)
                                    REFERENCES tb_categoria(id)
) ENGINE=InnoDB;
