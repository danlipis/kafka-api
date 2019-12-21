package br.com.desafioitu.kafka.service.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import br.com.desafioitu.kafka.dto.Usuario;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Bean
	public ConsumerFactory<String, Usuario> consumerFactory() {

		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.31.44.247:9093");

		props.put("security.protocol", "SSL");

		props.put("ssl.keystore.location", "/opt/ssl/client.keystore.jks");
		props.put("ssl.keystore.password", "abc123");
		props.put("ssl.key.password", "abc123");

		props.put("ssl.truststore.location", "/opt/ssl/client.truststore.jks");
		props.put("ssl.truststore.password", "abc123");

		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, Usuario.class);

		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Usuario> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, Usuario> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
