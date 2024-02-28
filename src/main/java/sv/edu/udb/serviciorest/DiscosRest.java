package sv.edu.udb.serviciorest;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.edu.udb.model.discos;
import sv.edu.udb.model.DiscosDAO;

@Path("discos")
public class DiscosRest {

    DiscosDAO discosDAO = new DiscosDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscos() throws SQLException{
        List<discos> discos = discosDAO.findAll();
        return Response.status(200).entity(discos).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByDiscosId(@PathParam("id") int id) throws SQLException{
        discos discos = discosDAO.findById(id);
        if(discos == null){
            return Response.status(404).entity("404 Not Found").build();
        }
        return Response.status(200).entity(discos).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertDisco(
            @FormParam("id_disco") int id_disco,
            @FormParam("nombre_disco") String nombre_disco,
            @FormParam("id_artista") int id_artista,
            @FormParam("numero_canciones") int numero_canciones,
            @FormParam("precio") double precio) throws SQLException {

        if (nombre_disco == null || nombre_disco.isEmpty()) {
            return Response.status(400).entity("ERROR 400: Bad Request").build();
        }

        discos disco = new discos();
        disco.setId_disco(id_disco);
        disco.setNombre_disco(nombre_disco);
        disco.setId_artista(id_artista);
        disco.setNumero_canciones(numero_canciones);
        disco.setPrecio(precio);

        discosDAO.insert(disco);

        return Response.status(201).entity("Disco agregado").build();
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDisco(
            @FormParam("id_disco") int id_disco,
            @FormParam("nombre_disco") String nombre_disco,
            @FormParam("id_artista") int id_artista,
            @FormParam("numero_canciones") int numero_canciones,
            @FormParam("precio") double precio) throws SQLException{

        discos disco = new discos();
        disco.setId_disco(id_disco);
        disco.setNombre_disco(nombre_disco);
        disco.setId_artista(id_artista);
        disco.setNumero_canciones(numero_canciones);
        disco.setPrecio(precio);

        discosDAO.update(disco);

        return Response.status(200).entity("“204: No Content").build();
    }
    
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDisco(@PathParam("id") int id) throws SQLException{
        discos existingDisco = discosDAO.findById(id);
        if (existingDisco == null) {
            return Response.status(404).entity("Disco no encontrado").build();
        }

        discosDAO.delete(id);

        return Response.status(204).entity("Disco eliminado").build();
    }
    
}
