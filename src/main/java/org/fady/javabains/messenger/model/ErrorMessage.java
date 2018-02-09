package org.fady.javabains.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorMeassage;
	private int errorCode;
	private String Documentation;
	
	public ErrorMessage(String errorMeassage, int errorCode, String documentation) {
		//super();
		this.errorMeassage = errorMeassage;
		this.errorCode = errorCode;
		Documentation = documentation;
	}
	public String getErrorMeassage() {
		return errorMeassage;
	}
	public void setErrorMeassage(String errorMeassage) {
		this.errorMeassage = errorMeassage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return Documentation;
	}
	public void setDocumentation(String documentation) {
		Documentation = documentation;
	}
	
}
