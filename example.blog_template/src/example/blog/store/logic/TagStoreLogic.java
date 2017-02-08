package example.blog.store.logic;

import java.util.List;

import example.blog.constants.Constants;
import example.blog.domain.Tag;
import example.blog.store.TagStore;
import example.blog.store.util.ConnectionFactory;

public class TagStoreLogic implements TagStore {

	private ConnectionFactory factory;
	
	public TagStoreLogic() {
		factory = ConnectionFactory.getInstance();
		factory.setUrl(Constants.DB_URL);
	}
	
	@Override
	public boolean create(Tag tag) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int tagId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByPostId(int postId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Tag> readByPostId(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

}
