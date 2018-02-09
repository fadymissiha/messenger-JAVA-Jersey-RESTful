package org.fady.javabains.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.fady.javabains.messenger.database.databaseClass;
import org.fady.javabains.messenger.model.comment;
import org.fady.javabains.messenger.model.message;

public class CommentServices {

	private Map<Long, message> messages = databaseClass.getMessages();
	
	public List<comment> getComments(Long messageId){
		Map<Long, comment> comments = messages.get(messageId).getComments();
		return new  ArrayList<comment>(comments.values());
	}
	public comment getComment(Long messageId,Long commentId){
		Map<Long, comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	public comment addComment(Long messageId,comment comment){
		Map<Long, comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	public comment updateComment(Long messageId,comment comment){
		Map<Long, comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <= 0)return null;
		comments.put(comment.getId(), comment);
		return comment;
	}
	public comment removeComment(Long messageId,Long commentId){
		Map<Long, comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
}
