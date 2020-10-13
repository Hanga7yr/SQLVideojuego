package objects;

public class Personaje {
	private String nombre;
	private String clase;
	
	private int vida_max;
	private int vida_actual;
	private int energia_max;
	private int energia_actual;
	private int monedas;
	
	private boolean npc;
	private boolean hostil;
	
	private int num_habilidades;
	private int num_equipo;
	
	private Habilidad[] habilidades;
	private Item[] equipo;
	
	
	//Constructores
	public Personaje(){
		nombre = "";
		clase = "";
		
		vida_max = 0;
		vida_actual = 0;
		energia_max = 0;
		energia_actual = 0;
		monedas = 0;
		
		npc = false;
		hostil = false;
		
		num_equipo = 0;
		num_habilidades = 0;
		
		habilidades = new Habilidad[5];
		
		equipo = new Item[10];
		
	}
	
	public Personaje(	String _nombre, String _clase,
				int _vida_max, int _energia_max, int _vida_actual, int _energia_actual, int _monedas,
				Habilidad[] _habilidades,
				Item[] _equipo,
				boolean _npc, boolean _hostil){
		
		nombre = _nombre;
		clase = _clase;
		
		vida_max = _vida_max;
		vida_actual = _vida_actual;
		energia_max = _energia_max;
		energia_actual = _energia_actual;
		monedas = _monedas;
		
		npc = _npc;
		hostil = _hostil;
		
		num_equipo = 0;
		num_habilidades = 0;
		
		habilidades = new Habilidad[5];
		equipo = new Item[5];
		
		for(int i = 0; i < _habilidades.length; i++)
			if(!checkArray(_habilidades[i]))
				habilidades[num_habilidades++] = _habilidades[i];
		
		for(int i = 0; i < _equipo.length; i++)
			if(!checkArray(_equipo[i]))
				equipo[num_equipo++] = _equipo[i];
	}
	
	public Personaje(Personaje _personaje){
		nombre = _personaje.nombre;
		clase = _personaje.clase;
		
		vida_max = _personaje.vida_max;
		vida_actual = _personaje.vida_actual;
		energia_max = _personaje.energia_max;
		energia_actual = _personaje.energia_actual;
		monedas = _personaje.monedas;
		
		npc = _personaje.npc;
		hostil = _personaje.hostil;
		
		num_equipo = _personaje.num_equipo;
		num_habilidades = _personaje.num_habilidades;
		
		habilidades = new Habilidad[5];
		for(int i = 0; i < habilidades.length; i++)
			habilidades[i] = _personaje.habilidades[i];
		
		equipo = new Item[5];
		for(int i = 0; i < equipo.length; i++)
			equipo[i] = _personaje.equipo[i];
	}
	
	//Getter y Setters
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public String getClase() { return clase; }
	public void setClase(String clase) { this.clase = clase; }
	
	public int getVida_max() { return vida_max;	}
	public void setVida_max(int vida_max) {	this.vida_max = vida_max; }
	
	public int getVida_actual() { return vida_actual; }
	public void setVida_actual(int vida_actual) { this.vida_actual = vida_actual; }
	
	public int getEnergia_max() { return energia_max; }
	public void setEnergia_max(int energia_max) { this.energia_max = energia_max; }
	
	public int getEnergia_actual() { return energia_actual; }
	public void setEnergia_actual(int energia_actual) { this.energia_actual = energia_actual; }
	
	public int getMonedas() { return monedas; }
	public void setMonedas(int monedas) { this.monedas = monedas; }
	
	public boolean isNpc() { return npc; }
	public void setNpc(boolean npc) { this.npc = npc; }
	
	public boolean isHostil() { return hostil;}
	public void setHostil(boolean hostil) { this.hostil = hostil; }
	
	public int getNumEquipo() { return num_equipo;}
	public void setNumEquipo(int num_equipo) { this.num_equipo = num_equipo; }
	
	public int getNumHab() { return num_habilidades;}
	public void setNumHab(int num_hab) { this.num_habilidades = num_hab; }
	
	public Habilidad[] getHabilidades() { return habilidades; }
	public void setHabilidades(Habilidad[] habilidades) { this.habilidades = habilidades; }
	
	public Item[] getEquipo() { return equipo; }
	public void setEquipo(Item[] equipo) { this.equipo = equipo; }
	
	//Función que comprueba si una habilidad esta en el array de habilidades
	private boolean checkArray(Habilidad _habilidad) {
		boolean salida = false;
		
		for(int i = 0; i < num_habilidades; i++)
			if(_habilidad != null && habilidades[i] != null) {
				if(habilidades[i].esIgual(_habilidad))
					salida = true;
			}else
				salida = true;
		
		if(habilidades[0] == null && _habilidad == null)
			salida = true;
		return salida;
	}
	
