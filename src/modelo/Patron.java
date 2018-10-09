/**
 * 
 */
package modelo;

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;


/**
 * 
 * Clase Patron. Representa un conjunto de Celdas Vivas.
 * @author faag1-48643667
 *
 */
public class Patron{
	
	/**
	 * Variable miembro de la clase Patron
	 */
	private String nombre;
	/**
	 * Variable miembro de la clase Patron
	 */
	private Tablero tablero;
	
	/**
	 * Constructor de la Clase Patron
	 * @param nombre Cadena de Caracteres que contiene el nombre del Patron
	 * @param tablero Tablero con el conjunto de celdas
	 */
	public Patron(String nombre, Tablero tablero){
		
		if(nombre == null || tablero == null) throw new ExcepcionArgumentosIncorrectos();
		else {
			this.nombre = nombre;
			this.tablero = tablero;
		}
	}
	
	
	
	/**
	 * Metodo Get para obtener el nombre del Patron
	 * @return nombre Cadena de Caracteres
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo Get para obtener el Estado de la Celda
	 * @param posicion Coordenada
	 * @return EstadoCelda de la Posicion
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		
		if(posicion == null) throw new ExcepcionArgumentosIncorrectos();
		else {

			return tablero.getCelda(posicion);
	
		}
	}
	
	/**
	 * Metodo Get para obtener las posiciones del Tablero
	 * @return celdas
	 */
	public Collection<Coordenada> getPosiciones(){
		return tablero.getPosiciones();
		
	}
	
	
	/**
	 * Metodo que devuelve el nombre del patron seguido del Tablero con las celdas vivas
	 * @return String
	 */
	public String toString() {

		return (nombre +"\n" + tablero.toString());
	}
	
}
