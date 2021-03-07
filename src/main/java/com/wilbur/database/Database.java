package com.wilbur.database;

import com.wilbur.model.Message;
import com.wilbur.model.Profile;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Database
{
    private static Map<Long, Message> messages = new ConcurrentHashMap<>();
    private static Map<Long, Profile> profiles = new ConcurrentHashMap<>();

    public static Map<Long, Message> getMessages()
    {
        return messages;
    }

    public static Map<Long, Profile> getProfiles()
    {
        return profiles;
    }
}
