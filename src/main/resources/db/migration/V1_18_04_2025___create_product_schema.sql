1CREATE TABLE products (
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    code                VARCHAR(20) UNIQUE,
    name                VARCHAR(100) NOT NULL,
    description         TEXT,
    price               DECIMAL(10,2) NOT NULL,
    cost                DECIMAL(10,2),
    category_id         BIGINT NOT NULL,
    preparation_time    INT COMMENT 'Time in minutes',
    is_active           BOOLEAN DEFAULT TRUE,
    inventory_controlled BOOLEAN DEFAULT FALSE,
    image_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);