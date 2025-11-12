package resources;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class LogInResources {
    
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public Response logIn(@FormParam("usuario") String usuario, @FormParam("contrasena") String contrasena) {

        String safeUsuario = usuario == null || usuario.trim().isEmpty() ? "invitado" : escapeHtml(usuario.trim());

        String html = "<!doctype html>"
                    + "<html lang=\"es\">"
                    + "<head><meta charset=\"utf-8\"><title>Bienvenido</title></head>"
                    + "<body><div>Bienvenido, " + safeUsuario + "</div></body>"
                    + "</html>";

        return Response.ok(html, MediaType.TEXT_HTML).build();
    }
    private String escapeHtml(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }

}
