package org.fady.javabains.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class message {
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long, comment> comments = new HashMap<>();
	private List<Link> links =new ArrayList<>();
	
	public message(){
		
	}
	
	public message(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlTransient
	public Map<Long, comment> getComments(){
		return comments;
	}
	public void setComments(Map<Long, comment> comments){
		this.comments= comments;
	}
	public void AddLink(String link,String rel){
		Link newlink = new Link();
		newlink.setLink(link);
		newlink.setRel(rel);
		links.add(newlink);
	}

}
