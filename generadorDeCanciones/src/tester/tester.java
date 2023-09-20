package tester;

import generadorDeCanciones.GenerarConGenero;
import mixer.Combinador;
import generadorDeCanciones.Cancion;

public class tester {
	
	public static void reproducir(String pCancion) {
		
	}

	public static void main(String[] args) {
		String pResultado1 = new String();
		String pResultado2 = new String();
		String pResultado3 = new String();
		Cancion letraCancion = new Cancion();
		GenerarConGenero cancion = new GenerarConGenero();
		GenerarConGenero letra = new GenerarConGenero();
		Combinador combinada = new Combinador();
		letraCancion.setLetra("el amor de mi vida no me contesta los mensajes de whatsapp");
		letra.generarCancion(letraCancion.getLetra(), pResultado1);
		cancion.GenerarCancionConGenero(letra, "bachata", pResultado2);
		combinada.combinarTresGenero(cancion, "reggae", "jaz", pResultado3);
		tester.reproducir(combinada.getCombinacion());

	}

}
