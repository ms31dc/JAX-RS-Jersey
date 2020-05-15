package org.sai.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.sai.rest.messenger.model.Profile;
import org.sai.rest.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
	
	ProfileService prf = new ProfileService();
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	
	public List<Profile> getProfiles()
	{	
		return  prf.getAllProfiles();
	}
	
	
	
	@Path("/{profileName}")
	@GET
	@Produces(MediaType.APPLICATION_XML) 
	public Profile getTest(@PathParam ("profileName") String ProfileName )
	{
		
		 
		return prf.getProfile(ProfileName) ;
		
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML) 
	public Profile addProfile(Profile pfName)
	{
		
		return prf.addProfile(pfName);
	}
	
	
	@Path("/{profileName}")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML) 
	public Profile updateProfile(@PathParam ("profileName") String ProfileName ,Profile prff)
	{
		prff.setProfileName(ProfileName);
		
		return prf.updateProfile(prff);
	}
	 
	
	
	@Path("/{profileName}")
	@DELETE
 
	@Produces(MediaType.APPLICATION_XML) 
	public Profile DeleteProfile(@PathParam ("profileName") String ProfileName  )
	{
	return prf.removeProfile(ProfileName);
	}
	
	

}
