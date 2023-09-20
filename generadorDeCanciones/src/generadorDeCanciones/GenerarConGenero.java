package generadorDeCanciones;

public abstract class GenerarConGenero extends generadorDeCanciones {
	private String Genero;
	private String Cancion;
	
	public String GenerarConGenero(String pLetra, String pGenero) {
		
	}
	
	public abstract String generarCancion(String pLetra);
}
