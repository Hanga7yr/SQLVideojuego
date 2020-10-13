package objects;

public class Arma extends Item{
	private int agravio;
	private int peso;
	
	//Constructores
	public Arma(){
		super();
		agravio = 0;
	}
	
	public Arma(String _nombre, int _valor,
					Habilidad[] _acciones,
					int agravio, int _peso){
		super(_nombre, _valor, _acciones);
		this.agravio = agravio;
		this.peso = _peso;
	}
	
	public Arma(Arma arma){
		super(arma);
		this.agravio = arma.agravio;
		this.peso = arma.peso;
	}

	//Getter y Setters
	public int getAgravio() { return agravio; }
	public void setAgravio(int agravio) { this.agravio = agravio; }
	
	public int getPeso() { return peso; }
	public void setPeso(int peso) { this.peso = peso; }
	
	//Visualiza todos los datos
	public void visualizar(){
		
		System.out.println("---------------------");
		System.out.println("Nombre: " + super.nombre);
		
		System.out.println();
		
		System.out.println("Peso: " + this.peso);
		System.out.println("Valor: " + super.valor);
		System.out.println("Agravio: " + this.agravio);
		
		System.out.println("---------------------");
		
		for(int i = 0; i < super.getNumAcciones(); i++) {
			System.out.println("\nHabilidad: " + (i+1) + "\n");
			super.acciones[i].visualizar();
		}
		
	}

	//Visualiza los datos basicos
	@Override
	public void visualizarBasico() {

		System.out.println("---------------------");
		System.out.println("Nombre: " + super.nombre);
		
		System.out.println();
		
		System.out.println("Peso: " + this.peso);
		System.out.println("Valor: " + super.valor);
		System.out.println("Agravio: " + this.agravio);
		
		
		System.out.println("---------------------");
		
		System.out.println("\nHabilidades: " + super.getNumAcciones());
	}
}
