package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * Clase Abstracta Coordenada
 * @author fran
 *
 */
public abstract class Coordenada {
	
	/**
	 * Constructor
	 */
	public Coordenada() {
		
	}
	
	/**
	 * Metodo abstracto
	 * @throws ExcepcionArgumentosIncorrectos
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public abstract Coordenada suma(Coordenada c) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta;
	
}
