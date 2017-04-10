package namoo.social.service;

import java.util.List;

import namoo.social.entity.User;
import namoo.social.entity.UserToUser;

public interface UserService {
	public User findUserById(String userId);
	public boolean registerUser(User user);
	public boolean registerUserToUser(UserToUser userToUser);
	public List<User> findUsersByFromIdWithoutSelf(String fromUserId);
	public List<User> findUsersByFromIdWithoutSelf(String fromUserId, String searchText);
	public int numberOfRelatedUsersByFromUser(String fromUserId);
	public List<User> findUsersByToUserWithoutSelf(String toUserId);
	public List<User> findUsersByToUserWithoutSelf(String toUserId, String searchText);
	public int numberOfRelatedUsersByToUser(String toUserId);
	public boolean removeUserToUser(UserToUser userToUser);
}
