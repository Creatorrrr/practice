package example.blog.store.logic;

import java.util.ArrayList;
import java.util.List;

import example.blog.constants.Constants;
import example.blog.domain.Post;
import example.blog.domain.Tag;
import example.blog.store.TagStore;
import example.blog.store.util.ConnectionFactory;

public class TagStoreLogic extends StoreDB implements TagStore {

	public TagStoreLogic() {
		super();
	}
	
	@Override
	public boolean create(Tag tag) {
		return this.updateDB("INSERT INTO tag_tb(id,name,post_id) VALUES(tag_seq.NEXTVAL,?,?)",
				tag.getName(),
				tag.getPostId()) > 0;
	}

	@Override
	public boolean delete(int tagId) {
		return this.updateDB("DELETE FROM tag_tb WHERE id = ?", 
				tagId) > 0;
	}

	@Override
	public boolean deleteByPostId(int postId) {
		return this.updateDB("DELETE FROM tag_tb WHERE post_id = ?", 
				postId) > 0;
	}

	@Override
	public List<Tag> readByPostId(int postId) {
		Tag tag = new Tag();
		List<List<String>> selectedList = null;
		List<Tag> tagList = new ArrayList<>();	
		
		selectedList = this.selectDB(
				"SELECT id, name, post_id FROM tag_tb WHERE post_id = ?", 
				postId);
		
		for(List<String> l : selectedList) {
			tag.setId(Integer.parseInt(l.get(0)));
			tag.setName(l.get(1));
			tag.setPostId(Integer.parseInt(l.get(2)));
			
			tagList.add(tag);
		}
		
//		for(String s : l) {
//			System.out.print(s.toString() + "\t");
//		}
//		System.out.println();
		
		return tagList;
	}

}
