/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * Clase Juego
 * @author Faag1-48643667
 *
 */
public class Juego {
	
	/**
	 * Variable Miembro que almacena el Tablero
	 */
	private Tablero tablero;
	/**
	 * Variable miembro que almacena la Regla de Conway
	 */
	private Regla regla;
	/**
	 * Variable miembro que almacena un vector de patrones usados
	 */
	private ArrayList<Patron> patronesUsados;
	
	/**
	 * Constructor de la clase Juego
	 * @param tablero Tablero
	 * @param regla ReglaConway
	 */
	public Juego(Tablero tablero, Regla regla) {
		
		if(tablero == null || regla == null) throw new ExcepcionArgumentosIncorrectos();
		else {
			patronesUsados = new ArrayList<Patron>();
			this.tablero = tablero;
			this.regla = regla;
		}

		
	}
	
	/**
	 * Metodo Getter para obtener el tablero
	 * @return tablero Tablero del Juego
	 */
	public Tablero getTablero() {
		return tablero;
	}
	
	/**
	 * Metodo Getter para obtener los patrones usados
	 * @return patronesUsados Vector con los Patrones usados
	 */
	public ArrayList<Patron> getPatrones(){
		return patronesUsados;
	}
	
	
	
	/**
	 * Metodo que intenta cargar el patron en el tablero guardando este patron entre los usados.
	 * Si no cabe no se guarda como patron usado y se dara mensaje de error.
	 * @param p
	 * @param posicionInicial
	 * @throws ExcepcionPosicionFueraTablero 
	 * @throws ExcepcionCoordenadaIncorrecta 
	 * @throws ExcepcionArgumentosIncorrectos 
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta {
		tablero.cargaPatron(p, posicionInicial);
		patronesUsados.add(p);		
	}
	
	/**
	 * Evoluciona todas las casillas del tablero simultaneamente
	 */
	public void actualiza() {
		
		Collection<Coordenada> posiciones = tablero.getPosiciones();
		EstadoCelda estado;
		
		for(Coordenada c:posiciones) {
			try {
				estado = regla.calculaSiguienteEstadoCelda(tablero,c);
				tablero.setCelda(c, estado);
				
			} catch (ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionEjecucion();
			}

		}

		
	}
	
}
