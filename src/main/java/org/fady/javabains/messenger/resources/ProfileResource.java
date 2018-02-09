package org.fady.javabains.messenger.resources;

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

import org.fady.javabains.messenger.model.profile;
import org.fady.javabains.messenger.services.ProfileServices;

@Path("/profiles")
public class ProfileResource {
	ProfileServices MS=new ProfileServices();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<profile> getprofiles(){
		
		return MS.GetAllprofiles();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileId}")
	public profile profile(@PathParam("profileId") long profileId){

		return MS.Getprofile(profileId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public profile addprofile(profile mes){
		
		return MS.Addprofile(mes);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{profileId}")
	public profile updateprofile(@PathParam("profileId") long profileId, profile mes){
		//System.out.print("helloooooooooooooooooo1");
		mes.setId(profileId);
		return MS.Updateprofile(mes);
	}
	
	@DELETE
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileId}")
	public void deleteprofile(@PathParam("profileId") long profileId){

		MS.Removeprofile(profileId);
	}
	
}
