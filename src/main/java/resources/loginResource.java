package resources;

public class loginResource {
    

    @path("/login")
    @POST
    public Response loginUser(Credentials creds) {
        // Logic to authenticate user
        boolean isAuthenticated = AuthService.authenticate(creds.getUsername(), creds.getPassword());
        
        if (isAuthenticated) {
            String token = AuthService.generateToken(creds.getUsername());
            return Response.ok(new AuthResponse(token)).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
    }
}
