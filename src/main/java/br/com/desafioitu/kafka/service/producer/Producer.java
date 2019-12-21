package br.com.desafioitu.kafka.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.desafioitu.kafka.dto.Usuario;

@Service
public class Producer {

	private static final String TOPIC = "secure-topic";

	@Autowired
	private KafkaTemplate<String, Usuario> kafkaTemplate;

	public void sendMessage(Usuario usuario) {
		kafkaTemplate.send(TOPIC, usuario);
	}
}