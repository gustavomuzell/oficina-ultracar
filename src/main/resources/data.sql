INSERT INTO tb_cliente (nome, cpf, email, telefone, endereco)
VALUES ('Gustavo Muzell', '12345678901', 'gustavo@email.com', '1190000-0000', 'rua 1, numero 366');

INSERT INTO tb_carro (cliente_id, veiculo, placa, cor, ano, acessorio)
VALUES (1, 'Honda civic', 'ABC123', 'Vermelho', '2023', 'Ar condicionado'),
       (1, 'Porsche 911', 'DEF456', 'Preto', '2015', 'Cabriot'),
       (1, 'Volkswagen Golf', 'GYE123', 'Branco', '2019', 'Teto Solar');

INSERT INTO tb_checklist (avarias, amassado, sujo)
 VALUES (true, false, true);
