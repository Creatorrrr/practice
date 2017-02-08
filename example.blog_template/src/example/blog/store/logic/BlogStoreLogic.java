package example.blog.store.logic;

import java.util.List;

import example.blog.domain.Author;
import example.blog.domain.Blog;
import example.blog.store.BlogStore;

public class BlogStoreLogic extends StoreDB implements BlogStore {

	public BlogStoreLogic() {
		super();
	}
	
	@Override
	public boolean create(Blog blog) {
		return this.updateDB("INSERT INTO blog_tb VALUES(?,?,?)", 
				blog.getId(), 
				blog.getTitle(), 
				blog.getAuthor().getId()) > 0;
	}

	@Override
	public boolean update(Blog blog) {
		return this.updateDB("UPDATE blog_tb SET title = ?, author_id = ? WHERE id = ?", 
				blog.getTitle(), 
				blog.getAuthor().getId(),
				blog.getId()) > 0;
	}

	@Override
	public boolean delete(int blogId) {
		return this.updateDB("DELETE FROM blog_tb WHERE id = ?", 
				blogId) > 0;
	}

	@Override
	public Blog read(int blogId) {
		Blog blog = new Blog();
		Author author = null;
		List<List<String>> list = null;
		
		list = this.selectDB(
				"SELECT id, title, author_id FROM blog_tb WHERE id = ?", 
				blogId);
		
		for(List<String> l : list) {
			author = new Author();
			author.setId(l.get(2));
			
			blog.setId(Integer.parseInt(l.get(0)));
			blog.setTitle(l.get(1));
			blog.setAuthor(author);
			
//			for(String s : l) {
//				System.out.print(s.toString() + "\t");
//			}
//			System.out.println();
		}
		
		return blog;
	}

}
