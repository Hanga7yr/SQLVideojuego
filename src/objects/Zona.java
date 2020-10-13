package objects;

public class Zona {
	
	private String nombre;
	
	private int nivel;
	
	private int num_npcs;
	
	private Personaje[] npcs;
	
	//Constructores
	public Zona(){
		nombre = "";
		
		nivel = 0;
		
		num_npcs = 0;
		
		npcs = new Personaje[10];
	}
	
	public Zona(String _nombre, int _nivel, Personaje[] _npcs){
		nombre = _nombre;
		nivel = _nivel;
		
		num_npcs = 0;
		
		npcs = new Personaje[10];
		
		for(int i = 0; i < _npcs.length; i++)
			if(!checkArray(_npcs[i]))
				npcs[num_npcs++] = _npcs[i];
	}
	
	public Zona(Zona _zona){
		nombre = _zona.nombre;
		
		nivel = _zona.nivel;
		
		num_npcs = _zona.num_npcs;
		
		npcs = new Personaje[10];
		
		for(int i = 0; i < npcs.length; i++)
			npcs[i] = _zona.npcs[i];
	}

	//Getter y Setters
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public int getNivel() { return nivel; }
	public void setNivel(int nivel) { this.nivel = nivel; }

	public Personaje[] getNpcs() { return npcs; }
	public void setNpcs(Personaje[] npcs) { this.npcs = npcs; }
	
	//Función que comprueba si un personaje existe en el array de personajes
	private boolean checkArray(Personaje _perso) {
		boolean salida = false;
		
		for(int i = 0; i < num_npcs; i++)
			if(_perso != null && npcs[i] != null) {
				if(npcs[i].esIgual(_perso))
					salida = true;
			}else{
				salida = true;
			}
		
		if(npcs[0] == null && _perso == null)
			salida = true;
					
		return salida;
	}
	
	//Función que añade un personaje al array de personajes
	public int addPersonaje(Personaje _npc) {
		boolean error = false;
		boolean existe = error;
		
		existe = checkArray(_npc);
		
		if(!existe && (num_npcs != npcs.length))
			npcs[num_npcs++] = _npc;
		else
			error = true;
		return error ? 0 : 1;
	}
	
	//Función que elimina un personaje del array de personajes.
	public int eliminarPersonaje(Personaje _npc) {
		boolean error = false;
		boolean existe = false;
		int pos = 0;
		
		for(int i = 0; i < this.num_npcs && !existe; i++)
			if(npcs[i].esIgual(_npc)) {
				existe = true;
				pos = i;
			}
	
		error = existe;
		if(existe){
			for(int i = pos; i < num_npcs-1; i++)
				npcs[i] = npcs[i+1];
			
			npcs[num_npcs-1] = null;
			num_npcs--;
		}
		
		return error ? 1 : 0;
	}
	
	//Visualizar los datos básicos
	public void visualizarBasico() {
		
		System.out.println("---------------------");
		System.out.println("Nombre: " + nombre);
		
		System.out.println("Nivel: " + nivel);
		System.out.println("---------------------");
		
		System.out.println("NPCs: " + (num_npcs));
		
	}
	
	//Visualizar todos los datos
	public void visualizar() {
		System.out.println("---------------------");
		System.out.println("Nombre: " + nombre);
		
		System.out.println("Nivel: " + nivel);
		System.out.println("---------------------");
		
		for(int i = 0; i < num_npcs; i++) {
			System.out.println("NPCs: " + (i+1));
			npcs[i].visualizarBasico();
		}
	}
	
	//Función igual
	//Comprueba si la zona es igual
	public boolean esIgual(Zona _zona) {
		return nombre.equals(_zona.nombre);
	}
	
}
