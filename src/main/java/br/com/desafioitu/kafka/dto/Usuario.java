package br.com.desafioitu.kafka.dto;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Usuario implements Serializer<Usuario>, Deserializer<Usuario> {

	private String nome;
	private Long idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	@Override
	public void close() {
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
	}

	@Override
	public byte[] serialize(String arg0, Usuario valor) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal = objectMapper.writeValueAsString(valor).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}

	@Override
	public Usuario deserialize(String arg0, byte[] valor) {
		ObjectMapper mapper = new ObjectMapper();
		Usuario usuario = null;
		try {
			usuario = mapper.readValue(valor, Usuario.class);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return usuario;
	}
}
