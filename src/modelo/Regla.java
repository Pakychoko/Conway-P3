package modelo;

import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * Clase Abstracta Regla
 * @author fran
 *
 */
public abstract class Regla {

	/**
	 * Constructor de Regla
	 */
	public Regla() {
		
	}
	
	/**
	 * Metodo Abstracto que Calcula el siguiente Estado de Celda
	 * @param tablero
	 * @param coordenada
	 * @return
	 * @throws ExcepcionPosicionFueraTablero
	 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada coordenada) throws ExcepcionPosicionFueraTablero;
	
}