	//Función que comprueba si un item esta en el array de items
	private boolean checkArray(Item _equipo) {
		boolean salida = false;
		
		for(int i = 0; i < num_equipo; i++)
			if(_equipo != null && equipo[i] != null) {
				if(equipo[i].esIgual(_equipo))
					salida = true;
			}else
				salida = true;
		
		if(equipo[0] == null && _equipo == null)
			salida = true;
		
		return salida;
	}
	
	//Función que añade una habilidad al array de habilidades
	public int addHabilidad(Habilidad _habilidad) {
		boolean error = false;
		boolean existe = error;
		
		existe = checkArray(_habilidad);
		
		if(!existe && (num_habilidades != habilidades.length))
			habilidades[num_habilidades++] = _habilidad;
		else
			error = true;
		
		return error ? 0 : 1;
	}
	
	//Función que elimina una habilidad del array de habilidades
	public int eliminarHabilidad(Habilidad _habilidad) {
		boolean error = false;
		boolean existe = false;
		int pos = 0;
		
		for(int i = 0; i < num_habilidades && !existe; i++)
			if(habilidades[i].esIgual(_habilidad)) {
				existe = true;
				pos = i;
			}
	
		error = existe;
		if(existe){
			for(int i = pos; i < num_habilidades-1; i++)
				habilidades[i] = habilidades[i+1];
			
			habilidades[num_habilidades-1] = null;
			num_habilidades--;
		}
		
		return error ? 1 : 0;
	}
	
	//Función que añade un item al array de items
	public int addItem(Item _item) {
		boolean error = false;
		boolean existe = error;
		
		existe = checkArray(_item);
		
		if(!existe && (num_equipo != equipo.length))
			equipo[num_equipo++] = _item;
		else
			error = true;
		return error ? 0 : 1;
	}
	
	//Función que elimina un item del array de items
	public int eliminarItem(Item _item) {
		boolean error = false;
		boolean existe = false;
		int pos = 0;
		
		for(int i = 0; i < num_equipo && !existe; i++)
			if(equipo[i].esIgual(_item)) {
				existe = true;
				pos = i;
			}
	
		error = existe;
		if(existe){
			for(int i = pos; i < num_equipo-1; i++)
				equipo[i] = equipo[i+1];
			
			equipo[num_equipo-1] = null;
			num_equipo--;
		}
		
		return error ? 1 : 0;
	}

	//Visualiza los datos básicos
	public void visualizarBasico() {
		System.out.println("---------------------");
		System.out.println("Nombre: " + nombre);
		System.out.println("Clase: " + clase);
		
		System.out.println();
		
		System.out.println("Vida Max: " + vida_max);
		System.out.println("Vida actual: " + vida_actual);
		System.out.println("Energia Max: " + energia_max);
		System.out.println("Energia actual: " + energia_actual);
		System.out.println("Monedas: " + monedas);
		
		System.out.println();
		
		System.out.println("NPC: " + (npc ? "Si" : "No"));
		System.out.println("Hostil: " + (hostil ? "Si" : "No"));
		System.out.println("---------------------");
		
		System.out.println();
		
		System.out.println("Habilidad " + num_habilidades);
		
		System.out.println();
		
		System.out.println("Equipo " + num_equipo);
	}
	
	//Visualiza todos los datos
	public void visualizar() {
		System.out.println("---------------------");
		System.out.println("Nombre: " + nombre);
		System.out.println("Clase: " + clase);
		
		System.out.println();
		
		System.out.println("Vida Max: " + vida_max);
		System.out.println("Vida actual: " + vida_actual);
		System.out.println("Energia Max: " + energia_max);
		System.out.println("Energia actual: " + energia_actual);
		System.out.println("Monedas: " + monedas);
		
		System.out.println();
		
		System.out.println("NPC: " + (npc ? "Si" : "No"));
		System.out.println("Hostil: " + (hostil ? "Si" : "No"));
		System.out.println("---------------------");
		
		System.out.println();
		
		for(int i = 0; i < num_habilidades; i++) {
			System.out.println("Habilidad " + (i+1));
			
			habilidades[i].visualizarBasico();
		}
		
		
		System.out.println();
		
		for(int i = 0; i < num_equipo; i++) {
			System.out.println("Equipo " + (i+1));
			
			equipo[i].visualizarBasico();
		}
	}
	
	//Función Igual
	//Comprueba si es el mismo personaje.
	public boolean esIgual(Personaje _personaje) {
		return nombre.equals(_personaje.nombre);
	}
	
	@Override
	public String toString() {
		String result = "";

		result += 	"('" 	+ nombre + "', '"
						+ clase + "', "
						+ vida_max + ", "
						+ vida_actual + ", "
						+ energia_max + ", "
						+ energia_actual + ", "
						+ monedas + ", "
						+ npc + ", "
						+ hostil + ", "
						+ num_habilidades + ", "
						+ num_equipo
					+ ")";
		
		
		return result;
	}
	
}
