package example.blog.service.logic;

import example.blog.domain.Author;
import example.blog.service.AuthorService;
import example.blog.store.AuthorStore;
import example.blog.store.logic.AuthorStoreLogic;

public class AuthorServiceLogic implements AuthorService {
	
	private AuthorStore store;
	
	public AuthorServiceLogic() {
		store = new AuthorStoreLogic();
	}

	@Override
	public boolean register(Author author) {
		return store.create(author);
	}

	@Override
	public boolean modify(Author author) {
		return store.update(author);
	}

	@Override
	public boolean remove(String authorId) {
		return store.delete(authorId);
	}

	@Override
	public Author find(String authorId) {
		return store.read(authorId);
	}

}
