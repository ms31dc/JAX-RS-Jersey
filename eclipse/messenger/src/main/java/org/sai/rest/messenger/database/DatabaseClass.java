package org.sai.rest.messenger.database;

import org.sai.rest.messenger.model.*;
import java.util.HashMap;

public class DatabaseClass {
	
	
	public static  HashMap<Long , Message> messages = new HashMap<>();
	
	public static  HashMap<String , Profile> profiles = new HashMap<>();
	
	public static HashMap<Long,Message> getMessages()
	{
		
		return messages;
	}
	
	
	public static HashMap<String,Profile> getProfiles()
	{
		
		return profiles;
	}

}
