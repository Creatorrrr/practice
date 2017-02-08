package example.blog.store.logic;

import java.util.ArrayList;
import java.util.List;

import example.blog.domain.Comment;
import example.blog.store.CommentStore;

public class CommentStoreLogic extends StoreDB implements CommentStore {
	
	public CommentStoreLogic() {
		super();
	}
	
	@Override
	public boolean create(Comment comment) {
		return this.updateDB("INSERT INTO comment_tb VALUES(comment_seq.NEXTVAL,?,?,?)", 
				comment.getName(), 
				comment.getComment(), 
				comment.getPostId()) > 0;
	}

	@Override
	public boolean delete(int commentId) {
		return this.updateDB("DELETE FROM comment_tb WHERE id = ?", 
				commentId) > 0;
	}

	@Override
	public boolean deleteByPostId(int postId) {
		return this.updateDB("DELETE FROM comment_tb WHERE post_id = ?", 
				postId) > 0;
	}

	@Override
	public List<Comment> readByPostId(int postId) {
		Comment comment = null;
		List<List<String>> selectedList = null;
		List<Comment> commentList = new ArrayList<>();	
		
		selectedList = this.selectDB(
				"SELECT id, name, comment_contents, post_id FROM comment_tb WHERE post_id = ?", 
				postId + "");
		
		for(List<String> l : selectedList) {
			comment = new Comment();
			comment.setId(Integer.parseInt(l.get(0)));
			comment.setName(l.get(1));
			comment.setComment(l.get(2));
			comment.setPostId(Integer.parseInt(l.get(3)));
			
			commentList.add(comment);
			
//			for(String s : l) {
//				System.out.print(s.toString() + "\t");
//			}
//			System.out.println();
		}
		
		return commentList;
	}

}
