package objects;

public class Habilidad {
	private String nombre;
	private String tipo;
	
	private int vida;
	private int energia;
	
	//Constructores
	public Habilidad(){
		nombre = "";
		tipo = "";
		
		vida = 0;
		energia = 0;
	}
	
	public Habilidad(Habilidad _habilidad){
		nombre = _habilidad.nombre;
		tipo = _habilidad.tipo;
		
		vida = _habilidad.vida;
		energia = _habilidad.energia;
	}
	
	public Habilidad(	String _nombre,
				int _vida, int _energia, String _tipo){
		nombre = _nombre;
		tipo = _tipo;
		
		vida = _vida;
		energia = _energia;
	}
	
	//Getter y Setters
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getTipo() { return tipo; }
	public void setTipo(String tipo) {this.tipo = tipo; }

	public int getVida() { return vida;	}
	public void setVida(int vida) { this.vida = vida; }

	public int getEnergia() { return energia; }
	public void setEnergia(int energia) { this.energia = energia; }

	//Visualizar todos los datos
	public void visualizar(){
		
		System.out.println("---------------------");
		System.out.println("Nombre: " + nombre);
		System.out.println("Tipo: " + tipo);
		
		System.out.println();
		
		System.out.println("Vida: " + vida);
		System.out.println("Energia: " + energia);
		System.out.println("---------------------");
	}
	
	//Visualizar los datos básicos
	public void visualizarBasico() {
		visualizar();
	}
	
	//Función igual
	//Si la habilidad es la misma, devuelve true.
	public boolean esIgual(Habilidad _habilidad) {
		return nombre.equals(_habilidad.nombre);
	}

}
