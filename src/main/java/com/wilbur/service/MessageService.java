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

    public List<Message> getAllMessagesByYear(int year){
        List<Message> messagesForYear = Collections.synchronizedList(new ArrayList<>());
        Calendar calendar = Calendar.getInstance();
        for (int i = 1; i < messages.size()+1; i++)
        {
            calendar.setTime(messages.get(Long.valueOf(i)).getCreated());
            if (calendar.get(Calendar.YEAR) == year){
                messagesForYear.add(messages.get(Long.valueOf(i)));
            }
        }
        return messagesForYear;
    }

    public List<Message> getMessagePagination(int start, int size){
        List<Message> listMessages = Collections.synchronizedList(new ArrayList<>(messages.values()));
        if (start+size > listMessages.size()){
            return Collections.synchronizedList(new ArrayList<>());
        }
        return listMessages.subList(start, start+size);
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
