package emlakcepte.service;

import emlakcepte.model.Message;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.UserType;
import emlakcepte.repository.MessageRepository;
import emlakcepte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;


	public void create(Message message) {
		messageRepository.saveMessage(message);
	}

	public void update(Message message) {
		messageRepository.updateMessage(message);
	}

	public void delete(Message message) {
		messageRepository.deleteMessage(message);
	}

	public List<Message> getAll() {
		return messageRepository.findAll();
	}
}
