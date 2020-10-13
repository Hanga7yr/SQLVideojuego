package gestor;

import objects.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Gestor {
	
	private final int num_arrays = 50;
	
	//Arrays de los objetos
	public Habilidad[] habilidades;
	public Item[] items;
	public Personaje[] personajes;
	public Zona[] zonas;
	public Mision[] misiones;
	public Usuario[] users;
	
	private Comprobacion comprobacion = new Comprobacion();
	public int[] num_array;
	
	private Scanner entrada = new Scanner(System.in);
	
	public Gestor(){
		habilidades = new Habilidad[num_arrays];
		items = new Item[num_arrays];
		personajes = new Personaje[num_arrays];
		zonas = new Zona[num_arrays];
		misiones = new Mision[num_arrays];
		users = new Usuario[num_arrays];
		
		num_array = new int[6];
		
		for(int i = 0; i < num_array.length; i++)
			num_array[i] = 0;
	
	}
	
	//Función que muestra el menu y permite utilizar las diferentes funciones.
	public void menu() {
		boolean salir = false;
		
		do {
			boolean error = false;
			
			do {
				error = false;
				
				System.out.println("1. Añadir habilidad.");
				System.out.println("2. Añadir item.");
				System.out.println("3. Añadir personaje.");
				System.out.println("4. Añadir mision.");
				System.out.println("5. Añadir zona");
				
				System.out.println("");
				
				System.out.println("6. Mostrar habilidad.");
				System.out.println("7. Mostrar item.");
				System.out.println("8. Mostrar personaje.");
				System.out.println("9. Mostrar mision.");
				System.out.println("10. Mostrar zona.");
				
				System.out.println("");
				
				System.out.println("11. Eliminar habilidad.");
				System.out.println("12. Eliminar item.");
				System.out.println("13. Eliminar personaje.");
				System.out.println("14. Eliminar mision.");
				System.out.println("15. Eliminar zona.");
				
				System.out.println("");
				
				System.out.println("16. Asignar habilidad a item.");
				System.out.println("17. Eliminar Habilidad a item.");
				
				System.out.println("");
				
				System.out.println("18. Modificar equipo personaje.");
				System.out.println("19. Modificar habilidades personaje.");
				
				System.out.println("");
				
				System.out.println("20. Añadir personaje a zona.");
				System.out.println("21. Eliminar personaje de zona.");
				
				System.out.println("22. Salir.");
				
				System.out.println();
				
				System.out.println("Introduce una opción: ");
				
				String option = entrada.nextLine();
				
				if(!comprobacion.soloInt(option))
					error = true;
				else {
					int opt = Integer.parseInt(option);
					
					if(opt >= 1 && opt <= 22) {
						switch(opt) {
							case 1:
								this.anyadirHabilidad();
								break;
							case 2:
								this.anyadirItem();
								break;
							case 3:
								this.anyadirPersonaje();
								break;
							case 4:
								this.anyadirMision();
								break;
							case 5:
								this.anyadirZona();
								break;
							case 6:
								this.mostrarHabilidades();
								break;
							case 7:
								this.mostrarItems();
								break;
							case 8:
								this.mostrarPersonajes();
								break;
							case 9:
								this.mostrarMisiones();
								break;
							case 10:
								this.mostrarZonas();
								break;
							case 11:
								this.eliminarHabilidad();
								break;
							case 12:
								this.eliminarItem();
								break;
							case 13:
								this.eliminarPersonaje();
								break;
							case 14:
								this.eliminarMision();
								break;
							case 15:
								this.eliminarZona();
								break;
							case 16:
								this.asigHabItem();
								break;
							case 17:
								this.eliminarHabItem();
								break;
							case 18:
								this.modEquipo();
								break;
							case 19:
								this.modHabPer();
								break;
							case 20:
								this.addPersonajeAZona();
								break;
							case 21:
								this.eliminarPersonajeAZona();
								break;
							case 22:
								salir = true;
								break;
						}
					}else 
						System.out.println("El número introducido no es una opción");
				}
				
				if(error)
					System.out.println("No se ha introducido un número");
				
			}while(error);
			
		}while(!salir);
		
	}
	
	//Función anyadir Habilidad
	//Pide los diferentes datos y comprueba si son admitibles.
	public boolean anyadirHabilidad() {
		
		boolean error = false;
		
		String[] entrada = new String[4];
		
		String[] salida = new String[] {	"Introduce el nombre: ", 
											"Introduce el tipo: ",
											"Introduce la vida: ",
											"Introduce la energia: "};
		
		for(int i = 0; i < entrada.length; i++){
			System.out.print(salida[i]);
			entrada[i] = this.entrada.nextLine();
		}
		
		for(int i = 2; i < salida.length; i++)
			if(!comprobacion.soloInt(entrada[i]))
				error = true;
			
		if(!error) {
			Habilidad temp = new Habilidad	(
												entrada[0],
												Integer.parseInt(entrada[2]),
												Integer.parseInt(entrada[3]),
												entrada[1]
											);
			
			if(!anyadirHabilidad(temp))
				System.out.println("El elemeto ya existe.\nNo va a ser introducido.");
		}
		
		return !error;
	}

	//Función anyadir Item
	//Pide los diferentes datos y comprueba si son admitibles.
	public boolean anyadirItem() {
		boolean error = false;
		
		int tipoitem = 0;
		
		String[] temp_entrada = new String[2];
		
		Habilidad[] temp_habi = new Habilidad[5];
		
		String[] entrada = new String[2];
		
		String[] salida = new String[] {	"Introduce el nombre: ",
											"Introduce el valor: "};
		
		System.out.println("Seleccione que tipo de item a crear: ");
		System.out.println("1. Armadura.");
		System.out.println("2. Arma.");
		System.out.println("3. Consumible.");
		
		String opt = this.entrada.nextLine();
		
		
		for(int i = 0; i < entrada.length; i++){
			System.out.print(salida[i]);
			entrada[i] = this.entrada.nextLine();
		}
		
		for(int i = 2; i < salida.length; i++)
			if(!comprobacion.soloInt(entrada[i]))
				error = true;
	
		
		if(comprobacion.soloInt(opt)) {
			tipoitem = Integer.parseInt(opt);
			
			if(tipoitem < 1 && tipoitem > 3)
				error = true;
			else {
				if(tipoitem == 1) {
					System.out.print("Introduce la armadura: ");
					temp_entrada[0] = this.entrada.nextLine();
					
					System.out.print("Introduce el peso: ");
					temp_entrada[1] = this.entrada.nextLine();
				}else if(tipoitem == 2) {
					System.out.print("Introduce el agravio: ");
					temp_entrada[0] = this.entrada.nextLine();
					
					System.out.print("Introduce el peso: ");
					temp_entrada[1] = this.entrada.nextLine();
				}else {
					System.out.print("Introduce la cantidad: ");
					temp_entrada[0] = this.entrada.nextLine();
				}
				
				for(int i = 0; i < temp_entrada.length; i++)
					if(!comprobacion.soloInt(temp_entrada[i]))
						error = true;
			}
		}else
			error = true;
			
		boolean salir_outer = false;
		
		int num_hab = 0;
		
		do {
			
			System.out.println("¿Quiere introducir habilidades?");
			System.out.println("1. Si.");
			System.out.println("2. No.");
			
			System.out.print("\nIntroduce tu opción: ");
			String intro = this.entrada.nextLine();
			
			if(comprobacion.soloInt(intro)) {
				if(Integer.parseInt(intro) == 1) {
					
						System.out.println("");
						
						for(int i = 0; i < num_array[0]; i++)
							System.out.println((i+1) + ". " + this.habilidades[i].getNombre());
						
						System.out.print("\nIntroduce el número de la habilidad: ");
						intro = this.entrada.nextLine();
						
						if(comprobacion.soloInt(intro)) {
							int nHabilidad = Integer.parseInt(intro)-1;
							
							if(nHabilidad < 0 || nHabilidad > num_array[0])
								System.out.println("\nLa entrada no esta en el rango\n");
							else {
								temp_habi[num_hab++] = this.habilidades[nHabilidad];
							}
						}else
							System.out.println("\nLa entrada no es un número.\n");
						
				}else if(Integer.parseInt(intro) == 2) {
					salir_outer = true;
				}else {
					System.out.println("\nError en la entrada.\n");
				}
			}
			
		}while(!salir_outer);
		
		if(!error) {
			
			Item temp;
			
			if(tipoitem == 1)
				temp = new Armadura(
									entrada[0],
									Integer.parseInt(entrada[1]),
									temp_habi,
									Integer.parseInt(temp_entrada[0]),
									Integer.parseInt(temp_entrada[1])
								);
			else if(tipoitem == 2)
				temp = new Arma(
						entrada[0],
						Integer.parseInt(entrada[1]),
						temp_habi,
						Integer.parseInt(temp_entrada[0]),
						Integer.parseInt(temp_entrada[1])
					);
			else
				temp = new Consumible(
						entrada[0],
						Integer.parseInt(entrada[1]),
						temp_habi,
						Integer.parseInt(temp_entrada[0])
					);
			
			if(!anyadirItem(temp))
				System.out.println("El elemeto ya existe.\nNo va a ser introducido.");
		}
		
		return !error;
	}
	
	//Función anyadir Personaje
	//Pide los diferentes datos y comprueba si son admitibles.
	public boolean anyadirPersonaje() {
		boolean error = false;
		
		Habilidad[] temp_habi = new Habilidad[5];
		Item[] temp_item = new Item[10];
		
		String[] entrada = new String[9];
		
		String[] salida = new String[] {	"Introduce el nombre: ", 
											"Introduce la clase: ",
											"Introduce la vida maxima: ",
											"Introduce la energia maxima: ",
											"Introduce la vida actual: ",
											"Introduce la energia actual: ",
											"Introduce las monedas: ",
											"Es npc?: ",
											"Es hostil? "};
		
		for(int i = 0; i < entrada.length; i++){
			System.out.print(salida[i]);
			entrada[i] = this.entrada.nextLine();
		}
		
		for(int i = 2; i < salida.length-2; i++)
			if(!comprobacion.soloInt(entrada[i]))
				error = true;
		
		boolean salir_outer = false;
		int num_hab = 0;
		
		do {
			
			System.out.println("¿Quiere introducir habilidades?");
			System.out.println("1. Si.");
			System.out.println("2. No.");
			
			System.out.print("\nIntroduce tu opción: ");
			String intro = this.entrada.nextLine();
			
			if(comprobacion.soloInt(intro)) {
				if(Integer.parseInt(intro) == 1) {
					
						System.out.println("");
						
						for(int i = 0; i < num_array[0]; i++)
							System.out.println((i+1) + ". " + this.habilidades[i].getNombre());
						
						System.out.print("\nIntroduce el número de la habilidad: ");
						intro = this.entrada.nextLine();
						
						if(comprobacion.soloInt(intro)) {
							int nHabilidad = Integer.parseInt(intro)-1;
							
							if(nHabilidad < 0 || nHabilidad > num_array[0])
								System.out.println("\nLa entrada no esta en el rango\n");
							else {
								temp_habi[num_hab++] = this.habilidades[nHabilidad];
							}
						}else
							System.out.println("\nLa entrada no es un número.\n");
						
				}else if(Integer.parseInt(intro) == 2) {
					salir_outer = true;
				}else {
					System.out.println("\nError en la entrada.\n");
				}
			}
			
		}while(!salir_outer && num_hab <= 10);
		
		salir_outer = false;
		int num_item = 0;
		
		do {
			
			System.out.println("¿Quiere introducir items?");
			System.out.println("1. Si.");
			System.out.println("2. No.");
			
			System.out.print("\nIntroduce tu opción: ");
			String intro = this.entrada.nextLine();
			
			if(comprobacion.soloInt(intro)) {
				if(Integer.parseInt(intro) == 1) {
					
						System.out.println("");
						
						for(int i = 0; i < num_array[1]; i++)
							System.out.println((i+1) + ". " + this.items[i].getNombre());
						
						System.out.print("\nIntroduce el número del item: ");
						intro = this.entrada.nextLine();
						
						if(comprobacion.soloInt(intro)) {
							int nItem = Integer.parseInt(intro)-1;
							
							if(nItem >= 0 && nItem < num_array[1])
								temp_item[num_item++] = this.items[nItem];
							else {
								System.out.println("\nLa entrada no esta en el rango\n");
							}
						}else
							System.out.println("\nLa entrada no es un número.\n");
						
				}else if(Integer.parseInt(intro) == 2) {
					salir_outer = true;
				}else {
					System.out.println("\nError en la entrada.\n");
				}
			}
			
		}while(!salir_outer && num_item <= 5);
		
		if(!error) {
			
			Personaje temp = new Personaje	(
												entrada[0],
												entrada[1],
												Integer.parseInt(entrada[2]),
												Integer.parseInt(entrada[3]),
												Integer.parseInt(entrada[4]),
												Integer.parseInt(entrada[5]),
												Integer.parseInt(entrada[6]),
												temp_habi,
												temp_item,
												entrada[7].toLowerCase().equals("true") || entrada[7].toLowerCase().equals("si") ? true : false,
												entrada[8].toLowerCase().equals("true") || entrada[8].toLowerCase().equals("si") ? true : false
											);
			
			if(!anyadirPersonaje(temp))
				System.out.println("El elemeto ya existe.\nNo va a ser introducido.");
		}
		
		return !error;
	}
	
	//Función anyadir Zona
	//Pide los diferentes datos y comprueba si son admitibles.
	public boolean anyadirZona() {
		boolean error = false;
		
		Personaje[] temp_per = new Personaje[10];
		
		String[] entrada = new String[2];
		
		String[] salida = new String[] {	"Introduce el nombre: ", 
											"Introduce el nivel: "};
		
		for(int i = 0; i < entrada.length; i++){
			System.out.print(salida[i]);
			entrada[i] = this.entrada.nextLine();
		}
		
		for(int i = 1; i < salida.length; i++)
			if(!comprobacion.soloInt(entrada[i]))
				error = true;
		
		boolean salir_outer = false;
		int num_per = 0;
		
		do {
			
			System.out.println("¿Quiere introducir npcs?");
			System.out.println("1. Si.");
			System.out.println("2. No.");
			
			System.out.print("\nIntroduce tu opción: ");
			String intro = this.entrada.nextLine();
			
			if(comprobacion.soloInt(intro)) {
				if(Integer.parseInt(intro) == 1) {
					
						System.out.println("");
						
						int j = 0;
						for(int i = 0; i < num_array[2]; i++)
							if(this.personajes[i].isNpc())
								System.out.println((j+++1) + ". " + this.personajes[i].getNombre());
						
						System.out.print("\nIntroduce el número del personaje: ");
						intro = this.entrada.nextLine();
						
						if(comprobacion.soloInt(intro)) {
							int nPer = Integer.parseInt(intro)-1;
							
							if(nPer < 0 || nPer >= j)
								System.out.println("\nLa entrada no esta en el rango\n");
							else {
								temp_per[num_per++] = this.personajes[nPer];
							}
						}else
							System.out.println("\nLa entrada no es un número.\n");
						
				}else if(Integer.parseInt(intro) == 2) {
					salir_outer = true;
				}else {
					System.out.println("\nError en la entrada.\n");
				}
			}
			
		}while(!salir_outer);
		
		if(!error) {
			
			Zona temp = new Zona(
									entrada[0],
									Integer.parseInt(entrada[1]),
									temp_per
								);
			
			if(!anyadirZona(temp))
				System.out.println("El elemeto ya existe.\nNo va a ser introducido.");
		}
		
		return !error;
	}
	
	//Función anyadir Mision
	//Pide los diferentes datos y comprueba si son admitibles.
	public boolean anyadirMision() {
		boolean error = false;
		
		Personaje temp_per = new Personaje();
		Item recompensa = new Armadura();
		Zona zona = new Zona();
		
		String[] entrada = new String[3];
		
		String[] salida = new String[] {	"Introduce el nombre: ", 
											"Introduce el nivel: ",
											"Introduce las monedas: "};
		
		for(int i = 0; i < entrada.length; i++){
			System.out.print(salida[i]);
			entrada[i] = this.entrada.nextLine();
		}
		
		for(int i = 1; i < salida.length; i++)
			if(!comprobacion.soloInt(entrada[i]))
				error = true;
		
			System.out.println("¿Quiere introducir Personaje?");
			System.out.println("1. Si.");
			System.out.println("2. No.");
			
			System.out.print("\nIntroduce tu opción: ");
			String intro = this.entrada.nextLine();
			
			if(comprobacion.soloInt(intro)) {
				if(Integer.parseInt(intro) == 1) {
				
						System.out.println("");
						
						int j = 0;
						for(int i = 0; i < num_array[2]; i++)
							if(this.personajes[i].isNpc())
								System.out.println((j+++1) + ". " + this.personajes[i].getNombre());
						
						System.out.print("\nIntroduce el número del personaje: ");
						intro = this.entrada.nextLine();
						
						if(comprobacion.soloInt(intro)) {
							int nPer = Integer.parseInt(intro)-1;
							
							if(nPer < 0 || nPer >= num_array[2])
								System.out.println("\nLa entrada no esta en el rango\n");
							else {
								temp_per = this.personajes[nPer];
							}
						}else
							System.out.println("\nLa entrada no es un número.\n");
						
				}else if(Integer.parseInt(intro) == 2) {
				}else {
					System.out.println("\nError en la entrada.\n");
				}
			}
			
			System.out.println("¿Quiere introducir Item?");
			System.out.println("1. Si.");
			System.out.println("2. No.");
			
			System.out.print("\nIntroduce tu opción: ");
			intro = this.entrada.nextLine();
			
			if(comprobacion.soloInt(intro)) {
				if(Integer.parseInt(intro) == 1) {
				
						System.out.println("");
						
						for(int i = 0; i < num_array[1]; i++)
							System.out.println((i+1) + ". " + this.items[i].getNombre());
						
						System.out.print("\nIntroduce el número del personaje: ");
						intro = this.entrada.nextLine();
						
						if(comprobacion.soloInt(intro)) {
							int nItem = Integer.parseInt(intro)-1;
							
							if(nItem < 0 || nItem > num_array[1])
								System.out.println("\nLa entrada no esta en el rango\n");
							else {
								recompensa = this.items[nItem];
							}
						}else
							System.out.println("\nLa entrada no es un número.\n");
						
				}else if(Integer.parseInt(intro) == 2) {
				}else {
					System.out.println("\nError en la entrada.\n");
				}
			}
			
			System.out.println("¿Quiere introducir Zona?");
			System.out.println("1. Si.");
			System.out.println("2. No.");
			
			System.out.print("\nIntroduce tu opción: ");
			intro = this.entrada.nextLine();
			
			if(comprobacion.soloInt(intro)) {
				if(Integer.parseInt(intro) == 1) {
				
						System.out.println("");
						
						for(int i = 0; i < num_array[3]; i++)
							System.out.println((i+1) + ". " + this.zonas[i].getNombre());
						
						System.out.print("\nIntroduce el número de la zona: ");
						intro = this.entrada.nextLine();
						
						if(comprobacion.soloInt(intro)) {
							int nZona = Integer.parseInt(intro)-1;
							
							if(nZona < 0 || nZona > num_array[3])
								System.out.println("\nLa entrada no esta en el rango\n");
							else {
								zona = this.zonas[nZona];
							}
						}else
							System.out.println("\nLa entrada no es un número.\n");
						
				}else if(Integer.parseInt(intro) == 2) {
				}else {
					System.out.println("\nError en la entrada.\n");
				}
			}
			
			
		
		if(!error) {
			
			Mision temp = new Mision(
									entrada[0],
									Integer.parseInt(entrada[1]),
									temp_per,
									zona,
									recompensa,
									Integer.parseInt(entrada[2])
								);
			
			if(!anyadirMision(temp))
				System.out.println("El elemeto ya existe.\nNo va a ser introducido.");
		}
		
		return !error;
	}
	
	//Función anyadir Habilidad
	//Pide un parametro que usará para añadir esa habilidad al array
	//Se comprueba que esa habilidad no esta incluida
	//Si el array esta al limite, se agranda.
	//Se añade la habilidad a la última posición
	public boolean anyadirHabilidad(Habilidad habilidad) {
		boolean existe = false;
		
		for(int i = 0; i < num_array[0] && !existe; i++)
			if(habilidades[i].esIgual(habilidad))
				existe = true;
		
		if(!existe)
			if(num_array[0] != habilidades.length)
				habilidades[num_array[0]++] = habilidad;
			else {
				this.incrementarArrays(1);
				habilidades[num_array[0]++] = habilidad;
			}
		
		return !existe;
	}
	
	//Función anyadir Item
	//Pide un parametro que usará para añadir esa item al array
	//Se comprueba que esa item no esta incluida
	//Si el array esta al limite, se agranda.
	//Se añade la item a la última posición
	public boolean anyadirItem(Item item) {
		boolean existe = false;
		
		for(int i = 0; i < num_array[1] && !existe; i++)
			if(items[i].esIgual(item))
				existe = true;
		
		if(!existe)
			if(num_array[1] != items.length)
				items[num_array[1]++] = item;
			else {
				this.incrementarArrays(2);
				items[num_array[1]++] = item;
			}
		
		return !existe;
	}
	
	//Función anyadir Personaje
	//Pide un parametro que usará para añadir esa personaje al array
	//Se comprueba que esa personaje no esta incluida
	//Si el array esta al limite, se agranda.
	//Se añade la personaje a la última posición
	public boolean anyadirPersonaje(Personaje personaje) {
		boolean existe = false;
		
		for(int i = 0; i < num_array[2] && !existe; i++)
			if(personajes[i].esIgual(personaje))
				existe = true;
		
		if(!existe)
			if(num_array[2] != personajes.length)
				personajes[num_array[2]++] = personaje;
			else {
				this.incrementarArrays(3);
				personajes[num_array[2]++] = personaje;
			}
		
		return !existe;
	}
	
	//Función anyadir Zona
	//Pide un parametro que usará para añadir esa zona al array
	//Se comprueba que esa zona no esta incluida
	//Si el array esta al limite, se agranda.
	//Se añade la zona a la última posición
	public boolean anyadirZona(Zona zona) {
		boolean existe = false;
		
		for(int i = 0; i < num_array[3] && !existe; i++)
			if(zonas[i].esIgual(zona))
				existe = true;
		
		if(!existe)
			if(num_array[3] != zonas.length)
				zonas[num_array[3]++] = zona;
			else{
				this.incrementarArrays(4);
				zonas[num_array[3]++] = zona;
				
			}
		
		return !existe;
	}
	
	//Función anyadir Mision
	//Pide un parametro que usará para añadir esa mision al array
	//Se comprueba que esa mision no esta incluida
	//Si el array esta al limite, se agranda.
	//Se añade la mision a la última posición
	public boolean anyadirMision(Mision mision) {
		boolean existe = false;
		
		for(int i = 0; i < num_array[4] && !existe; i++)
			if(misiones[i].esIgual(mision))
				existe = true;
		
		if(!existe)
			if(num_array[4] != misiones.length)
				misiones[num_array[4]++] = mision;
			else{
				this.incrementarArrays(5);
				misiones[num_array[4]++] = mision;
			}
		
		return !existe;
	}
	
	//Función anyadir User
	//Pide un parametro que usará para añadir esa user al array
	//Se comprueba que esa user no esta incluida
	//Si el array esta al limite, se agranda.
	//Se añade la user a la última posición
	public boolean anyadirUser(Usuario user) {
		boolean existe = false;
		
		for(int i = 0; i < num_array[5] && !existe; i++)
			if(users[i].esIgual(user))
				existe = true;
		
		if(!existe)
			if(num_array[5] != users.length)
				users[num_array[5]++] = user;
			else{
				this.incrementarArrays(6);
				users[num_array[5]++] = user;
			}
		
		return !existe;
	}
	
	//Función Mostrar Habilidades
	//Muestra todas las habilidades del array de habilidades.
	public void mostrarHabilidades() {
		for(int i = 0; i < num_array[0]; i++)
			this.habilidades[i].visualizar();
	}
	
	//Función Mostrar Personaje
	//Muestra todos los personajes del array de personajes.
	public void mostrarPersonajes() {
		for(int i = 0; i < num_array[2]; i++)
			this.personajes[i].visualizarBasico();
	}
	
	//Función Mostrar Items
	//Muestra todos los items del array de items.
	public void mostrarItems() {
		for(int i = 0; i < num_array[1]; i++)
			this.items[i].visualizarBasico();
	}
	
	//Función Mostrar Misiones
	//Muestra todas las misiones del array de misiones.
	public void mostrarMisiones() {
		for(int i = 0; i < num_array[4]; i++)
			this.misiones[i].visualizarBasico();
	}
	
	//Función Mostrar Zonas
	//Muestra todas las zonas del array de zonas.
	public void mostrarZonas() {
		for(int i = 0; i < num_array[3]; i++)
			this.zonas[i].visualizarBasico();
	}
	
	//Función eliminar habilidad
	//Lista las habilidades y pregunta al usuario cual eliminar
	public boolean eliminarHabilidad() {
		boolean error = false;
		boolean salir = false;
		
		do {
			
			System.out.println("Seleccione una habilidad a eliminar: ");
			System.out.println("-1 para salir.");
			
			System.out.println("");
			
			for(int i = 0; i < num_array[0]; i++)
				System.out.println((i+1)+". " + habilidades[i].getNombre() + ".");
			
			System.out.println("\nIntroduce la opción elegida: ");
			String option = entrada.nextLine();
			
			if(comprobacion.soloInt(option)) {
				int opt = Integer.parseInt(option)-1;
				
				if(opt >= 0 && opt < num_array[0])
					error = eliminarHabilidad(habilidades[opt]);
				
				else
					System.out.println("No se ha introducido una opción correcta");
			}else if(option.equals("-1"))
				salir = true;
			else
				System.out.println("No se ha introducido una opción correcta");
			
		}while(!salir);
		
		return !error;
	}

	//Función eliminar items
	//Lista los items y pregunta al usuario cual eliminar
	public boolean eliminarItem() {
		boolean error = false;
		boolean salir = false;
		
		do {
			
			System.out.println("Seleccione un item a eliminar: ");
			System.out.println("-1 para salir.");
			
			System.out.println("");
			
			for(int i = 0; i < num_array[1]; i++)
				System.out.println((i+1)+". " + items[i].getNombre() + ".");
			
			System.out.println("\nIntroduce la opción elegida: ");
			String option = entrada.nextLine();
			
			if(comprobacion.soloInt(option)) {
				int opt = Integer.parseInt(option)-1;
				
				if(opt >= 0 && opt < num_array[1])
					error = eliminarItem(items[opt]);
				else
					System.out.println("No se ha introducido una opción correcta");
			}else if(option.equals("-1"))
				salir = true;
			else
				System.out.println("No se ha introducido una opción correcta");
			
		}while(!salir);
		
		return !error;
	}

	//Función eliminar personajes
	//Lista los personajes y pregunta al usuario cual eliminar
	public boolean eliminarPersonaje() {
		boolean error = false;
		boolean salir = false;
		
		do {
			
			System.out.println("Seleccione un personaje a eliminar: ");
			System.out.println("-1 para salir.");
			
			System.out.println("");
			
			for(int i = 0; i < num_array[2]; i++)
				System.out.println((i+1)+". " + personajes[i].getNombre() + ".");
			
			System.out.println("\nIntroduce la opción elegida: ");
			String option = entrada.nextLine();
			
			if(comprobacion.soloInt(option)) {
				int opt = Integer.parseInt(option)-1;
				
				if(opt >= 0 && opt < num_array[2])
					error = eliminarPersonaje(personajes[opt]);
				else
					System.out.println("No se ha introducido una opción correcta");
			}else if(option.equals("-1"))
				salir = true;
			else
				System.out.println("No se ha introducido una opción correcta");
			
		}while(!salir);
		
		return !error;
	}

	//Función eliminar zonas
	//Lista las zonas y pregunta al usuario cual eliminar
	public boolean eliminarZona() {
		boolean error = false;
		boolean salir = false;
		
		do {
			
			System.out.println("Seleccione una zona a eliminar: ");
			System.out.println("-1 para salir.");
			
			System.out.println("");
			
			for(int i = 0; i < num_array[3]; i++)
				System.out.println((i+1)+". " + zonas[i].getNombre() + ".");
			
			System.out.println("\nIntroduce la opción elegida: ");
			String option = entrada.nextLine();
			
			if(comprobacion.soloInt(option)) {
				int opt = Integer.parseInt(option)-1;
				
				if(opt >= 0 && opt < num_array[3])
					error = eliminarZona(zonas[opt]);
				else
					System.out.println("No se ha introducido una opción correcta");
			}else if(option.equals("-1"))
				salir = true;
			else
				System.out.println("No se ha introducido una opción correcta");
			
		}while(!salir);
		
		return !error;
	}

	//Función eliminar mision
	//Lista las misiones y pregunta al usuario cual eliminar	
	public boolean eliminarMision() {
		boolean error = false;
		boolean salir = false;
		
		do {
			
			System.out.println("Seleccione una mision a eliminar: ");
			System.out.println("-1 para salir.");
			
			System.out.println("");
			
			for(int i = 0; i < num_array[4]; i++)
				System.out.println((i+1)+". " + misiones[i].getNombre() + ".");
			
			System.out.println("\nIntroduce la opción elegida: ");
			String option = entrada.nextLine();
			
			if(comprobacion.soloInt(option)) {
				int opt = Integer.parseInt(option)-1;
				
				if(opt >= 0 && opt < num_array[4])
					error = eliminarMision(misiones[opt]);
				else
					System.out.println("No se ha introducido una opción correcta");
			}else if(option.equals("-1"))
				salir = true;
			else
				System.out.println("No se ha introducido una opción correcta");
			
		}while(!salir);
		
		return !error;
	}

	//Función eliminar habilidad
	//Pide un parametro que será la habilidad a eliminar del array
	//Comprueba que la habilidad existe en el array y la elimina
	public boolean eliminarHabilidad(Habilidad habilidad) {
		boolean error = false;
		
		for(int i = 0; i < num_array[0]; i++)
			if(habilidades[i].esIgual(habilidad)) {
				error = false;
				
				int pos = i;
				
				for(int j = pos; j < num_array[0]; j++)
					habilidades[j] = habilidades[j+1];
				
				habilidades[num_array[0]-1] = null;
				num_array[0]--;
			}else	
				error = true;
		
		if(num_array[0] <= habilidades.length-5  && habilidades.length >= 5)
			decrementarArrays(1);
		
		return !error;
	}

	//Función eliminar item
	//Pide un parametro que será el item a eliminar del array
	//Comprueba que el item existe en el array y la elimina
	public boolean eliminarItem(Item item) {
		boolean error = false;
		
		for(int i = 0; i < num_array[1]; i++)
			if(items[i].esIgual(item)) {
				error = false;
				
				int pos = i;
				
				for(int j = pos; j < num_array[1]-1; j++)
					items[j] = items[j+1];
				
				items[num_array[1]-1] = null;
				num_array[1]--;
			}else	
				error = true;
		
		if(num_array[1] <= items.length-5  && items.length >= 5)
			decrementarArrays(2);
		
		return !error;
	}
	
	//Función eliminar personaje
	//Pide un parametro que será el personaje a eliminar del array
	//Comprueba que el personaje existe en el array y la elimina
	public boolean eliminarPersonaje(Personaje personaje) {
		boolean error = false;
		
		for(int i = 0; i < num_array[2]; i++)
			if(personajes[i].esIgual(personaje)) {
				error = false;
				
				int pos = i;
				
				for(int j = pos; j < num_array[2]-1; j++)
					personajes[j] = personajes[j+1];
				
				personajes[num_array[2]-1] = null;
				num_array[2]--;
			}else	
				error = true;
		
		if(num_array[2] <= personajes.length-5  && personajes.length >= 5)
			decrementarArrays(3);
		
		return !error;
	}

	//Función eliminar zona
	//Pide un parametro que será la zona a eliminar del array
	//Comprueba que la zona existe en el array y la elimina
	public boolean eliminarZona(Zona zona) {
		boolean error = false;
		
		for(int i = 0; i < num_array[3]; i++)
			if(zonas[i].esIgual(zona)) {
				error = false;
				
				int pos = i;
				
				for(int j = pos; j < num_array[3]-1; j++)
					zonas[j] = zonas[j+1];
				
				zonas[num_array[3]-1] = null;
				num_array[3]--;
			}else	
				error = true;
		
		if(num_array[3] <= zonas.length-5  && zonas.length >= 5)
			decrementarArrays(4);
		
		return !error;
	}
	
	//Función eliminar mision
	//Pide un parametro que será la mision a eliminar del array
	//Comprueba que la mision existe en el array y la elimina
	public boolean eliminarMision(Mision mision) {
		boolean error = false;
		
		for(int i = 0; i < num_array[4]; i++)
			if(misiones[i].esIgual(mision)) {
				error = false;
				
				int pos = i;
				
				for(int j = pos; j < num_array[4]-1; j++)
					misiones[j] = misiones[j+1];
				
				misiones[num_array[4]-1] = null;
				num_array[4]--;
			}else	
				error = true;
		
		if(num_array[4] <= misiones.length-5  && misiones.length >= 5)
			decrementarArrays(5);
		
		return !error;
	}
	
	//Función asignar habilidad a item
	//Añade una habilidad determinada a un item
	public boolean asigHabItem(Habilidad habilidad, Item item) {
		return item.addHabilidad(habilidad);
	}
	
	//Función asignar Habilidad a Item
	//Lista los items para que el usuario los selecciones
	//Lista las habilidades para que el usuario seleccione una a añadir.
	public boolean asigHabItem() {
		boolean error = false;
		boolean salir = false;
		
		do {
			
			System.out.println("Seleccione un item al que asignar una habilidad: ");
			System.out.println("-1 para salir.");
			
			for(int i = 0; i < num_array[1]; i++)
				System.out.println((i+1)+". "+items[i].getNombre()+".");
			
			System.out.println("\nIntroduce el item a seleccionar: ");
			String opt_item = entrada.nextLine();
			
			if(comprobacion.soloInt(opt_item)) {
				int nitem = Integer.parseInt(opt_item)-1;
				
				if(nitem >= 0 && nitem < num_array[1]){
					System.out.println("Seleccione una habilidadad: ");
					System.out.println("-1 para salir.");
					
					for(int i = 0; i < num_array[0]; i++)
						System.out.println((i+1)+". "+habilidades[i].getNombre()+".");
					
					System.out.println("\nIntroduce la habilidad a insertar: ");
					String opt_hab = entrada.nextLine();
					
					if(comprobacion.soloInt(opt_hab)) {
						int nhab = Integer.parseInt(opt_hab) -1;
						
						if(nhab >= 0 && nhab < num_array[0])
							error = asigHabItem(habilidades[nhab], items[nitem]);
						else
							System.out.println("No se introducido un opcion correcta.");
					}else if(opt_hab.equals("-1"))
						salir = true;
					else
						System.out.println("No se introducido un opcion correcta.");
				}else
					System.out.println("No se ha introducido una opcion correcta.");
			}else if(opt_item.equals("-1"))
				salir = true;
			else
				System.out.println("No se introducido un opcion correcta.");
				
		}while(!salir);
		
		return !error;
	}
	
	//Función eliminar habilidad a item
	//Eliminar una habilidad determinada a un item
	public boolean eliminarHabItem(Habilidad habilidad, Item item) {
		return item.eliminarHabilidad(habilidad);
	}
	
	//Función eliminar Habilidad de Item
	//Lista los items para que el usuario los selecciones
	//Lista las habilidades del item para que el usuario seleccione una a eliminar.
	public boolean eliminarHabItem() {
		boolean error = false;
		boolean salir = false;
		
		do {
			
			System.out.println("Seleccione un item al que eliminar una habilidad: ");
			System.out.println("-1 para salir.");
			
			for(int i = 0; i < num_array[1]; i++)
				System.out.println((i+1)+". "+items[i].getNombre()+".");
			
			System.out.println("\nIntroduce el item a seleccionar: ");
			String opt_item = entrada.nextLine();
			
			if(comprobacion.soloInt(opt_item)) {
				int nitem = Integer.parseInt(opt_item)-1;
				
				if(nitem >= 0 && nitem < num_array[1]){
					System.out.println("Seleccione una habilidadad: ");
					System.out.println("-1 para salir.");
					
					for(int i = 0; i < items[nitem].getNumAcciones(); i++)
						System.out.println((i+1)+". "+items[nitem].getAcciones()[i].getNombre()+".");
					
					System.out.println("\nIntroduce la habilidad a eliminar: ");
					String opt_hab = entrada.nextLine();
					
					if(comprobacion.soloInt(opt_hab)) {
						int nhab = Integer.parseInt(opt_hab) -1;
						
						if(nhab >= 0 && nhab < num_array[0])
							error = eliminarHabItem(items[nitem].getAcciones()[nhab], items[nitem]);
						else
							System.out.println("No se introducido un opcion correcta.");
					}else if(opt_hab.equals("-1"))
						salir = true;
					else
						System.out.println("No se introducido un opcion correcta.");
				}else
					System.out.println("No se ha introducido una opcion correcta.");
			}else if(opt_item.equals("-1"))
				salir = true;
			else
				System.out.println("No se introducido un opcion correcta.");
			
		}while(!salir);
		
		return !error;
	}
	
	//Función añadir personaje a zona
	//Añade un personaje a una determinada zona.
	public int addPersonajeAZona(Personaje personaje, Zona zona) {
		return zona.addPersonaje(personaje);
	}
	
	//Función añadir personaje a zona
	//Muestra las zonas para que el usuario las seleccione
	//Lista los personajes para que el usuario seleccione uno a añadir a la zona
	public int addPersonajeAZona() {
		int error = 0;
		boolean salir = false;
		
		do {
			
			System.out.println("Seleccione una zona a la que asignar un personaje: ");
			System.out.println("-1 para salir.");
			
			for(int i = 0; i < num_array[3]; i++)
				System.out.println((i+1)+". "+zonas[i].getNombre()+".");
			
			System.out.println("\nIntroduce la zona a seleccionar: ");
			String opt_zona = entrada.nextLine();
			
			if(comprobacion.soloInt(opt_zona)) {
				int nzon = Integer.parseInt(opt_zona)-1;
				
				if(nzon >= 0 && nzon < num_array[3]){
					System.out.println("Seleccione un personaje: ");
					System.out.println("-1 para salir.");
					
					for(int i = 0; i < num_array[2]; i++)
						System.out.println((i+1)+". "+personajes[i].getNombre()+".");
					
					System.out.println("\nIntroduce el personaje a insertar: ");
					String opt_per = entrada.nextLine();
					
					if(comprobacion.soloInt(opt_per)) {
						int nper = Integer.parseInt(opt_per) -1;
						
						if(nper >= 0 && nper < num_array[2])
							error = addPersonajeAZona(personajes[nper], zonas[nzon]);
						else
							System.out.println("No se introducido un opcion correcta.");
					}else if(opt_per.equals("-1"))
						salir = true;
					else
						System.out.println("No se introducido un opcion correcta.");
				}else
					System.out.println("No se ha introducido una opcion correcta.");
			}else if(opt_zona.equals("-1"))
				salir = true;
			else
				System.out.println("No se introducido un opcion correcta.");
			
		}while(!salir);
		
		return error == 0 ? 1 : 0;
	}
	
	//Función eliminar persoanje de una zona
	//Eliminar un personaje de una determinada zona
	public int eliminarPersonajeAZona(Personaje personaje, Zona zona) {
		return zona.eliminarPersonaje(personaje);
	}
	
	//Función eliminar personaje de zona
	//Muestra las zonas para que el usuario las seleccione
	//Lista los personajes de la zona para que el usuario seleccione uno a eliminar
	public int eliminarPersonajeAZona() {
		int error = 0;
		boolean salir = false;
		
		do {
			
			System.out.println("Seleccione una zona a la que eliminar un personaje: ");
			System.out.println("-1 para salir.");
			
			for(int i = 0; i < num_array[3]; i++)
				System.out.println((i+1)+". "+zonas[i].getNombre()+".");
			
			System.out.println("\nIntroduce la zona a seleccionar: ");
			String opt_zona = entrada.nextLine();
			
			if(comprobacion.soloInt(opt_zona)) {
				int nzon = Integer.parseInt(opt_zona)-1;
				
				if(nzon >= 0 && nzon < num_array[3]){
					System.out.println("Seleccione un personaje: ");
					System.out.println("-1 para salir.");
					
					for(int i = 0; i < num_array[2]; i++)
						System.out.println((i+1)+". "+zonas[nzon].getNpcs()[i].getNombre()+".");
					
					System.out.println("\nIntroduce el personaje a insertar: ");
					String opt_per = entrada.nextLine();
					
					if(comprobacion.soloInt(opt_per)) {
						int nper = Integer.parseInt(opt_per) -1;
						
						if(nper >= 0 && nper < num_array[2])
							error = eliminarPersonajeAZona(zonas[nzon].getNpcs()[nper], zonas[nzon]);
						else
							System.out.println("No se introducido un opcion correcta.");
					}else if(opt_per.equals("-1"))
						salir = true;
					else
						System.out.println("No se introducido un opcion correcta.");
				}else
					System.out.println("No se ha introducido una opcion correcta.");
			}else if(opt_zona.equals("-1"))
				salir = true;
			else
				System.out.println("No se introducido un opcion correcta.");
			
		}while(!salir);
		
		return error == 0 ? 1 : 0;
	}

	//Función modificar equipo
	//Pregunta al usuario si se va a añadir, eliminar o salir de la función
	//Muestra los personajes para que el usuario seleccione uno
	//Muestra los items del personaje si se va a eliminar o todos los items si se añade
	public int modEquipo() {
		boolean salir = false;
		int error = 0;
		
		do {
			
			System.out.println("¿Qué desea hacer?");
			System.out.println("1. Añadir.");
			System.out.println("2. Eliminar.");
			System.out.println("3. Salir.");
			
			String opt = entrada.nextLine();
			
			if(comprobacion.soloInt(opt)) {
				int opt_outer = Integer.parseInt(opt);
				int nper = -1;
				boolean salir_per = false;
				
				if(opt_outer != 3)
					do {
						System.out.println("\n\nSeleccione el personaje a modificar: ");
						
						for(int i = 0; i < num_array[2]; i++)
							System.out.println((i+1)+". "+personajes[i].getNombre()+".");
						
						System.out.println("Introduce número del personaje: ");
						String opt_per_str = entrada.nextLine();
						
						if(comprobacion.soloInt(opt_per_str)) {
							nper = Integer.parseInt(opt_per_str)-1;
							
							if(nper >= 0 && nper < num_array[2]) {
								salir_per = true;
							}else
								System.out.println("La opcion no es correcta.");
							
						}else
							System.out.println("La opcion no es correcta.");
					}while(!salir_per);
				
				if(opt_outer == 1) {

					System.out.println("\n\nSeleccione el item a añadir: ");
					
					for(int i = 0; i < num_array[1]; i++)
						System.out.println((i+1)+". "+items[i].getNombre()+".");
					
					System.out.println("Introduce el número del item: ");
					String opt_item_str = entrada.nextLine();
					
					if(comprobacion.soloInt(opt_item_str)) {
						int opt_item = Integer.parseInt(opt_item_str)-1;
						
						if(opt_item >= 0 && opt_item < num_array[1]) {
							error = this.modEquipo(personajes[nper], items[opt_item], true);
						}else
							System.out.println("La opcion no es correcta.");
						
						if(error == 0)	System.out.println("No se ha podido añadir, el array esta completo.");
					}else
						System.out.println("La opcion no es correcta.");
					
				}else if(opt_outer == 2) {
					System.out.println("\n\nSeleccione el item a eliminar: ");
					
					for(int i = 0; i < personajes[nper].getNumEquipo(); i++)
						System.out.println((i+1)+". "+personajes[nper].getEquipo()[i].getNombre()+".");
					
					System.out.println("Introduce el número del item: ");
					String opt_item_str = entrada.nextLine();
					
					if(comprobacion.soloInt(opt_item_str)) {
						int opt_item = Integer.parseInt(opt_item_str)-1;
						
						if(opt_item >= 0 && opt_item < personajes[nper].getNumEquipo()) {
							error = this.modEquipo(personajes[nper], personajes[nper].getEquipo()[opt_item], false);
						}else
							System.out.println("La opcion no es correcta.");
						if(error == 0)	System.out.println("No se ha podido eliminar.");
					}else
						System.out.println("La opcion no es correcta.");
				}else if(opt_outer == 3) {
					salir = true;
				}else
					System.out.println("La opcion no es correcta.");
			}else
				System.out.println("La opcion no es correcta.");
	
		}while(!salir);
		
		return error == 0 ? 1 : 0;
	}

	//Función modificar equipo
	//Dependiendo de la variable anyadir, se añade o elimina el item del personaje
	public int modEquipo(Personaje personaje, Item item, boolean anyadir) {
		return anyadir ? personaje.addItem(item) : personaje.eliminarItem(item);
	}

	//Función modificar habilidad personaje
	//Pregunta al usuario si se va a añadir, eliminar o salir de la función
	//Muestra los personajes para que el usuario seleccione uno
	//Muestra las habilidades del personaje si se va a eliminar o todos las habilidades si se añade
	public int modHabPer() {
		boolean salir = false;
		int error = 0;
		
		do {
			
			System.out.println("¿Qué desea hacer?");
			System.out.println("1. Añadir.");
			System.out.println("2. Eliminar.");
			System.out.println("3. Salir.");
			
			String opt = entrada.nextLine();
			
			if(comprobacion.soloInt(opt)) {
				int opt_outer = Integer.parseInt(opt);
				int nper = -1;
				boolean salir_per = false;
				
				if(opt_outer != 3)
					do {
						System.out.println("\n\nSeleccione el personaje a modificar: ");
						
						for(int i = 0; i < num_array[2]; i++)
							System.out.println((i+1)+". "+personajes[i].getNombre()+".");
						
						System.out.println("Introduce número del personaje: ");
						String opt_per_str = entrada.nextLine();
						
						if(comprobacion.soloInt(opt_per_str)) {
							nper = Integer.parseInt(opt_per_str)-1;
							
							if(nper >= 0 && nper < num_array[2]) {
								salir_per = true;
							}else
								System.out.println("La opcion no es correcta.");
							
						}else
							System.out.println("La opcion no es correcta.");
					}while(!salir_per);
				
				if(opt_outer == 1) {

					System.out.println("\n\nSeleccione el item a añadir: ");
					
					for(int i = 0; i < num_array[0]; i++)
						System.out.println((i+1)+". "+habilidades[i].getNombre()+".");
					
					System.out.println("Introduce el número del item: ");
					String opt_hab_str = entrada.nextLine();
					
					if(comprobacion.soloInt(opt_hab_str)) {
						int opt_hab = Integer.parseInt(opt_hab_str)-1;
						
						if(opt_hab >= 0 && opt_hab < num_array[0]) {
							error = this.modHabPer(personajes[nper], habilidades[opt_hab], true);
						}else
							System.out.println("La opcion no es correcta.");
						
						if(error == 0)	System.out.println("No se ha podido añadir, el array esta completo.");
					}else
						System.out.println("La opcion no es correcta.");
					
				}else if(opt_outer == 2) {
					System.out.println("\n\nSeleccione el item añadir: ");
					
					for(int i = 0; i < personajes[nper].getNumEquipo(); i++)
						System.out.println((i+1)+". "+personajes[nper].getHabilidades()[i].getNombre()+".");
					
					System.out.println("Introduce el número del item: ");
					String opt_hab_str = entrada.nextLine();
					
					if(comprobacion.soloInt(opt_hab_str)) {
						int opt_hab = Integer.parseInt(opt_hab_str)-1;
						
						if(opt_hab >= 0 && opt_hab < personajes[nper].getNumEquipo()) {
							error = this.modHabPer(personajes[nper], personajes[nper].getHabilidades()[opt_hab], false);
						}else
							System.out.println("La opcion no es correcta.");
						
						if(error == 0)	System.out.println("No se ha podido eliminar.");
					}else
						System.out.println("La opcion no es correcta.");
				}else if(opt_outer == 3) {
					salir = true;
				}else
					System.out.println("La opcion no es correcta.");
			}else
				System.out.println("La opcion no es correcta.");
			
		}while(!salir);
		
		return error == 0 ? 1 : 0;
	}

	//Función modificar habilidad personaje
	//Dependiendo de la variable anyadir, se añade o elimina la habilidad del personaje
	public int modHabPer(Personaje personaje, Habilidad hab, boolean anyadir) {
		return anyadir ? personaje.addHabilidad(hab) : personaje.eliminarHabilidad(hab);
	}
	
	//Función que incrementa el tamaño de los arrays
	//Dependiendo del valor de array, se incrementa un determinado array
	//Se crea un array con un tamaño mayor y se pasan todos los valores al array.
	//Se asigna el antiguo array al nuevo array.
	private void incrementarArrays(int array) {
		
		if(array == 1) {
			Habilidad[] temp = new Habilidad[habilidades.length+5];
			
			for(int i = 0; i < habilidades.length; i++)
				temp[i] = habilidades[i];
			
			habilidades = temp;
		}else if(array == 2) {
			Item[] temp = new Item[items.length+5];
			
			for(int i = 0; i < items.length; i++)
				temp[i] = items[i];
			
			items = temp;
		}else if(array == 3) {
			Zona[] temp = new Zona[zonas.length+5];
			
			for(int i = 0; i < zonas.length; i++)
				temp[i] = zonas[i];
			
			zonas = temp;
		}else if(array == 4) {
			Personaje[] temp = new Personaje[personajes.length+5];
			
			for(int i = 0; i < personajes.length; i++)
				temp[i] = personajes[i];
			
			personajes = temp;
		}else if(array == 5) {
			Mision[] temp = new Mision[misiones.length+5];
			
			for(int i = 0; i < misiones.length; i++)
				temp[i] = misiones[i];
			
			misiones = temp;
		}else if(array == 6) {
			Usuario[] temp = new Usuario[users.length+5];
			
			for(int i = 0; i < users.length; i++)
				temp[i] = users[i];
			
			users = temp;
		}
		
	}

	//Función que decrementa el tamaño de los arrays
	//Dependiendo del valor de array, se decrementa un determinado array
	//Se crea un array con un tamaño mmenor y se pasan todos los valores al array.
	//Se asigna el antiguo array al nuevo array.
	private void decrementarArrays(int array) {
		
		if(array == 1) {
			Habilidad[] temp = new Habilidad[habilidades.length-5];
			
			for(int i = 0; i < temp.length; i++)
				temp[i] = habilidades[i];
			
			habilidades = temp;
		}else if(array == 2) {
			Item[] temp = new Item[items.length-5];
			
			for(int i = 0; i < temp.length; i++)
				temp[i] = items[i];
			
			items = temp;
		}else if(array == 3) {
			Zona[] temp = new Zona[zonas.length-5];
			
			for(int i = 0; i < temp.length; i++)
				temp[i] = zonas[i];
			
			zonas = temp;
		}else if(array == 4) {
			Personaje[] temp = new Personaje[personajes.length-5];
			
			for(int i = 0; i < temp.length; i++)
				temp[i] = personajes[i];
			
			personajes = temp;
		}else if(array == 5) {
			Mision[] temp = new Mision[misiones.length-5];
			
			for(int i = 0; i < temp.length; i++)
				temp[i] = misiones[i];
			
			misiones = temp;
		}else if(array == 6) {
			Usuario[] temp = new Usuario[users.length-5];
			
			for(int i = 0; i < temp.length; i++)
				temp[i] = users[i];
			
			users = temp;
		}
		
	}

	public void escribirEnBaseDatos() {
		Basedatos.update("DELETE FROM personaje_habilidades WHERE true");
	
		Basedatos.update("DELETE FROM habilidad WHERE true");
		Basedatos.update("DELETE FROM personaje WHERE true");
		
		for(int i = 0; i < this.num_array[0]; i++)
			Basedatos.insert("habilidad(nombre, tipo, energia, vida) VALUES " + this.habilidades[i]);
		
		for(int i = 0; i < this.num_array[2]; i++) {
			Basedatos.insert("personaje(nombre, clase, vida_max, vida_actual, energia_max, energia_actual, monedas, npc, hostil, num_habilidades, num_equipo) VALUES " + this.personajes[i]);
			
			for(int j = 0; j < this.personajes[i].getNumHab(); j++)
				Basedatos.insert("personaje_habilidades(personaje, habilidad) VALUES ('" + this.personajes[i].getNombre() + "', '" + this.personajes[i].getHabilidades()[j].getNombre() + "')");
			
		}
	}
	
	public void leerDeBaseDatos(){
		try {
			//HABILIDADES
			{
				ResultSet result = Basedatos.select("SELECT * FROM habilidad");
				
				while(result.next())
					if(!this.anyadirHabilidad(new Habilidad(
							result.getString("nombre"),
							result.getInt("vida"),
							result.getInt("energia"),
							result.getString("tipo")
						)))
						System.out.println("Error al añadir la habilidad");
			}
			
			//PERSONAJES
			{
				ResultSet per = Basedatos.select("SELECT * FROM personaje");
				while(per.next()) {
					Habilidad[] habilidades = new Habilidad[per.getInt("num_habilidades")];
					
					
					{
						ResultSet habper = Basedatos.select(
								"SELECT habilidad FROM personaje_habilidades WHERE personaje = '" + per.getString("nombre") + "'");
						int nHab = 0;
						while(habper.next())
							for(int iterHab = 0; iterHab < this.num_array[0]; iterHab++)
								if(habper.getString("habilidad").equals(this.habilidades[iterHab].getNombre()))
									habilidades[nHab++] = this.habilidades[iterHab];
							
					}
					
						
					if(!this.anyadirPersonaje(new Personaje(
							per.getString("nombre"),
							per.getString("clase"),
							per.getInt("vida_max"),
							per.getInt("energia_max"),
							per.getInt("vida_actual"),
							per.getInt("energia_actual"),
							per.getInt("monedas"),
							habilidades,
							new Item[5],
							per.getBoolean("npc"),
							per.getBoolean("hostil"))))
						System.out.println("Error al añadir un personaje");;
				
				}
			}
			
		}catch(SQLException e) {
			System.out.println("SQL mensaje: " + e.getMessage());
	      	System.out.println("SQL Estado: " + e.getSQLState());
	      	System.out.println("SQL codigo especifico: " + e.getErrorCode());
		}
	}
}
