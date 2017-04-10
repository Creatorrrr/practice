package namoo.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import namoo.social.dao.MessageDao;
import namoo.social.entity.Message;

@Service
public class MessageServiceLogic implements MessageService {

	@Autowired
	private MessageDao messageDao;
	
	@Override
	public boolean registerMessage(Message message) {
		return messageDao.create(message) == 1;
	}

	@Override
	public List<Message> findMessagesByWriterId(String writerId) {
		return messageDao.retrieveMessage(writerId);
	}
	
	@Override
	public List<Message> findNewestMessagesByWriterId(String writerId) {
		return messageDao.retrieveRelatedMessage(writerId);
	}

}
