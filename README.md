# Desafio Ultracar API 

##  Descrição do desafio
Esta aplicação foi criada para realizar o desafio proposto pela Ultracar funcionalidades:
- Leitura, cadastro, atualização e deleção de clientes;
- Leitura, cadastro, atualização e deleção de carros;
- Leitura, cadastro, atualização e deleção de checklist de avarias;
- abertura de ordem de serviço
- vizualização e impressão da ordem de serviço

##  Tecnologias
- Java [11]
- Maven [3.8.6]
- Spring Boot [2.7.3] (MVC, JPA)
- H2 Database [2.1.214]
- Lombok [1.18.24]

## ✅ Requisitos
- [JDK 17.0.4.1](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.8.6](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [IntelliJ IDEA (recomendado)](https://www.jetbrains.com/idea/download)
- [Postman (recomendado)](https://www.postman.com/downloads/)
- [Git (recomendado)](https://git-scm.com/downloads)


##  Lógica
Para realizar uma requisição de uma abertura de Ordem de servicço, é necessário atender primeiramente os seguintes requisitos:
- Deve ser enviado id do cliente .
- O cliente deve estar cadastrado no sistema.
- Ter ao menos uma carro cadastrado e ativo no sistema.
- selecionar qual carro deseja o atendimento

Sendo atendido esses primeiros requisitos, o sistema partirá para próxima etapa. A seguda etapa o sistema irá exibir um checklist do carro do cliente, para verificar se o carro possui alguma avaria, amassado ou o carro está sujo, sendo possível clicar no checkbox se possui algum item danificado 

Após passar para terceira e Última tela, o sistema irá apresentar um checkbox para qual serviço será feito no carro do cliente e terá a função de imprimir a Ordem de serviço gerada com os dados do veículo e do cliente e qual serviço foi indicado para o veículo


## 💾 Banco de Dados
Ao iniciar a aplicação, o Spring Boot irá executar o arquivo "data.sql" (localizado em "src/main/resources/") automaticamente. Dessa forma, as tabelas "tb_cliente", "tb_checklist" e "tb_carro" serão alimentadas com o script SQL abaixo:
```sql
INSERT INTO tb_cliente (nome, cpf, email, telefone, endereco)
VALUES ('Gustavo Muzell', '12345678901', 'gustavo@email.com', '1190000-0000', 'rua 1, numero 366');

INSERT INTO tb_carro (cliente_id, veiculo, placa, cor, ano, acessorio)
VALUES (1, 'Honda civic', 'ABC123', 'Vermelho', '2023', 'Ar condicionado'),
       (1, 'Porsche 911', 'DEF456', 'Preto', '2015', 'Cabriot'),
       (1, 'Volkswagen Golf', 'GYE123', 'Branco', '2019', 'Teto Solar');

INSERT INTO tb_checklist (avarias, amassado, sujo)
 VALUES (true, false, true);

```
O H2 Database pode ser acessado através do seguinte caminho:
```
http://localhost:8081/h2-console
```
> Observação: utilize "jdbc:h2:mem:testdb;DATABASE_TO_UPPER=false".

>Observação: não foi possível concluir o desafio completo devido ao prazo ter chego ao fim, entretanto irei continuar implementando melhorias como desafio pessoal.