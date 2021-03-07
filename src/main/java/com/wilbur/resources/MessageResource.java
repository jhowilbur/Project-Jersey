package com.wilbur.resources;

import com.wilbur.model.Message;
import com.wilbur.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("messages")
public class MessageResource
{
    private MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessages(@QueryParam("year") int year,
                                        @QueryParam("start") int start,
                                        @QueryParam("size") int size)
    {
        if (year > 0){
            return messageService.getAllMessagesByYear(year);
        }
        if (start >= 0 && size > 0){
            return messageService.getMessagePagination(start, size);
        }
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessageById(@PathParam("messageId") long id){
        return messageService.getMessage(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message removeMessageById(@PathParam("messageId") long id){
        return messageService.removeMessage(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(Message message){
        return messageService.updateMessage(message);
    }
}
