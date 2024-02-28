package sv.edu.udb.model;

public class discos {
	    private int id_disco;
	    private String nombre_disco;
	    private int id_artista;
	    private int numero_canciones;
	    private double precio;
	    private String nombre_artista;

	    // Getters y Setters
	    public int getId_disco() {
	        return id_disco;
	    }

	    public void setId_disco(int id_disco) {
	        this.id_disco = id_disco;
	    }

	    public String getNombre_disco() {
	        return nombre_disco;
	    }

	    public void setNombre_disco(String nombre_disco) {
	        this.nombre_disco = nombre_disco;
	    }

	    public int getId_artista() {
	        return id_artista;
	    }

	    public void setId_artista(int id_artista) {
	        this.id_artista = id_artista;
	    }

	    public int getNumero_canciones() {
	        return numero_canciones;
	    }

	    public void setNumero_canciones(int numero_canciones) {
	        this.numero_canciones = numero_canciones;
	    }

	    public double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }
	    
	    public String getNombre_artista() {
	        return nombre_artista;
	    }

	    public void setNombre_artista(String nombre_artista) {
	        this.nombre_artista = nombre_artista;
	    }

	}
