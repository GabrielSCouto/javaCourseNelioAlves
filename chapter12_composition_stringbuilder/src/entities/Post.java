package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private String title;
	private String content;
	private Integer likes;
	
	private List<Comment> comments = new ArrayList<>();

	public Post() {
		
	}
	
	public Post(LocalDateTime moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public void removeComment(Comment comment) {
		comments.remove(comment);
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();
		
		build.append(title + "\n");
		build.append(likes + " Likes - ");
		build.append(moment.format(format) + "\n");
		build.append(content + "\n");
		build.append("Comments: \n");
		
		for (Comment c : comments) {
			build.append(c.getText() + "\n");
		}
		
		return build.toString();
	}
	
	
}
