package emlakcepte.repository;

import emlakcepte.model.Message;
import emlakcepte.model.Realty;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    private static List<Message> messageList = new ArrayList<>();
    public void saveMessage(Message message) {
        messageList.add(message);
    }

    public void updateMessage(Message message){
        deleteMessage(message);
        saveMessage(message);
    }

    public void deleteMessage(Message message){
        messageList.removeIf(msg -> msg.getId()== message.getId());
    }
    public List<Message> findAll() {
        return messageList;
    }
}
