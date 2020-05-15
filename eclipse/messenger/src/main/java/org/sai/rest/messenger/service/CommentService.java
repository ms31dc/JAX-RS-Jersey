package org.sai.rest.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sai.rest.messenger.database.DatabaseClass;
import org.sai.rest.messenger.model.Comment;
import org.sai.rest.messenger.model.Message;

public class CommentService {
	
	
	public static  HashMap<Long , Message> messages =   DatabaseClass.getMessages();
	
	
	
	
	public List<Comment> getAllComments(long messageId){
		Map<Long,Comment> comments=  messages.get(messageId).getComments();
		List<Comment> list = new ArrayList<>();
		list.addAll(comments.values());
		
		return list;
	}
	
	
	public Comment getComment(long messageId,long CommentId)
	{
		Map<Long,Comment> comments=  messages.get(messageId).getComments();
		return comments.get(CommentId);
	}
	
	public Comment addComment(long messageId, Comment comment)
	{
		Map<Long,Comment> comments=  messages.get(messageId).getComments();
		
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		
		return comment;
	}
	
	
	public Comment updateComment(long messageId, Comment comment)
	{
		Map<Long,Comment> comments=  messages.get(messageId).getComments();
		if(comment.getId()<=0)
		{
			return null;
		}
		
		comments.put(comment.getId(), comment);
		return comment;
		
	}
	
	public Comment removeComment(long messageId, long CommentId)
	{
		
		Map<Long,Comment> comments=  messages.get(messageId).getComments();
		return comments.remove(CommentId);
		
	}
	
	
	

}
