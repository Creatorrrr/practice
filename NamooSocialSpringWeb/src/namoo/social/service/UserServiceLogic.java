package namoo.social.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import namoo.social.dao.UserDao;
import namoo.social.entity.User;
import namoo.social.entity.UserToUser;

@Service
public class UserServiceLogic implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findUserById(String userId) {
		return userDao.retrieveUser(userId);
	}
	
	@Override
	public boolean registerUser(User user) {
		int userResult =  userDao.createUser(user);
		UserToUser utu = new UserToUser();
		utu.setFromUser(user);
		utu.setToUser(user);
		int utuResult = userDao.createUserToUser(utu);
		return userResult == 1 && utuResult == 1;
	}

	@Override
	public boolean registerUserToUser(UserToUser userToUser) {
		return userDao.createUserToUser(userToUser) == 1;
	}

	@Override
	public List<User> findUsersByFromIdWithoutSelf(String fromUserId) {
		List<User> users = userDao.retrieveUsersByFromUser(fromUserId);
		List<User> removedUsers = new ArrayList<>();
		for(User user : users) {
			if(!user.getId().equals(fromUserId)) {
				removedUsers.add(user);
			}
		}
		return removedUsers;
	}

	@Override
	public List<User> findUsersByFromIdWithoutSelf(String fromUserId, String searchText) {
		List<User> users = userDao.retrieveUsersByFromUser(fromUserId, searchText);
		List<User> removedUsers = new ArrayList<>();
		for(User user : users) {
			if(!user.getId().equals(fromUserId)) {
				removedUsers.add(user);
			}
		}
		return removedUsers;
	}

	@Override
	public int numberOfRelatedUsersByFromUser(String fromUserId) {
		return userDao.countOfRelatedUsersByFromUser(fromUserId) - 1;
	}

	@Override
	public List<User> findUsersByToUserWithoutSelf(String toUserId) {
		List<User> users = userDao.retrieveUsersByToUser(toUserId);
		List<User> removedUsers = new ArrayList<>();
		for(User user : users) {
			if(!user.getId().equals(toUserId)) {
				removedUsers.add(user);
			}
		}
		return removedUsers;
	}

	@Override
	public List<User> findUsersByToUserWithoutSelf(String toUserId, String searchText) {
		List<User> users = userDao.retrieveUsersByToUser(toUserId, searchText);
		List<User> removedUsers = new ArrayList<>();
		for(User user : users) {
			if(!user.getId().equals(toUserId)) {
				removedUsers.add(user);
			}
		}
		return removedUsers;
	}

	@Override
	public int numberOfRelatedUsersByToUser(String toUserId) {
		return userDao.countOfRelatedUsersByToUser(toUserId) - 1;
	}

	@Override
	public boolean removeUserToUser(UserToUser userToUser) {
		return userDao.deleteUserToUser(userToUser) > 0;
	}
}
