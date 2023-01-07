package emlakcepte.controller;

import emlakcepte.model.Message;
import emlakcepte.model.User;
import emlakcepte.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {
	
	@Autowired
	private MessageService service;

	@GetMapping
	public List<Message> getAll() {
		return service.getAll();
	}

	@PostMapping
	public ResponseEntity<Message> create(@RequestBody Message message) {
		service.create(message);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Message> update(@RequestBody Message message) {
		service.update(message);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

	@DeleteMapping
	public ResponseEntity<Message> delete(@RequestBody Message message) {
		service.delete(message);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}


}
