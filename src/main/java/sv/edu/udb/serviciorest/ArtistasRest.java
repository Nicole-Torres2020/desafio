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
import sv.edu.udb.model.artistas;
import sv.edu.udb.model.ArtistasDAO;

@Path("artistas")
public class ArtistasRest {
	
	ArtistasDAO artistasDAO = new ArtistasDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArtistas() throws SQLException {
	    List<artistas> artistas = artistasDAO.findAll();
	    return Response.status(200).entity(artistas).build();
	}


	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByArtistaId(@PathParam("id") int id) throws SQLException {
	    artistas artista = artistasDAO.findById(id);
	    if (artista == null) {
	        return Response.status(404).entity("ERROR 404: Artista no encontrado").build();
	    }
	    return Response.status(200).entity(artista).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertArtista(
	        @FormParam("id_artista") int id_artista,
	        @FormParam("nombre_artista") String nombre_artista,
	        @FormParam("descripcion") String descripcion) throws SQLException {

	    if (nombre_artista == null || nombre_artista.isEmpty()) {
	        return Response.status(400).entity("El nombre del artista no es válido").build();
	    }

	    artistas artista = new artistas();
	    artista.setId_artista(id_artista);
	    artista.setNombre_artista(nombre_artista);
	    artista.setDescripcion(descripcion);

	    artistasDAO.insert(artista);

	    return Response.status(201).entity("Artista Registrado").build();
	}


	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateArtista(
	        @FormParam("id_artista") int id_artista,
	        @FormParam("nombre_artista") String nombre_artista,
	        @FormParam("descripcion") String descripcion) throws SQLException {

	    artistas artista = new artistas();
	    artista.setId_artista(id_artista);
	    artista.setNombre_artista(nombre_artista);
	    artista.setDescripcion(descripcion);

	    artistasDAO.update(artista);

	    return Response.status(200).entity("Artista actualizado satisfactoriamente").build();
	}

}
