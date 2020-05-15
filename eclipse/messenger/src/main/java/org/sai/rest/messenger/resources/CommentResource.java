package org.sai.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sai.rest.messenger.model.Comment;
import org.sai.rest.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)

public class CommentResource {
	 
	private CommentService commentService = new CommentService();
	
	
	@GET
	public List<Comment> getAllComments(@PathParam ("messageId") long messageID)
	{
		return getAllComments(messageID);
	}
	
	@POST
	public Comment updateComment(@PathParam ("messageId") long messageID,Comment comment )
	{
		return commentService.addComment( messageID,   comment);
	}
	
	
	
	@PUT
	@Path("/{commentId}")
	
	public Comment updateComment(@PathParam ("messageId") long messageID , @PathParam ("commentId") long commentId, Comment comment  )
	{
		comment.setId(commentId);
		return commentService.updateComment(  messageID,   comment);
	}
	
	
	
	@DELETE
	@Path("/{commentId}")
	
	public Comment removeComment(@PathParam ("messageId") long messageID , @PathParam ("commentId") long commentId)
	{
		return commentService.removeComment(  messageID,   commentId);
	}
	
	
	
	
	@GET
	@Path("/{commentId}")
	public Comment getComment( @PathParam ("messageId") long messageID , @PathParam ("commentId") long commentId )
	{
		return commentService.getComment(  messageID,  commentId);
	}
		 
	}
	
//	
//	@Path("/{commentId}")
//	@GET
//	public String getComment(@PathParam("messageId") long messageID ,@PathParam("commentId") long comeId)
//	{
//		return "The comment id is"+comeId+"and the message is if fucking continously flowing so "+messageID;
//	}
//	
//}
