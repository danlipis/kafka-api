# Run
mvn spring-boot:run

# Producer
Executar em qualquer navegador http://localhost:8080/kafka e preencher o form ou executar o comando abaixo no terminal:

```shell
curl -d '{"nome":"DANIEL BASTOS", "idade":31}' -H "Content-Type: application/json" -X POST http://34.229.110.61:8080	
```

# Arquitetura Desafio
![alt text](https://raw.githubusercontent.com/danlipis/kafka-api/master/arquitetura_desafio_itau.png)
