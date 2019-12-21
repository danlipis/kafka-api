package br.com.desafioitu.kafka.service.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import br.com.desafioitu.kafka.dto.Usuario;

@Configuration
public class KafkaProducerConfig {

	@Bean
	public ProducerFactory<String, Usuario> producerFactory() {

		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.31.44.247:9093");

		props.put("security.protocol", "SSL");

		props.put("ssl.keystore.location", "/opt/ssl/client.keystore.jks");
		props.put("ssl.keystore.password", "abc123");
		props.put("ssl.key.password", "abc123");

		props.put("ssl.truststore.location", "/opt/ssl/client.truststore.jks");
		props.put("ssl.truststore.password", "abc123");

		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Usuario.class);

		return new DefaultKafkaProducerFactory<>(props);
	}

	@Bean
	public KafkaTemplate<String, Usuario> kafkaTemplate() {
		return new KafkaTemplate<String, Usuario>(producerFactory());
	}
}
