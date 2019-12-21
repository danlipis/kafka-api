# Run
mvn spring-boot:run

# Producer
Executar em qualquer navegador http://localhost:8080/kafka e preencher o form ou executar o comando abaixo no terminal:

```shell
curl -d '{"nome":"EDUARDO DUARTE DE OLIVEIRA", "idade":31}' -H "Content-Type: application/json" -X POST http://localhost:8080/api/kafka	
```

# Arquitetura Desafio
![alt text](https://bitbucket.org/edoliveira/kafka-api/raw/b0f2d59366f8703cb1e557493cf8d14a26dcbe04/arquitetura_desafio.png)