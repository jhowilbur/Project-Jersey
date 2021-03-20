package com.wilbur.resource;

import com.wilbur.model.Profile;
import com.wilbur.service.ProfileService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("resources")
public class ProfileResource
{
    private ProfileService profileSevice = new ProfileService();

    @GET
    @Path("/{profileId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getProfileById(@PathParam("profileId") long id){
        return profileSevice.getProfileById(id);
    }
}
