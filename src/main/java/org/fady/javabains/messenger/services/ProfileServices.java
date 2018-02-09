package org.fady.javabains.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.fady.javabains.messenger.database.databaseClass;
import org.fady.javabains.messenger.model.message;
import org.fady.javabains.messenger.model.profile;

public class ProfileServices {
	private  Map<Long, profile> profiles= databaseClass.getprofiles();
	//private List<> s = new ArrayList<>();
	private static Boolean flag1 = false;
	public ProfileServices(){
		profile p1=new profile((long) 1,"fady","fady","zakarya");
		profile p2=new profile((long) 2,"ali","ali","ahmed");
		if (flag1 == false){
			profiles.put(1L, p1);
			profiles.put(2L, p2);
			flag1=true;
		}
	}

	public List<profile> GetAllprofiles(){
		
		return new ArrayList<profile>(profiles.values());
	
	}
	public profile Getprofile(long id){
		
		return profiles.get(id);
	
	}
	public profile Addprofile(profile mes){
		
		mes.setId((long) (profiles.size()+1));
		profiles.put(mes.getId(), mes);
		return mes;
	}
	public profile Updateprofile(profile mes){
		
		if( mes.getId()<=0){
			return null;
		}
		profiles.put(mes.getId(), mes);
		//System.out.print("helloooooooooooooooooo2" + mes.getprofile());
		return mes;
	}
	public profile Removeprofile(long id){
		
		return profiles.remove(id);
	
	}
}
