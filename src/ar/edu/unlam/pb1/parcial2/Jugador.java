package ar.edu.unlam.pb1.parcial2;

public class Jugador {

	private int numero;
	private String nombre;
	private int edad;
	private double precio;
	private EquipoDeFutbol equipo;
	
	public Jugador(int numero, String nombre, int edad, double precio, EquipoDeFutbol equipo) {
		this.numero=numero;
		this.nombre = nombre;
		this.edad=edad;
		this.precio=precio;
		this.equipo=equipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String toString() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public EquipoDeFutbol getEquipo() {
		return equipo;
	}
}
