package objects;

public class Comprobacion {
	
	public boolean validarDNI(String _dni) {
		boolean igual = true;
		
		String dni = _dni.toUpperCase();
		
		if(dni.length() < 9 || dni.length() > 9)
			igual = false;
		
		if(igual && !soloInt(dni.substring(0, 8)))
			igual = false;
		
		if(igual && !letraCorrecta(dni))
			igual = false;
		
		return igual;
	}
	
	public boolean soloInt(String cadena) {
		boolean igual = true;
		
		for(int i = 0; i < cadena.length(); i++)
			if(cadena.charAt(i) < '0' || cadena.charAt(i) > '9')
				igual = false;
		
		return igual;
	}
	
	public boolean letraCorrecta(String cadena) {
		return calcularLetra(cadena.substring(0, 8)) == cadena.charAt(8);
	}
	
	public char calcularLetra(String numero) {
		char[] listaletra = new char[] {'T', 'R', 'W', 'A',
										'G', 'M', 'Y', 'F',
										'P', 'D', 'X', 'B',
										'N', 'J', 'Z', 'S',
										'Q', 'V', 'H', 'L',
										'C', 'K', 'E'};
		
		int num = Integer.parseInt(numero);
		num %= 23;
		
		return listaletra[num];
	}
}
