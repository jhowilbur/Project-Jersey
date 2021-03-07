package com.wilbur.resources;

import com.wilbur.model.Message;
import com.wilbur.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("messages")
public class MessageResource
{
    private MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }
}
