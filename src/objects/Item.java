package objects;

public abstract class Item {
	
	protected String nombre;
	
	protected int valor;
	
	protected Habilidad acciones[];
	private int num_acciones;
	
	//Constructores
	public Item(){
		nombre = "";
		
		valor = 0;
		
		acciones = new Habilidad[5];
	}
	
	public Item(	String _nombre, int _valor,
					Habilidad[] _acciones){
		
		nombre = _nombre;
		
		valor = _valor;
		
		num_acciones = 0;
		
		acciones = new Habilidad[5];
		
		for(int i = 0; i < _acciones.length; i++)
			if(!checkArray(_acciones[i]))
				acciones[num_acciones++] = _acciones[i];
		
	}
	
	public Item(Item _objeto){
		nombre = _objeto.nombre;
		
		valor = _objeto.valor;
		
		acciones = new Habilidad[5];
		
		for(int i = 0; i < acciones.length; i++)
			acciones[i] = _objeto.acciones[i];
	}

	//Getter y Setters
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public int getValor() { return valor; }
	public void setValor(int valor) { this.valor = valor; }
	
	public int getNumAcciones() { return num_acciones; }
	public void setNumAcciones(int numacciones) { this.num_acciones = numacciones; }

	public Habilidad[] getAcciones() { return acciones; }
	public void setAcciones(Habilidad[] acciones) { this.acciones = acciones; }
	
	//Función que comprueba si una determinada habilidad esta en el array de habilidades
	private boolean checkArray(Habilidad _accion) {
		boolean salida = false;
		
		for(int i = 0; i < this.num_acciones; i++)
			if(acciones[i] != null && _accion != null) {
				if(acciones[i].esIgual(_accion))
					salida = true;
			}else
				salida = true;
		
		if(acciones[0] == null && _accion == null)
			salida = true;
		
		return salida;
	}
	
	//Función que añade una determinada habilidad al array. No se añade si ya existe.
	public boolean addHabilidad(Habilidad _accion) {
		boolean error = false;
		boolean existe = error;
		
		existe = checkArray(_accion);
		
		
		if(!existe && (num_acciones != acciones.length)) {
			acciones[num_acciones++] = _accion;
		}else
			error = true;
		
		return !error;
	}
	
	//Función que eliminar una determinada habilidad del array.
	public boolean eliminarHabilidad(Habilidad _accion) {
		boolean error = false;
		boolean existe = false;
		int pos = 0;
		
		for(int i = 0; i < this.num_acciones && !existe; i++)
			if(acciones[i].esIgual(_accion)) {
				existe = true;
				pos = i;
			}
	
		error = existe;
		if(existe){
			for(int i = pos; i < num_acciones-1; i++)
				acciones[i] = acciones[i+1];
			
			acciones[num_acciones-1] = null;
			num_acciones--;
		}
		
		return error;
	}
	
	//Función igual
	//Comprueba si es el mismo item
	public boolean esIgual(Item _objeto) {
		boolean igual = true;
		
		igual &= nombre.equals(_objeto.nombre);
		
		igual &= (num_acciones == _objeto.num_acciones);
		
		for(int i = 0; i < _objeto.num_acciones && igual; i++)
			if(acciones[i] != null && _objeto.acciones[i] != null)
				igual &= checkArray(_objeto.acciones[i]);
			else
				igual = false;
		
		return igual;
	}
	
	//Visualiza los datos básicos.
	public void visualizarBasico(){
		
		System.out.println("---------------------");
		System.out.println("Nombre: " + nombre);
		
		System.out.println();
		
		System.out.println("Valor: " + valor);
		
		System.out.println("---------------------");
		
		System.out.println("\nHabilidad: " + (num_acciones));
		
	}
	
	//Visualiza todos los datos.
	public void visualizar(){
		
		System.out.println("---------------------");
		System.out.println("Nombre: " + nombre);
		
		System.out.println();
		
		System.out.println("Valor: " + valor);
		
		System.out.println("---------------------");
		
		for(int i = 0; i < num_acciones; i++) {
			System.out.println("\nHabilidad: " + (i+1));
			
			acciones[i].visualizarBasico();
		}
	}
	
}
