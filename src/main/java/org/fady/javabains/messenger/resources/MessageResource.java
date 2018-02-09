package org.fady.javabains.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.fady.javabains.messenger.exception.DataNotfoundException;
import org.fady.javabains.messenger.model.message;
import org.fady.javabains.messenger.resources.beans.messageFilterBean;
import org.fady.javabains.messenger.services.MessageServices;
import org.glassfish.jersey.server.Uri;

@Path("/messages")
public class MessageResource {
	MessageServices MS=new MessageServices();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<message> getMessages(@BeanParam messageFilterBean messagefilters){
		if(messagefilters.getYear()>0)
			return MS.GetAllMessagesforyear(messagefilters.getYear());
		if(messagefilters.getStart()>=0 && messagefilters.getSize()>=0)
			return MS.GetAllMessagesforPaginated(messagefilters.getStart(), messagefilters.getSize());
		return MS.GetAllMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public message Message(@PathParam("messageId") long messageId, @Context UriInfo uriinfo){
			message mes =MS.GetMessage(messageId);
			//if (mes == null) throw new DataNotfoundException("message number " + messageId + "not found");
			String uri=uriinfo.getBaseUriBuilder()
					.path(MessageResource.class)
					.path(Long.toString(mes.getId()))
					.build()
					.toString();
			mes.AddLink(uri, "Self");
			
		return mes;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(message mes, @Context UriInfo uriinfo){
		message newmessage =MS.AddMessage(mes);
		String getid= String.valueOf(newmessage.getId());
		URI uri =uriinfo.getAbsolutePathBuilder().path(getid).build();
		
		return Response.created(uri).entity(newmessage).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public message updateMessage(@PathParam("messageId") long messageId, message mes){
		//System.out.print("helloooooooooooooooooo1");
		mes.setId(messageId);
		return MS.UpdateMessage(mes);
	}
	
	@DELETE
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageId){

		MS.RemoveMessage(messageId);
	}
	
}
