package br.com.desafioitu.kafka.service.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.desafioitu.kafka.dto.Usuario;
import br.com.desafioitu.kafka.service.producer.Producer;

@Service
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Producer.class);

	@KafkaListener(topics = "secure-topic", groupId = "group_id")
	public void consume(Usuario usuario) throws IOException {
		logger.info(String.format("#### -> Consumindo secure-topic -> %s :: Idade -> %s.", usuario.getNome(), usuario.getIdade()));
	}
}
