package com.wilbur.service;

import com.wilbur.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService
{
    public List<Message> getAllMessages(){
        Message m1 = new Message(1L, "Hello world 1", "Wilbur");
        Message m2 = new Message(1L, "Hello world 2", "Jonas");
        List<Message> messages = new ArrayList<>();
        messages.add(m1);
        messages.add(m2);
        return messages;
    }
}
