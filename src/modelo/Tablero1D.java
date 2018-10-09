/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * Clase de Tableros de 1 Dimension
 * @author fran
 *
 */
public class Tablero1D extends Tablero {

	/**
	 * Constructor de Tableros de 1 Dimension
	 * @param dimensiones
	 * @throws ExcepcionArgumentosIncorrectos
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public Tablero1D(int ancho) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta {
		
		super(new Coordenada1D(ancho));
		
		Coordenada1D dim = (Coordenada1D) dimensiones;
		
			this.celdas = new HashMap<Coordenada,EstadoCelda>();
			
			for(int x = 0; x < dim.getX(); x++){
					
				try {
					  celdas.put(new Coordenada1D(x), EstadoCelda.MUERTA);
				} catch (ExcepcionCoordenadaIncorrecta e) {
					  throw new ExcepcionEjecucion(e); 
				} 
			}
			
	}

	/**
	 * Devuelve un vector de posiciones vecinas de X, puede ser X-1 o X+1 o ambas. 
	 * @param posicion Coordenada Posicion
	 * @return vecinas ArrayList con las Posicion Vecinas en Sentido AntiHorario
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		
		ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
		
		if(posicion == null) throw new ExcepcionArgumentosIncorrectos();
		else {
			
			Coordenada1D pos = (Coordenada1D) posicion;
			Coordenada1D dim = (Coordenada1D) dimensiones;
			
			int x = pos.getX();
			
			if(contiene(posicion))
			{
				try {
				
					if(x==0) {
						//(0)
						vecinas.add(new Coordenada1D(x+1));
	
					}else if(x == dim.getX()) {
						//MAX
						vecinas.add(new Coordenada1D(x-1));
					}else {
						vecinas.add(new Coordenada1D(x-1));
						vecinas.add(new Coordenada1D(x+1));
					}
						
					return vecinas;
						
				}catch (ExcepcionCoordenadaIncorrecta e) {
					  throw new ExcepcionEjecucion(e); 
				} 
				
			}else {
				throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
			}
				
		}

	}

	
	
	
	/**  
	 * Las celdas vivas se mostrarán con un asterisco y las muertas con un espacio en blanco. 
	 * Los límites se representarán con los caracteres '|'. 
	 * 
	 * @return String Muestra el Mapa
	 * 
	 **/
	@Override
	public String toString() {
		
		String representacion = new String();
		Collection<Coordenada> pos = getPosiciones();
		
		Coordenada1D dim = (Coordenada1D) dimensiones;
		
		int maxX = dim.getX() +1;

		EstadoCelda estado = EstadoCelda.MUERTA;
		
		
		for(int i = 0; i <= maxX; i++) {
			
			if(i==0) representacion = representacion + ("|");
			else if(i==maxX) representacion = representacion + ("|");
			else representacion = representacion + ("*");
		}

		
		for(Coordenada celda:pos) {
			
			try {
				estado = getCelda(celda);
			} catch (ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionEjecucion();
			}
			
			Coordenada1D c = (Coordenada1D) celda;
			int x = c.getX();

			int anterior = (x-1);
			int posterior = (x+1);

			String delante = representacion.substring(0,anterior);
			String detras = representacion.substring(posterior);
			
			switch(estado) {
				case MUERTA: representacion = delante +' '+ detras;break;
				case VIVA: representacion = delante +'*'+ detras; break;
			}
			

		}
		
		return representacion;
	}
	
	
}
