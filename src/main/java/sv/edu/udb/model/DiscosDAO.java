package sv.edu.udb.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DiscosDAO extends AppConnection{

	public void insert(discos discos) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("INSERT INTO discos (id_disco, nombre_disco, id_artista, numero_canciones, precio) VALUES (?, ?, ?, ?, ?)");
        pstmt.setInt(1, discos.getId_disco());
        pstmt.setString(2, discos.getNombre_disco());
        pstmt.setInt(3, discos.getId_artista());
        pstmt.setInt(4, discos.getNumero_canciones());
        pstmt.setDouble(5, discos.getPrecio());
        pstmt.execute();
        close();
    }

	public void update(discos discos) throws SQLException {
	    connect();
	    pstmt = conn.prepareStatement("UPDATE discos SET nombre_disco = ?, id_artista = ?, numero_canciones = ?, precio = ? WHERE id_disco = ?");
	    pstmt.setString(1, discos.getNombre_disco());
	    pstmt.setInt(2, discos.getId_artista());
	    pstmt.setInt(3, discos.getNumero_canciones());
	    pstmt.setDouble(4, discos.getPrecio());
	    pstmt.setInt(5, discos.getId_disco());
	    pstmt.executeUpdate();
	    close();
	}

	    public void delete(int id) throws SQLException {
	        connect();
	        pstmt = conn.prepareStatement("DELETE FROM discos WHERE id_disco = ?");
	        pstmt.setInt(1, id);
	        pstmt.execute();
	        close();
	    }

	    public ArrayList<discos> findAll() throws SQLException {
	        connect();
	        stmt = conn.createStatement();
	        resultSet = stmt.executeQuery("SELECT discos.id_disco, discos.nombre_disco, discos.id_artista, discos.numero_canciones, discos.precio, artistas.nombre_artista " +
	                                      "FROM discos " +
	                                      "JOIN artistas ON discos.id_artista = artistas.id_artista");
	        ArrayList<discos> discos = new ArrayList();
	        
	        while(resultSet.next()) {
	            discos tmp = new discos();
	            tmp.setId_disco(resultSet.getInt("id_disco"));
	            tmp.setNombre_disco(resultSet.getString("nombre_disco"));
	            tmp.setId_artista(resultSet.getInt("id_artista"));
	            tmp.setNumero_canciones(resultSet.getInt("numero_canciones"));
	            tmp.setPrecio(resultSet.getDouble("precio"));
	            tmp.setNombre_artista(resultSet.getString("nombre_artista"));
	            discos.add(tmp);
	        }

	        close();
	        return discos;
	    }

	    public discos findById(int id) throws SQLException {
	        discos discos = null;

	        connect();
	        pstmt = conn.prepareStatement("SELECT d.id_disco, d.nombre_disco, d.id_artista, d.numero_canciones, d.precio, a.nombre_artista " +
	                                      "FROM discos d " +
	                                      "JOIN artistas a ON d.id_artista = a.id_artista " +
	                                      "WHERE d.id_disco = ?");
	        pstmt.setInt(1, id);

	        resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            discos = new discos();
	            discos.setId_disco(resultSet.getInt("id_disco"));
	            discos.setNombre_disco(resultSet.getString("nombre_disco"));
	            discos.setId_artista(resultSet.getInt("id_artista"));
	            discos.setNumero_canciones(resultSet.getInt("numero_canciones"));
	            discos.setPrecio(resultSet.getDouble("precio"));
	            discos.setNombre_artista(resultSet.getString("nombre_artista"));
	        }

	        close();
	        return discos;
	    }

	}

