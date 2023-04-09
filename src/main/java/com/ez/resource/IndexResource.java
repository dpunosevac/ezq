package com.ez.resource;


import com.ez.dto.CreateIndexRequest;
import com.ez.service.IndexService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

import static com.ez.ApiConstants.API_V1;

/**
 * @author dpunosevac
 */
@Path(API_V1 + "/index")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IndexResource {

    @Inject
    IndexService indexService;

    // TODO: Handle properly Exceptions
    // TODO: Figure out if cross-site scripting attacks is a problem here https://owasp.org/www-community/attacks/xss/
    // TODO: Make a stop words list
    @POST
    public Response indexPage(@Valid CreateIndexRequest createIndexRequest) throws IOException {
        indexService.indexWebPage(createIndexRequest.contentPath());
        return Response.ok().build();
    }
}
