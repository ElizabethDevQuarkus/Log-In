package resources;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

public class LogInResources {
    @Path("/login")
    @POST
    public Response logIn() {
        return Response.ok().build();
    }
}
