package model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class PostForm {
	@NotEmpty(message="没有标题")
	private String title;
	private String thumbnail;
	private String postClass;
	private String description;
	@NotEmpty(message="没有正文")
	private String context;
	private String author;
	private String user_id;
	private List<String> post_tag;

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
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
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
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((postClass == null) ? 0 : postClass.hashCode());
		result = prime * result
				+ ((post_tag == null) ? 0 : post_tag.hashCode());
		result = prime * result
				+ ((thumbnail == null) ? 0 : thumbnail.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		PostForm other = (PostForm) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PostForm [title=" + title + ", thumbnail=" + thumbnail
				+ ", postClass=" + postClass + ", description=" + description
				+ ", context=" + context + ", author=" + author + ", user_id="
				+ user_id + ", post_tag=" + post_tag + "]";
	}

	
	
}
