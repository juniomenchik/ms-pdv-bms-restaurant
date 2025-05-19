INSERT INTO tb_users (id, email, password, username)
VALUES
    (
        UNHEX(REPLACE('123e4567-e89b-12d3-a456-426614174001', '-', '')),
        'juniomenchik@live.com',
        '11112000',
        'juniomenchik'
    );