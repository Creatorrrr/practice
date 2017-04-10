package namoo.social.service;

import java.util.List;

import namoo.social.entity.Message;

public interface MessageService {
	public boolean registerMessage(Message message);
	public List<Message> findMessagesByWriterId(String writerId);
	public List<Message> findNewestMessagesByWriterId(String writerId);
}
