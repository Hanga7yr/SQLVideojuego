package objects;

public class Mision {
	
	private String nombre;
	
	private int nivel;
	private int monedas;
	
	//Constructores
	private Personaje objetivo;
	private Item recompensa;
	private Zona zona;
	
	//Constructores
	public Mision(){
		nombre = "";
		
		nivel = 0;
		monedas = 0;
		
		objetivo = new Personaje();
		recompensa = new Armadura();
		zona = new Zona();
	}
	
	public Mision(	String _nombre,
			int _nivel,
			Personaje _objetivo,
			Zona _zona,
			Item _item, int _monedas){
		
		nombre = _nombre;
		
		nivel = _nivel;
		monedas = _monedas;
		
		objetivo = _objetivo;
		recompensa = _item;
		zona = _zona;
		
	}
	
	public Mision(Mision _mision){
		nombre = _mision.nombre;
		
		nivel = _mision.nivel;
		monedas = _mision.monedas;
		
		objetivo = _mision.objetivo;
		recompensa = _mision.recompensa;
		zona = _mision.zona;
	}

	//Getter y Setters
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public int getNivel() { return nivel; }
	public void setNivel(int nivel) { this.nivel = nivel; }

	public int getMonedas() { return monedas; }
	public void setMonedas(int monedas) { this.monedas = monedas; }

	public Personaje getObjetivo() { return objetivo; }
	public void setObjetivo(Personaje objetivo) { this.objetivo = objetivo; }

	public Item getRecompensa() { return recompensa; }
	public void setRecompensa(Item recompensa) { this.recompensa = recompensa; }

	public Zona getZona() { return zona; }
	public void setZona(Zona zona) { this.zona = zona; }
	
	//Visualizar todos los datos
	public void visualizar() {
		
		System.out.println("---------------------");
		System.out.println("Nombre: " + nombre);
		
		
		System.out.println("");
		
		System.out.println("Nivel : " + nivel);
		System.out.println("Monedas: " + monedas);
		System.out.println("---------------------");
		
		System.out.println("");
		
		
		objetivo.visualizarBasico();
		
		System.out.println("");
		
		recompensa.visualizarBasico();
		
		System.out.println("");
		
		zona.visualizarBasico();
		
	}
	
	//Visualizar los datos básicos
	public void visualizarBasico() {
		
		System.out.println("---------------------");
		System.out.println("Nombre: " + nombre);
		
		
		System.out.println("");
		
		System.out.println("Nivel : " + nivel);
		System.out.println("Monedas: " + monedas);
		System.out.println("---------------------");
		
		System.out.println("");
		
	}
	
	//Función igual
	//Comprueba si la mision es igual
	public boolean esIgual(Mision _mision) {
		boolean igual = true;
		
		igual &= (nombre.equals(_mision.nombre));
		
		igual &= (nivel == _mision.nivel);
		
		igual &= (objetivo.esIgual(_mision.objetivo));
		
		return igual;
	}
	
}
