package com.wilbur.service;

import com.wilbur.model.Profile;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ProfileService
{
    private Map<Long, Profile> profiles = new ConcurrentHashMap<>();

    public ProfileService(){
        profiles.put(1L, new Profile(1L, "Wilbur Ferreira", "Wilbur", "Ferreira"));
        profiles.put(1L, new Profile(1L, "Jonas Ferreira", "Jonas", "Ferreira"));
    }

    public List<Profile> getAllProfiles(){
        return Collections.synchronizedList(new ArrayList<>(profiles.values()));
    }

    public Profile getProfileById(long id){
        return profiles.get(id);
    }

    public Profile addProfile(Profile profile){
        profile.setId(Long.valueOf(profiles.size()+1));
        return profiles.put(profile.getId(), profile);
    }

    public Profile updateProfile(Profile profile){
        if (profile.getId() <= 0){
            return null;
        }
        profile.setCreated(new Date());
        return profiles.put(profile.getId(), profile);
    }

    public Profile deleteProfile(long id){
        return profiles.remove(id);
    }

}
