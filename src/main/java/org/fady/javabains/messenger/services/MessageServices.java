package org.fady.javabains.messenger.services;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.fady.javabains.messenger.model.message;
import org.fady.javabains.messenger.database.*;
public class MessageServices {
	private  Map<Long, message> messages= databaseClass.getMessages();
	//private List<message> messages = new ArrayList<>();
	private static Boolean flag1 = false;
	public MessageServices(){
		message m1=new message(1,"message hello would","fady");
		message m2=new message(2,"message hello Jersey","fady");
		if (flag1 == false){
			messages.put(1L, m1);
			messages.put(2L, m2);
			flag1=true;
		}
	}

	public List<message> GetAllMessages(){
		
		return new ArrayList<message>(messages.values());
	
	}
	public List<message> GetAllMessagesforyear(int year){
		List<message> messagesForYear =new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(message mes : messages.values()){
			cal.setTime(mes.getCreated());
			if(cal.get(Calendar.YEAR)==year)
				messagesForYear.add(mes);
		}
		return messagesForYear; //new ArrayList<message>(messages.values());
	
	}
	public List<message> GetAllMessagesforPaginated(int start, int size){
		ArrayList<message> list =new ArrayList<message>(messages.values());
		if(start+size > list.size())
			return list;
		return list.subList(start, size); //new ArrayList<message>(messages.values());
	
	}
	public message GetMessage(long id){
		
		return messages.get(id);
	
	}
	public message AddMessage(message mes){
		
		mes.setId(messages.size()+1);
		messages.put(mes.getId(), mes);
		return mes;
	}
	public message UpdateMessage(message mes){
		
		if( mes.getId()<=0){
			return null;
		}
		messages.put(mes.getId(), mes);
		//System.out.print("helloooooooooooooooooo2" + mes.getMessage());
		return mes;
	}
	public message RemoveMessage(long id){
		
		return messages.remove(id);
	
	}
}
