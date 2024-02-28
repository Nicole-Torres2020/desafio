package sv.edu.udb.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistasDAO extends AppConnection{
	
	public void insert(artistas artistas) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("INSERT INTO artistas (id_artista, nombre_artista, descripcion) VALUES (?, ?, ?)");
        pstmt.setInt(1, artistas.getId_artista());
        pstmt.setString(2, artistas.getNombre_artista());
        pstmt.setString(3, artistas.getDescripcion());
        pstmt.execute();
        close();
    }
	
	public void update(artistas artistas) throws SQLException {
	    connect();
	    pstmt = conn.prepareStatement("UPDATE artistas SET id_artista = ?, nombre_artista = ?, descripcion = ? WHERE id_artista = ?");
	    pstmt.setInt(1, artistas.getId_artista());
        pstmt.setString(2, artistas.getNombre_artista());
        pstmt.setString(3, artistas.getDescripcion());
	    pstmt.executeUpdate();
	    close();
	}
	
	public void delete(int id) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("DELETE FROM artistas WHERE id_artistas = ?");
        pstmt.setInt(1, id);
        pstmt.execute();
        close();
    }
	
	public ArrayList<artistas> findAll() throws SQLException {
	    connect();
	    stmt = conn.createStatement();
	    resultSet = stmt.executeQuery("SELECT id_artista, nombre_artista, descripcion FROM artistas");
	    ArrayList<artistas> artistas = new ArrayList();
	    
	    while(resultSet.next()) {
	        artistas artista = new artistas();
	        artista.setId_artista(resultSet.getInt("id_artista"));
	        artista.setNombre_artista(resultSet.getString("nombre_artista"));
	        artista.setDescripcion(resultSet.getString("descripcion"));
	        artistas.add(artista);
	    }

	    close();
	    return artistas;
	}
	
	public artistas findById(int id) throws SQLException{
        artistas artistas = null;

        connect();
        pstmt = conn.prepareStatement("SELECT id_artista, nombre_artista, descripcion FROM artistas WHERE id_artista = ?");
        pstmt.setInt(1, id);

        resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            artistas = new artistas();
            artistas.setId_artista(resultSet.getInt("id_artista"));
	        artistas.setNombre_artista(resultSet.getString("nombre_artista"));
	        artistas.setDescripcion(resultSet.getString("descripcion"));
        }

        close();
        return artistas;
    }

	public ArtistasDAO() {
		// TODO Auto-generated constructor stub
	}

	

}
