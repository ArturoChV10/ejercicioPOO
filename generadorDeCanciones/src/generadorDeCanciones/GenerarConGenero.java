package generadorDeCanciones;

public class GenerarConGenero {
	private String CancionGenero;
	private String Cancion;
	
	public void GenerarCancionConGenero(GenerarConGenero pLetra, String pGenero, String pResultado) {
		this.setCancionGenero(pResultado);
		
	}
	
	public void generarCancion(String pLetra, String pResultado) {
		this.setCancion(pResultado);
		
	}

	public String getCancionGenero() {
		return CancionGenero;
	}

	public void setCancionGenero(String cancionGenero) {
		CancionGenero = cancionGenero;
	}

	public String getCancion() {
		return Cancion;
	}

	public void setCancion(String cancion) {
		Cancion = cancion;
	}
}
