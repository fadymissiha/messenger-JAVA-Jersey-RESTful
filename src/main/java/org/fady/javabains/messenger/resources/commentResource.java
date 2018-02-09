package org.fady.javabains.messenger.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.fady.javabains.messenger.model.*;
import org.fady.javabains.messenger.resources.beans.messageFilterBean;
import org.fady.javabains.messenger.services.*;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class commentResource {
	CommentServices cS=new CommentServices();
	
	@GET
	public List<comment> getMessages(@PathParam("messageId") Long messageId){
		return cS.getComments(messageId);
	}
	
	@GET
	@Path("/{commentid}")
	public comment getComment(@PathParam("messageId") Long messageId, @PathParam("commentid") long commentid){

		return cS.getComment(messageId, commentid);
	}
	
	@POST
	public comment addComment(@PathParam("messageId") Long messageId,comment comment){
		
		return cS.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentid}")
	public comment updateMessage(@PathParam("messageId") long messageId,@PathParam("commentid") long commentid, comment comment){
		comment.setId(commentid);
		return cS.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentid}")
	public void deletecomment(@PathParam("messageId") Long messageId, @PathParam("commentid") long commentid){

		cS.removeComment(messageId, commentid);
	}
	
}
