package br.com.desafioitu.kafka.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioitu.kafka.dto.Usuario;
import br.com.desafioitu.kafka.service.producer.Producer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	private final Producer producer;

	@Autowired
	KafkaController(Producer producer) {
		this.producer = producer;
	}

	@GetMapping
	public void getForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.html");
		dispatcher.forward(req, resp);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sendMessageToKafkaTopic(@RequestBody Usuario usuario) {
		producer.sendMessage(usuario);
		return new ResponseEntity<String>("{\"mensagem\": \"Usuário enviado com sucesso!\"}", HttpStatus.OK);
	}
}