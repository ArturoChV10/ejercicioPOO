package generadorDeCanciones;

public class ClaseBase extends generadorDeCanciones implements IGenero {
	Cancion letra = new Cancion();
	private String pResultado;

	
	public void generarCancion(String pLetra, String pResultado) {
		this.setpResultado(pResultado);
		
	}

	@Override
	public void genero(Genero pGenero) {
		if(pGenero==Genero.bachata) {
			letra.GenerarCancionConGenero(this.getpResultado(), "bachata");
		}else {
			if(pGenero==Genero.reggaeton) {
				letra.GenerarCancionConGenero(this.getpResultado(), "reggaeton");
			}else {
				if(pGenero==Genero.reggae) {
					letra.GenerarCancionConGenero(this.getpResultado(), "reggae");
				}else {
					if(pGenero==Genero.pop) {
						letra.GenerarCancionConGenero(this.getpResultado(), "pop");
					}else {
						if(pGenero==Genero.jazz) {
							letra.GenerarCancionConGenero(this.getpResultado(), "jazz");		
						}
					}
				}
			}
		}
	}

	@Override
	public String generarCancion() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getpResultado() {
		return pResultado;
	}

	public void setpResultado(String pResultado) {
		this.pResultado = pResultado;
	}

	@Override
	public String hacerCancion(String pLetra, String pResultado) {
		// TODO Auto-generated method stub
		return null;
	}
}
