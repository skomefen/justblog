package model;

import java.util.Date;
import java.util.List;


/**
 * @author Oliver
 *
 */
public class PostModel {
	private String id;
	private String title;
	private String thumbnail;
	private String postClass;
	private String description;
	private String contextAddress;
	private String author;
	private String user_id;
	private List<String> post_tag;
	private Date udate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getPostClass() {
		return postClass;
	}
	public void setPostClass(String postClass) {
		this.postClass = postClass;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public List<String> getPost_tag() {
		return post_tag;
	}
	public void setPost_tag(List<String> post_tag) {
		this.post_tag = post_tag;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public String getContextAddress() {
		return contextAddress;
	}
	public void setContextAddress(String contextAddress) {
		this.contextAddress = contextAddress;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((contextAddress == null) ? 0 : contextAddress.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((postClass == null) ? 0 : postClass.hashCode());
		result = prime * result
				+ ((post_tag == null) ? 0 : post_tag.hashCode());
		result = prime * result
				+ ((thumbnail == null) ? 0 : thumbnail.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((udate == null) ? 0 : udate.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostModel other = (PostModel) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (contextAddress == null) {
			if (other.contextAddress != null)
				return false;
		} else if (!contextAddress.equals(other.contextAddress))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (postClass == null) {
			if (other.postClass != null)
				return false;
		} else if (!postClass.equals(other.postClass))
			return false;
		if (post_tag == null) {
			if (other.post_tag != null)
				return false;
		} else if (!post_tag.equals(other.post_tag))
			return false;
		if (thumbnail == null) {
			if (other.thumbnail != null)
				return false;
		} else if (!thumbnail.equals(other.thumbnail))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (udate == null) {
			if (other.udate != null)
				return false;
		} else if (!udate.equals(other.udate))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PostModel [id=" + id + ", title=" + title + ", thumbnail="
				+ thumbnail + ", postClass=" + postClass + ", description="
				+ description + ", contextAddress=" + contextAddress
				+ ", author=" + author + ", user_id=" + user_id + ", post_tag="
				+ post_tag + ", udate=" + udate + "]";
	}


	

	
	
}
