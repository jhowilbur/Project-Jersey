package com.wilbur.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

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

    @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
        return String.format("Path: %s \nQueryParams: %s \nHeaders from Request: %s \nCookies: %s",
                uriInfo.getAbsolutePath().toString(),
                uriInfo.getQueryParameters().values(),
                httpHeaders.getRequestHeaders().toString(),
                httpHeaders.getCookies().values());
    }
}
