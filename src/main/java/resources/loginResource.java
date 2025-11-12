package resources;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;


public class loginResource {
    @POST
    public Response loginUser() {
        return Response.status(200).entity("Login Successful").build();
    }
}
