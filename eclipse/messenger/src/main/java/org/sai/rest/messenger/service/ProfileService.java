package org.sai.rest.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.sai.rest.messenger.database.DatabaseClass;

import org.sai.rest.messenger.model.Profile;

public class ProfileService {

	
public static  HashMap<String , Profile> profiles =   DatabaseClass.getProfiles();
	
	
	public ProfileService() {
		
		Profile as = new Profile(1L,"sai","S","K");
		Profile as2 = new Profile(2L,"rylon","First","Last");
		
		profiles.put("sai", as);
		profiles.put("ryan", as2);
		
		profiles.put("noob", new Profile(3L,"noob","Rai","Lolum")  );
	}


	
	
	
	public List<Profile> getAllProfiles(){
		List<Profile> list = new ArrayList<>();
		list.addAll(profiles.values());//This is a hashmap method to return all values	 
		return list;
	}
	
	
	public Profile getProfile(String pfname) {		
		return profiles.get(pfname);	
	}
	
	
	public Profile addProfile(Profile profile) {
	 
		profile.setId(profiles.size()+1);
		
	 
		profiles.put( profile.getProfileName(), profile);	
		return  profile;
	}
	
	
	public Profile updateProfile(Profile profile)
	{
		if(profile.getProfileName().isEmpty()) {return null;}		
		profiles.put(profile.getProfileName(), profile);		
		return profile;
	}
	
	
	public Profile removeProfile(String FirstName) {
	return profiles.remove(FirstName);		
	}
	
	
}
