-- Tabela tb_estoque
CREATE TABLE tb_estoque (
                            id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                            nome_estoque VARCHAR(255),
                            produto_id BINARY(16) NOT NULL UNIQUE,
                            quantidade_guardada INTEGER NOT NULL,
                            preco_soma_venda DECIMAL(19, 2),
                            preco_soma_custo DECIMAL(19, 2),
                            CONSTRAINT fk_estoque_produto
                                FOREIGN KEY (produto_id)
                                    REFERENCES tb_produto(id)
                                    ON DELETE CASCADE
) ENGINE=InnoDB;