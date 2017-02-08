package example.blog.store.logic;

import java.util.List;

import example.blog.constants.Constants;
import example.blog.domain.Comment;
import example.blog.store.CommentStore;
import example.blog.store.util.ConnectionFactory;

public class CommentStoreLogic implements CommentStore {

	private ConnectionFactory factory;
	
	public CommentStoreLogic() {
		factory = ConnectionFactory.getInstance();
		factory.setUrl(Constants.DB_URL);
	}
	
	@Override
	public boolean create(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int commentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByPostId(int postId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Comment> readByPostId(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

}
