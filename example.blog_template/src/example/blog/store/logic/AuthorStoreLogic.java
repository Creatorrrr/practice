package example.blog.store.logic;

import java.util.List;

import example.blog.domain.Author;
import example.blog.store.AuthorStore;

public class AuthorStoreLogic extends StoreDB implements AuthorStore {
	
	public AuthorStoreLogic() {
		super();
	}

	@Override
	public boolean create(Author author) {
		return this.updateDB("INSERT INTO author_tb VALUES(?,?,?,?)", 
				author.getId(), 
				author.getPassword(), 
				author.getName(), 
				author.getEmail()) > 0;
	}

	@Override
	public boolean update(Author author) {
		return this.updateDB("UPDATE author_tb SET password = ?, name = ?, email = ? WHERE id = ?", 
				author.getPassword(), 
				author.getName(), 
				author.getEmail(),
				author.getId()) > 0;
	}

	@Override
	public boolean delete(String authorId) {
		return this.updateDB("DELETE FROM author_tb WHERE id = ?", 
				authorId) > 0;
	}

	@Override
	public Author read(String authorId) {
		Author author = new Author();
		List<List<String>> list = null;
		
		list = this.selectDB(
				"SELECT id, password, name, email FROM author_tb WHERE id = ?", 
				authorId);
		
		for(List<String> l : list) {
			author.setId(l.get(0));
			author.setPassword(l.get(1));
			author.setName(l.get(2));
			author.setEmail(l.get(3));
			
			for(String s : l) {
				System.out.print(s.toString());
			}
			System.out.println();
		}
		
		return author;
	}

}
