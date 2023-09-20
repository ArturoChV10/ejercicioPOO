package tester;

import generadorDeCanciones.GenerarConGenero;
import mixer.Combinador;

public class tester {
	
	public void reproducir(String pCancion) {
		
	}

	public static void main(String[] args) {
		GenerarConGenero cancion = new GenerarConGenero();
		GenerarConGenero letra = new GenerarConGenero();
		Combinador combinada = new Combinador();
		tester reproductor = new tester();
		letra.generarCancion("el amor de mi vida no me contesta los mensajes de whatsapp");
		cancion.GenerarConGenero(letra, "bachata");
		combinada.combinarDosGenero(cancion, "reggae", "jazz");
		tester.reproducir(combinada);

	}

}
