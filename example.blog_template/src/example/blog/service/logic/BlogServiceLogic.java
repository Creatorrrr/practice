package example.blog.service.logic;

import example.blog.domain.Blog;
import example.blog.service.BlogService;
import example.blog.store.BlogStore;
import example.blog.store.logic.BlogStoreLogic;

public class BlogServiceLogic implements BlogService {
	
	private BlogStore store;
	
	public BlogServiceLogic() {
		store = new BlogStoreLogic();
	}

	@Override
	public boolean register(Blog blog) {
		return store.create(blog);
	}

	@Override
	public boolean modify(Blog blog) {
		return store.update(blog);
	}

	@Override
	public boolean remove(int blogId) {
		return store.delete(blogId);
	}

	@Override
	public Blog find(int blogId) {
		return store.read(blogId);
	}

}
