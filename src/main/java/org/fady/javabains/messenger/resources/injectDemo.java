package org.fady.javabains.messenger.resources;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.fady.javabains.messenger.model.message;
import org.fady.javabains.messenger.services.MessageServices;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)

public class injectDemo {
	
	@GET
	@Path("annotations")
	public String getparambyAnnotation(@MatrixParam("param") String matrixvalue , 
										@HeaderParam("hparam") String hparam , 
										@CookieParam("Cparam") String cparam){
		return "Matrixvalue : " + matrixvalue + " Header Param : " + hparam + "Cookie param : " + cparam;
		
		
	}
	@GET
	@Path("context")
	public String getInfofromContext(@Context UriInfo uriinfo, @Context HttpHeaders headers){
		return "Path : " + uriinfo.getAbsolutePath().toString() + " Cookie : " + headers.getCookies().toString();
	}

}
