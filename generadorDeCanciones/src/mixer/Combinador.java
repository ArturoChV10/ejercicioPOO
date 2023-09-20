package mixer;

import generadorDeCanciones.GenerarConGenero;

public class Combinador {
	private String combinacion; 
	
	String pResultado = new String();
	
	public void combinarUnGenero(String pCancion, String pGeneroAdicional) {
		this.setCombinacion(pResultado);
	}
	
	public void combinarDosGenero(String pCancion, String pGeneroAdicional1, String pGeneroAdicional2) {
		this.setCombinacion(pResultado);
	}
	
	public void combinarTresGenero(GenerarConGenero pCancion, String pGeneroAdicional1, String pGeneroAdicional2, String pGeneroAdicional3) {
		this.setCombinacion(pResultado);
	}

	public String getCombinacion() {
		return combinacion;
	}

	public void setCombinacion(String combinacion) {
		this.combinacion = combinacion;
	}
	
}
