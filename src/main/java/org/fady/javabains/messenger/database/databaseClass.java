package org.fady.javabains.messenger.database;


import java.util.HashMap;
import java.util.Map;

import org.fady.javabains.messenger.model.*;
//import org.fady.javabains.messenger.model.profile;

public class databaseClass {
	
	private static  Map <Long, message> messages = new HashMap<>();
	private static  Map <Long, profile> profiles = new HashMap<>();
		public static Map <Long, message> getMessages(){
			return messages;
		}
		public static Map <Long, profile> getprofiles(){
			return profiles;
		}
}

