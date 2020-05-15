package org.sai.rest.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.sai.rest.messenger.database.*;
import org.sai.rest.messenger.model.Message;

public class MessageService {

	public static  HashMap<Long , Message> messages =   DatabaseClass.getMessages();
	
	
	public MessageService() {
		
		Message as = new Message(1,"My fist Hash","Sai");
		
		messages.put(1L,as );
		messages.put(2L, new Message(2,"My fist OO changing","Rai")  );
	}


	
	
	
	public List<Message> getAllMessages(){
		List<Message> list = new ArrayList<>();
		list.addAll(messages.values());//This is a hashmap method to return all values	 
		return list;
	}
	
	
	public Message getMessage(long i) {		
		return messages.get(i);	
	}
	
	
	public Message addMessage(Message a) {
	 
		a.setId(messages.size()+1);
		messages.put(  a.getId(), a);	
		return  a;
	}
	
	
	public Message updateMessage(Message asd)
	{
		if(asd.getId()==0) {return null;}		
		messages.put(asd.getId(), asd);		
		return asd;
	}
	
	
	public Message removeMessage(long a) {
	return messages.remove(a);		
	}
	
	
	
	public List<Message> geAllMessages(int year)
	{List<Message> list = new ArrayList<>();
	Calendar cal =   Calendar.getInstance();
		
	for(Message msg :messages.values() )
	{
		cal.setTime(msg.getCreated());
		if(cal.get(Calendar.YEAR)==year)
		{list.add(msg);}		
	}
		
	return list;
		
	}
	
	
	public List<Message> getAllMessagesPaginated(int start,int size)
	{
		ArrayList<Message> list =new ArrayList<Message>();
		list.addAll(messages.values());
		if(start+size> list.size()) 
		{
			return new ArrayList<Message>();
		}
		return list.subList(start, start+size);
		
		
	}
	

}
