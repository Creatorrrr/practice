package example.blog.store.logic;

import java.util.List;

import example.blog.constants.Constants;
import example.blog.domain.Post;
import example.blog.store.PostStore;
import example.blog.store.util.ConnectionFactory;

public class PostStoreLogic implements PostStore {

	private ConnectionFactory factory;
	
	public PostStoreLogic() {
		factory = ConnectionFactory.getInstance();
		factory.setUrl(Constants.DB_URL);
	}
	
	@Override
	public int nextId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean create(Post post) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Post post) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int postId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Post read(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> readByBlogId(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

}
