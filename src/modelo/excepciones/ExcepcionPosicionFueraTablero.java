package modelo.excepciones;

import modelo.Coordenada;

/**
 * Clase que recoge las excepciones de posiciones que estan fuera del tablero
 * @author fran
 *
 */
public class ExcepcionPosicionFueraTablero extends Exception {

	/**
	 * Variable miembro dimensiones
	 */
	private Coordenada dimensiones;
	/**
	 * Variable miembro coordenada
	 */
	private Coordenada coordenada;
	
	/**
	 * Constructor de la Clase
	 * @param dimensiones
	 * @param coordenada
	 */
	public ExcepcionPosicionFueraTablero(Coordenada dimensiones, Coordenada coordenada){
		this.dimensiones = dimensiones;
		this.coordenada = coordenada;
	}
	
	/**
	 * Metodo GET que devuelve las dimensiones de la excepcion
	 * @return dimensiones
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	
	/**
	 * Metodo GET que devuelve la coordenada de la excepcion
	 * @return coordenada
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	/**
	 * Metodo GET que devuelve un mensaje de error
	 * @return mensaje
	 */
	public String getMessage() {
		
		return "Error: Posicion Fuera de Tablero";
	}
}
