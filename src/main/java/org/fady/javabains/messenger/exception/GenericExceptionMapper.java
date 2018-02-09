package org.fady.javabains.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.fady.javabains.messenger.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		// TODO Auto-generated method stub
		ErrorMessage errmes=new ErrorMessage(ex.getMessage(),500,"http://tetst.test.test/");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				//.entity(errmes)
				.build();
			}
	
	

}
