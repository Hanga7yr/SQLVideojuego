package objects;

public class Armadura extends Item {
	private int armadura;
	private int peso;
	
	//Contructores
	public Armadura(){
		super();
		armadura = 0;
	}
	
	public Armadura(String _nombre, int _valor,
					Habilidad[] _acciones,
					int armadura, int _peso){
		super(_nombre, _valor, _acciones);
		this.armadura = armadura;
		this.peso = _peso;
	}
	
	public Armadura(Armadura arma){
		super(arma);
		this.armadura = arma.armadura;
		this.peso = arma.peso;
	}

	//Getter y Setters
	public int getArmadura() { return armadura; }
	public void setArmadura(int armadura) { this.armadura = armadura; }
	
	public int getPeso() { return peso;	}
	public void setPeso(int peso) { this.peso = peso; }
	
	//Visualizar todos los datos
	@Override
	public void visualizar(){
		
		System.out.println("---------------------");
		System.out.println("Nombre: " + super.nombre);
		System.out.println();
		
		System.out.println("Peso: " + this.peso);
		System.out.println("Valor: " + super.valor);
		System.out.println("Armadura: " + this.armadura);
		
		System.out.println("---------------------");
		
		for(int i = 0; i < super.getNumAcciones(); i++) {
			System.out.println("\nHabilidad: " + (i+1) + "\n");
			super.acciones[i].visualizar();
		}
	}

	//Visualizas datos basicos
	@Override
	public void visualizarBasico() {

		System.out.println("---------------------");
		System.out.println("Nombre: " + super.nombre);
		System.out.println();
		
		System.out.println("Peso: " + this.peso);
		System.out.println("Valor: " + super.valor);
		System.out.println("Armadura: " + this.armadura);
		
		System.out.println("---------------------");
		
		System.out.println("\nHabilidades: " + super.getNumAcciones());
	}
}
