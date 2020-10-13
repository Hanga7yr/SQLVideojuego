package main;

import java.util.Scanner;
import gestor.*;
import objects.*;

public class Main {

	public static void main(String[] args) {
		Gestor g = new Gestor();
		System.out.println("Anaydir");
		g.anyadirHabilidad(new Habilidad("prueba1", 10, 10, "tipo1"));
		g.anyadirHabilidad(new Habilidad("p", 0, 0, "i"));
		
		g.anyadirPersonaje(new Personaje("prueba1", "clase1", 1, 1, 1, 1, 1, new Habilidad[] {g.habilidades[0]}, new Item[10], true, true));
		g.anyadirPersonaje(new Personaje("prueba1", "clase1", 1, 1, 1, 1, 1, new Habilidad[] {g.habilidades[0]}, new Item[10], true, true));
		g.anyadirPersonaje(new Personaje("prueba2", "clase1", 1, 1, 1, 1, 1, new Habilidad[] {g.habilidades[1]}, new Item[10], true, true));
		g.escribirEnBaseDatos();
		System.out.println("Leer");
		Gestor p = new Gestor();
		p.leerDeBaseDatos();
		
		p.mostrarHabilidades();
		p.mostrarPersonajes();
	}
}