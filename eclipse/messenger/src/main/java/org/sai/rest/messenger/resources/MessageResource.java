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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.sai.rest.messenger.model.Message;
import org.sai.rest.messenger.service.MessageService;

@Path("/messages")

public class MessageResource {

	MessageService msg = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	
	public List<Message> getMessages(@QueryParam("year") int year,
			@QueryParam("start") int start,
			@QueryParam("size") int size)///for empty querying the query paramaeter is zero, as int=0. boolean=false,default datatype
	{	
		if(year>0) {return msg.geAllMessages(year);}
		
		 if(start>0 && size>0)
			return msg.getAllMessagesPaginated(start, size);
		 return  msg.getAllMessages();
	}
	
	
	 

	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_XML) 
	public Message getTest(@PathParam ("messageId") long messageID )
	{
		return msg.getMessage(messageID) ;
	}
	
	
 
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML) 
	public Message addMessage(Message msga)
	{
		return msg.addMessage(msga);
	}
	 
	
	@Path("/{messageId}")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML) 
	public Message updateMessage(@PathParam ("messageId") long messageID ,Message msga)
	{
		msga.setId(messageID);
		return msg.updateMessage(msga);
	}
	
	
	@Path("/{messageId}")
	@DELETE
 
	@Produces(MediaType.APPLICATION_XML) 
	public Message updateMessage(@PathParam ("messageId") long messageID )
	{
	return msg.removeMessage(messageID);
	}
	
	
	@Path("/{messageId}/comments")
	 
	public CommentResource getCommentResource( )
	{
		return new CommentResource( );
	}
	
}
