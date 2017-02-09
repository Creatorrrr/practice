package example.blog.store.logic;

import java.util.ArrayList;
import java.util.List;

import example.blog.constants.Constants;
import example.blog.domain.Post;
import example.blog.store.PostStore;

public class PostStoreLogic extends StoreDB implements PostStore {

	public PostStoreLogic() {
		super();
	}
	
	@Override
	public int nextId() {
		List<List<String>> list = null;
		
		this.updateDB("ALTER SEQUENCE post_seq INCREMENT BY -1");
		this.selectDB("SELECT post_seq.NEXTVAL FROM dual");
		this.updateDB("ALTER SEQUENCE post_seq INCREMENT BY 1");
		list = this.selectDB("SELECT post_seq.NEXTVAL FROM dual");
		
		if(list != Constants.SELECT_FAIL) {
			return Integer.parseInt(list.get(0).get(0)) + 1;
		} else {
			return Constants.NEXTID_FAIL;
		}
	}

	@Override
	public boolean create(Post post) {
		return this.updateDB("INSERT INTO post_tb(id,subject,contents,blog_id) VALUES(post_seq.NEXTVAL,?,?,?)",
				post.getSubject(), 
				post.getContents(),
				post.getBlogId()) > 0;
	}

	@Override
	public boolean update(Post post) {
		return this.updateDB("UPDATE post_tb SET subject = ?, contents = ?, blog_id = ? WHERE id = ?", 
				post.getSubject(), 
				post.getContents(),
				post.getBlogId(),
				post.getId()) > 0;
	}

	@Override
	public boolean delete(int postId) {
		return this.updateDB("DELETE FROM post_tb WHERE id = ?", 
				postId) > 0;
	}

	@Override
	public Post read(int postId) {
		Post post = new Post();
		List<List<String>> list = null;
		
		list = this.selectDB(
				"SELECT id, subject, contents, blog_id FROM post_tb WHERE id = ?", 
				postId);
		
		if(list != Constants.SELECT_FAIL) {
			post.setId(Integer.parseInt(list.get(0).get(0)));
			post.setSubject(list.get(0).get(1));
			post.setContents(list.get(0).get(2));
			post.setBlogId(Integer.parseInt(list.get(0).get(3)));
		} else {
			return null;
		}
		
//		for(String s : l) {
//			System.out.print(s.toString() + "\t");
//		}
//		System.out.println();
		
		return post;
	}

	@Override
	public List<Post> readByBlogId(int blogId) {
		Post post = new Post();
		List<List<String>> selectedList = null;
		List<Post> postList = new ArrayList<>();	
		
		selectedList = this.selectDB(
				"SELECT id, subject, contents, blog_id FROM post_tb WHERE blog_id = ?", 
				blogId);
		
		for(List<String> l : selectedList) {
			post.setId(Integer.parseInt(l.get(0)));
			post.setSubject(l.get(1));
			post.setContents(l.get(2));
			post.setBlogId(Integer.parseInt(l.get(3)));
			
			postList.add(post);
		}
		
//		for(String s : l) {
//			System.out.print(s.toString() + "\t");
//		}
//		System.out.println();
		
		return postList;
	}

}
