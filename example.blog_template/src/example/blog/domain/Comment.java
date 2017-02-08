package example.blog.domain;

/**
 * Comment
 * 
 * @author Eunyoung Kim(eykim@nextree.co.kr)
 * @sinse Mar 1, 2016
 */
public class Comment {

	private int id;
	private String name;
	private String comment;
	private int postId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String toString() {
		return "Comment: " + id + " : " + name + " : " + comment;
	}
}
