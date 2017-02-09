package example.blog.service.logic;

import java.util.List;

import example.blog.domain.Post;
import example.blog.service.PostService;
import example.blog.store.PostStore;
import example.blog.store.logic.PostStoreLogic;

public class PostServiceLogic implements PostService {
	
	private PostStore store;
	
	public PostServiceLogic() {
		store = new PostStoreLogic();
	}

	@Override
	public boolean register(Post post) {
		return store.create(post);
	}

	@Override
	public boolean modify(Post post) {
		return store.update(post);
	}

	@Override
	public boolean remove(int postId) {
		return store.delete(postId);
	}

	@Override
	public Post find(int postId) {
		return store.read(postId);
	}

	@Override
	public List<Post> findByBlogId(int blogId) {
		return store.readByBlogId(blogId);
	}

}
