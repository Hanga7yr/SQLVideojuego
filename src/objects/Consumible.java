package objects;

public class Consumible extends Item {
	private int cantidad;
	
	//Constructores
	public Consumible(){
		super();
	}
	
	public Consumible(String _nombre, int _valor,
					Habilidad[] _acciones,
					int _cantidad){
		super(_nombre, _valor, _acciones);
		this.cantidad = _cantidad;
	}
	
	public Consumible(Consumible consumible){
		super(consumible);
		this.cantidad = consumible.cantidad;
	}
	
	//Getter y Setters
	public int getCantidad() { return cantidad; }
	public void setCantidad(int cantidad) { this.cantidad = cantidad; }

	//Visualizar todos los datos
	@Override
	public void visualizar(){
		
		System.out.println("---------------------");
		System.out.println("Nombre: " + this.nombre);
		
		System.out.println();
		
		System.out.println("Valor: " + this.valor);
		System.out.println("Cantidad: " + this.cantidad);
		
		System.out.println("---------------------");
		
		for(int i = 0; i < super.getNumAcciones(); i++) {
			System.out.println("\nHabilidad: " + (i+1) + "\n");
			super.acciones[i].visualizar();
		}
	}
	
	//Visualizar los datos basicos
	@Override
	public void visualizarBasico(){
		
		System.out.println("---------------------");
		System.out.println("Nombre: " + this.nombre);
		
		System.out.println();
		
		System.out.println("Valor: " + this.valor);
		System.out.println("Cantidad: " + this.cantidad);
		
		System.out.println("---------------------");
		
		System.out.println("\nHabilidad: " + super.getNumAcciones());
	}
}
