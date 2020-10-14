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
		g.anyadirHabilidad(new Habilidad("p", 0, 0, "i"));
		
		g.anyadirPersonaje(new Personaje("prueba2", "clase1", 1, 1, 1, 1, 1, new Habilidad[] {g.habilidades[1]}, new Item[10], true, true));
		g.anyadirPersonaje(new Personaje("prueba2", "clase1", 1, 1, 1, 1, 1, new Habilidad[] {g.habilidades[1]}, new Item[10], true, true));
		g.anyadirItem(new Consumible("prueba1", 1, new Habilidad[] {g.habilidades[0]}, 1));
		g.anyadirItem(new Armadura("prueba1", 1, new Habilidad[] {}, 1, 1));
		g.anyadirPersonaje(new Personaje("prueba1", "clase1", 1, 1, 1, 1, 1, new Habilidad[] {g.habilidades[0]}, new Item[] {g.items[0]}, true, true));
		
		System.out.println("\nEscritura en base de datos \n");
		g.escribirEnBaseDatos();
		System.out.println("Leer");
		Gestor p = new Gestor();
		
		System.out.println("\n Lectura de base de datos \n");
		p.leerDeBaseDatos();
		
		System.out.println("\n Mostrar habilidades\n");
		p.mostrarHabilidades();
		System.out.println("\n Mostrar item\n");
		p.mostrarItems();
		System.out.println("\n Mostrar personajes\n");
		p.mostrarPersonajes();
		
		System.out.println("\n Mostrar item de personaje");
		p.personajes[0].visualizar();
	}
}