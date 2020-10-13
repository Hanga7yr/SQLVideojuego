package objects;

public class Usuario {

	private String nombre;
	private String nick;
	private String email;
	private String dni;
	private String pass;
	private String tipo;
	
	//Constructores
	public Usuario(){
		nombre = "No definido";
		nick = "No definido";
		email = "No definido";
		dni = "No definido";
		pass = "No definido";
		tipo = "No definido";
	}
	
	public Usuario(String _nombre, String _nick, String _email, String _dni, String _pass, String _tipo){
		nombre = _nombre;
		nick = _nick;
		email = _email;
		dni = _dni;
		pass = _pass;
		tipo = _tipo;
	}
	
	public Usuario(Usuario _user){
		nombre = _user.nombre;
		nick = _user.nick;
		email = _user.email;
		dni = _user.dni;
		pass = _user.pass;
		tipo = _user.tipo;
	}

	//Getter y Setters
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getNick() { return nick; }
	public void setNick(String nick) { this.nick = nick; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getDni() { return dni; }
	public void setDni(String dni) { this.dni = dni; }

	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }

	public String getTipo() { return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
	
	//Visualizar todos los datos
	public void visualizar() {
		
		System.out.println("Nombre: " + nombre);
		System.out.println("Nick: " + nick);
		System.out.println("Email: " + email);
		System.out.println("DNI: " + dni);
		System.out.println("Password: " + pass);
		System.out.println("Tipo: " + tipo);
		
	}
	
	//Función igual
	//Comprueba si es el mismo usuario
	public boolean esIgual(Usuario _user) {
		boolean igual = true;
		
		igual &= (nombre.equals(_user.nombre));
		igual &= (nick.equals(_user.nick));
		igual &= (email.equals(_user.email));
		igual &= (dni.equals(_user.dni));
		igual &= (pass.equals(_user.pass));
		igual &= (tipo.equals(_user.tipo));
		
		return igual;
	}
	
}
