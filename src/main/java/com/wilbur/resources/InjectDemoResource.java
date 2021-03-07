package com.wilbur.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource
{
    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
                                            @HeaderParam("headerParam") String headerParam,
                                            @CookieParam("cookieParam") String cookieParam)
    {
        return String.format("matrixParam: %s \nheaderParam: %s \ncookieParam: %s",
                                matrixParam, headerParam, cookieParam);
    }
}
