package com.wilbur.service;

import com.wilbur.database.Database;
import com.wilbur.model.Message;

import java.util.*;

public class MessageService
{
    private Map<Long, Message> messages = Database.getMessages();

    public MessageService(){
        messages.put(1L, new Message(1L, "one msg", "Wilbur"));
        messages.put(2L, new Message(2L, "two msg", "Jonas"));
    }

    public List<Message> getAllMessages(){
        return Collections.synchronizedList(new ArrayList<Message>(messages.values()));
    }

    public Message getMessage(long id){
        return messages.get(id);
    }

    public Message addMessage(Message message){
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message){
        if (message.getId() <= 0){
            return null;
        }
        message.setCreated(new Date());
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
