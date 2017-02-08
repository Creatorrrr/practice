package example.blog.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Blog
 * 
 * @author Eunyoung Kim(eykim@nextree.co.kr)
 * @sinse Mar 1, 2016
 */
public class Blog {

	private int id;
	private String title;
	private Author author;
	private List<Post> posts;
	
	public Blog() {
		author = new Author();
		posts = new ArrayList<>();
	}

	public Blog(int id, String title, String authorId) {
		//
		this();
		this.id = id;
		this.title = title;
		this.author.setId(authorId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String toString() {
		return "Blog: " + id + " : " + title + " (" + author + ")";
	}
}
