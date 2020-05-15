package org.sai.rest.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement///Jacks p converts to xml

public class Profile {
	
	
	
	private long id;
	private String ProfileName;
	private String FirstName;
	private String LastName;
	private Date created;
	
	
	
	
	
	public Profile() {
		 
	}


	public Profile(long id, String profileName, String firstName, String lastName ) {
	//	super();
		this.id = id;
		ProfileName = profileName;
		FirstName = firstName;
		LastName = lastName;
		this.created = new Date();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return ProfileName;
	}
	public void setProfileName(String profileName) {
		ProfileName = profileName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
	
	

}
