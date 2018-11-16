package org.citiustech.RESTfulAPI.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.citiustech.RESTfulAPI.messenger.model.Message;
import org.citiustech.RESTfulAPI.messenger.service.MessageService;

@Path(value = "/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResourse {
	MessageService messageService = new MessageService();	
	
	@GET	
	public List<Message> getMessages(@BeanParam BeanParameter bean) {
		if(bean.getYear()>0){
			return messageService.getMessages(bean.getYear());
		}
		if(bean.getStart()>=0 && bean.getEnd()>=0){
			return messageService.getMessagesPaginated(bean.getStart(), bean.getEnd());
		}
		return messageService.getMessages();
		 
	}
	@Path(value="/{id}")
	@GET	
	public Message getMessage(@PathParam("id") long ids){		
		return messageService.getMessage(ids);
	}
	@POST	
	public Message addMessage(Message msg){
		Message message = messageService.createMessage(msg);
		return message;
	}
	@Path(value="/{id}")
	@PUT	
	public Message updateMessage(@PathParam("id") long id,Message message){
		message.setId(id);
		Message msg = messageService.updateMessage(id, message);
		return msg;
	}
	@Path(value="/{id}")
	@DELETE	
	public Message deleteMessage(@PathParam("id") long id){
		Message message = messageService.deleteMessage(id);
		return message;
	}
	@Path(value="/test")
	@GET	
	public String test(){		
		return "Hey there, Good Evening!!";
	}
	
}
