package org.fady.javabains.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.fady.javabains.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotfoundException>  {

	@Override
	public Response toResponse(DataNotfoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage errmes=new ErrorMessage(ex.getMessage(),404,"http://tetst.test.test/");
		return Response.status(Status.NOT_FOUND)
				.entity(errmes)
				.build();
		
	}

}
